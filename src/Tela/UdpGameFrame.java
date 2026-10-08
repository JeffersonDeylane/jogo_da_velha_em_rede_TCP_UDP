package Tela;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.swing.*;

/** UDP LAN game. Server is X; client is O. All UI mutations run on the EDT. */
public class UdpGameFrame extends JFrame {
    private final boolean server;
    private final JButton[] cells = new JButton[9];
    private final char[] board = new char[9];
    private final JLabel status = new JLabel("Iniciando...");
    private final JTextField hostField = new JTextField("127.0.0.1", 14);
    private final JTextField portField = new JTextField("9876", 5);
    private final JButton connect = new JButton("Conectar");
    private final JButton reset = new JButton("Nova partida");
    private DatagramSocket socket;
    private InetSocketAddress peer;
    private volatile boolean running;
    private boolean connected, myTurn, finished;
    private int nextId = 1;
    private final Set<String> processed = new HashSet<>();
    private String session = "";
    private final Map<Integer, Pending> pending = new HashMap<>();
    private static final int RETRIES = 12;
    private static final int RETRY_MS = 500;
    private static class Pending {
        final String data;
        int tries;
        long sentAt;
        Pending(String data) { this.data = data; }
    }
    public UdpGameFrame(boolean server) {
        this.server = server;
        setTitle("Jogo da Velha - UDP - " + (server ? "Servidor X" : "Cliente O"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(460, 540);
        setLocationByPlatform(true);
        setLayout(new BorderLayout(10, 10));
        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel(server ? "Porta:" : "IP do servidor:"));
        if (!server) top.add(hostField);
        if (!server) top.add(new JLabel("Porta:"));
        top.add(portField);
        top.add(connect);
        add(top, BorderLayout.NORTH);
        JPanel grid = new JPanel(new GridLayout(3,3,5,5));
        grid.setBackground(Color.BLACK);
        grid.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        Font f = new Font("SansSerif", Font.BOLD, 60);
        for (int i=0; i<9; i++) {
            final int index=i;
            JButton b=new JButton(""); b.setFont(f); b.setFocusable(false);
            b.addActionListener(e -> play(index));
            cells[i]=b; grid.add(b);
        }
        add(grid, BorderLayout.CENTER);
        JPanel bottom=new JPanel(new BorderLayout());
        bottom.add(status, BorderLayout.CENTER);
        bottom.add(reset, BorderLayout.EAST);
        bottom.setBorder(BorderFactory.createEmptyBorder(6,10,10,10));
        add(bottom, BorderLayout.SOUTH);
        connect.addActionListener(e -> startNetwork());
        reset.addActionListener(e -> requestReset());
        addWindowListener(new WindowAdapter() { @Override public void windowClosed(WindowEvent e) { shutdown(); } });
        clearBoard();
        status.setText(server ? "Clique em Conectar para aguardar cliente" : "Informe o IP e clique em Conectar");
        if (server) SwingUtilities.invokeLater(this::startNetwork);
    }
    private void clearBoard() {
        Arrays.fill(board, ' ');
        finished=false;
        myTurn=server && connected;
        refresh();
    }
    private void refresh() {
        for (int i=0;i<9;i++) {
            cells[i].setText(board[i]==' ' ? "" : String.valueOf(board[i]));
            cells[i].setEnabled(connected && !finished && myTurn && board[i]==' ');
        }
        reset.setEnabled(connected);
    }
    private int port() {
        int p=Integer.parseInt(portField.getText().trim());
        if (p<1 || p>65535) throw new NumberFormatException();
        return p;
    }
    private void startNetwork() {
        if (running) return;
        final int p;
        try { p=port(); } catch (NumberFormatException e) { JOptionPane.showMessageDialog(this,"Porta inválida"); return; }
        final String host=hostField.getText().trim();
        if (!server && host.isEmpty()) { JOptionPane.showMessageDialog(this,"Informe o IP do servidor"); return; }
        try {
            socket=server ? new DatagramSocket(p) : new DatagramSocket();
            socket.setSoTimeout(250);
            if (!server) peer=new InetSocketAddress(InetAddress.getByName(host),p);
        } catch (Exception e) { status.setText("Erro ao abrir UDP: "+e.getMessage()); return; }
        running=true; connect.setEnabled(false); hostField.setEditable(false); portField.setEditable(false);
        status.setText(server ? "Aguardando cliente na porta "+p : "Conectando a "+host+":"+p+"...");
        Thread receiver=new Thread(this::receiveLoop,"udp-receiver"); receiver.setDaemon(true); receiver.start();
        Thread retry=new Thread(this::retryLoop,"udp-retry"); retry.setDaemon(true); retry.start();
        if (!server) sendReliable("HELLO", "");
    }
    private synchronized void sendRaw(String msg) {
        if (socket==null || socket.isClosed() || peer==null) return;
        try {
            byte[] data=msg.getBytes(StandardCharsets.UTF_8);
            socket.send(new DatagramPacket(data,data.length,peer));
        } catch (Exception e) { SwingUtilities.invokeLater(() -> status.setText("Erro UDP: "+e.getMessage())); }
    }
    private synchronized void sendReliable(String type, String value) {
        int id=nextId++;
        String msg="JV1|"+session+"|"+id+"|"+type+"|"+value;
        Pending item=new Pending(msg); pending.put(id,item);
        transmit(item);
    }
    private void transmit(Pending item) { sendRaw(item.data); item.sentAt=System.currentTimeMillis(); item.tries++; }
    private void retryLoop() {
        while (running) {
            try { Thread.sleep(100); } catch (InterruptedException e) { return; }
            synchronized(this) {
                Iterator<Map.Entry<Integer,Pending>> it=pending.entrySet().iterator();
                while(it.hasNext()) {
                    Pending item=it.next().getValue();
                    if(System.currentTimeMillis()-item.sentAt < RETRY_MS) continue;
                    if(item.tries>=RETRIES) {
                        it.remove();
                        SwingUtilities.invokeLater(() -> { status.setText("Sem resposta do outro computador. Verifique a rede."); connected=false; refresh(); });
                    } else transmit(item);
                }
            }
        }
    }
    private void receiveLoop() {
        while(running) {
            try {
                byte[] bytes=new byte[2048]; DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
                socket.receive(packet);
                String message=new String(packet.getData(),packet.getOffset(),packet.getLength(),StandardCharsets.UTF_8);
                String[] parts=message.split("\\|",-1);
                if(parts.length!=5 || !"JV1".equals(parts[0])) continue;
                InetSocketAddress sender=new InetSocketAddress(packet.getAddress(),packet.getPort());
                if(server && peer==null && "HELLO".equals(parts[3])) peer=sender;
                if(!sender.equals(peer)) continue;
                int id; try { id=Integer.parseInt(parts[2]); } catch(NumberFormatException e) { continue; }
                if("ACK".equals(parts[3])) { synchronized(this) { pending.remove(id); } continue; }
                sendRaw("JV1|"+parts[1]+"|"+id+"|ACK|");
                String key=parts[1]+":"+id;
                synchronized(processed) { if(!processed.add(key)) continue; }
                SwingUtilities.invokeLater(() -> onMessage(parts[1],parts[3],parts[4]));
            } catch(SocketTimeoutException ignored) {
            } catch(Exception e) { if(running) SwingUtilities.invokeLater(() -> status.setText("Erro de recepção: "+e.getMessage())); }
        }
    }
    private void onMessage(String incomingSession,String type,String value) {
        if(server && "HELLO".equals(type)) {
            if(!connected) {
                session=UUID.randomUUID().toString(); connected=true; clearBoard();
                status.setText("Cliente conectado! Sua vez (X)");
            }
            sendReliable("WELCOME",session);
            return;
        }
        if(!server && "WELCOME".equals(type)) {
            if(!connected) { session=value; connected=true; synchronized(this) { pending.clear(); } clearBoard(); status.setText("Conectado! Aguarde o X jogar."); }
            return;
        }
        if(!connected || !session.equals(incomingSession)) return;
        if("MOVE".equals(type)) {
            int n; try { n=Integer.parseInt(value); } catch(NumberFormatException e) { return; }
            if(n<0 || n>=9 || board[n]!=' ' || myTurn || finished) return;
            board[n]=server?'O':'X'; myTurn=true; checkEnd();
            if(!finished) status.setText("Sua vez ("+(server?'X':'O')+")");
            refresh();
        } else if("RESET".equals(type)) {
            clearBoard(); status.setText(server ? "Nova partida: sua vez (X)" : "Nova partida: aguarde o X");
        }
    }
    private void play(int n) {
        if(!connected || finished || !myTurn || board[n]!=' ') return;
        board[n]=server?'X':'O'; myTurn=false;
        sendReliable("MOVE",Integer.toString(n));
        checkEnd(); if(!finished) status.setText("Aguardando jogada do adversário...");
        refresh();
    }
    private void checkEnd() {
        int[][] lines={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for(int[] line:lines) {
            char a=board[line[0]];
            if(a!=' ' && a==board[line[1]] && a==board[line[2]]) {
                finished=true; status.setText("Vitória do "+a+"!"); refresh(); return;
            }
        }
        boolean full=true; for(char c:board) if(c==' ') full=false;
        if(full) { finished=true; status.setText("Empate!"); refresh(); }
    }
    private void requestReset() {
        if(!connected) return;
        sendReliable("RESET", ""); clearBoard();
        status.setText(server ? "Nova partida: sua vez (X)" : "Nova partida: aguarde o X");
    }
    private void shutdown() {
        running=false;
        if(socket!=null) socket.close();
    }
}

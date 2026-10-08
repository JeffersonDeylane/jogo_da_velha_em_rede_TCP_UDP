package Tela;
public class JogoClienteUdp extends UdpGameFrame {
    public JogoClienteUdp() { super(false); }
    public static void main(String[] args) { javax.swing.SwingUtilities.invokeLater(() -> new JogoClienteUdp().setVisible(true)); }
}

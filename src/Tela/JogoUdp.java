package Tela;
public class JogoUdp extends UdpGameFrame {
    public JogoUdp() { super(true); }
    public static void main(String[] args) { javax.swing.SwingUtilities.invokeLater(() -> new JogoUdp().setVisible(true)); }
}

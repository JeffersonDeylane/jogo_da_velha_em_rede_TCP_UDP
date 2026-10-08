
package Tela;


import java.io.DataInputStream;   // entrada e saida
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Jogo extends javax.swing.JFrame {
    static ServerSocket ss;
    static Socket s;
    static DataInputStream receptor;
    static DataOutputStream enviador;
    static String  udptcp;
    public Jogo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        B1 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        B9 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        XO = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B1MouseClicked(evt);
            }
        });
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        B7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B7MouseClicked(evt);
            }
        });
        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });

        B8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B8MouseClicked(evt);
            }
        });
        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });

        B9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B9MouseClicked(evt);
            }
        });
        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });

        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B2MouseClicked(evt);
            }
        });
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B3MouseClicked(evt);
            }
        });
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });

        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B4MouseClicked(evt);
            }
        });
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B5MouseClicked(evt);
            }
        });
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        B6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B6MouseClicked(evt);
            }
        });
        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(B7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(B4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(B2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(B4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B6, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(B5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(B9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {B1, B2});

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        XO.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        XO.setForeground(new java.awt.Color(255, 255, 255));
        XO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        XO.setText("X");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(XO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(XO)
                .addGap(26, 26, 26))
        );

        status.setText("esperando cliente");

        jButton1.setText("Reiniciar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(status)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(status)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
//os botões marcão com X depois desativão todos para que não se aperte duas vezes 
//
        B6.setText("X");
        desativar(false);
        
        String msgout = "";
        try {

            msgout = "b6";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente");Verificacao();
       
    }//GEN-LAST:event_B6ActionPerformed

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed

        B8.setText("X");
        desativar(false);
        

        String msgout = "";
        try {

            msgout = "b8";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente");Verificacao();
        // TODO add your handling code here:
    }//GEN-LAST:event_B8ActionPerformed

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked


    }//GEN-LAST:event_B2MouseClicked

    private void B3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseClicked

    }//GEN-LAST:event_B3MouseClicked

    private void B4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseClicked

    }//GEN-LAST:event_B4MouseClicked

    private void B5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseClicked

    }//GEN-LAST:event_B5MouseClicked

    private void B6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B6MouseClicked

    }//GEN-LAST:event_B6MouseClicked

    private void B7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B7MouseClicked

    }//GEN-LAST:event_B7MouseClicked

    private void B8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B8MouseClicked

    }//GEN-LAST:event_B8MouseClicked

    private void B9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B9MouseClicked

    }//GEN-LAST:event_B9MouseClicked

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed

        B1.setText("X");
        desativar(false);
        

        // codigo para mandar o sinal para marcar o "o" do outro lado
        String msgout = "";
        try {

            msgout = "b1";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente");Verificacao();
        // codigo para mandar o sinal para marcar o "o" do outro lado // TODO add your handling code here:
    }//GEN-LAST:event_B1ActionPerformed

    private void B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseClicked

    }//GEN-LAST:event_B1MouseClicked

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed

        B2.setText("X");
        desativar(false);
      

        // codigo para mandar o sinal para marcar o "o" do outro lado
        String msgout = "";
        try {

            msgout = "b2";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente");   Verificacao();// TODO add your handling code here:
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed

        B3.setText("X");
        desativar(false);
    
        String msgout = "";
        try {

            msgout = "b3";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente");    Verificacao(); // TODO add your handling code here:
    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed

        B4.setText("X");
        desativar(false);
        
        String msgout = "";
        try {

            msgout = "b4";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente"); Verificacao();// TODO add your handling code here:
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed

        B5.setText("X");
        desativar(false);
        
        String msgout = "";
        try {

            msgout = "b5";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente");Verificacao(); // TODO add your handling code here:
    }//GEN-LAST:event_B5ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed

        B7.setText("X");
        desativar(false);
       

        String msgout = "";
        try {

            msgout = "b7";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente"); Verificacao(); // TODO add your handling code here:
    }//GEN-LAST:event_B7ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed

        B9.setText("X");
        desativar(false);
        
        String msgout = "";
        try {

            msgout = "b9";
            enviador.writeUTF(msgout);
        } catch (Exception e) {

        }
        status.setText("esperando jogada do oponente");Verificacao(); // TODO add your handling code here:
    }//GEN-LAST:event_B9ActionPerformed

    private static void ganhou(int ganhador) {

        if (ganhador == 1) {
            status.setText("O jogador n° 1 venceu!");
        } else {
            status.setText("O jogador n° 2 venceu!");
        }

    }

    private static void Verificacao() {
        String um = "X", dois = "O";

        //diagonal principal
        if ((B1.getText() != null) && (B5.getText() != null) && (B9.getText() != null)) {
            if ((B1.getText().equals(um)) && (B5.getText().equals(um)) && (B9.getText().equals(um))) {
                ganhou(1);
                return;
            }
            if ((B1.getText().equals(dois)) && (B5.getText().equals(dois)) && (B9.getText().equals(dois))) {
                ganhou(2);
                return;
            }
        }

        //diagonal secundaria
        if ((B3.getText() != null) && (B5.getText() != null) && (B7.getText() != null)) {
            if ((B3.getText().equals(um)) && (B5.getText().equals(um)) && (B7.getText().equals(um))) {
                ganhou(1);
                return;
            }
            if ((B3.getText().equals(dois)) && (B5.getText().equals(dois)) && (B7.getText().equals(dois))) {
                ganhou(2);
                return;
            }
        }

        //primeira linha
        if ((B1.getText() != null) && (B2.getText() != null) && (B3.getText() != null)) {
            if ((B1.getText().equals(um)) && (B2.getText().equals(um)) && (B3.getText().equals(um))) {
                ganhou(1);
                return;
            }
            if ((B1.getText().equals(dois)) && (B2.getText().equals(dois)) && (B3.getText().equals(dois))) {
                ganhou(2);
                return;
            }
        }

        //segunda linha
        if ((B4.getText() != null) && (B5.getText() != null) && (B6.getText() != null)) {
            if ((B4.getText().equals(um)) && (B5.getText().equals(um)) && (B6.getText().equals(um))) {
                ganhou(1);
                return;
            }
            if ((B4.getText().equals(dois)) && (B5.getText().equals(dois)) && (B6.getText().equals(dois))) {
                ganhou(2);
                return;
            }
        }

        //treceira linha
        if ((B7.getText() != null) && (B8.getText() != null) && (B9.getText() != null)) {
            if ((B7.getText().equals(um)) && (B8.getText().equals(um)) && (B9.getText().equals(um))) {
                ganhou(1);
                return;
            }
            if ((B7.getText().equals(dois)) && (B8.getText().equals(dois)) && (B9.getText().equals(dois))) {
                ganhou(2);
                return;
            }
        }

        //primeira coluna
        if ((B1.getText() != null) && (B4.getText() != null) && (B7.getText() != null)) {
            if ((B1.getText().equals(um)) && (B4.getText().equals(um)) && (B7.getText().equals(um))) {
                ganhou(1);
                return;
            }
            if ((B1.getText().equals(dois)) && (B4.getText().equals(dois)) && (B7.getText().equals(dois))) {
                ganhou(2);
                return;
            }
        }

        //segunda coluna
        if ((B2.getText() != null) && (B5.getText() != null) && (B8.getText() != null)) {
            if ((B2.getText().equals(um)) && (B5.getText().equals(um)) && (B8.getText().equals(um))) {
                ganhou(1);
                return;
            }
            if ((B2.getText().equals(dois)) && (B5.getText().equals(dois)) && (B8.getText().equals(dois))) {
                ganhou(2);
                return;
            }
        }

        //treceira coluna
        if ((B3.getText() != null) && (B6.getText() != null) && (B9.getText() != null)) {
            if ((B3.getText().equals(um)) && (B6.getText().equals(um)) && (B9.getText().equals(um))) {
                ganhou(1);
                return;
            }

            if ((B3.getText().equals(dois)) && (B6.getText().equals(dois)) && (B9.getText().equals(dois))) {
                ganhou(2);
                return;
            }
        }
          if ((B1.getText() != "") && (B2.getText() != "") && (B3.getText() != "") && 
                (B4.getText() != "") && (B5.getText() != "") && (B6.getText() != "") && (B7.getText() != "") &&
                (B8.getText() != "") && (B9.getText() != "") && (status.getText() == "esperando jogada do oponente" || status.getText() == "jogue")) {
           
                  status.setText("Empate!");
            
            //se ocorrer empate
          
        }

    }

    private static void desativar(boolean x) {
        //essa parte vai desativar todos botões para
        //que o jogador não possa jogar na vez do outro
        if (x == false) {
            B1.setEnabled(x);
            B2.setEnabled(x);
            B3.setEnabled(x);
            B4.setEnabled(x);
            B5.setEnabled(x);
            B6.setEnabled(x);
            B7.setEnabled(x);
            B8.setEnabled(x);
            B9.setEnabled(x);
        } // já essa parte vai ativar os botões que ainda não estão marcados
        // para que o jogo possa continuar
        else {

            if (B1.getText() == "") {
                B1.setEnabled(x);
            }
            if (B2.getText() == "") {
                B2.setEnabled(x);
            }
            if (B3.getText() == "") {
                B3.setEnabled(x);
            }
            if (B4.getText() == "") {
                B4.setEnabled(x);
            }
            if (B5.getText() == "") {
                B5.setEnabled(x);
            }
            if (B6.getText() == "") {
                B6.setEnabled(x);
            }
            if (B7.getText() == "") {
                B7.setEnabled(x);
            }
            if (B8.getText() == "") {
                B8.setEnabled(x);
            }
            if (B9.getText() == "") {
                B9.setEnabled(x);
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jogo().setVisible(true);
            }
        });
        //cria a veriável mensagem para poder trabalhar na estrutura de casos 
        String mensagem = "";

        try {
          
            //cria o servidor do socket
            ss = new ServerSocket(7000);
           
            s = ss.accept(); // fica esperandoo o cliente se conectar, então cria um socket 
            // para que se estabelise a conecção 
             status.setText("cliente conectado");
           
                  
                  // com o DataOutputStream possibilia a leitura da mensagem, como se fosse um scanner    
            receptor = new DataInputStream(s.getInputStream());// com o s.getInputStream() recebe a mensagem da conecção do socket 
            enviador = new DataOutputStream(s.getOutputStream());// com o getOutputStream pode então mandar mensagens
            //
            
            while (true) {
                mensagem = receptor.readUTF();// passa o comando do servidor para o mensagem

                // caso o jogador/servidor apertar um botão, 
                //o comando do botão será enviado para a estrutura de seleção 
                //e fará os seus devidos comando internos para "marcar o X"
                switch (mensagem) {
                    case "b1":
                        B1.setText("O");
                        B1.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;
                    case "b2":
                        B2.setText("O");
                        B2.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;
                    case "b3":
                        B3.setText("O");
                        B3.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;
                    case "b4":
                        B4.setText("O");
                        B4.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;
                    case "b5":
                        B5.setText("O");
                        B5.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;
                    case "b6":
                        B6.setText("O");
                        B6.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;
                    case "b7":
                        B7.setText("O");
                        B7.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;
                    case "b8":
                        B8.setText("O");
                        B8.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;

                    case "b9":
                        B9.setText("O");
                        B9.setEnabled(false);
                        desativar(true);
                        status.setText("jogue");
                        Verificacao();
                        break;
                }

            }
        } catch (Exception e) {
        
      }
      }
         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton B1;
    private static javax.swing.JButton B2;
    private static javax.swing.JButton B3;
    private static javax.swing.JButton B4;
    private static javax.swing.JButton B5;
    private static javax.swing.JButton B6;
    private static javax.swing.JButton B7;
    private static javax.swing.JButton B8;
    private static javax.swing.JButton B9;
    private javax.swing.JLabel XO;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}

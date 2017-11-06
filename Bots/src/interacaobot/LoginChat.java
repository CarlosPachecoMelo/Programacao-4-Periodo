package interacaobot;

import javax.swing.JOptionPane;

public class LoginChat extends javax.swing.JFrame {

    Bot bot;
    
    final String token = "MzcyODU4NzA2OTA1NTMwMzc4.DNWFAQ.Zvf9HYSarTX4LDBxI3lGKsr5H7Q";
    final String LOGIN = "Logado no ";
    
    public LoginChat() {
        
        initComponents();
        
        botaoLogar.addActionListener((e)->{
            bot = BotFactory.createBot(ServicoMensagens.getSelectedItem().toString());
            if(bot.entrar(token)){
                setVisible(false);
                JOptionPane.showMessageDialog(this, LOGIN + ServicoMensagens.getSelectedItem().toString() + "!");
                Chat.createJanelaMensagem(this);
            }
        });
        
    }
    
    public String getServicoMensagem(){
        return ServicoMensagens.getSelectedItem().toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoLogar = new javax.swing.JButton();
        ServicoMensagens = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoLogar.setText("Logar");
        botaoLogar.setToolTipText("Logar");
        botaoLogar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        ServicoMensagens.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Discord", "Telegram", "Facebook" }));
        ServicoMensagens.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        ServicoMensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServicoMensagensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(ServicoMensagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ServicoMensagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoLogar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        ServicoMensagens.getAccessibleContext().setAccessibleName("servicoMensagens");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ServicoMensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServicoMensagensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ServicoMensagensActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ServicoMensagens;
    private javax.swing.JButton botaoLogar;
    // End of variables declaration//GEN-END:variables
}

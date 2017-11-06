package interacaobot;

import javax.swing.JOptionPane;

public class Chat extends javax.swing.JFrame {
    
    final String MENSAGEM_ENVIADA = "Mensagem enviada!";
    final String MENSAGEM_VAZIA = "Digite sua mensagem!";
    final String LOGOUT = "Deslogado do ";

    public Chat(LoginChat janelaLogin) {
        
        initComponents();
        
        botaoSair.addActionListener((e)->{
            JOptionPane.showMessageDialog(this, LOGOUT + janelaLogin.getServicoMensagem() + "!");
            janelaLogin.setVisible(true);
            dispose();
            janelaLogin.bot.sair();
        });
        
        botaoEnviar.addActionListener((e)->{
            if(caixaTextoMensagem.getText() != null && !caixaTextoMensagem.getText().equalsIgnoreCase("")){
               janelaLogin.bot.enviaMensagem(caixaTextoMensagem.getText());
               JOptionPane.showMessageDialog(this, MENSAGEM_ENVIADA);
            }else{
               JOptionPane.showMessageDialog(this, MENSAGEM_VAZIA);
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoSair = new javax.swing.JButton();
        botaoEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        caixaTextoMensagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoSair.setText("Sair");
        botaoSair.setToolTipText("Sair");

        botaoEnviar.setText("Enviar");
        botaoEnviar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        caixaTextoMensagem.setColumns(20);
        caixaTextoMensagem.setRows(5);
        caixaTextoMensagem.setToolTipText("Mensagem");
        jScrollPane1.setViewportView(caixaTextoMensagem);
        caixaTextoMensagem.getAccessibleContext().setAccessibleName("Mensagem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoSair.getAccessibleContext().setAccessibleName("botaoSair");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void createJanelaMensagem(LoginChat janelaLogin) {
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
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat(janelaLogin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextArea caixaTextoMensagem;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

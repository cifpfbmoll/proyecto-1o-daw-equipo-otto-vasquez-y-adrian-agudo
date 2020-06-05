/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofinal.usuario;

/**
 *
 * @author ADRI
 */
public class menuPrincipal extends javax.swing.JFrame {
    private usuario usu;
    /**
     * Creates new form menuPrincipal
     */
    public menuPrincipal() {
        initComponents();
    }
    
    public menuPrincipal(usuario usu){
        this.usu=usu;
        initComponents();
        setLabel();
    }

    public void setUsu(usuario usu) {
        this.usu = usu;
    }

    public usuario getUsu() {
        return usu;
    }
    
    public void setLabel(){
        nomUsuSalida.setText(this.usu.getNick());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nomUsuSalida = new javax.swing.JLabel();
        opcButon = new javax.swing.JButton();
        matchBut = new javax.swing.JButton();
        chatBut = new javax.swing.JButton();
        listaBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenido");

        opcButon.setText("opsiones");
        opcButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcButonActionPerformed(evt);
            }
        });

        matchBut.setText("Match");
        matchBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchButActionPerformed(evt);
            }
        });

        chatBut.setText("Chat");
        chatBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatButActionPerformed(evt);
            }
        });

        listaBut.setText("Lista");
        listaBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(394, 394, 394)
                        .addComponent(nomUsuSalida))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opcButon)
                            .addComponent(listaBut))
                        .addGap(114, 114, 114)
                        .addComponent(matchBut)
                        .addGap(115, 115, 115)
                        .addComponent(chatBut)
                        .addGap(19, 19, 19)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nomUsuSalida))
                .addGap(51, 51, 51)
                .addComponent(opcButon)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matchBut)
                    .addComponent(chatBut)
                    .addComponent(listaBut))
                .addContainerGap(417, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcButonActionPerformed
        opciones opc=new opciones(usu);
        opc.setVisible(true);
        opc.pack();
        this.dispose();
    }//GEN-LAST:event_opcButonActionPerformed

    private void chatButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatButActionPerformed
        elegirChat chat=new elegirChat(usu);
        chat.setVisible(true);
        chat.pack();
        this.dispose();
    }//GEN-LAST:event_chatButActionPerformed

    private void matchButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchButActionPerformed
        match match =new match(usu);
        match.setVisible(true);
        match.pack();
        this.dispose();
    }//GEN-LAST:event_matchButActionPerformed

    private void listaButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaButActionPerformed
        try {
            Lista lista = new Lista(usu);
            lista.setVisible(true);
            lista.pack();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listaButActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chatBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listaBut;
    private javax.swing.JButton matchBut;
    private javax.swing.JLabel nomUsuSalida;
    private javax.swing.JButton opcButon;
    // End of variables declaration//GEN-END:variables
}

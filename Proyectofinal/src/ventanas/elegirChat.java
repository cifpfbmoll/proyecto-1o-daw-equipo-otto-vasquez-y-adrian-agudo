/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinal.conectarBBDD;

/**
 *
 * @author ADRI
 */
public class elegirChat extends javax.swing.JFrame {
    private usuario usu;
    private usuario usu2=new usuario();
    conectarBBDD con = new conectarBBDD();
    private ArrayList<String> nicks=new ArrayList<String>();
    /**
     * Creates new form elegirChat
     */
    public elegirChat() {
        initComponents();
    }
    
    public elegirChat(usuario usu){
        this.usu=usu;
        initComponents();
        printarChats();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        introChatField = new javax.swing.JTextField();
        irBut = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        printChatsField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        introChatField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introChatFieldActionPerformed(evt);
            }
        });

        irBut.setText("Ir");
        irBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irButActionPerformed(evt);
            }
        });

        printChatsField.setColumns(20);
        printChatsField.setRows(5);
        jScrollPane2.setViewportView(printChatsField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(introChatField)
                        .addGap(18, 18, 18)
                        .addComponent(irBut, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(introChatField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(irBut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void irButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irButActionPerformed
        try {
            int i=0;
            boolean found=false;
            while(i<nicks.size()&&!found){
                System.out.println(nicks.size()+" i:"+i+" nick:"+nicks.get(i));
                if (nicks.get(i).contentEquals(introChatField.getText())) {
                    found=true;
                    Statement st = con.getConnection().createStatement();               
                    ResultSet ExisteUsu = st.executeQuery("select * from usuarios where nick = '"+nicks.get(i)+"'");
                    ExisteUsu.next();
                    usu2.crearUsuario(ExisteUsu.getInt("id"),ExisteUsu.getString("nick"),ExisteUsu.getString("contraseña"),ExisteUsu.getString("nombre"),ExisteUsu.getString("apellidos"),ExisteUsu.getString("genero"),ExisteUsu.getString("orSex"),ExisteUsu.getString("provincia"),ExisteUsu.getString("fechaNac"),ExisteUsu.getString("descripcion"));
                    chat chat=new chat(usu,usu2);
                    chat.setVisible(true);
                    this.dispose();
                } else {
                   if(i==(nicks.size()-1)){
                      JOptionPane.showMessageDialog(null, "No se encuentra el usuario");
                   }
                }
                i++;
            }
        } catch (SQLException ex) {
                    Logger.getLogger(elegirChat.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_irButActionPerformed

    private void introChatFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_introChatFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_introChatFieldActionPerformed

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
            java.util.logging.Logger.getLogger(elegirChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(elegirChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(elegirChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(elegirChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new elegirChat().setVisible(true);
            }
        });
    }
    
    
    
    public void printarChats(){
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select nick from usuarios where id in(select distinct id_usuario0 from (select * from mensajes where id_usuario0=" + usu.getId() + " or id_usuario1=" + usu.getId() + ") as t1 where id_usuario0!=" + usu.getId() + " union select distinct id_usuario1 from (select * from mensajes where id_usuario0=" + usu.getId() + " or id_usuario1=" + usu.getId() + ") as t2 where id_usuario1!=" + usu.getId() + ")");
            while (rs.next()) { 
                System.out.println(rs.getString("nick"));
                printChatsField.setText(printChatsField.getText() + "\n" + rs.getString("nick"));
                nicks.add(rs.getString("nick"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField introChatField;
    private javax.swing.JToggleButton irBut;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea printChatsField;
    // End of variables declaration//GEN-END:variables
}

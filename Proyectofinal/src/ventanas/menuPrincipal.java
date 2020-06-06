/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.File;

import java.io.FileWriter;
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
        instrucciones = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jLabel1.setText("Bienvenido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 20));
        getContentPane().add(nomUsuSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 70, 20));

        opcButon.setText("Opciones");
        opcButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcButonActionPerformed(evt);
            }
        });
        getContentPane().add(opcButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        matchBut.setText("Match");
        matchBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchButActionPerformed(evt);
            }
        });
        getContentPane().add(matchBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        chatBut.setText("Chat");
        chatBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatButActionPerformed(evt);
            }
        });
        getContentPane().add(chatBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        listaBut.setText("Lista de usuarios");
        listaBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaButActionPerformed(evt);
            }
        });
        getContentPane().add(listaBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        instrucciones.setText("Instrucciones");
        instrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesActionPerformed(evt);
            }
        });
        getContentPane().add(instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo menu.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-380, -110, 970, 430));

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
        try {
            match match =new match(usu);
            match.setVisible(true);
            match.pack();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_matchButActionPerformed

    private void listaButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaButActionPerformed

            Lista lista = new Lista(usu);
            lista.setVisible(true);
            lista.pack();
            this.dispose();
    }//GEN-LAST:event_listaButActionPerformed

    private void instruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instruccionesActionPerformed
        try {
            String instrucTXT="Bienvenido: "+usu.getNick()+"\n\nA continuación le explicaremos el funcionamiento de la aplicación."
            + "Si nos fijamos en el menú principal nos encontraremos con 5 botones, el de intrucciones, el de match, el de lista,"
            + "el de chat y el de opciones:\n\n\nMatch: Seleccionará quien le parece atractivo, ya que podrá ver la foto del usuario "
            + "en cuestión, los usuarios son expuestos de uno en uno.\n\nLista: Podrá ver todos los usuarios que se adaptan a usted"
            + ", sin embrago no podrá ver sus fotos.\n\nChat: Cuando tanto tú como el otro usuario hayáis dado like, se producirá "
            + "un match, el cual os permitirá abrir uun chat. Para hablar introduciras el nick de la persona a la que quieres"
            + " hablar (dispones una lista de las personas con las que has hecho match).\nOpciones: Aquí puedes cambiar los valores "
            + "de tu perfil, como nick o contraseña.\n\n\nTodos los usuarios mostrados en Match y Lista se adaptan a su orientación sexual y género."
            + "\n\n(Para mayor comprensión puede leer el txt generado con las mismas instrucciones)";
            File archivo = new File ("C:/Users/Public/instrucciones.txt");
            FileWriter ficheroEscribir = new FileWriter(archivo);
            ficheroEscribir.write(instrucTXT);
            ficheroEscribir.close();
            instrucciones instruc=new instrucciones(usu,archivo);
            instruc.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(menuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_instruccionesActionPerformed

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
    private javax.swing.JLabel fondo;
    private javax.swing.JButton instrucciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listaBut;
    private javax.swing.JButton matchBut;
    private javax.swing.JLabel nomUsuSalida;
    private javax.swing.JButton opcButon;
    // End of variables declaration//GEN-END:variables
}

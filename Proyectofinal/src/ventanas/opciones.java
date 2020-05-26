/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import proyectofinal.conectarBBDD;
/**
 *
 * @author ADRI
 */
public class opciones extends javax.swing.JFrame {
    private usuario usu;
    conectarBBDD con = new conectarBBDD();
    /**
     * Creates new form opciones
     */
    public opciones() {
        initComponents();
    }
    
    public opciones(usuario usu){
        this.usu=usu;
        initComponents();
    }

    public usuario getUsu() {
        return usu;
    }

    public void setUsu(usuario usu) {
        this.usu = usu;
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
        jLabel2 = new javax.swing.JLabel();
        camContraBut = new javax.swing.JButton();
        camNombreUsuBut = new javax.swing.JButton();
        camResiBut = new javax.swing.JButton();
        camFechaNacBut = new javax.swing.JButton();
        camNombreBut = new javax.swing.JButton();
        camApellidosBut = new javax.swing.JButton();
        camDescBut = new javax.swing.JButton();
        camOrSexBut = new javax.swing.JButton();
        camGenBut = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        camLugarBut = new javax.swing.JButton();
        camEdadBut = new javax.swing.JButton();
        camSexoBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("OPCIONES");

        jLabel2.setText("Modificar perfíl");

        camContraBut.setText("Cambiar contraseña");

        camNombreUsuBut.setText("Cambiar nombre de usuario");
        camNombreUsuBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camNombreUsuButActionPerformed(evt);
            }
        });

        camResiBut.setText("Cambiar residencia");

        camFechaNacBut.setText("Cambiar fecha nacimiento");

        camNombreBut.setText("Cambiar nombre");
        camNombreBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camNombreButActionPerformed(evt);
            }
        });

        camApellidosBut.setText("Cambiar apellidos");

        camDescBut.setText("Cambiar descripción");
        camDescBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camDescButActionPerformed(evt);
            }
        });

        camOrSexBut.setText("Cambiar orientación sexual");

        camGenBut.setText("Cambiar género");

        jLabel3.setText("Modificar filtros de búsqueda");

        camLugarBut.setText("Lugar");
        camLugarBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camLugarButActionPerformed(evt);
            }
        });

        camEdadBut.setText("Edad");
        camEdadBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camEdadButActionPerformed(evt);
            }
        });

        camSexoBut.setText("Sexo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(314, 314, 314))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(camResiBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(camFechaNacBut, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(camNombreUsuBut)
                                        .addComponent(camContraBut, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(camSexoBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(camEdadBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(camLugarBut, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(177, 177, 177)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(camGenBut, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(camOrSexBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(camDescBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(camApellidosBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(camNombreBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(camNombreBut)
                    .addComponent(camNombreUsuBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(camApellidosBut)
                    .addComponent(camContraBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(camResiBut)
                    .addComponent(camDescBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(camFechaNacBut)
                    .addComponent(camOrSexBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(camGenBut)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(camLugarBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(camEdadBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(camSexoBut)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void camNombreUsuButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camNombreUsuButActionPerformed
        try{
            String input = JOptionPane.showInputDialog("Introducir nuevo NOMBRE DE USUARIO");
            if (!input.equals("")){
                if (input.length()<=10){
                    PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET nick = ? WHERE id = ?");
                    update.setString(1, input);
                    update.setInt(2, usu.getId());
                    update.executeUpdate();
                    System.out.print(usu.getNick());
                }else{
                    JOptionPane.showMessageDialog(null, "Campo demasiado extenso");
                }
            }else{
                 JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        }catch(SQLException ex){
            System.out.println("Hubo un problema");
        }
    }//GEN-LAST:event_camNombreUsuButActionPerformed

    private void camNombreButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camNombreButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camNombreButActionPerformed

    private void camDescButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camDescButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camDescButActionPerformed

    private void camLugarButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camLugarButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camLugarButActionPerformed

    private void camEdadButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camEdadButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camEdadButActionPerformed

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
            java.util.logging.Logger.getLogger(opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new opciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton camApellidosBut;
    private javax.swing.JButton camContraBut;
    private javax.swing.JButton camDescBut;
    private javax.swing.JButton camEdadBut;
    private javax.swing.JButton camFechaNacBut;
    private javax.swing.JButton camGenBut;
    private javax.swing.JButton camLugarBut;
    private javax.swing.JButton camNombreBut;
    private javax.swing.JButton camNombreUsuBut;
    private javax.swing.JButton camOrSexBut;
    private javax.swing.JButton camResiBut;
    private javax.swing.JButton camSexoBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import proyectofinal.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinal.conectarBBDD;

/**
 *
 * @author Usuario
 */
public class Lista extends javax.swing.JFrame {

    private usuario usu1;
    private ArrayList<String> nicks=new ArrayList<String>();


    public usuario getUsu1() {
        return usu1;
    }

    public void setUsu(usuario usu) {
        this.usu1 = usu;
    }

    /**
     * Creates new form NewJFrame
     */
    public Lista() {
        initComponents();
    }


    public Lista(usuario usu) {
        try {
            this.usu1 = usu;
            initComponents();
            datosTabla(usu1);
        } catch (SQLException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        introNickField = new javax.swing.JTextField();
        atrasBut = new javax.swing.JButton();
        irBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabladatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 680, 340));

        introNickField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introNickFieldActionPerformed(evt);
            }
        });
        getContentPane().add(introNickField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 510, 40));

        atrasBut.setText("Atrás");
        atrasBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButActionPerformed(evt);
            }
        });
        getContentPane().add(atrasBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, 40));

        irBut.setText("Ir");
        irBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irButActionPerformed(evt);
            }
        });
        getContentPane().add(irBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 60, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void introNickFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_introNickFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_introNickFieldActionPerformed

    private void irButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irButActionPerformed
        /*try {
            boolean found = false;
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select id, nick from usuarios where nick = '" + introNickField.getText() + "'");
            while (rs.next()) {
                if (introNickField.getText().equals(rs.getString("nick"))) {
                    found = true;
                    Statement st2 = con.getConnection().createStatement();
                    ResultSet comprExist = st2.executeQuery("select id from matchh where id_usuario0 = '" + usu1.getId() + "' and id_usuario1='" + rs.getInt("id") + "'");
                    if (comprExist.next()) {
                        Statement st3 = con.getConnection().createStatement();
                        ResultSet maxId = st3.executeQuery("select coalesce(max(id), -1) as maxId from mensajes");
                        maxId.next();
                        PreparedStatement insert = con.getConnection().prepareStatement("insert into mensajes (id,mensaje,id_usuario0,id_usuario1,url) values (?,?,?,?,?)");
                        insert.setInt(1, maxId.getInt("maxId") + 1);
                        insert.setString(2, "");
                        insert.setInt(3, usu1.getId());
                        insert.setInt(4, rs.getInt("id"));
                        insert.setString(5, null);
                        insert.executeUpdate();
                        insert.close();
                        JOptionPane.showMessageDialog(null, "MATCH");
                    } else {
                        Statement max = con.getConnection().createStatement();
                        ResultSet maxId = max.executeQuery("select coalesce(max(id), -1) as maxId from mensajes");
                        maxId.next();
                        PreparedStatement insert2 = con.getConnection().prepareStatement("insert into matchh (id,id_usuario0,id_usuario1) values (?,?,?)");
                        insert2.setInt(1, maxId.getInt("maxId") + 1);
                        insert2.setInt(2, rs.getInt("id"));
                        insert2.setInt(3, usu1.getId());
                        insert2.executeUpdate();
                        insert2.close();
                        JOptionPane.showMessageDialog(null, "LIKE");
                    }
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null, "No se encuentra el usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(elegirChat.class.getName()).log(Level.SEVERE, null, ex);
        }*/
         try {
            int i=0;
            boolean found=false;
            while(i<nicks.size()&&!found){
                System.out.println(nicks.size()+" i:"+i+" nick:"+nicks.get(i));
                if (nicks.get(i).contentEquals(introNickField.getText())) {
                    Statement st = con.getConnection().createStatement();
                    ResultSet rs = st.executeQuery("select id, nick from usuarios where nick = '" + introNickField.getText() + "'");
                    rs.next();
                    found = true;
                    Statement st2 = con.getConnection().createStatement();
                    ResultSet comprExist = st2.executeQuery("select id from matchh where id_usuario0 = '" + usu1.getId() + "' and id_usuario1='" + rs.getInt("id") + "'");
                    if (comprExist.next()) {
                        Statement st3 = con.getConnection().createStatement();
                        ResultSet maxId = st3.executeQuery("select coalesce(max(id), -1) as maxId from mensajes");
                        maxId.next();
                        PreparedStatement insert = con.getConnection().prepareStatement("insert into mensajes (id,mensaje,id_usuario0,id_usuario1,url) values (?,?,?,?,?)");
                        insert.setInt(1, maxId.getInt("maxId") + 1);
                        insert.setString(2, "");
                        insert.setInt(3, usu1.getId());
                        insert.setInt(4, rs.getInt("id"));
                        insert.setString(5, null);
                        insert.executeUpdate();
                        insert.close();
                        JOptionPane.showMessageDialog(null, "MATCH");
                    } else {
                        Statement max = con.getConnection().createStatement();
                        ResultSet maxId = max.executeQuery("select coalesce(max(id), -1) as maxId from matchh");
                        maxId.next();
                        PreparedStatement insert2 = con.getConnection().prepareStatement("insert into matchh (id,id_usuario0,id_usuario1) values (?,?,?)");
                        insert2.setInt(1, maxId.getInt("maxId") + 1);
                        insert2.setInt(2, rs.getInt("id"));
                        insert2.setInt(3, usu1.getId());
                        insert2.executeUpdate();
                        insert2.close();
                        JOptionPane.showMessageDialog(null, "LIKE");
                    }
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

    private void atrasButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButActionPerformed
        menuPrincipal menu=new menuPrincipal(usu1);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasButActionPerformed


    /**
     * @param args the command line arguments
     */
    conectarBBDD con = new conectarBBDD();
    Connection cn = con.getConnection();
   
    public void rellenarTabla(String[] datos, String query, DefaultTableModel modelo){
        try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                

                while (rs.next()) {
                    datos[0] = rs.getString("nick");
                    datos[1] = rs.getString("edad");
                    datos[2] = rs.getString("descripcion");
                    nicks.add(rs.getString("nick"));
                    modelo.addRow(datos);
                }
                tabladatos.setModel(modelo);
            } catch (SQLException sQLException) {
            }
    }

    public void datosTabla(usuario usu) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel() {
            //para definir si la celda es editable o no
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("Nick");
        modelo.addColumn("Edad");
        modelo.addColumn("Descripcion");
        tabladatos.setModel(modelo);
        String query;
        String datos[] = new String[3];
        String nick = usu.getNick();
        if (usu.getOrSex().equals("homosexual") && usu.getGenero().equals("masculino")) {
            query = "SELECT nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, descripcion FROM usuarios where (orSex = 'bisexual' AND genero = 'masculino' or orSex = 'homosexual' AND genero = 'masculino') and nick != '" + nick + "';";
            rellenarTabla(datos, query, modelo);
        } else if (usu.getOrSex().equals("homosexual") && usu.getGenero().equals("femenino")) {
            query = "SELECT nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, descripcion FROM usuarios where (orSex = 'bisexual' AND genero = 'femenino' or orSex = 'homosexual' AND genero = 'femenino') and nick != '" + nick + "';";
            rellenarTabla(datos, query, modelo);
        } else if (usu.getOrSex().equals("heterosexual") && usu.getGenero().equals("femenino")) {
            query = "SELECT nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, descripcion FROM usuarios where (orSex = 'bisexual' AND genero = 'masculino' or orSex = 'heterosexual' AND genero = 'masculino') and nick != '" + nick + "';";
            rellenarTabla(datos, query, modelo);
        } else if (usu.getOrSex().equals("heterosexual") && usu.getGenero().equals("masculino")) {
            query = "SELECT nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, descripcion FROM usuarios where (orSex = 'heterosexual' AND genero = 'femenino' or orSex = 'bisexual' AND genero = 'femenino') and nick != '" + nick + "';";
            rellenarTabla(datos, query, modelo);
        } else if (usu.getOrSex().equals("bisexual") && usu.getGenero().equals("masculino")) {
            query = "SELECT nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, descripcion FROM usuarios where (orSex = 'heterosexual' AND genero = 'femenino' or orSex = 'homosexual' AND genero = 'masculino' or orSex = 'bisexual' AND genero = 'femenino' or orSex = 'bisexual' AND genero = 'masculino') and nick != '" + nick + "';";
            rellenarTabla(datos, query, modelo);
        } else if (usu.getOrSex().equals("bisexual") && usu.getGenero().equals("femenino")) {
            query = "SELECT nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, descripcion FROM usuarios where (orSex = 'heterosexual' AND genero = 'masculino' or orSex = 'homosexual' AND genero = 'femenino' or orSex = 'bisexual' AND genero = 'femenino' or orSex = 'bisexual' AND genero = 'masculino') and nick != '" + nick + "';";
            rellenarTabla(datos, query, modelo);
        }
    }

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
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasBut;
    private javax.swing.JTextField introNickField;
    private javax.swing.JButton irBut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabladatos;
    // End of variables declaration//GEN-END:variables
}

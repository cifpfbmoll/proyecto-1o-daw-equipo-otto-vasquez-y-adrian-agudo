/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import proyectofinal.conectarBBDD;
import proyectofinal.usuario;

/**
 *
 * @author Usuario
 */
public class match extends javax.swing.JFrame {

    conectarBBDD con = new conectarBBDD();
    Connection cn = con.getConnection();
    public static ResultSet rs = null;
    public static Statement st = null;
    private usuario usu;

    /**
     * Creates new form match
     */
    public match() {
        initComponents();
    }

    public match(usuario usu) throws SQLException, IOException {
        this.usu = usu;
        initComponents();
        statementImagen(usu);

    }

    public usuario getUsu() {
        return usu;
    }

    public void setUsu(usuario usu) {
        this.usu = usu;
    }

    public void statementImagen(usuario usu) {
        try {
            String query = "";
            String nick = usu.getNick();
            if (usu.getOrSex().equals("homosexual") && usu.getGenero().equals("masculino")) {
                query = "SELECT id, nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, provincia, descripcion, imgperfil FROM usuarios where (orSex = 'bisexual' AND genero = 'masculino' or orSex = 'homosexual' AND genero = 'masculino') and nick != '" + nick + "';";
            } else if (usu.getOrSex().equals("homosexual") && usu.getGenero().equals("femenino")) {
                query = "SELECT id, nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, provincia, descripcion, imgperfil FROM usuarios where (orSex = 'bisexual' AND genero = 'femenino' or orSex = 'homosexual' AND genero = 'femenino') and nick != '" + nick + "';";
            } else if (usu.getOrSex().equals("heterosexual") && usu.getGenero().equals("femenino")) {
                query = "SELECT id, nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, provincia, descripcion, imgperfil FROM usuarios where (orSex = 'bisexual' AND genero = 'masculino' or orSex = 'heterosexual' AND genero = 'masculino') and nick != '" + nick + "';";
            } else if (usu.getOrSex().equals("heterosexual") && usu.getGenero().equals("masculino")) {
                query = "SELECT id, nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, provincia, descripcion, imgperfil FROM usuarios where (orSex = 'heterosexual' AND genero = 'femenino' or orSex = 'bisexual' AND genero = 'femenino') and nick != '" + nick + "';";
            } else if (usu.getOrSex().equals("bisexual") && usu.getGenero().equals("masculino")) {
                query = "SELECT id, nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, provincia, descripcion, imgperfil FROM usuarios where (orSex = 'heterosexual' AND genero = 'femenino' or orSex = 'homosexual' AND genero = 'masculino' or orSex = 'bisexual' AND genero = 'femenino' or orSex = 'bisexual' AND genero = 'masculino') and nick != '" + nick + "';";
            } else if (usu.getOrSex().equals("bisexual") && usu.getGenero().equals("femenino")) {
                query = "SELECT id, nick, TIMESTAMPDIFF(YEAR,fechaNac,CURDATE()) AS edad, provincia, descripcion, imgperfil FROM usuarios where (orSex = 'heterosexual' AND genero = 'masculino' or orSex = 'homosexual' AND genero = 'femenino' or orSex = 'bisexual' AND genero = 'femenino' or orSex = 'bisexual' AND genero = 'masculino') and nick != '" + nick + "';";
            }
            llamarInfo(usu, query);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en la imagen");
        }
    }

    public void llamarInfo(usuario usu, String query) throws SQLException, IOException {
        st = cn.createStatement();
        rs = st.executeQuery(query);
        rs.first();
        byte[] img = rs.getBytes("imgperfil");
        Image imagen = getImage(img, false);
        imagen = imagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        foto.setIcon(new ImageIcon(imagen));

        st = cn.createStatement();
        rs = st.executeQuery(query);
        rs.first();
        nick.setText(rs.getString("nick"));
        edad.setText(rs.getString("edad"));
        provincia.setText(rs.getString("provincia"));
        descripcion.setText(rs.getString("descripcion"));
    }

    public void siguienteInfo(usuario usu) throws SQLException, IOException {
        byte[] img = rs.getBytes("imgperfil");
        Image imagen = getImage(img, false);
        imagen = imagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        foto.setIcon(new ImageIcon(imagen));

        nick.setText(rs.getString("nick"));
        edad.setText(rs.getString("edad"));
        provincia.setText(rs.getString("provincia"));
        descripcion.setText(rs.getString("descripcion"));
    }

    private Image getImage(byte[] bytes, boolean isThumbnail) throws IOException {

        ImageReader reader = null;
        ImageReadParam param = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            Iterator readers = ImageIO.getImageReadersByFormatName("png");
            reader = (ImageReader) readers.next();
            Object source = bis; // File or InputStream
            ImageInputStream iis = ImageIO.createImageInputStream(source);
            reader.setInput(iis, true);
            param = reader.getDefaultReadParam();
            if (isThumbnail) {

                param.setSourceSubsampling(4, 4, 0, 0);

            }
        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, "png error");
        }
        return reader.read(0, param);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        foto = new javax.swing.JLabel();
        likeBut = new javax.swing.JButton();
        DislikeBut = new javax.swing.JButton();
        nick = new javax.swing.JLabel();
        edad = new javax.swing.JLabel();
        provincia = new javax.swing.JLabel();
        txt = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        atrasBut = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 41, 297, 240));

        likeBut.setText("Like");
        likeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeButActionPerformed(evt);
            }
        });
        getContentPane().add(likeBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        DislikeBut.setText("Dislike");
        DislikeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DislikeButActionPerformed(evt);
            }
        });
        getContentPane().add(DislikeBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        nick.setText("jLabel1");
        getContentPane().add(nick, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 315, -1, -1));

        edad.setText("jLabel2");
        getContentPane().add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 315, -1, -1));

        provincia.setText("jLabel3");
        getContentPane().add(provincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 347, -1, -1));

        descripcion.setColumns(20);
        descripcion.setRows(5);
        txt.setViewportView(descripcion);

        getContentPane().add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 250, 120));

        atrasBut.setText("Atras");
        atrasBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButActionPerformed(evt);
            }
        });
        getContentPane().add(atrasBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo instrucciones.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void likeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeButActionPerformed
        try {
            if (!rs.isAfterLast()) {

                Statement st2 = con.getConnection().createStatement();
                ResultSet comprExist = st2.executeQuery("select id from matchh where id_usuario0 = '" + usu.getId() + "' and id_usuario1='" + rs.getInt("id") + "'");
                if (comprExist.next()) {
                    Statement st3 = con.getConnection().createStatement();
                    ResultSet maxId = st3.executeQuery("select coalesce(max(id), -1) as maxId from mensajes");
                    maxId.next();
                    PreparedStatement insert = con.getConnection().prepareStatement("insert into mensajes (id,mensaje,id_usuario0,id_usuario1,url) values (?,?,?,?,?)");
                    insert.setInt(1, maxId.getInt("maxId") + 1);
                    insert.setString(2, "");
                    insert.setInt(3, usu.getId());
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
                    insert2.setInt(3, usu.getId());
                    insert2.executeUpdate();
                    insert2.close();
                    JOptionPane.showMessageDialog(null, "LIKE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Has llegado al final");
            }
            rs.next();
            siguienteInfo(usu);
            
        } catch (SQLException ex) {
            Logger.getLogger(match.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(match.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_likeButActionPerformed

    private void DislikeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DislikeButActionPerformed
        try {
            if (!rs.isAfterLast()) {
                rs.next();
                siguienteInfo(usu);
            } else {
                JOptionPane.showMessageDialog(null, "Has llegado al final");
            }

        } catch (SQLException ex) {
            Logger.getLogger(match.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(match.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DislikeButActionPerformed

    private void atrasButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButActionPerformed
        menuPrincipal menu = new menuPrincipal(usu);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atrasButActionPerformed

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
            java.util.logging.Logger.getLogger(match.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(match.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(match.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(match.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new match().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DislikeBut;
    private javax.swing.JButton atrasBut;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel edad;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel foto;
    private javax.swing.JButton likeBut;
    private javax.swing.JLabel nick;
    private javax.swing.JLabel provincia;
    private javax.swing.JScrollPane txt;
    // End of variables declaration//GEN-END:variables
}

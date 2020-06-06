/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import proyectofinal.usuario;
import com.mysql.jdbc.MysqlDataTruncation;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyectofinal.conectarBBDD;
import static ventanas.match.rs;

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

    public opciones(usuario usu) {
        this.usu = usu;
        initComponents();
        fotoActual();
        guardarFoto.hide();
    }

    public usuario getUsu() {
        return usu;
    }

    public void setUsu(usuario usu) {
        this.usu = usu;
    }

    public void fotoActual() {

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT imgperfil from usuarios where id=" + usu.getId() + ";");
            rs.next();
            byte[] img = rs.getBytes("imgperfil");
            Image imagen = getImage(img, false);
            imagen = imagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            fotoPerf.setIcon(new ImageIcon(imagen));
        } catch (SQLException ex) {
            Logger.getLogger(opciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        camContraBut = new javax.swing.JButton();
        camNombreUsuBut = new javax.swing.JButton();
        camResiBut = new javax.swing.JButton();
        camFechaNacBut = new javax.swing.JButton();
        camNombreBut = new javax.swing.JButton();
        camApellidosBut = new javax.swing.JButton();
        camDescBut = new javax.swing.JButton();
        camGenBut = new javax.swing.JButton();
        atrasBut = new javax.swing.JButton();
        cambiarFoto = new javax.swing.JButton();
        fotoPerf = new javax.swing.JLabel();
        rutaimg = new javax.swing.JLabel();
        guardarFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("OPCIONES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel2.setText("Modificar perfíl");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        camContraBut.setText("Cambiar contraseña");
        camContraBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camContraButActionPerformed(evt);
            }
        });
        getContentPane().add(camContraBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 118, 188, -1));

        camNombreUsuBut.setText("Cambiar nombre de usuario");
        camNombreUsuBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camNombreUsuButActionPerformed(evt);
            }
        });
        getContentPane().add(camNombreUsuBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 84, 190, -1));

        camResiBut.setText("Cambiar residencia");
        camResiBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camResiButActionPerformed(evt);
            }
        });
        getContentPane().add(camResiBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 152, 188, -1));

        camFechaNacBut.setText("Cambiar fecha nacimiento");
        camFechaNacBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camFechaNacButActionPerformed(evt);
            }
        });
        getContentPane().add(camFechaNacBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 181, 188, -1));

        camNombreBut.setText("Cambiar nombre");
        camNombreBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camNombreButActionPerformed(evt);
            }
        });
        getContentPane().add(camNombreBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 84, 255, -1));

        camApellidosBut.setText("Cambiar apellidos");
        camApellidosBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camApellidosButActionPerformed(evt);
            }
        });
        getContentPane().add(camApellidosBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 118, 255, -1));

        camDescBut.setText("Cambiar descripción");
        camDescBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camDescButActionPerformed(evt);
            }
        });
        getContentPane().add(camDescBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 152, 255, -1));

        camGenBut.setText("Cambiar género");
        camGenBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camGenButActionPerformed(evt);
            }
        });
        getContentPane().add(camGenBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 181, 255, -1));

        atrasBut.setText("Atrás");
        atrasBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButActionPerformed(evt);
            }
        });
        getContentPane().add(atrasBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, -1, -1));

        cambiarFoto.setText("Cambiar foto de perfil");
        cambiarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(cambiarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 215, 188, -1));
        getContentPane().add(fotoPerf, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 200, 200));
        getContentPane().add(rutaimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 244, 188, 23));

        guardarFoto.setText("Guardar foto");
        guardarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(guardarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void camNombreUsuButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camNombreUsuButActionPerformed
        try {
            String input = JOptionPane.showInputDialog("Introducir nuevo NOMBRE DE USUARIO");
            if (!input.equals("")) {
                if (input.length() <= 10) {
                    Statement st2 = con.getConnection().createStatement();
                    ResultSet usuarios = st2.executeQuery("select * from usuarios where nick ='" + input + "'");
                    if (!usuarios.next()) {
                        PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET nick = ? WHERE id = ?");
                        update.setString(1, input);
                        update.setInt(2, usu.getId());
                        update.executeUpdate();
                        usu.setNick(input);
                        update.close();
                        JOptionPane.showMessageDialog(null, "Se realizó el cambio correctamente");
                    } else {
                        if (usu.getNick().equals(input)) {
                            JOptionPane.showMessageDialog(null, "Debe de introducir un nuevo campo distinto al que ya tenia");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe el usuario");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campo demasiado extenso");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema");
        }
    }//GEN-LAST:event_camNombreUsuButActionPerformed

    private void camNombreButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camNombreButActionPerformed
        try {
            String input = JOptionPane.showInputDialog("Introducir nuevo NOMBRE");
            if (!input.equals("")) {
                if (input.length() <= 20) {
                    PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET nombre = ? WHERE id = ?");
                    update.setString(1, input);
                    update.setInt(2, usu.getId());
                    update.executeUpdate();
                    usu.setNombre(input);
                    update.close();
                    JOptionPane.showMessageDialog(null, "Se realizó el cambio correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Campo demasiado extenso");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema");
        }
    }//GEN-LAST:event_camNombreButActionPerformed

    private void camDescButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camDescButActionPerformed
        try {
            String input = JOptionPane.showInputDialog("Introducir nueva DESCRIPCIÓN");
            if (!input.equals("")) {
                PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET descripcion = ? WHERE id = ?");
                update.setString(1, input);
                update.setInt(2, usu.getId());
                update.executeUpdate();
                usu.setDescripcion(input);
                update.close();
                JOptionPane.showMessageDialog(null, "Se realizó el cambio correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema");
        }
    }//GEN-LAST:event_camDescButActionPerformed

    private void camApellidosButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camApellidosButActionPerformed
        try {
            String input = JOptionPane.showInputDialog("Introducir nuevos APELLIDOS");
            if (!input.equals("")) {
                PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET apellidos = ? WHERE id = ?");
                update.setString(1, input);
                update.setInt(2, usu.getId());
                update.executeUpdate();
                usu.setApellidos(input);
                update.close();
                JOptionPane.showMessageDialog(null, "Se realizó el cambio correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema");
        }
    }//GEN-LAST:event_camApellidosButActionPerformed

    private void camGenButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camGenButActionPerformed
        try {
            String genero;
            String anterior = usu.getGenero();
            System.out.println(anterior);
            PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET genero = ? WHERE id = ?");
            if (anterior.equals("masculino")) {
                genero = "femenino";
                usu.setGenero("femenino");
            } else {
                genero = "masculino";
                usu.setGenero("masculino");
            }
            update.setString(1, genero);
            update.setInt(2, usu.getId());
            update.executeUpdate();
//            update.close();
            JOptionPane.showMessageDialog(null, "Se cambió de género de " + anterior + " a " + usu.getGenero());
        } catch (SQLException ex) {
            Logger.getLogger(opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_camGenButActionPerformed

    private void camContraButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camContraButActionPerformed
        try {
            String input = JOptionPane.showInputDialog("Introducir nueva CONTRASEÑA");
            if (!input.equals("")) {
                PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET contraseña = ? WHERE id = ?");
                update.setString(1, input);
                update.setInt(2, usu.getId());
                update.executeUpdate();
                update.close();
                JOptionPane.showMessageDialog(null, "Se realizó el cambio correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema");
        }
    }//GEN-LAST:event_camContraButActionPerformed

    private void camFechaNacButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camFechaNacButActionPerformed
        try {
            String input = JOptionPane.showInputDialog("Introducir nueva FECHA DE NACIMIENTO");
            Pattern patron = Pattern.compile("[0-9]{4}/[0-9]{2}/[0-9]{2}");
            Matcher mat = patron.matcher(input);
            if (!input.equals("")) {
                if (mat.matches()) {
                    PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET fechaNac = ? WHERE id = ?");
                    update.setString(1, input);
                    update.setInt(2, usu.getId());
                    update.executeUpdate();
                    usu.setFechaNac(input);
                    update.close();
                    JOptionPane.showMessageDialog(null, "Se realizó el cambio correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha no se adecua al formato (YYYY-MM-DD)");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        } catch (MysqlDataTruncation ex2) {
            JOptionPane.showMessageDialog(null, "Fecha errónea");
        } catch (SQLException ex) {
            System.out.println("Hubo un problema");
        }
    }//GEN-LAST:event_camFechaNacButActionPerformed

    private void camResiButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camResiButActionPerformed
        try {
            String input = JOptionPane.showInputDialog("Introducir nueva PROVINCIA");
            if (!input.equals("")) {
                PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET provincia = ? WHERE id = ?");
                update.setString(1, input);
                update.setInt(2, usu.getId());
                update.executeUpdate();
                usu.setProvincia(input);
                update.close();
                JOptionPane.showMessageDialog(null, "Se realizó el cambio correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacío");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema");
        }
    }//GEN-LAST:event_camResiButActionPerformed

    private void atrasButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButActionPerformed

        menuPrincipal menu = new menuPrincipal(usu);
        menu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_atrasButActionPerformed

    private void cambiarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarFotoActionPerformed
        guardarFoto.show();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos PNG", "png"); //filtro archivos
        JFileChooser archivo = new JFileChooser();
        archivo.setFileFilter(filtro);
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Seleccione archivo");
        int ventana = archivo.showOpenDialog(null);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            float longitudbytes = (float) archivo.getSelectedFile().length();

            //limitar tamaño imagen
            if (longitudbytes > 2000000) {
                JOptionPane.showMessageDialog(null, "La imagen debe pesar menos de 2MB, actualmente pesa: " + (longitudbytes / 1000000) + " MB");
            } else {
                rutaimg.setText(String.valueOf(file));
                Image foto = getToolkit().getImage(rutaimg.getText());
                foto = foto.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                fotoPerf.setIcon(new ImageIcon(foto));
            }
        }
    }//GEN-LAST:event_cambiarFotoActionPerformed

    private void guardarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarFotoActionPerformed
        try {
            FileInputStream archivofoto = new FileInputStream(rutaimg.getText());
            PreparedStatement update = con.getConnection().prepareStatement("UPDATE usuarios SET imgperfil = ? WHERE id = ?");
            update.setBinaryStream(1, archivofoto);
            update.setInt(2, usu.getId());
            update.executeUpdate();
            update.close();
            guardarFoto.hide();
            fotoActual();

        } catch (SQLException ex) {
            Logger.getLogger(opciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarFotoActionPerformed

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
    private javax.swing.JButton atrasBut;
    private javax.swing.JButton camApellidosBut;
    private javax.swing.JButton camContraBut;
    private javax.swing.JButton camDescBut;
    private javax.swing.JButton camFechaNacBut;
    private javax.swing.JButton camGenBut;
    private javax.swing.JButton camNombreBut;
    private javax.swing.JButton camNombreUsuBut;
    private javax.swing.JButton camResiBut;
    private javax.swing.JButton cambiarFoto;
    private javax.swing.JLabel fotoPerf;
    private javax.swing.JButton guardarFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel rutaimg;
    // End of variables declaration//GEN-END:variables
}

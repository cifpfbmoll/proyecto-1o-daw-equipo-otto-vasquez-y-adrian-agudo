/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADRI
 */
public class conectarBBDD {
    public static Connection conn;
    public conectarBBDD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/proyecto";
            conn = DriverManager.getConnection (url,"root","123picalaparet");
        } catch (SQLException ex) {
            Logger.getLogger(conectarBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex2){
            System.err.print("caput");
        }
    }
    public Connection getConnection(){
        return conn;
    }
    public void desconectar(){
        conn=null;
    }
}

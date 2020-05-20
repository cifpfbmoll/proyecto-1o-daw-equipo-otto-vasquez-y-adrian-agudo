/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author ADRI
 */
public class InicioSesion {
    private String contraseña;
    private String usuario;

    public InicioSesion(String contraseña, String usuario) {
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    public InicioSesion() {
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public void printar(){
        System.out.println(this.getUsuario());
        System.out.println(this.getContraseña());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

/**
 *
 * @author ADRI
 */
public class usuario {

    private int id;
    private String nick;
    private String contraseña;
    private String nombre;
    private String apellidos;
    private String genero;
    private String orSex;
    private String provincia;
    private String fechaNac;
    private String descripcion;
    private String imagen;

    public usuario(String nick, String contraseña, String nombre, String apellidos, String genero, String orSex, String provincia, String fechaNac, String descripcion, String imagen) {
        this.nick = nick;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.orSex = orSex;
        this.provincia = provincia;
        this.fechaNac = fechaNac;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public usuario() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public usuario(String imagen) {
        this.imagen = imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setOrSex(String orSex) {
        this.orSex = orSex;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public String getOrSex() {
        return orSex;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getDescripcion() {
        return descripcion;
    }

}

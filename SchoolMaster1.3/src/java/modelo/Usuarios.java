/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Danny
 */
public class Usuarios {
    private int ID_usuario;
    private String correo;
    private String clave;
    private String tipo_usuario;
    private int id_u_registro;

    public Usuarios(int ID_usuario, String correo, String clave, String tipo_usuario, int id_u_registro) {
        this.ID_usuario = ID_usuario;
        this.correo = correo;
        this.clave = clave;
        this.tipo_usuario = tipo_usuario;
        this.id_u_registro = id_u_registro;
    }

    public int getID_usuario() {
        return ID_usuario;
    }

    public void setID_usuario(int ID_usuario) {
        this.ID_usuario = ID_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public int getId_u_registro() {
        return id_u_registro;
    }

    public void setId_u_registro(int id_u_registro) {
        this.id_u_registro = id_u_registro;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny
 */
public class UsuariosDAO {
    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    
    public UsuariosDAO() {
        Conexion con=new Conexion();
        conexion = con.getConexion();
    }    
    
    //metodo para listar
    public List<Usuarios> listarUsuarios(){
        
        String sql = "SELECT ID_USUARIO, CORREO, CLAVE, TIPO_USUARIO, ID_U_REGISTRO FROM USUARIOS";
        List<Usuarios> lista= new ArrayList<>();
        try {
            
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while(rs.next()){
                int id_usuario = rs.getInt("ID_USUARIO");
                String correo = rs.getString("CORREO");
                String clave = rs.getString("CLAVE");
                String tipo_u = rs.getString("TIPO_USUARIO");
                int id_u_registro = rs.getInt("ID_U_REGISTRO");
                
                Usuarios usuario = new Usuarios(id_usuario, correo, clave, tipo_u, id_u_registro);
                
                lista.add(usuario);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para mostrar
    public boolean validarCorreoClave(String validarCorreo, String validarClave){
        
        String sql = "SELECT ID_USUARIO, CORREO, CLAVE, TIPO_USUARIO FROM USUARIOS WHERE CORREO=? AND CLAVE=?";
        int id_usuario = 0;
        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, validarCorreo);
            ps.setString(2, validarClave);
            rs = ps.executeQuery();
            while(rs.next()){
                id_usuario = rs.getInt("ID_USUARIO");
            }
        }
              
            
        catch (SQLException e) {
            System.out.println(e.toString());
            
        }
        return id_usuario!=0;
    }

    public Usuarios validarUsuario(String validarCorreo, String validarClave){
        
        Usuarios usuario = null;
        String sql = "SELECT ID_USUARIO, CORREO, CLAVE, TIPO_USUARIO, ID_U_REGISTRO FROM USUARIOS WHERE CORREO=? AND CLAVE=?";
        
        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, validarCorreo);
            ps.setString(2, validarClave);
            rs = ps.executeQuery();
            while(rs.next()){
                int id_usuario = rs.getInt("ID_USUARIO");
                String correo = rs.getString("CORREO");
                String clave = rs.getString("CLAVE");
                String tipo_u = rs.getString("TIPO_USUARIO");
                int id_u_registro = rs.getInt("ID_U_REGISTRO");
                
                usuario = new Usuarios(id_usuario, correo, clave, tipo_u, id_u_registro);
                
            }
            return usuario;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para insertar
    public boolean insertarUsuario(Usuarios usuarios){
        
        String sql = "INSERT INTO USUARIOS (ID_USUARIO, CORREO, CLAVE, TIPO_USUARIO) VALUES (USUARIOS_SEQ.NEXTVAL,?,?,?)";
        
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, usuarios.getCorreo());
            ps.setString(2, usuarios.getClave());
            ps.setString(3, usuarios.getTipo_usuario());
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Registro fallido interno: "+e.toString());
            return false;
        }
    }
    
    //metodo para actualizar
    public boolean actualizarUsuario(Usuarios usuario, int id ){
        
        String sql = "UPDATE USUARIOS SET ID_USUARIO=?, CORREO=?, CLAVE=? WHERE ID_USUARIO=?";
        
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getClave());
            ps.setInt(3, id);
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    //metodo para eliminar
    public boolean eliminarUsuario(int id){
        String sql = "DELETE FROM USUARIO WHERE ID_USUARIO=?";
        
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
//    public static void main(String[] args) {
//        String correo = "correo_acu";
//            String numero_i = "numero_i_acu";
//            
//
//            Usuarios usuarios = new Usuarios(0, correo, numero_i);
//            UsuariosDAO usuariosDAO = new UsuariosDAO();
//            usuariosDAO.insertarUsuario(usuarios);
//    }
}

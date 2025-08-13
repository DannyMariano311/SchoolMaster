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
public class NivelesDAO {
    
    Connection conexion;

    public NivelesDAO() {
        Conexion con=new Conexion();
        conexion = con.getConexion();
    }
    
    //metodo para listar
    public List<Niveles> listarNiveles(){
        
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT ID_NIVELES, NOMBRE_NIVEL, JORNADA, ID_PROFESOR_NIVEL FROM TBL_NIVELES";
        List<Niveles> lista= new ArrayList<>();
        try {
            
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while(rs.next()){
                int id_nivel = rs.getInt("ID_NIVELES");
                String nombre = rs.getString("NOMBRE_NIVEL");
                int jornada = rs.getInt("JORNADA");
                int id_profe = rs.getInt("ID_PROFE_NIVEL");
                
                Niveles niveles = new Niveles(id_nivel, nombre, jornada, null, id_profe, null);
                
                lista.add(niveles);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para mostrar
    public List<Niveles> mostrarNiveles(int id){
        
        List<Niveles> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        Niveles niveles;
        String sql = "SELECT ID_NIVELES, NOMBRE_NIVEL, JORNADA, ID_PROFESOR_NIVEL FROM TBL_NIVELES WHERE ID_NIVELES=?";
        
        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                int id_nivel = rs.getInt("ID_NIVELES");
                String nombre = rs.getString("NOMBRE_NIVEL");
                int jornada = rs.getInt("JORNADA");
                int id_profe = rs.getInt("ID_PROFESOR_NIVEL");
                
                niveles = new Niveles(id_nivel, nombre, jornada, null, id_profe, null);
                busqueda.add(niveles);
            }
            return busqueda;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public List<Niveles> nivelMostrar(int id){
        
        List<Niveles> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        Niveles niveles;
        String sql = "select id_niveles, nombre_nivel, nombre_jornada, numero_identidad_pro, nombre_pro, primer_apellido_pro, segundo_apellido_pro\n" +
            "from tbl_niveles\n" +
            "inner join tbl_jornadas on codigo_jornada = jornada\n" +
            "inner join tbl_profesor on id_profesor = id_profesor_nivel\n" +
            "where id_niveles = ?";
        
        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                int id_nivel = rs.getInt("ID_NIVELES");
                String nombre = rs.getString("NOMBRE_NIVEL");
                String jornada = rs.getString("NOMBRE_JORNADA");
                String info_profe = "Documento: "+rs.getString("NUMERO_IDENTIDAD_PRO")+" Nombre: "+rs.getString("nombre_pro")+rs.getString("primer_apellido_pro")+rs.getString("segundo_apellido_pro");
                
                niveles = new Niveles(id_nivel, nombre, 0, jornada, 0, info_profe);
                busqueda.add(niveles);
            }
            return busqueda;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para insertar
    public boolean insertarNivel(Niveles niveles){
        
        PreparedStatement ps;
        
        String sql = "INSERT INTO TBL_NIVELES (ID_NIVELES, NOMBRE_NIVEL, JORNADA, ID_PROFESOR_NIVEL) VALUES (NIVELES_SEQ.NEXTVAL,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, niveles.getNombre_nivel());
            ps.setInt(2, niveles.getJornada());
            ps.setInt(3, niveles.getId_profesor_nivel());
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Registro fallido interno: "+e.toString());
            return false;
        }
    }
    
    //metodo para actualizar
    public boolean actualizarNivel(Niveles niveles, int id ){
        
        PreparedStatement ps;
        String sql = "UPDATE TBL_NIVELES SET  NOMBRE_NIVEL=?, JORNADA=?, ID_PROFESOR_NIVEL=? WHERE ID_NIVELES=?";
        
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, niveles.getNombre_nivel());
            ps.setInt(2, niveles.getJornada());
            ps.setInt(3, niveles.getId_profesor_nivel());
            ps.setInt(4, id);
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    //metodo para eliminar
    public boolean eliminarNivel(int id){
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("DELETE FROM TBL_NIVELES WHERE ID_NIVELES=?");
            
            ps.setInt(1, id);
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
//    public static void main(String[] args) {
//        NivelesDAO ndao=new NivelesDAO();
//        Niveles n=new Niveles(1,"primerito", 2, 12);
//        ndao.insertarNivel(n);
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny
 */
public class AlumnosDAO {
    
    Connection conexion;

    public AlumnosDAO() {
        Conexion con=new Conexion();
        conexion = con.getConexion();
    }
    
    //metodo para listar
    public List<Alumnos> listarAlumnos(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Alumnos> lista= new ArrayList<>();
        String sql = "SELECT ID_ALUMNO, TIPO_IDENTIDAD_ALUM, NUMERO_IDENTIDAD_ALUM, NOMBRE_ALUMNO, PRIMER_APELLIDO_ALUM, SEGUNDO_APELLIDO_ALUM, FECHA_NACIMIENTO_ALUM, GENERO_ALUM, FECHA_INGRESO_ALUM, NIVEL_ACADEMICO, DIRECCION_RESIDENCIA_ALUM FROM TBL_ALUMNO";
        try {
            
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while(rs.next()){
                int id_alumno = rs.getInt("ID_ALUMNO");
                int tipo_i = rs.getInt("Tipo_identidad_alum");
                String numero_i = rs.getString("Numero_identidad_alum");
                String nombre = rs.getString("Nombre_alumno");
                String p_apellido = rs.getString("Primer_apellido_alum");
                String s_apellido = rs.getString("Segundo_apellido_alum");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_alum");
                int genero = rs.getInt("Genero_alum");
                Date ingreso = rs.getDate("Fecha_ingreso_alum");
                int nivel = rs.getInt("NIVEL_ACADEMINCO");
                String residencia = rs.getString("Direccion_Residencia_pro");
                
                
                
                
                Alumnos alumnos = new Alumnos(id_alumno, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, nacimiento, genero, null, ingreso, nivel, null, residencia);
                
                lista.add(alumnos);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para mostrar un alumno
    public List<Alumnos> mostrarAlumnos(int id){
        
        List<Alumnos> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        Alumnos alumnos;
        String sql = "SELECT ID_ALUMNO, TIPO_IDENTIDAD_ALUM, NUMERO_IDENTIDAD_ALUM, NOMBRE_ALUMNO, PRIMER_APELLIDO_ALUM, SEGUNDO_APELLIDO_ALUM, FECHA_NACIMIENTO_ALUM, GENERO_ALUM, FECHA_INGRESO_ALUM, NIVEL_ACADEMICO, DIRECCION_RESIDENCIA_ALUM FROM TBL_ALUMNO "
                +" WHERE ID_ALUMNO=?";

        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                int id_alumno = rs.getInt("Id_alumno");
                int tipo_i = rs.getInt("Tipo_identidad_alum");
                String numero_i = rs.getString("Numero_identidad_alum");
                String nombre = rs.getString("Nombre_alumno");
                String p_apellido = rs.getString("Primer_apellido_alum");
                String s_apellido = rs.getString("Segundo_apellido_alum");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_alum");
                int genero = rs.getInt("Genero_alum");
                Date ingreso = rs.getDate("Fecha_ingreso_alum");
                int nivel = rs.getInt("Nivel_academico");
                String residencia = rs.getString("Direccion_Residencia_alum");
                
                
                alumnos = new Alumnos(id_alumno, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, nacimiento, genero, null, ingreso, nivel, null, residencia);
                busqueda.add(alumnos);
            }
            return busqueda;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para mostrar un alumno con atributos específicos
    public List<Alumnos> alumnosMostrar(int id){
        
        List<Alumnos> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        Alumnos alumnos;
        String sql = "SELECT ID_ALUMNO, NOMBRE_T_IDENTIDAD, NUMERO_IDENTIDAD_ALUM, NOMBRE_ALUMNO, PRIMER_APELLIDO_ALUM, SEGUNDO_APELLIDO_ALUM, FECHA_NACIMIENTO_ALUM, NOMBRE_GENERO, FECHA_INGRESO_ALUM, NOMBRE_NIVEL, DIRECCION_RESIDENCIA_ALUM\n" +
            "FROM TBL_ALUMNO\n" +
            "INNER JOIN TBL_TIPO_IDENTIDAD ON CODIGO_T_IDENTIDAD = TIPO_IDENTIDAD_ALUM\n" +
            "INNER JOIN TBL_GENERO ON CODIGO_GENERO = GENERO_ALUM\n" +
            "INNER JOIN TBL_NIVELES ON ID_NIVELES = NIVEL_ACADEMICO\n" +
            "WHERE ID_ALUMNO =?";

        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                int id_alumno = rs.getInt("Id_alumno");
                String tipo_i = rs.getString("nombre_t_identidad");
                String numero_i = rs.getString("Numero_identidad_alum");
                String nombre = rs.getString("Nombre_alumno");
                String p_apellido = rs.getString("Primer_apellido_alum");
                String s_apellido = rs.getString("Segundo_apellido_alum");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_alum");
                String genero = rs.getString("nombre_genero");
                Date ingreso = rs.getDate("Fecha_ingreso_alum");
                String nivel = rs.getString("nombre_nivel");
                String residencia = rs.getString("Direccion_Residencia_alum");
                
                
                alumnos = new Alumnos(id_alumno, 0, tipo_i, numero_i, nombre, p_apellido, s_apellido, nacimiento, 0, genero, ingreso, 0, nivel, residencia);
                busqueda.add(alumnos);
            }
            return busqueda;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para insertar un alumno
    public boolean insertarAlumno(Alumnos alumnos){
        
        PreparedStatement ps;
        
        String sql = "INSERT INTO TBL_ALUMNO (ID_ALUMNO, TIPO_IDENTIDAD_ALUM, NUMERO_IDENTIDAD_ALUM, NOMBRE_ALUMNO, PRIMER_APELLIDO_ALUM, SEGUNDO_APELLIDO_ALUM, FECHA_NACIMIENTO_ALUM, GENERO_ALUM, FECHA_INGRESO_ALUM, NIVEL_ACADEMICO, DIRECCION_RESIDENCIA_ALUM) "
                +" VALUES  (ALUMNOS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, alumnos.getTipo_identidad_alum());
            ps.setString(2, alumnos.getNumero_identidad_alum());
            ps.setString(3, alumnos.getNombre_alumno());
            ps.setString(4, alumnos.getPrimer_apellido_alum());
            ps.setString(5, alumnos.getSegundo_apellido_alum());
            ps.setDate(6, (Date) alumnos.getFecha_nacimiento_alum());
            ps.setInt(7, alumnos.getGenero_alum());
            ps.setDate(8, (Date) alumnos.getFecha_ingreso_alum());
            ps.setInt(9, alumnos.getNivel_academico());
            ps.setString(10, alumnos.getDireccion_residencia_alum());

            ps.executeUpdate();
           
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Registro fallido interno: "+e.toString());
            return false;
        }
        
    }
    
    //metodo para insertarle una observacion a un alumno
    public boolean insertarObservacion(String observacion, int id_alumno){
        
        PreparedStatement ps;
        
        String sql = "UPDATE TBL_ALUMNO SET OBSERVACION=?  "
                +" WHERE ID_ALUMNO=?";
        try {
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, observacion);
            ps.setInt(2, id_alumno);
            
            ps.executeUpdate();
           
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Registro fallido interno: "+e.toString());
            return false;
        }
        
    }
    
    //metodo para actualizar
    public boolean actualizarAlumno(Alumnos alumnos, int id){
        
        PreparedStatement ps;
        String sql = "UPDATE TBL_ALUMNO SET TIPO_IDENTIDAD_ALUM=?, NUMERO_IDENTIDAD_ALUM=?, NOMBRE_ALUMNO=?, PRIMER_APELLIDO_ALUM=?, SEGUNDO_APELLIDO_ALUM=?, FECHA_NACIMIENTO_ALUM=?, GENERO_ALUM=?, FECHA_INGRESO_ALUM=?, NIVEL_ACADEMICO=?, DIRECCION_RESIDENCIA_ALUM=? "
                +" WHERE ID_ALUMNO=?";

        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, alumnos.getTipo_identidad_alum());
            ps.setString(2, alumnos.getNumero_identidad_alum());
            ps.setString(3, alumnos.getNombre_alumno());
            ps.setString(4, alumnos.getPrimer_apellido_alum());
            ps.setString(5, alumnos.getSegundo_apellido_alum());
            ps.setDate(6, (Date) alumnos.getFecha_nacimiento_alum());
            ps.setInt(7, alumnos.getGenero_alum());
            ps.setDate(8, (Date) alumnos.getFecha_ingreso_alum());
            ps.setInt(9, alumnos.getNivel_academico());
            ps.setString(10, alumnos.getDireccion_residencia_alum());
            ps.setInt(11, id);
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    //metodo para eliminar
    public boolean eliminarAlumno(int id){
        
        PreparedStatement ps;
        
        String sql = "DELETE FROM tbl_alumno WHERE id_alumno=?";
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
}

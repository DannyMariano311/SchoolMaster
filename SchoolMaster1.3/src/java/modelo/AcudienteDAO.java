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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny
 */
public class AcudienteDAO {

    Connection conexion;
    
    public AcudienteDAO() {
        Conexion con=new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Acudiente> listarAcudiente(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Acudiente> lista= new ArrayList<>();
        String sql = "SELECT ID_ACUDIENTE, TIPO_IDENTIDAD_ACU, NUMERO_IDENTIDAD_ACU, NOMBRE_ACUDIENTE, PRIMER_APELLIDO_ACU, SEGUNDO_APELLIDO_ACU, CORREO_ELECTRONICO_ACU, FECHA_NACIMIENTO_ACU, GENERO_ACU, TELEFONO_FIJO_ACU, TELEFONO_MOVIL_ACU, ID_ALUMNO_ACU, PARENTESCO "
                +" FROM TBL_ACUDIENTE";
        try {
            
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while(rs.next()){
                int id_acudiente = rs.getInt("ID_ACUDIENTE");
                int tipo_i = rs.getInt("Tipo_identidad_ACU");
                String numero_i = rs.getString("Numero_identidad_ACU");
                String nombre = rs.getString("Nombre_ACUDIENTE");
                String p_apellido = rs.getString("Primer_apellido_ACU");
                String s_apellido = rs.getString("Segundo_apellido_ACU");
                String correo = rs.getString("Correo_electronico_ACU");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_ACU");
                int genero = rs.getInt("Genero_ACU");
                String tf = rs.getString("Telefono_fijo_ACU");
                String tm = rs.getString("Telefono_movil_ACU");
                int id_alum = rs.getInt("ID_ALUMNO_ACU");
                String parentesco = rs.getString("PARENTESCO");
                
                Acudiente acudiente = new Acudiente(id_acudiente, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, genero, null, tf, tm, id_alum, null, parentesco);
                
                lista.add(acudiente);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para mustrar un acudiente
    public List<Acudiente> mostrarAcudiente(int id){
        
        List<Acudiente> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        Acudiente acudiente;
        String sql = "SELECT ID_ACUDIENTE, TIPO_IDENTIDAD_ACU, NUMERO_IDENTIDAD_ACU, NOMBRE_ACUDIENTE, PRIMER_APELLIDO_ACU, SEGUNDO_APELLIDO_ACU, CORREO_ELECTRONICO_ACU, FECHA_NACIMIENTO_ACU, GENERO_ACU, TELEFONO_FIJO_ACU, TELEFONO_MOVIL_ACU, ID_ALUMNO_ACU, PARENTESCO FROM TBL_ACUDIENTE "
                +" WHERE id_acudiente=?";
        
        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                int id_acudiente = rs.getInt("Id_acudiente");
                int tipo_i = rs.getInt("TIPO_IDENTIDAD_ACU");
                String numero_i = rs.getString("NUMERO_IDENTIDAD_ACU");
                String nombre = rs.getString("Nombre_ACUDIENTE");
                String p_apellido = rs.getString("Primer_apellido_ACU");
                String s_apellido = rs.getString("Segundo_apellido_ACU");
                String correo = rs.getString("Correo_electronico_ACU");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_ACU");
                int genero = rs.getInt("Genero_ACU");
                String tf = rs.getString("Telefono_fijo_ACU");
                String tm = rs.getString("Telefono_movil_ACU");
                int id_alum = rs.getInt("ID_ALUMNO_ACU");
                String parentesco = rs.getString("PARENTESCO");
                
                acudiente = new Acudiente(id_acudiente, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, genero, null, tf, tm, id_alum, null, parentesco);
                busqueda.add(acudiente);
            }
            
            return busqueda;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    //metodo de mostrar un acudiente con atributos comparados
    public List<Acudiente> acudienteMostrar(int id){
        
        List<Acudiente> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "select id_acudiente, nombre_t_identidad, NUMERO_IDENTIDAD_ACU, NOMBRE_ACUDIENTE, PRIMER_APELLIDO_ACU, SEGUNDO_APELLIDO_ACU, CORREO_ELECTRONICO_ACU, FECHA_NACIMIENTO_ACU, nombre_genero, TELEFONO_FIJO_ACU, TELEFONO_MOVIL_ACU, numero_identidad_alum, nombre_alumno, Primer_apellido_alum, segundo_apellido_alum, PARENTESCO \n" +
                "from tbl_acudiente\n" +
                "inner join tbl_tipo_identidad on codigo_t_identidad = tipo_identidad_acu\n" +
                "inner join tbl_genero on codigo_genero = GENERO_ACU\n" +
                "inner join tbl_alumno on id_alumno = ID_ALUMNO_ACU\n" +
                "where id_acudiente = ?";
        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                int id_acudiente = rs.getInt("id_acudiente");
                String tipo_i = rs.getString("nombre_t_identidad");
                String numero_i = rs.getString("NUMERO_IDENTIDAD_ACU");
                String nombre = rs.getString("Nombre_ACUDIENTE");
                String p_apellido = rs.getString("Primer_apellido_ACU");
                String s_apellido = rs.getString("Segundo_apellido_ACU");
                String correo = rs.getString("Correo_electronico_ACU");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_ACU");
                String genero = rs.getString("nombre_genero");
                String tf = rs.getString("Telefono_fijo_ACU");
                String tm = rs.getString("Telefono_movil_ACU");
                String id_alum = "Documento: "+rs.getString("numero_identidad_alum")+"<br/>"+" Nombre: "+rs.getString("nombre_alumno")+rs.getString("Primer_apellido_alum")+rs.getString("segundo_apellido_alum");
                String parentesco = rs.getString("PARENTESCO");
                
                Acudiente acudiente = new Acudiente(id_acudiente, 0, tipo_i, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, 0, genero, tf, tm, 0, id_alum, parentesco);
                busqueda.add(acudiente); 
            }
            
            return busqueda;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    //metodo para buscar un acudiente por el correo y numero de documento
    public List<Acudiente> acudienteMostrar_CorreoIdentidad(String correoU, String claveU){
        
        List<Acudiente> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "select id_acudiente, nombre_t_identidad, NUMERO_IDENTIDAD_ACU, NOMBRE_ACUDIENTE, PRIMER_APELLIDO_ACU, SEGUNDO_APELLIDO_ACU, CORREO_ELECTRONICO_ACU, FECHA_NACIMIENTO_ACU, nombre_genero, TELEFONO_FIJO_ACU, TELEFONO_MOVIL_ACU, numero_identidad_alum, nombre_alumno, Primer_apellido_alum, segundo_apellido_alum, PARENTESCO \n" +
                "from tbl_acudiente\n" +
                "inner join tbl_tipo_identidad on codigo_t_identidad = tipo_identidad_acu\n" +
                "inner join tbl_genero on codigo_genero = GENERO_ACU\n" +
                "inner join tbl_alumno on id_alumno = ID_ALUMNO_ACU\n" +
                "where correo_electronico_acu=? and numero_identidad_acu=?";
        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, correoU);
            ps.setString(2, claveU);
            
            rs = ps.executeQuery();
            while(rs.next()){
                int id_acudiente = rs.getInt("id_acudiente");
                String tipo_i = rs.getString("nombre_t_identidad");
                String numero_i = rs.getString("NUMERO_IDENTIDAD_ACU");
                String nombre = rs.getString("Nombre_ACUDIENTE");
                String p_apellido = rs.getString("Primer_apellido_ACU");
                String s_apellido = rs.getString("Segundo_apellido_ACU");
                String correo = rs.getString("Correo_electronico_ACU");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_ACU");
                String genero = rs.getString("nombre_genero");
                String tf = rs.getString("Telefono_fijo_ACU");
                String tm = rs.getString("Telefono_movil_ACU");
                String id_alum = "Documento: "+rs.getString("numero_identidad_alum")+"<br/>"+" Nombre: "+rs.getString("nombre_alumno")+rs.getString("Primer_apellido_alum")+rs.getString("segundo_apellido_alum");
                String parentesco = rs.getString("PARENTESCO");
                
                Acudiente acudiente = new Acudiente(id_acudiente, 0, tipo_i, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, 0, genero, tf, tm, 0, id_alum, parentesco);
                busqueda.add(acudiente); 
            }
            
            return busqueda;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    //metodo para retornar el id del un acudiente
    public int retornar_id(String correoU, String claveU){
        PreparedStatement ps;
        ResultSet rs;

        int id_pro = 0;
        
        String sql = "SELECT ID_ACUDIENTE, TIPO_IDENTIDAD_ACU, NUMERO_IDENTIDAD_ACU, NOMBRE_ACUDIENTE, PRIMER_APELLIDO_ACU, SEGUNDO_APELLIDO_ACU, CORREO_ELECTRONICO_ACU, FECHA_NACIMIENTO_ACU, GENERO_ACU, TELEFONO_FIJO_ACU, TELEFONO_MOVIL_ACU, ID_ALUMNO_ACU, PARENTESCO FROM TBL_ACUDIENTE "
                +" WHERE correo_electronico_acu=? and numero_identidad_acu=?";

        try {

            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, correoU);
            ps.setString(2, claveU);
            rs = ps.executeQuery();
            while (rs.next()) {
                id_pro = rs.getInt("id_acudiente");
            }
            
            return id_pro;
            
        }catch (SQLException e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    
    
    //metodo de insertar un acudiente
    public boolean insertarAcudiente(Acudiente acudiente){
        
        PreparedStatement ps;
        
        String sql = "INSERT INTO TBL_ACUDIENTE (ID_ACUDIENTE, TIPO_IDENTIDAD_ACU, NUMERO_IDENTIDAD_ACU, NOMBRE_ACUDIENTE, PRIMER_APELLIDO_ACU, SEGUNDO_APELLIDO_ACU, CORREO_ELECTRONICO_ACU, FECHA_NACIMIENTO_ACU, GENERO_ACU, TELEFONO_FIJO_ACU, TELEFONO_MOVIL_ACU, ID_ALUMNO_ACU, PARENTESCO) "
                +" VALUES (ACUDIENTE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            
            ps = conexion.prepareStatement(sql);
             
            ps.setInt(1, acudiente.getTipo_identidad_acu());
            ps.setString(2, acudiente.getNumero_identidad_acu());
            ps.setString(3, acudiente.getNombre_acudiente());
            ps.setString(4, acudiente.getPrimer_apellido_acu());
            ps.setString(5, acudiente.getSegundo_apellido_acu());
            ps.setString(6, acudiente.getCorreo_acu());
            ps.setDate(7, (Date) acudiente.getFecha_nacimiento_acu());
            ps.setInt(8, acudiente.getGenero_acu());
            ps.setString(9, acudiente.getTelefono_fijo_acu());
            ps.setString(10, acudiente.getTelefono_movil_acu());
            ps.setInt(11, acudiente.getId_alumno_acu());
            ps.setString(12, acudiente.getParentesco());

            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    //metodo para actualizar un acudiente
    public boolean actualizarAcudiente(Acudiente acudiente, int id){
        
        PreparedStatement ps;
        
        String sql = "UPDATE TBL_ACUDIENTE SET ID_ACUDIENTE=?, TIPO_IDENTIDAD_ACU=?, NUMERO_IDENTIDAD_ACU=?, NOMBRE_ACUDIENTE=?, PRIMER_APELLIDO_ACU=?, SEGUNDO_APELLIDO_ACU=?, CORREO_ELECTRONICO_ACU=?, FECHA_NACIMIENTO_ACU=?, GENERO_ACU=?, TELEFONO_FIJO_ACU=?, TELEFONO_MOVIL_ACU=?, ID_ALUMNO_ACU=?, PARENTESCO=? "
                +" WHERE ID_ACUDIENTE=?";
        
        try {
            ps = conexion.prepareStatement(sql);
             
            ps.setInt(1, acudiente.getTipo_identidad_acu());
            ps.setString(2, acudiente.getNumero_identidad_acu());
            ps.setString(3, acudiente.getNombre_acudiente());
            ps.setString(4, acudiente.getPrimer_apellido_acu());
            ps.setString(5, acudiente.getSegundo_apellido_acu());
            ps.setString(6, acudiente.getCorreo_acu());
            ps.setDate(7, (Date) acudiente.getFecha_nacimiento_acu());
            ps.setInt(8, acudiente.getGenero_acu());
            ps.setString(9, acudiente.getTelefono_fijo_acu());
            ps.setString(10, acudiente.getTelefono_movil_acu());
            ps.setInt(11, acudiente.getId_alumno_acu());
            ps.setString(12, acudiente.getParentesco());
            ps.setInt(13, acudiente.getId_acudiente());
            ps.setInt(14, id);
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    //metodo eliminar acudiente
    public boolean eliminarAcudiente(int id){
        
        PreparedStatement ps;
        
        String sql = "DELETE FROM TBL_ACUDIENTE WHERE ID_ACUDIENTE=?";
        try {
            
            ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
//    public static void main(String[] args) {
//        AcudienteDAO a=new AcudienteDAO();
//        List<String> busqueda = new ArrayList<>();
//
//        busqueda = a.acudienteMostrar(29);
//        JOptionPane.showMessageDialog(null, busqueda.get(11));
//    }
}

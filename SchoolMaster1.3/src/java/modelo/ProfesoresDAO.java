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
public class ProfesoresDAO {

    Connection conexion;

    public ProfesoresDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

    //metodo para listar
    public List<Profesores> listarProfesores() {

        PreparedStatement ps;
        ResultSet rs;

        List<Profesores> lista = new ArrayList<>();
        String sql = "SELECT ID_PROFESOR, TIPO_IDENTIDAD_PRO, NUMERO_IDENTIDAD_PRO, NOMBRE_PRO, PRIMER_APELLIDO_PRO, SEGUNDO_APELLIDO_PRO, CORREO_ELECTRONICO_PRO, FECHA_NACIMIENTO_PRO, GENERO_PRO, DIRECCION_RESIDENCIA_PRO, TELEFONO_FIJO_PRO, TELEFONO_MOVIL_PRO, FECHA_INGRESO_PRO FROM TBL_PROFESOR";
        try {

            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_profesor = rs.getInt("ID_Profesor");
                int tipo_i = rs.getInt("Tipo_identidad_pro");
                String numero_i = rs.getString("Numero_identidad_pro");
                String nombre = rs.getString("Nombre_pro");
                String p_apellido = rs.getString("Primer_apellido_pro");
                String s_apellido = rs.getString("Segundo_apellido_pro");
                String correo = rs.getString("Correo_electronico_pro");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_pro");
                int genero = rs.getInt("Genero_pro");
                String residencia = rs.getString("Direccion_Residencia_pro");
                String tf = rs.getString("Telefono_fijo_pro");
                String tm = rs.getString("Telefono_movil_pro");
                Date ingreso = rs.getDate("Fecha_ingreso_pro");

                Profesores profesores = new Profesores(id_profesor, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, genero, null, residencia, tf, tm, ingreso);

                lista.add(profesores);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    //metodo para mostrar un profesor
    public List<Profesores> mostrarProfesores(int id) {

        List<Profesores> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        Profesores profesores;
        String sql = "SELECT ID_PROFESOR, TIPO_IDENTIDAD_PRO, NUMERO_IDENTIDAD_PRO, NOMBRE_PRO, PRIMER_APELLIDO_PRO, SEGUNDO_APELLIDO_PRO, CORREO_ELECTRONICO_PRO, FECHA_NACIMIENTO_PRO, GENERO_PRO, DIRECCION_RESIDENCIA_PRO, TELEFONO_FIJO_PRO, TELEFONO_MOVIL_PRO, FECHA_INGRESO_PRO FROM TBL_PROFESOR  "
                + " WHERE ID_PROFESOR=?";

        try {

            ps = conexion.prepareStatement(sql);

            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_pro = rs.getInt("ID_Profesor");
                int tipo_i = rs.getInt("Tipo_identidad_pro");
                String numero_i = rs.getString("Numero_identidad_pro");
                String nombre = rs.getString("Nombre_pro");
                String p_apellido = rs.getString("Primer_apellido_pro");
                String s_apellido = rs.getString("Segundo_apellido_pro");
                String correo = rs.getString("Correo_electronico_pro");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_pro");
                int genero = rs.getInt("Genero_pro");
                String residencia = rs.getString("Direccion_Residencia_pro");
                String tf = rs.getString("Telefono_fijo_pro");
                String tm = rs.getString("Telefono_movil_pro");
                Date ingreso = rs.getDate("Fecha_ingreso_pro");
                
                profesores = new Profesores(id_pro, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, genero, null, residencia, tf, tm, ingreso);
                busqueda.add(profesores);
            }

            return busqueda;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para mostrar un profesor con unos resultados mas especificos 
    public List<Profesores> profesoresMostrar(int id) {

        List<Profesores> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        Profesores profesores;
        String sql = "select id_profesor, nombre_t_identidad, numero_identidad_pro, nombre_pro, primer_apellido_pro, segundo_apellido_pro, correo_electronico_pro, fecha_nacimiento_pro, nombre_genero, direccion_residencia_pro, telefono_fijo_pro, telefono_movil_pro, fecha_ingreso_pro\n" +
            "from tbl_profesor\n" +
            "inner join tbl_tipo_identidad on codigo_t_identidad = tipo_identidad_pro\n" +
            "inner join tbl_genero on codigo_genero = genero_pro\n" +
            "where id_profesor =?";

        try {

            ps = conexion.prepareStatement(sql);

            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_pro = rs.getInt("ID_Profesor");
                String tipo_i = rs.getString("nombre_t_identidad");
                String numero_i = rs.getString("Numero_identidad_pro");
                String nombre = rs.getString("Nombre_pro");
                String p_apellido = rs.getString("Primer_apellido_pro");
                String s_apellido = rs.getString("Segundo_apellido_pro");
                String correo = rs.getString("Correo_electronico_pro");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_pro");
                String genero = rs.getString("nombre_genero");
                String residencia = rs.getString("Direccion_Residencia_pro");
                String tf = rs.getString("Telefono_fijo_pro");
                String tm = rs.getString("Telefono_movil_pro");
                Date ingreso = rs.getDate("Fecha_ingreso_pro");

                profesores = new Profesores(id_pro, 0, tipo_i, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, 0, genero, residencia, tf, tm, ingreso);
                busqueda.add(profesores);
            }

            return busqueda;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    //metodo para buscar un usuario por el correo y numero de cedula
    public List<Profesores> profesoresMostrar_CorreoIdentidad(String correoU, String claveU) {

        List<Profesores> busqueda = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        Profesores profesores;
        String sql = "select id_profesor, nombre_t_identidad, numero_identidad_pro, nombre_pro, primer_apellido_pro, segundo_apellido_pro, correo_electronico_pro, fecha_nacimiento_pro, nombre_genero, direccion_residencia_pro, telefono_fijo_pro, telefono_movil_pro, fecha_ingreso_pro\n" +
            "from tbl_profesor\n" +
            "inner join tbl_tipo_identidad on codigo_t_identidad = tipo_identidad_pro\n" +
            "inner join tbl_genero on codigo_genero = genero_pro\n" +
            "where correo_electronico_pro=? and numero_identidad_pro=?";

        try {

            ps = conexion.prepareStatement(sql);

            ps.setString(1, correoU);
            ps.setString(2, claveU);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_pro = rs.getInt("ID_Profesor");
                String tipo_i = rs.getString("nombre_t_identidad");
                String numero_i = rs.getString("Numero_identidad_pro");
                String nombre = rs.getString("Nombre_pro");
                String p_apellido = rs.getString("Primer_apellido_pro");
                String s_apellido = rs.getString("Segundo_apellido_pro");
                String correo = rs.getString("Correo_electronico_pro");
                Date nacimiento = rs.getDate("Fecha_Nacimiento_pro");
                String genero = rs.getString("nombre_genero");
                String residencia = rs.getString("Direccion_Residencia_pro");
                String tf = rs.getString("Telefono_fijo_pro");
                String tm = rs.getString("Telefono_movil_pro");
                Date ingreso = rs.getDate("Fecha_ingreso_pro");

                profesores = new Profesores(id_pro, 0, tipo_i, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, 0, genero, residencia, tf, tm, ingreso);
                busqueda.add(profesores);
            }

            return busqueda;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    //metodo para retornar el id del profesor
    public int retornar_id(String correoU, String claveU){
        PreparedStatement ps;
        ResultSet rs;

        int id_pro = 0;
        
        String sql = "SELECT ID_PROFESOR, TIPO_IDENTIDAD_PRO, NUMERO_IDENTIDAD_PRO, NOMBRE_PRO, PRIMER_APELLIDO_PRO, SEGUNDO_APELLIDO_PRO, CORREO_ELECTRONICO_PRO, FECHA_NACIMIENTO_PRO, GENERO_PRO, DIRECCION_RESIDENCIA_PRO, TELEFONO_FIJO_PRO, TELEFONO_MOVIL_PRO, FECHA_INGRESO_PRO FROM TBL_PROFESOR  "
                + " WHERE correo_electronico_pro=? and numero_identidad_pro=?";

        try {

            ps = conexion.prepareStatement(sql);
            
            ps.setString(1, correoU);
            ps.setString(2, claveU);
            rs = ps.executeQuery();
            while (rs.next()) {
                id_pro = rs.getInt("id_Profesor");
            }
            
            return id_pro;
            
        }catch (SQLException e) {
            System.out.println(e.toString());
            return 0;
        }
    }
    
    //metodo para insertar un usuario profesor
    public boolean insertar(Profesores profesores) {

        PreparedStatement ps;

        String sql = "INSERT INTO TBL_PROFESOR (ID_PROFESOR, TIPO_IDENTIDAD_PRO, NUMERO_IDENTIDAD_PRO, NOMBRE_PRO, PRIMER_APELLIDO_PRO, SEGUNDO_APELLIDO_PRO, CORREO_ELECTRONICO_PRO, FECHA_NACIMIENTO_PRO, GENERO_PRO, DIRECCION_RESIDENCIA_PRO, TELEFONO_FIJO_PRO, TELEFONO_MOVIL_PRO, FECHA_INGRESO_PRO) "
                + " VALUES (PROFESOR_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, profesores.getTipo_identidad());
            ps.setString(2, profesores.getNumero_identidad_pro());
            ps.setString(3, profesores.getNombre_pro());
            ps.setString(4, profesores.getPrimer_apellido_pro());
            ps.setString(5, profesores.getSegundo_apellido_pro());
            ps.setString(6, profesores.getCorreo_electronico_pro());
            ps.setDate(7, (Date) profesores.getFecha_nacimiento_pro());
            ps.setInt(8, profesores.getGenero_pro());
            ps.setString(9, profesores.getDireccion_residencia_pro());
            ps.setString(10, profesores.getTelefono_fijo_pro());
            ps.setString(11, profesores.getTelefono_movil_pro());
            ps.setDate(12, (Date) profesores.getFecha_ingreso_pro());

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Registro fallido interno: " + e.toString());
            return false;
        }
    }

    //metodo para actualizar
    public boolean actualizar(Profesores profesores, int id) {

        PreparedStatement ps;

        String sql = "UPDATE tbl_profesor SET Tipo_identidad_pro=?, Numero_identidad_pro=?, Nombre_pro=?, Primer_apellido_pro=?, Segundo_apellido_pro=?, Correo_electronico_pro=?, Fecha_Nacimiento_pro=?, Genero_pro=?, Direccion_Residencia_pro=?, Telefono_fijo_pro=?, Telefono_movil_pro=?, Fecha_ingreso_pro=? "
                + " WHERE ID_PROFESOR=?";

        try {
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, profesores.getTipo_identidad());
            ps.setString(2, profesores.getNumero_identidad_pro());
            ps.setString(3, profesores.getNombre_pro());
            ps.setString(4, profesores.getPrimer_apellido_pro());
            ps.setString(5, profesores.getSegundo_apellido_pro());
            ps.setString(6, profesores.getCorreo_electronico_pro());
            ps.setDate(7, (java.sql.Date) profesores.getFecha_nacimiento_pro());
            ps.setInt(8, profesores.getGenero_pro());
            ps.setString(9, profesores.getDireccion_residencia_pro());
            ps.setString(10, profesores.getTelefono_fijo_pro());
            ps.setString(11, profesores.getTelefono_movil_pro());
            ps.setDate(12, (java.sql.Date) profesores.getFecha_ingreso_pro());
            ps.setInt(13, id);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    //metodo para eliminar
    public boolean eliminar(int id) {

        PreparedStatement ps;
        
        String sql = "DELETE FROM tbl_profesor WHERE id_profesor=?";
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
//        ProfesoresDAO profe = new ProfesoresDAO();
//        Date n=new Date(7/02/2022);
//        Profesores profesores = new Profesores(1, 3, "123124", "danny", "garcia", "garcia", "elpoderosoDanny@gmail.com", n, 2, "minas", "31242343", "12341231", n);
//        profe.actualizar(profesores, 1);
////        JOptionPane.showMessageDialog(null, profe.mostrarProfesores(1));
//    }
}

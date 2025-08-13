/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Profesores;
import modelo.ProfesoresDAO;
import modelo.Usuarios;
import modelo.UsuariosDAO;

/**
 *
 * @author Danny
 */
public class ControladorProfesores {

    Profesores profesores;

    public static boolean profesor(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {

        ProfesoresDAO profesoresDAO = new ProfesoresDAO();
        UsuariosDAO usuariosDAO = new UsuariosDAO();

        boolean rp = false;
        
        try {
            int tipo_i = Integer.parseInt(request.getParameter("tipo_i_pro"));
            String numero_i = request.getParameter("numero_i_pro");
            String nombre = request.getParameter("nombre_pro");
            String p_apellido = request.getParameter("p_apellido_pro");
            String s_apellido = request.getParameter("s_apellido_pro");
            String correo = request.getParameter("correo_pro");
            Date nacimiento = java.sql.Date.valueOf(request.getParameter("nacimiento_pro"));
            int genero = Integer.parseInt(request.getParameter("genero_pro"));
            String residencia = request.getParameter("residencia_pro");
            String tf = request.getParameter("tf_pro");
            String tm = request.getParameter("tm_pro");
            Date ingreso = java.sql.Date.valueOf(request.getParameter("ingreso_pro"));

            Profesores profesores = new Profesores(0, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, genero, null, residencia, tf, tm, ingreso);
            rp = profesoresDAO.insertar(profesores);
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido externo: " + e.toString());

        }
        if (rp == true) {
            String correo = request.getParameter("correo_pro");
            String numero_i = request.getParameter("numero_i_pro");
            String tipo_u = "U_PROFESOR";
            
            int id = profesoresDAO.retornar_id(correo, numero_i);

            Usuarios usuarios = new Usuarios(0, correo, numero_i, tipo_u, id);
            usuariosDAO.insertarUsuario(usuarios);

        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario Profesor");
        }
        return rp;
    }

    public static boolean actualizar(HttpServletRequest request, HttpServletResponse response, int id_profe) throws ServletException, IOException {
        ProfesoresDAO profesoresDAO = new ProfesoresDAO();

        try {

            int tipo_i = Integer.parseInt(request.getParameter("mod_t_documento_pro"));
            String numero_i = request.getParameter("mod_n_document_pro");
            String nombre = request.getParameter("mod_nom_pro");
            String p_apellido = request.getParameter("mod_primer_ape_pro");
            String s_apellido = request.getParameter("mod_segundo_ape_pro");
            String correo = request.getParameter("mod_correo_pro");
            Date nacimiento = java.sql.Date.valueOf(request.getParameter("mod_fecha_pro"));
            int genero = Integer.parseInt(request.getParameter("mod_genero_pro"));
            String residencia = request.getParameter("mod_residencia_pro");
            String tf = request.getParameter("mod_tf_pro");
            String tm = request.getParameter("mod_tm_pro");
            Date ingreso = java.sql.Date.valueOf(request.getParameter("mod_ingreso_pro"));

            try {
                Profesores profesores = new Profesores(id_profe, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, genero, null, residencia, tf, tm, ingreso);
                profesoresDAO.actualizar(profesores, id_profe);
                //JOptionPane.showMessageDialog(null, "Actualzacion exitosa");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Actualzacion fallido 1: " + e.toString());
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Actualización fallido 2: " + e.toString());
            return false;
        }

    }

}

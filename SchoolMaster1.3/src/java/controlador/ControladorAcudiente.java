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
import modelo.Acudiente;
import modelo.AcudienteDAO;
import modelo.Usuarios;
import modelo.UsuariosDAO;

/**
 *
 * @author Danny
 */
public class ControladorAcudiente {

    Acudiente acudiente;

    public static boolean insertarAcudiente(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {

        AcudienteDAO acudienteDAO = new AcudienteDAO();
        UsuariosDAO usuariosDAO = new UsuariosDAO();

        boolean rp = false;
        try {
            int tipo_i = Integer.parseInt(request.getParameter("tipo_i_acu"));
            String numero_i = request.getParameter("numero_i_acu");
            String nombre = request.getParameter("nombre_acu");
            String p_apellido = request.getParameter("p_apellido_acu");
            String s_apellido = request.getParameter("s_apellido_acu");
            String correo = request.getParameter("correo_acu");
            Date nacimiento = java.sql.Date.valueOf(request.getParameter("nacimiento_acu"));
            int genero = Integer.parseInt(request.getParameter("genero_acu"));
            String tf = request.getParameter("tf_acu");
            String tm = request.getParameter("tm_acu");
            int id_alum_acu = Integer.parseInt(request.getParameter("id_alum_acu"));
            String parentesco = request.getParameter("parentesco");
            
            Acudiente acudiente = new Acudiente(0, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, genero, null, tf, tm, id_alum_acu, null, parentesco);
            rp = acudienteDAO.insertarAcudiente(acudiente);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido externo: " + e.toString());
        }
        if (rp == true) {
            String correo = request.getParameter("correo_acu");
            String numero_i = request.getParameter("numero_i_acu");
            String tipo_u = "U_ACUDIENTE";
            int id = acudienteDAO.retornar_id(correo, numero_i);
            
            Usuarios usuarios = new Usuarios(0, correo, numero_i, tipo_u, id);
            usuariosDAO.insertarUsuario(usuarios);
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario Acudiente");

        }
        return rp;
    }

    public static boolean actualizar(HttpServletRequest request, HttpServletResponse response, int id_acudiente) throws ServletException, IOException {
        AcudienteDAO acudienteDAO = new AcudienteDAO();
        
        try {
            
            int tipo_i = Integer.parseInt(request.getParameter("tipo_i_acu"));
            String numero_i = request.getParameter("numero_i_acu");
            String nombre = request.getParameter("nombre_acu");
            String p_apellido = request.getParameter("p_apellido_acu");
            String s_apellido = request.getParameter("s_apellido_acu");
            String correo = request.getParameter("correo_acu");
            Date nacimiento = java.sql.Date.valueOf(request.getParameter("nacimiento_acu"));
            int genero = Integer.parseInt(request.getParameter("genero_acu"));
            String tf = request.getParameter("tf_acu");
            String tm = request.getParameter("tm_acu");
            int id_alum_acu = Integer.parseInt(request.getParameter("id_alum_acu"));
            String parentesco = request.getParameter("parentesco");

            try {
                Acudiente acudiente = new Acudiente(0, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, correo, nacimiento, genero, null, tf, tm, id_alum_acu, null, parentesco);
                acudienteDAO.actualizarAcudiente(acudiente, id_acudiente);
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

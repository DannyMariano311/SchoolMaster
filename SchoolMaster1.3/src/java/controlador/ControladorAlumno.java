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
import modelo.Alumnos;
import modelo.AlumnosDAO;
import modelo.Profesores;

/**
 *
 * @author Danny
 */
public class ControladorAlumno {

    Profesores profesores;

    public static boolean insertarAlumno(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {

        AlumnosDAO alumnosDAO = new AlumnosDAO();
        boolean rp = false;
        
        try {
            int tipo_i = Integer.parseInt(request.getParameter("tipo_i_alum"));
            String numero_i = request.getParameter("numero_i_alumno");
            String nombre = request.getParameter("nombre_alum");
            String p_apellido = request.getParameter("p_apellido_alum");
            String s_apellido = request.getParameter("s_apellido_alum");
            Date nacimiento = java.sql.Date.valueOf(request.getParameter("nacimiento_alum"));
            int genero = Integer.parseInt(request.getParameter("genero_alum"));
            Date ingreso = java.sql.Date.valueOf(request.getParameter("fecha_ingreso_alum"));
            int nivel = Integer.parseInt(request.getParameter("nivel_academico_alum"));
            String residencia = request.getParameter("direccion_alum");
            
            Alumnos alumnos = new Alumnos(0, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, nacimiento, genero, null, ingreso, nivel, null, residencia);
            rp = alumnosDAO.insertarAlumno(alumnos);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido externo: " + e.toString());
        }
        return rp;
    }

    public static boolean actualizarAlumno(HttpServletRequest request, HttpServletResponse response, int id_alumno) throws ServletException, IOException {
        AlumnosDAO alumnosDAO = new AlumnosDAO();

        try {

            int tipo_i = Integer.parseInt(request.getParameter("tipo_i_alum"));
            String numero_i = request.getParameter("numero_i_alum");
            String nombre = request.getParameter("nombre_alum");
            String p_apellido = request.getParameter("p_apellido_alum");
            String s_apellido = request.getParameter("s_apellido_alum");
            Date nacimiento = java.sql.Date.valueOf(request.getParameter("nacimiento_alum"));
            int genero = Integer.parseInt(request.getParameter("genero_alum"));
            Date ingreso = java.sql.Date.valueOf(request.getParameter("fecha_ingreso_alum"));
            int nivel = Integer.parseInt(request.getParameter("nivel_academico_alum"));
            String residencia = request.getParameter("direccion_alum");
            
            Alumnos alumnos = new Alumnos(id_alumno, tipo_i, null, numero_i, nombre, p_apellido, s_apellido, nacimiento, genero, null, ingreso, nivel, null, residencia);
            alumnosDAO.actualizarAlumno(alumnos, id_alumno);
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Actualización fallido: " + e.toString());
            return false;
        }

    }

}

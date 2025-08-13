/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Niveles;
import modelo.NivelesDAO;

/**
 *
 * @author Danny
 */
public class ControladorNiveles {

    Niveles niveles;

    public static boolean insertarNiveles(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {

        NivelesDAO nivelesDAO = new NivelesDAO();
        boolean rp = false;
        
        try {
            String nombre = request.getParameter("nom_nivel");
            int jornada = Integer.parseInt(request.getParameter("jornada"));
            int id_profesor_nivel = Integer.parseInt(request.getParameter("id_profe_nivel"));
            
            Niveles niveles = new Niveles(0, nombre, jornada, null, id_profesor_nivel, null);
            rp = nivelesDAO.insertarNivel(niveles);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido externo: " + e.toString());
        }
        return rp;
    }

    public static boolean actualizarNivel(HttpServletRequest request, HttpServletResponse response, int id_nivel) throws ServletException, IOException {
        NivelesDAO nivelesDAO = new NivelesDAO();
        
        try {
            
            String nombre = request.getParameter("nom_nivel");
            int jornada = Integer.parseInt(request.getParameter("jornada"));
            int id_profesor_nivel = Integer.parseInt(request.getParameter("id_profe_nivel"));

            try {
                Niveles niveles = new Niveles(id_nivel, nombre, jornada, null, id_profesor_nivel, null);
                nivelesDAO.actualizarNivel(niveles, id_nivel);

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

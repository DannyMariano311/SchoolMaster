package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.Acudiente;
import modelo.AcudienteDAO;
import modelo.Alumnos;
import modelo.AlumnosDAO;
import modelo.Niveles;
import modelo.NivelesDAO;
import modelo.Profesores;
import modelo.ProfesoresDAO;
import modelo.Usuarios;
import modelo.UsuariosDAO;

/**
 *
 * @author Danny
 */

public class MiServlet extends HttpServlet {
    
    int id_profe = 0;
    int id_nivel = 0;
    int id_alumno = 0;
    int id_acudiente = 0;
    
    String correo=null;
    String clave=null;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ProfesoresDAO profesoresDAO = new ProfesoresDAO();
        UsuariosDAO usuariosDAO=new UsuariosDAO();
        NivelesDAO nivelesDAO =new NivelesDAO();
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        AcudienteDAO acudienteDAO = new AcudienteDAO();
        
        String accion;
        
        RequestDispatcher dispatcher = null;
        
        
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("index.jsp");
            
        //pequeña validacion
        }else if("login".equals(accion)){
            correo=(String)request.getParameter("Email");
            clave=(String)request.getParameter("Password1");
            boolean validar = usuariosDAO.validarCorreoClave(correo, clave);
            //List<Usuarios> validar = usuariosDAO.validarUsuario(usuario, clave);
            
            if(validar==false)
            {
                dispatcher = request.getRequestDispatcher("index.jsp");
                request.setAttribute("validacion", "Usuario o contraseña incorrectas");
            }
            else
            {
                Usuarios u = usuariosDAO.validarUsuario(correo, clave);
                
                if(u.getTipo_usuario().equals("U_ADMINISTRADOR"))
                {
                    dispatcher = request.getRequestDispatcher("Administrador.jsp");
                }
                else if(u.getTipo_usuario().equals("U_PROFESOR"))
                {
                    List<Profesores> busqueda = profesoresDAO.profesoresMostrar_CorreoIdentidad(correo, clave);
                    int id_profesor_encontrado = profesoresDAO.retornar_id(correo, clave);
                    dispatcher = request.getRequestDispatcher("Profesor.jsp");
                    request.setAttribute("busqueda", busqueda);
                    request.setAttribute("pro", String.valueOf(id_profesor_encontrado));
                }
                else if(u.getTipo_usuario().equals("U_ACUDIENTE"))
                {
                    List<Acudiente> busqueda = acudienteDAO.acudienteMostrar_CorreoIdentidad(correo, clave);
                    int id_acudiente_econtrado = acudienteDAO.retornar_id(correo, clave);
                    dispatcher = request.getRequestDispatcher("Acudiente.jsp");
                    request.setAttribute("busqueda", busqueda);
                    request.setAttribute("acu", String.valueOf(id_acudiente_econtrado));
                }
                else
                {
                    dispatcher = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("validacion", "Error al tratar de iniciar sesión");
                }
            }
            
//en esta parte se gestionan los servicios de gestion para el usuario profesor            
        //metodo de insertar un profesor
        }
        else if("insert".equals(accion))
        {
            boolean rp = ControladorProfesores.profesor(request, response, accion);
            if(rp!=false)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Usuario profesor registrado con exito!");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡No se pudo registrar el usuario profesor con exito!");
            }
            
            
        //metodo de buscar un profesor
        }else if("buscar".equals(accion))
        {
            int id = Integer.parseInt(request.getParameter("buscarProfe"));
            List<Profesores> busqueda = profesoresDAO.mostrarProfesores(id);
            
            if(busqueda==null)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Usuario profesor no encontrado en la base de datos!"); 
            }
            else if(busqueda.isEmpty()!=true)
            {
                //JOptionPane.showMessageDialog(null, "profesor encontrado");
                HttpSession session = request.getSession();
                session.invalidate();
                dispatcher = request.getRequestDispatcher("ActualizarProfe.jsp");
                request.setAttribute("busqueda", busqueda);
                this.id_profe = id;
            }
            else
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Usuario profesor no encontrado en la base de datos!"); 
            }
            
        //metodo de actualizar un profesor
        }
        else if("actualizar".equals(accion))
        {
            boolean rp = ControladorProfesores.actualizar(request, response, id_profe);
            if(rp!=false)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Usuario profesor actualizado con exito!");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("ActualizarProfe.jsp");
                JOptionPane.showMessageDialog(null, "Actualización fallida, problemas internos");
            }
        //metodo de borrar un profesor
        }
        else if("borrar".equals(accion))
        {
            profesoresDAO.eliminar(id_profe);
            usuariosDAO.eliminarUsuario(id_profe);
            dispatcher = request.getRequestDispatcher("Administrador.jsp");
            request.setAttribute("validacion", "¡Usuario profesor borrado con exito!");
        }
        
//secuencialmente en este punto se gestionan los servicios para los niveles
        //metodo de insertar un nivel
        else if("insertarNivel".equals(accion))
        {
            boolean rp = ControladorNiveles.insertarNiveles(request, response, accion);
            
            if(rp!=false){
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Nivel registrado con exito!");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡No se pudo registrar el nivel académico con exito!");
            }
        }
        //metodo de buscar un nivel
        else if("buscarNivel".equals(accion))
        {
            int idNivel = Integer.parseInt(request.getParameter("buscar_nivel"));
            List<Niveles> busquedaNivel = nivelesDAO.nivelMostrar(idNivel);
            
            if(busquedaNivel==null)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Nivel académico no encontrado en la base de datos!"); 
            }
            else if(busquedaNivel.isEmpty()!=true)
            {
                //JOptionPane.showMessageDialog(null, "Nivel encontrado");
                dispatcher = request.getRequestDispatcher("ActualizarNivel.jsp");
                request.setAttribute("busqueda", busquedaNivel);
                this.id_nivel = idNivel;
            }
            else
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Nivel académico no encontrado en la base de datos!"); 
            }
            
        //metodo de actualizar un nivel
        }else if("actualizarNivel".equals(accion)){
            boolean rp = ControladorNiveles.actualizarNivel(request, response, id_nivel);
            
            if(rp!=false)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Nivel académico actualizado con exito!");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("ActualizarNivel.jsp");
                JOptionPane.showMessageDialog(null, "Actualización fallida, problemas internos");
            }
        //metodo de borrar un nivel
        }else if("borrarNivel".equals(accion))
        {
            nivelesDAO.eliminarNivel(id_nivel);
            dispatcher = request.getRequestDispatcher("Administrador.jsp");
            request.setAttribute("validacion", "¡Nivel académico borrado con exito!");
        }
//en esta parte se gestionan los servicios de gestion para el usuario alumno 
        //metodo de insertar un Alumno
        else if("insertarAlumno".equals(accion))
        {
            boolean rp = ControladorAlumno.insertarAlumno(request, response, accion);
            
            if(rp!=false)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Alumno registrado con exito!");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡No se pudo registrar el usuario alumno con exito!");
            }
        }
        
        //metodo de buscar un Alumno
        else if("buscarAlumno".equals(accion))
        {
            int idAlumno = Integer.parseInt(request.getParameter("buscar_alumno"));
            List<Alumnos> busquedaAlumno = alumnosDAO.alumnosMostrar(idAlumno);
            
            if(busquedaAlumno==null)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Usuario alumno no encontrado en la base de datos!"); 
                
            }
            else if(busquedaAlumno.isEmpty()!=true)
            {
                //JOptionPane.showMessageDialog(null, "Alumno encontrado");
                dispatcher = request.getRequestDispatcher("ActualizarAlumno.jsp");
                request.setAttribute("busqueda", busquedaAlumno);
                this.id_alumno = idAlumno;
                
            }
            else
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Alumno no encontrado en la base de datos!"); 
            }
            
        //metodo de actualizar un Alumno
        }
        else if("actualizarAlumno".equals(accion))
        {
            boolean rp = ControladorAlumno.actualizarAlumno(request, response, id_alumno);
            
            if(rp!=false)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Alumno actualizado con exito!");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("ActualizarAlumno.jsp");
                JOptionPane.showMessageDialog(null, "Actualización fallida, problemas internos");
            }
        //metodo de borrar un Alumno
        }
        else if("borrarAlumno".equals(accion))
        {
            alumnosDAO.eliminarAlumno(id_alumno);
            dispatcher = request.getRequestDispatcher("Administrador.jsp");
            request.setAttribute("validacion", "¡Alumno borrado con exito!");
        }
        
//secuencialmente en este punto se gestionan los servicios para los niveles
        //metodo de insertar un Acudiente
        else if("insertarAcudiente".equals(accion))
        {
            boolean rp = ControladorAcudiente.insertarAcudiente(request, response, accion);
            
            if(rp!=false)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Acudiente registrado con exito!");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡No se pudo registrar el usuario acudiente con exito!");
            }
        }
        //metodo de buscar un Acudiente
        else if("buscarAcudiente".equals(accion))
        {
            int idAcudiente = Integer.parseInt(request.getParameter("buscar_acudiente"));
            List<Acudiente> busquedaAcudiente = acudienteDAO.acudienteMostrar(idAcudiente);
            
            if(busquedaAcudiente==null)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Usuario Acudiente no encontrado en la base de datos!"); 
            }
            else if(busquedaAcudiente.isEmpty()!=true)
            {
                //JOptionPane.showMessageDialog(null, "Acudiente encontrado");
                dispatcher = request.getRequestDispatcher("ActualizarAcudiente.jsp");
                request.setAttribute("busqueda", busquedaAcudiente);
                this.id_acudiente = idAcudiente;
            }
            else
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Acudiente no encontrado en la base de datos!"); 
            }
        }
        //metodo de actualizar un Acudiente
        else if("actualizarAcudiente".equals(accion))
        {
            boolean rp = ControladorAlumno.actualizarAlumno(request, response, id_acudiente);
            
            if(rp!=false)
            {
                dispatcher = request.getRequestDispatcher("Administrador.jsp");
                request.setAttribute("validacion", "¡Acudiente actualizado con exito!");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("ActualizarAcudiente.jsp");
                JOptionPane.showMessageDialog(null, "Actualización fallida, problemas internos");
            }
        }
        //metodo de borrar un Acudiente
        else if("borrarAcudiente".equals(accion))
        {
            acudienteDAO.eliminarAcudiente(id_acudiente);
            
            dispatcher = request.getRequestDispatcher("Administrador.jsp");
            request.setAttribute("validacion", "¡Acudiente borrado con exito!");
        }
        else if("observacion".equals(accion))
        {
            int alum =Integer.parseInt(request.getParameter("id_alum"));
            String observacion =(String)request.getParameter("Observacion");
            
            alumnosDAO.insertarObservacion(observacion, alum);
            
            List<Profesores> busqueda = profesoresDAO.profesoresMostrar_CorreoIdentidad(correo, clave);
            int id_profesor_encontrado = profesoresDAO.retornar_id(correo, clave);
            dispatcher = request.getRequestDispatcher("Profesor.jsp");
            request.setAttribute("busqueda", busqueda);
            request.setAttribute("pro", String.valueOf(id_profesor_encontrado));
        }
        else if("cancelar".equals(accion))
        {
            dispatcher = request.getRequestDispatcher("Administrador.jsp");
        }else if("cerrarSesion".equals(accion)){
            //hacer una pequena validacion de si qiere salir
            HttpSession session = request.getSession(); 
            session.invalidate();
            dispatcher = request.getRequestDispatcher("index.jsp");
        }
        
        dispatcher.forward(request, response);

        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

<%-- 
    Document   : Profesor
    Created on : 17/01/2022, 01:14:14 AM
    Author     : Danny
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Master - Profesor</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
            />
        <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
            />
        <!--import-->
        <link rel="stylesheet" href="styleP.css" />
    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
                <a class="navbar-brand" href="#">
                    <image
                        src="https://cdn.glitch.me/440365e1-8468-4e6b-95c6-e1ff92360eb1%2Frsz_1rsz_1rsz_1rsz_deberes.png?v=1635425610407"
                        alt="icono"
                        />
                    SchoolMaster - Profesor
                </a>

                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link " href="#">Acerca de</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ayuda</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <image
                                src="https://cdn.glitch.me/a41a83bc-555e-4096-b02e-5f77808b5ef6%2Frsz_rsz_1perfil-del-usuario.png?v=1636507212952"
                                alt="icono"
                                />
                            Profesor
                        </a>
                        <ul>
                            <%
                                Conexion con = new Conexion();
                                PreparedStatement ps;
                                ResultSet rs;
                                Connection cn = con.getConexion();

                                String idProfe = (String) request.getAttribute("pro");

                                if (idProfe != null) {
                                    try {
                                        String sql = "select id_profesor, nombre_pro, correo_electronico_pro from tbl_profesor where id_profesor=?";
                                        ps = cn.prepareStatement(sql);
                                        ps.setInt(1, Integer.parseInt(idProfe));
                                        rs = ps.executeQuery();
                                        while (rs.next()) {
                                            out.println("<li class='nav-item'>");
                                            out.println("<label style='color: white'> ID: " + rs.getInt("id_profesor") + "</label>");
                                            out.println("</li>");
                                            out.println("<li class='nav-item'>");
                                            out.println("<label style='color: white'> Correo: " + rs.getString("correo_electronico_pro") + "</label>");
                                            out.println("</li>");


                            %>
                            <li class="nav-item">
                                <a class="nav-link" href="ProfesorServlet?accion=cerrarSesion">Cerrar sesión</a>
                            </li>
                        </ul>
                    </li>
                    
                </ul>
                            <%              out.println("<label style='color:aquamarine'><h4>Hola " + rs.getString("nombre_pro") + "</h4></label>");
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Error al cargar los datos de 'Profesor': " + e);
                                    }
                                }
                            %> 
            </nav>
        </header>

        <section id="profesor">
            <div class="container mt-5 mb-5 col-18 col-sm-9 col-lg-8">
                <h1>
                    Profesor
                </h1>
                <p>
                    En este espacio va la foto del profesor
                </p>
                <div class="row justify-content-center">
                    <div class="col-12 col-sm-6 col-lg-5"></div>
                    <div class="col-12 col-sm-6">
                        <table>
                            <thead>
                                <c:forEach var="profesores" items="${busqueda}">
                                    <tr>
                                        <td><label><strong>ID: </strong></label></td>
                                        <td><c:out value="${profesores.id_profesor}" /></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><label><strong>Nombre y apellidos: </strong></label></td>
                                        <td><c:out value="${profesores.nombre_pro} ${profesores.primer_apellido_pro} ${profesores.segundo_apellido_pro}" /></td>
                                    </tr>
                                    <tr>
                                        <td><label><strong>Numero de documento: </strong></label></td>
                                        <td><c:out value="${profesores.numero_identidad_pro}" /></td>
                                    </tr>
                                </c:forEach>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </section>

        <section id="matricula">
            <div class="container mt-5 mb-5 col-18 col-sm-9 col-lg-8">
                <h1>
                    Listado de alumnos
                </h1>
                <div class="row justify-content-center">
                    <table>
                        <thead>
                            <tr class="titulos-tabla">
                                <th>ID alumno</th>
                                <th>Numero de documento</th>
                                <th>Nombre</th>
                                <th>ID del acudiente</th>
                                <th>Agregar observación</th>
                            </tr>
                        </thead>


                        <%
                            if (idProfe != null) {

                                try {

                                    String sql = "select ID_ALUMNO, NUMERO_IDENTIDAD_ALUM, NOMBRE_ALUMNO, PRIMER_APELLIDO_ALUM, SEGUNDO_APELLIDO_ALUM from tbl_alumno where nivel_academico in (select id_niveles from tbl_niveles where id_profesor_nivel =?) order by NOMBRE_ALUMNO";
                                    ps = cn.prepareStatement(sql);
                                    ps.setInt(1, Integer.parseInt(idProfe));
                                    rs = ps.executeQuery();
                                    while (rs.next()) {
                                        out.println("<tr>");
                                        out.println("<td>" + rs.getString("id_alumno") + "</td>");
                                        out.println("<td>" + rs.getString("numero_identidad_alum") + "</td>");
                                        out.println("<td>" + rs.getString("nombre_alumno") + " " + rs.getString("primer_apellido_alum") + rs.getString("segundo_apellido_alum") + "</td>");
                                        out.println("<td>" + idProfe + "</td>");
                                        //imprimir observacion
                                        out.println("</tr>");

                                    }

                                } catch (Exception e) {
                                    System.out.println("Error al cargar los datos de 'Tipo de identidad': " + e);
                                    JOptionPane.showMessageDialog(null, "profesor error" + e);
                                }
                            } else {
                                out.println("<tr>");
                                out.println("<td>No se encontraron Estudiantes</td>");
                                out.println("</tr>");
                            }
                        %>



                    </table>
                </div>
            </div>
        </section>
        <div class="container mt-5 mb-5 col-18 col-sm-9 col-lg-8">
            <h1>
                Agregar una observación a un Alumno
            </h1>
            
            <div class="row justify-content-center">
                <form action="ProfesorServlet?accion=observacion" method="POST" autocomplete="off">
                    <table>
                        <tr>
                            <td>
                                <label><strong>ID del alumno:</strong></label>
                            </td>
                            <td>
                                <input type="text" name="id_alum" id="id_alum"/>
                            </td>
                        </tr>
                        <br/>
                        <tr>
                            <td>
                                <label><strong>Observación:</strong></label><br/>
                            </td>
                            <td>
                                <input type="text" id="Observacion" name="Observacion" Style="width: 800px"/>
                            </td>
                        </tr>
                    </table>
                    
                    <input class="btn-primary" type="submit" name="btnAgregar"  value="Agregar observacion"/>
                </form>
            </div>
        </div>
        <script src="popupP.js"></script>
    </body>
</html>

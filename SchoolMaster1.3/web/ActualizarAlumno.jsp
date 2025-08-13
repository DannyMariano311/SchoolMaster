<%-- 
    Document   : ActualizarAlumno
    Created on : 7/02/2022, 06:38:41 PM
    Author     : Danny
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Master - Admin</title>
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
        <link rel="stylesheet" href="styleA.css" />

    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
                <a class="navbar-brand" href="#">
                    <image
                        src="https://cdn.glitch.me/440365e1-8468-4e6b-95c6-e1ff92360eb1%2Frsz_1rsz_1rsz_1rsz_deberes.png?v=1635425610407"
                        alt="icono"
                        />
                    SchoolMaster-Administrador
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
                            Admin
                        </a>
                        <ul>
                            <li class="nav-item">
                                <a class="nav-link" href="#">-Nombre de Usuario-</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">-Cédula-</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="">Cerrar sesión</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link"> </a></li>
                </ul>
            </nav>
        </header>

        <div class="row">
            <div class="col-3 col-s-3 menu">
                <ul>
                    <a id="cancelar" name="cancelar" href="ProfesorServlet?accion=cancelar"><li>Cancelar</li></a>
                </ul>
            </div>

            <!--en esta sesión esta la informacion correspondiente al INICIO Y ADVENTENCIAS-->
            <div class="col-4 col-s-10" id="">

                <div id="encontrado_mod">

                    <h5>
                        <strong>Resultados de la búsqueda:</strong>
                    </h5>
                    <table>
                        <tr>
                            <td><strong>Datos del usuario</strong></td>
                        </tr>
                        <tbody>

                            <c:forEach var="alumnos" items="${busqueda}">
                                <tr>
                                    <td><label>Id del Alumno: </label></td>
                                    <td><c:out value="${alumnos.id_alumno}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Tipo de identidad: </label></td>
                                    <td><c:out value="${alumnos.nombre_t_identidad}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Numero de identidad: </label></td>
                                    <td><c:out value="${alumnos.numero_identidad_alum}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Nombre: </label></td>
                                    <td><c:out value="${alumnos.nombre_alumno}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Primer apellido: </label></td>
                                    <td><c:out value="${alumnos.primer_apellido_alum}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Segundo apellido: </label></td>
                                    <td><c:out value="${alumnos.segundo_apellido_alum}" /></td>
                                </tr>
                                
                                <tr>
                                    <td><label>Fecha de nacimiento: </label></td>
                                    <td><c:out value="${alumnos.fecha_nacimiento_alum}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Genero: </label></td>
                                    <td><c:out value="${alumnos.nombre_genero}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Fecha de ingreso: </label></td>
                                    <td><c:out value="${alumnos.fecha_ingreso_alum}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Nivel Académico: </label></td>
                                    <td><c:out value="${alumnos.nombre_nivel}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Dirección de residencia: </label></td>
                                    <td><c:out value="${alumnos.direccion_residencia_alum}" /></td>
                                </tr>
                            </c:forEach>

                        </tbody>

                    </table>
                    <button class="btn btn-dark" id="btn-actualizar">Actualizar</button>
                    <button class="btn btn-dark" id="btn-optionBorrar">Borrar</button>

                </div>
            </div>


            <div class="col-5 col-s-11">
                <div class="aside">
                    <h2>Proceso</h2>

                </div>
                <div id="borrar">
                    ¿Esta seguro de querer borrar el usuario? 
                    <form action="ProfesorServlet?accion=borrarAlumno" method="POST" autocomplete="off">
                        <tr>
                            <td></td>
                        </tr>

                        <input type="submit" name="btnborrar"  value="Borrar"/>
                    </form>

                </div>

                <div id="actualizar">
                    <form  action="ProfesorServlet?accion=actualizarAlumno" method="POST" autocomplete="off">
                        <table>
                            <tr>
                                <td>
                                    <label for="tipo_i_alum">Tipo de identificación</label>
                                </td>
                                <td>
                                    <select name="tipo_i_alum" id="tipo_i_alum">
                                        <option>-seleccionar-</option>
                                        <%
                                            Conexion con = new Conexion();
                                            PreparedStatement ps;
                                            ResultSet rs;
                                            Connection cn = con.getConexion();
                                            int i = 1;
                                            try {

                                                String sql = "select * from tbl_tipo_identidad";
                                                ps = cn.prepareStatement(sql);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    out.println("<option value='" + i + "'>" + rs.getString("nombre_t_identidad"));
                                                    i = i + 1;
                                                }

                                            } catch (Exception e) {
                                                System.out.println("Error al cargar los datos de 'Tipo de identidad': " + e);
                                            }
                                        %>

                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="numero_i_alum">Numero de identificación</label>
                                </td>
                                <td>
                                    <input type="text" name="numero_i_alum" id="numero_i_alum"/>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="nom_alum">Nombres</label>
                                </td>
                                <td>
                                    <input type="text" name="nombre_alum" id="nombre_alum" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="ape_alum">Primer apellidos</label>
                                </td>
                                <td>
                                    <input type="text" name="p_apellido_alum" id="p_apellido_alum" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="ape_alum">Segundo apellidos</label>
                                </td>
                                <td>
                                    <input type="text" name="s_apellido_alum" id="s_apellido_alum" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="fecha_alum">Fecha de nacimientos</label>
                                </td>
                                <td>
                                    <input type="date" name="nacimiento_alum" id="nacimiento_alum" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="genero">Género</label>
                                </td>
                                <td>
                                    <select name="genero_alum" id="genero_alum">
                                        <option>--seleccionar--</option>
                                        <%
                                            i = 1;
                                            try {

                                                String sql = "select * from tbl_genero";
                                                ps = cn.prepareStatement(sql);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    out.println("<option value='" + i + "'>" + rs.getString("nombre_genero") + "</option>");
                                                    i = i + 1;
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error al cargar los datos de 'Tipo de identidad': " + e);
                                            }
                                        %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="fecha_ingreso_alum">Fecha de ingreso</label>
                                </td>
                                <td>
                                    <input type="date" name="fecha_ingreso_alum" id="fecha_ingreso_alum"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Nivel académico</label>
                                </td>
                                <td>
                                    <select name="nivel_academico_alum" id="nivel_academico_alum">
                                        <option>--seleccionar--</option>
                                        <%
                                            i = 1;
                                            try {

                                                String sql = "select * from tbl_niveles";
                                                ps = cn.prepareStatement(sql);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    out.println("<option value='" + rs.getInt("id_niveles") + "'>" + rs.getString("nombre_nivel") + "</option>");
                                                    i = i + 1;
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error al cargar los datos de 'Tipo de identidad': " + e);
                                            }
                                        %>
                                    </select>

                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="direccion_alum">Dirección de recidencia</label>
                                </td>
                                <td>
                                    <input type="adrees" name="direccion_alum" id="direccion_alum"/>
                                </td>
                            </tr>

                        </table>
                        <input type="submit" name="btnActualizarAlumno" value="Actualizar"/>
                    </form>
                </div> 
            </div>
        </div>

        <div class="footer">
            <p>
                <strong>MEDIOS DE CONTACTO</strong><br />
                <strong>Celular: </strong><em>+57-000-000-0000</em><br />
                <strong>Telefono: </strong><em>000-000-00</em><br />
                <strong>Correo: </strong><em>correo-ejemplo@extencion.dominio</em>
            </p>
        </div>
        <script src="popupP.js"></script>
    </body>
</html>


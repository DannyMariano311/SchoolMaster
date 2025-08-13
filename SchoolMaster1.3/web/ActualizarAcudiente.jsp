<%-- 
    Document   : ActualizarAcudiente
    Created on : 8/02/2022, 09:34:49 AM
    Author     : Danny
--%>

<%-- 
    Document   : Administrador
    Created on : 17/01/2022, 12:57:29 AM
    Author     : Danny
--%>


<%@page import="javax.swing.JOptionPane"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="modelo.Acudiente"%>
<%@page import="modelo.AcudienteDAO"%>
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

                            <c:forEach var="acudiente" items="${busqueda}">
                                <tr>
                                    <td><label>Id del acudiente: </label></td>
                                    <td><c:out value="${acudiente.id_acudiente}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Tipo de identidad: </label></td>
                                    <td><c:out value="${acudiente.nombre_t_identidad}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Numero de identidad: </label></td>
                                    <td><c:out value="${acudiente.numero_identidad_acu}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Nombre: </label></td>
                                    <td><c:out value="${acudiente.nombre_acudiente}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Primer apellido: </label></td>
                                    <td><c:out value="${acudiente.primer_apellido_acu}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Segundo apellido: </label></td>
                                    <td><c:out value="${acudiente.segundo_apellido_acu}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Correo electrónico: </label></td>
                                    <td><c:out value="${acudiente.correo_acu}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Fecha de nacimiento: </label></td>
                                    <td><c:out value="${acudiente.fecha_nacimiento_acu}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Genero: </label></td>
                                    <td><c:out value="${acudiente.nombre_genero}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Teléfono fijo: </label></td>
                                    <td><c:out value="${acudiente.telefono_fijo_acu}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Teléfono movil: </label></td>
                                    <td><c:out value="${acudiente.telefono_movil_acu}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Información del alumno: </label></td>
                                    <td><c:out value="${acudiente.info_alum}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Parentesco: </label></td>
                                    <td><c:out value="${acudiente.parentesco}" /></td>
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
                    <form action="ProfesorServlet?accion=borrarAcudiente" method="POST" autocomplete="off">
                        <tr>
                            <td></td>
                        </tr>
                         
                        <input type="submit" name="btnborrar"  value="Borrar"/>
                    </form>
                        
                </div>

                <div id="actualizar">
                    <form action="ProfesorServlet?accion=actualizarAcudiente" method="POST" autocomplete="off">
                        <table>

                            <tr>
                                <td>
                                    <label for="mod_t_document_acu">Tipo de identificación</label>
                                </td>
                                <td>
                                    <select name="mod_t_documento_acu" id="mod_t_documento_acu" required>
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
                                    <label for="mod_n_document_acu">Numero de identificación</label>
                                </td>
                                <td>
                                    <input type="text" name="mod_n_document_acu" id="mod_n_document_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="mod_nom_acu">Nombre</label>
                                </td>
                                <td>
                                    <input type="text" name="mod_nom_acu" id="mod_nom_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="mod_primer_ape_acu">Primer Apellido</label>
                                </td>
                                <td>
                                    <input type="text" name="mod_primer_ape_acu" id="mod_primer_ape_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="mod_segundo_ape_acu">Segundo Apellidos</label>
                                </td>
                                <td>
                                    <input type="text" name="mod_segundo_ape_acu" id="mod_segundo_ape_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="mod_ape_acu">Correo Electrónico: </label>
                                </td>
                                <td>
                                    <input type="email" name="mod_correo_acu" id="mod_correo_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="mod_fecha_acu">Fecha de nacimientos</label>
                                </td>
                                <td>
                                    <input type="date" name="mod_fecha_acu" id="mod_fecha_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="">Género</label>
                                </td>
                                <td>
                                    <select name="mod_genero_acu" id="mod_genero_acu">
                                        <option>-seleccionar-</option>
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
                                    <label for="mod_tf_acu">Teléfono fijo</label>
                                </td>
                                <td>
                                    <input type="text" name="mod_tf_acu" id="mod_tf_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="mod_tm_acu">Teléfono móvil</label>
                                </td>
                                <td>
                                    <input type="text" name="mod_tm_acu" id="mod_tm_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="id_alum_acu">Id alumno del acudiente: </label>
                                </td>
                                <td>
                                    <input type="date" name="id_alum_acu" id="id_alum_acu" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <label for="parentesco">Parentesco: </label>
                                </td>
                                <td>
                                    <input type="text" name="parentesco" id="parentesco" />
                                </td>
                            </tr>
                        </table>
                        <input type="submit" name="btnactualizarAcu" value="Actualizar"/>
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


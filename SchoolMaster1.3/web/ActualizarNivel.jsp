<%@page import="javax.swing.JOptionPane"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="modelo.Profesores"%>
<%@page import="modelo.ProfesoresDAO"%>
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
                            <td><strong>Datos del Nivel académico</strong></td>
                        </tr>
                        <tbody>

                            <c:forEach var="niveles" items="${busqueda}">
                                <tr>
                                    <td><label>Id del nivel académico: </label></td>
                                    <td><c:out value="${niveles.id_niveles}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Nombre: </label></td>
                                    <td><c:out value="${niveles.nombre_nivel}" /></td>
                                </tr>
                                <tr>
                                    <td><label>jornada: </label></td>
                                    <td><c:out value="${niveles.nombre_jornada}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Profesor asignado: </label></td>
                                    <td><c:out value="${niveles.info_profe}" /></td>
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
                    ¿Esta seguro de querer borrar el nivel académico? 
                    <form action="ProfesorServlet?accion=borrarNivel" method="POST" autocomplete="off">
                        <tr>
                            <td></td>
                        </tr>

                        <input type="submit" name="btnborrar"  value="Borrar"/>
                    </form>

                </div>

                <div id="actualizar">
                    <form action="ProfesorServlet?accion=actualizarNivel" method="POST" autocomplete="off">
                        <table>
                            <tr>
                                <td>
                                    <label for="nom_nivel">Nombre del nivel</label>
                                </td>
                                <td>
                                    <input type="text" name="nom_nivel" id="nom_nivel" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Jornada</label>
                                </td>
                                <td>
                                    <select name="jornada" id="jornada">
                                        <option>-seleccionar-</option>
                                        <%
                                            Conexion con = new Conexion();
                                            PreparedStatement ps;
                                            ResultSet rs;
                                            Connection cn = con.getConexion();
                                            int i = 1;
                                            try {

                                                String sql = "select * from tbl_jornadas";
                                                ps = cn.prepareStatement(sql);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    out.println("<option value='" + i + "'>" + rs.getString("nombre_jornada") + "</option>");
                                                    i = i + 1;
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Error al cargar los datos de 'joranda': " + e);
                                            }
                                        %>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><strong>Asignar profesor</strong></label>
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="id_profe_n">Informacion de los profesores</label>
                                </td>
                                <td>
                                    <select name="id_profe_nivel" id="id_profe_nivel">
                                        <option>--seleccionar--</option>
                                        <%
                                            try {
                                                String sql = "SELECT ID_PROFESOR, NUMERO_IDENTIDAD_PRO, NOMBRE_PRO, PRIMER_APELLIDO_PRO from TBL_PROFESOR ORDER BY NOMBRE_PRO";
                                                ps = cn.prepareStatement(sql);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    out.println("<option value='" + rs.getInt("ID_PROFESOR") + "'>" + "Documento: " + rs.getString("NUMERO_IDENTIDAD_PRO") + "| Nombre:" + rs.getString("NOMBRE_PRO") + " " + rs.getString("PRIMER_APELLIDO_PRO") + "</option>");

                                                }

                                            } catch (Exception e) {
                                                System.out.println("Error al cargar los datos de 'Profesor': " + e);
                                            }
                                        %>
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <input type="submit" name="btnactualizarNivel" value="Actualizar"/>
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

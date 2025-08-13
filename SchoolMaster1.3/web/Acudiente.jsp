<%-- 
    Document   : Acudiente
    Created on : 17/01/2022, 01:11:28 AM
    Author     : Danny
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="config.Conexion"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Master</title>
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
        <link rel="stylesheet" href="style.css" />
    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">
                    <image
                        src="https://cdn.glitch.me/440365e1-8468-4e6b-95c6-e1ff92360eb1%2Frsz_1rsz_1rsz_1rsz_deberes.png?v=1635425610407"
                        alt="icono"
                        />
                    SchoolMaster
                </a>

                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link" href="#estudiante">Estudiante</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#matricula">Matrícula</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <image
                                src="https://cdn.glitch.me/a41a83bc-555e-4096-b02e-5f77808b5ef6%2Frsz_rsz_1perfil-del-usuario.png?v=1636507212952"
                                alt="icono"
                                />
                            Acudiente
                        </a>
                        <ul>
                            <%
                                Conexion con = new Conexion();
                                PreparedStatement ps;
                                ResultSet rs;
                                Connection cn = con.getConexion();

                                String idAcu = (String) request.getAttribute("acu");

                                if (idAcu != null) {
                                    try {
                                        String sql = "select id_acudiente, nombre_acudiente, correo_electronico_acu from tbl_acudiente where id_acudiente=?";
                                        ps = cn.prepareStatement(sql);
                                        ps.setInt(1, Integer.parseInt(idAcu));
                                        rs = ps.executeQuery();
                                        while (rs.next()) {
                                            out.println("<li class='nav-item'>");
                                            out.println("<label style='color: white'> ID: " + rs.getInt("id_acudiente") + "</label>");
                                            out.println("</li>");
                                            out.println("<li class='nav-item'>");
                                            out.println("<label style='color: white'> Correo: " + rs.getString("correo_electronico_acu") + "</label>");
                                            out.println("</li>");


                            %>
                            <li class='nav-item'>
                                <a class='nav-link' href='ProfesorServlet?accion=cerrarSesion'>Cerrar sesión</a>
                            </li>

                        </ul>
                    </li>
                    <li class="nav-item">

                    </li>
                </ul>
                            <%              out.println("<label style='color:aquamarine'><h4>Hola " + rs.getString("nombre_acudiente") + "</h4></label>");
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Error al cargar los datos de 'Acudiente': " + e);
                                    }
                                }
                            %>    
            </nav>
        </header>

        <section id="estudiante" >
            <div class="container mt-5 mb-5 col-18 col-sm-9 col-lg-8">
                <h1>
                    Información del alumno
                </h1>
                <div class="row justify-content-center">
                    <div class="col-12 col-sm-6 col-lg-5">
                        <img
                            src="https://cdn.glitch.me/a41a83bc-555e-4096-b02e-5f77808b5ef6%2Frsz_nina_1.png?v=1636511816461"
                            alt="Foto del estudiante"
                            />
                    </div>
                    <div class="col-12 col-sm-6">
                        <table>

                            <%
                                if (idAcu != null) {
                                    try {

                                        String sql = "select ID_ALUMNO, NUMERO_IDENTIDAD_ALUM, NOMBRE_ALUMNO, PRIMER_APELLIDO_ALUM, SEGUNDO_APELLIDO_ALUM, NOMBRE_NIVEL, OBSERVACION "
                                                + "from tbl_alumno "
                                                + "inner join tbl_niveles on id_niveles = NIVEL_ACADEMICO "
                                                + "where id_alumno in (select id_alumno_acu from tbl_acudiente where id_acudiente =?)";
                                        ps = cn.prepareStatement(sql);
                                        ps.setInt(1, Integer.parseInt(idAcu));
                                        rs = ps.executeQuery();
                                        while (rs.next()) {
                                            out.println("<tr>");
                                            out.println("<th>Numero de identidad:</th>");
                                            out.println("<td>" + rs.getString("id_alumno") + "</td>");
                                            out.println("</tr>");
                                            out.println("<tr>");
                                            out.println("<th>Numero de identidad:</th>");
                                            out.println("<td>" + rs.getString("numero_identidad_alum") + "</td>");
                                            out.println("</tr>");
                                            out.println("<tr>");
                                            out.println("<th>Numero de identidad:</th>");
                                            out.println("<td>" + rs.getString("nombre_alumno") + " " + rs.getString("primer_apellido_alum") + " " + rs.getString("segundo_apellido_alum") + "</td>");
                                            out.println("</tr>");
                                            out.println("<tr>");
                                            out.println("<th>Grado cursado:</th>");
                                            out.println("<td>" + rs.getString("NOMBRE_NIVEL") + "</td>");
                                            out.println("</tr>");
                                            out.println("<tr>");
                                            out.println("<td>" + idAcu + "</td>");
                                            out.println("</tr>");


                            %>

                        </table>
                    </div>
                </div>
                <h3 id="obser">Observaciones:</h3>
                <p>

                    <%                                    out.println(rs.getString("observacion"));
                                }
                            } catch (Exception e) {
                                System.out.println("Error al cargar los datos de 'Alumno': " + e);
                                //JOptionPane.showMessageDialog(null, "Profesor error:" + e);
                            }
                        } else {
                            out.println("<tr>");
                            out.println("<td>No se encontraron Estudiantes</td>");
                            out.println("</tr>");
                        }
                    %>
                </p>
            </div>
        </section>

        <section id="matricula">
            <div class="container mt-5 mb-5 col-18 col-sm-9 col-lg-8">
                <h1>
                    Consultar o pagar Matrículas
                </h1>
                <div class="row justify-content-center">
                    <table>
                        <thead>
                            <tr class="titulos-tabla">
                                <th># Factura</th>
                                <th>Periodo actual</th>
                                <th>Fecha de expedición</th>
                                <th>Adjuntar comprobante de pago</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td>F-001</td>
                                <td>primer periodo</td>
                                <td>9/11/2021</td>
                                <td>
                                    <a href="#">
                                        <bottom href="#" class="btn btn-primary adjuntar">
                                            Adjuntar
                                        </bottom>
                                    </a>
                                </td>
                            </tr>

                            <tr>
                                <td>F-002</td>
                                <td>Segundo periodo</td>
                                <td>9/11/2021</td>
                                <td>
                                    <a class="adjuntar" href="#">
                                        <bottom href="#" class="btn btn-primary adjuntar">
                                            Adjuntar
                                        </bottom>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>F-003</td>
                                <td>tercer periodo</td>
                                <td>9/11/2021</td>
                                <td>
                                    <a class="adjuntar" href="#">
                                        <bottom href="#" class="btn btn-primary adjuntar">
                                            Adjuntar
                                        </bottom>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>F-004</td>
                                <td>cuarto periodo</td>
                                <td>9/11/2021</td>
                                <td>
                                    <a class="adjuntar" href="#">
                                        <bottom href="#" class="btn btn-primary adjuntar">
                                            Adjuntar
                                        </bottom>
                                    </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>


        <div class="footer">
            <p>
                <strong>MEDIOS DE CONTACTO</strong><br>
                <strong>Celular: </strong><em>+57-000-000-0000</em><br>
                <strong>Telefono: </strong><em>000-000-00</em><br>
                <strong>Correo: </strong><em>correo-ejemplo@extencion.dominio</em>
            </p>
        </div>
        <script src="popupAl.js"></script>
    </body>
</html>

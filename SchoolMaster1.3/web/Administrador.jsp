<%-- 
    Document   : Administrador
    Created on : 17/01/2022, 12:57:29 AM
    Author     : Danny
--%>

<%@page import="controlador.MiServlet"%>
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
                                <a class="nav-link" href="ProfesorServlet?accion=cerrarSesion">Cerrar sesión</a>
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
                    <a id="mos_g_profesor" href="#g_profesor"><li>Gestionar Profesor</li></a>
                    <a id="mos_niveles" href="#niveles"><li>Gestionar Niveles</li></a>
                    <a id="mos_alumno" href="#alumnos"><li>Gestionar Alumnos</li></a>
                    <a id="mos_acudiente" href="#acudiente"><li>Gestionar Acudiente</li></a>
                </ul>
            </div>

            <!--en esta sesión esta la informacion correspondiente al INICIO Y ADVENTENCIAS-->
            <div class="col-6 col-s-10" id="inicio">
                <h1>
                    Esta sesión de School Master, es exclusiva para uso del administrador
                    del aplicativo.
                </h1>
                
                    
                    <%
                        String validacion = (String) request.getAttribute("validacion");
                        if(validacion == null){
                            out.print("<p>"
                                        +"ADVERTENCIA:<br />"
                                        +"Si llegado el caso esta sessión es ejecutada por personal no"
                                        +"autorizado o con conocimientos nulos de la misma, puede ocasionar"
                                        +"cambios en la base de datos, pérdida de información o el manejo"
                                        +"ilícito de información privada de los usuarios del sistema, por lo"
                                        +"cual debe tener prioridad en el manejo de la información del"
                                        +"administrador y no compartirla con un tercero.<br />");
                            out.print("<br />");
                            out.print("RECOMENDACIONES: Para realizar cambios en la información del"
                                        +"administrador, como usuario o contraseña, comuníquese con el"
                                        +"desarrollador o el administrador de la base de datos.<br/>");
                        }
                        
                        if (validacion != null) {
                            out.print("<br/>");
                            out.print("<center>");
                            out.print("<h2 style='color:red'>EL SISTEMA INFORMA:</h2><br/>");
                            out.print("<br/>");
                            out.print("<span style='color:blue'><strong>" + validacion + "</strong></span>");
                            out.print("</center>");
                        }
                    %>

                </p>

            </div>

            <!--en esta sesión esta la informacion correspondiente a los PROFESORES-->
            <div class="col-6 col-s-10 " id="g_profesor">
                <h1>Gestionar Profesores</h1>
                <p>
                    En esta sesión se podrá gestionar la informacion de un profesor en el
                    sistema.
                </p>

                <!--primer collapse de profesores registrar-->
                <div class="wrapper">
                    <div class="collapsible">
                        <input type="checkbox" id="collapsible-head" />
                        <label class="coll" for="collapsible-head">Registrar un profesor</label>
                        <div class="collapsible-text">
                            <form id="formActualizar" action="ProfesorServlet?accion=insert" method="POST" autocomplete="off">
                                <h3>
                                    Registrar un Profesor nuevo en el sistema
                                </h3>
                                <table>
                                    <tr>
                                        <td>
                                            <label><strong>DATOS PERSONALES</strong></label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="">Tipo de identificación</label>
                                        </td>
                                        <td>
                                            <select name="tipo_i_pro" id="tipo_i_pro" required>
                                                <option id="t_identidad_pro">-seleccionar-</option>
                                                <%
                                                    Conexion con = new Conexion();
                                                    PreparedStatement ps;
                                                    ResultSet rs;
                                                    Connection cn = con.getConexion();

                                                    int i = 1;
                                                    try {

                                                        String sql = "select * from tbl_tipo_identidad order by codigo_t_identidad";
                                                        ps = cn.prepareStatement(sql);
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            out.println("<option value='" + rs.getInt("codigo_t_identidad") + "'>" + rs.getString("nombre_t_identidad"));
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
                                            <label for="n_document_pro">Numero de identificación</label>
                                        </td>
                                        <td>
                                            <input type="text" name="numero_i_pro" id="numero_i_pro" maxlength="20"/>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="nombre_pro">Nombre</label>
                                        </td>
                                        <td>
                                            <input type="text" name="nombre_pro" id="nombre_pro" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="ape">Primer Apellido</label>
                                        </td>
                                        <td>
                                            <input type="text" name="p_apellido_pro" id="p_apellido_pro" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="ape">Segundo Apellidos</label>
                                        </td>
                                        <td>
                                            <input type="text" name="s_apellido_pro" id="s_apellido_pro" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="correo_electronico_pro">Correo electrónico(Con este correo iniciara sesión)</label>
                                        </td>
                                        <td>
                                            <input type="email" name="correo_pro" id="correo_pro" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="fecha">Fecha de nacimiento</label>
                                        </td>
                                        <td>
                                            <input type="date" name="nacimiento_pro" id="nacimiento_pro" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="sexo">Género</label>
                                        </td>
                                        <td>
                                            <select name="genero_pro" id="genero_pro">
                                                <option>-seleccionar-</option>
                                                <%
                                                    i = 1;
                                                    try {

                                                        String sql = "select * from tbl_genero order by codigo_genero";
                                                        ps = cn.prepareStatement(sql);
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            out.println("<option value='" + rs.getInt("codigo_genero") + "'>" + rs.getString("nombre_genero") + "</option>");
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
                                            <label><strong>DATOS DE LOCACIÓN</strong></label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="direccion">Dirección de recidencia</label>
                                        </td>
                                        <td>
                                            <input type="adrees" name="residencia_pro" id="residencia_pro" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="tf">Teléfono fijo</label>
                                        </td>
                                        <td>
                                            <input type="text" name="tf_pro" id="tf_pro" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="tm">Teléfono móvil</label>
                                        </td>
                                        <td>
                                            <input type="text" name="tm_pro" id="tm_pro" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label><strong>INFORMACIÓN PROFESIONAL</strong></label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="fecha_ingreso">Fecha de ingreso</label>
                                        </td>
                                        <td>
                                            <input type="date" name="ingreso_pro" id="ingreso_pro" />
                                        </td>
                                    </tr>

                                </table>
                                <input class="btn btn-dark" type="submit" name="btnRegistrar" value="Registrar"> 

                            </form>
                        </div>
                    </div>
                </div>

                <!--segundo collapse de profesores modificar-->
                <div class="wrapper">
                    <div class="collapsible">
                        <input type="checkbox" id="collapsible-head2" />
                        <label class="coll" for="collapsible-head2">Modificar o eliminar un profesor</label>
                        <div class="collapsible-text2">
                            <h3>
                                Modificar o Eliminar los datos de un Profesor registrado en el sistema
                            </h3>
                            <p>
                                Primero debes buscarlo en la base de datos para poder validar si
                                esta registrado y posteriormente operar sobre éste.
                            </p>

                            <form action="ProfesorServlet?accion=buscar" method="POST" autocomplete="off">
                                <label for="b_id">ID del profesor</label>
                                <input type="text" name="buscarProfe" id="buscarProfe" />
                                <input class="btn btn-dark" type="submit" name="btnbusacarP" value="Buscar"/> 
                            </form>

                        </div>
                    </div>
                </div>

            </div>

            <!--en esta sesión esta la informacion correspondiente a los NIVELES-->
            <div class="col-6 col-s-10" id="niveles">
                <h1>Gestionar niveles</h1>
                <p>
                    En esta sesión se podrá borrar un Nivel educativo que actualmente esta
                    registrado en el sistema.
                </p>

                <!--primer collapse de niveles-->
                <div class="wrapper">
                    <div class="collapsible">
                        <input type="checkbox" id="collapsible-head4" />
                        <label class="coll" for="collapsible-head4">Registrar un nivel</label>
                        <div class="collapsible-text4">
                            <form action="ProfesorServlet?accion=insertarNivel" method="POST" autocomplete="off">
                                <h3>
                                    Registrar un nivel nuevo en el sistema
                                </h3>
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
                                                    i = 1;
                                                    try {

                                                        String sql = "select * from tbl_jornadas order by codigo_jornada";
                                                        ps = cn.prepareStatement(sql);
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            out.println("<option value='" + rs.getInt("codigo_jornada") + "'>" + rs.getString("nombre_jornada") + "</option>");
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

                                <input class="btn btn-dark" type="submit" name="btnRegistrarNivel" value="Registrar"/>            
                            </form>

                        </div>
                    </div>
                </div>

                <!--segundo collapse de niveles-->
                <div class="wrapper">
                    <div class="collapsible">
                        <input type="checkbox" id="collapsible-head5" />
                        <label class="coll" for="collapsible-head5"
                               >Modificar o eliminar un nivel académico</label
                        >
                        <div class="collapsible-text5">
                            <h3>
                                Modificar un nivel registrado en el sistema.
                            </h3>
                            <p>
                                Primero debes buscarlo en la base de datos para poder validar si
                                esta registrado y posteriormente operar sobre éste.
                            </p>

                            <form action="ProfesorServlet?accion=buscarNivel" method="POST" autocomplete="off">
                                <label for="buscar_nivel">ID del Nivel</label>
                                <input type="text" name="buscar_nivel" id="buscar_nivel" />
                                <input class="btn btn-dark" type="submit" name="btnbusacarN" value="Buscar"/>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>

            <!--en esta sesión esta la informacion correspondiente a los ALUMNOS-->
            <div class="col-6 col-s-10" id="alumnos">
                <h1>Gestionar alumnos</h1>
                <p>
                    en esta sesión podrás asignarle la validacion de pago o retrazo de
                    pago a un acudiente que tenga un estuiante previamente registrado en
                    el sistema.
                </p>

                <!--primer collapse de alumnos registrar-->
                <div class="wrapper">
                    <div class="collapsible">
                        <input type="checkbox" id="collapsible-head7" />
                        <label class="coll" for="collapsible-head7"
                               >Registrar un alumno</label
                        >
                        <div class="collapsible-text7">
                            <form  action="ProfesorServlet?accion=insertarAlumno" method="POST" autocomplete="off">
                                <h3>
                                    Registrar un Alumno nuevo en el sistema
                                </h3>
                                <table>
                                    <tr>
                                        <td>
                                            <label><strong>DATOS PERSONALES DEL ALUMNO</strong></label>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="tipo_i_alum">Tipo de identificación</label>
                                        </td>
                                        <td>
                                            <select name="tipo_i_alum" id="tipo_i_alum">
                                                <option>-seleccionar-</option>
                                                <%
                                                    i = 1;
                                                    try {

                                                        String sql = "select * from tbl_tipo_identidad order by codigo_t_identidad";
                                                        ps = cn.prepareStatement(sql);
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            out.println("<option value='" + rs.getInt("codigo_t_identidad") + "'>" + rs.getString("nombre_t_identidad"));
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
                                            <label for="n_document_alum">Numero de identificación</label>
                                        </td>
                                        <td>
                                            <input type="text" name="numero_i_alumno" id="numero_i_alumno"/>
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
                                            <label for="nacimiento_alum">Fecha de nacimientos</label>
                                        </td>
                                        <td>
                                            <input type="date" name="nacimiento_alum" id="nacimiento_alum" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="genero_alum">Género</label>
                                        </td>
                                        <td>
                                            <select name="genero_alum" id="genero_alum">
                                                <option>--seleccionar--</option>
                                                <%
                                                    i = 1;
                                                    try {

                                                        String sql = "select * from tbl_genero order by codigo_genero";
                                                        ps = cn.prepareStatement(sql);
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            out.println("<option value='" + rs.getInt("codigo_genero") + "'>" + rs.getString("nombre_genero") + "</option>");
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

                                                        
                                                        String sql = "select * from tbl_niveles order by nombre_nivel";
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
                                <input class="btn btn-dark" type="submit" name="btnRegistrarAlumno" value="Registrar"/>
                            </form>
                            
                        </div>
                    </div>
                </div>

                <!--segundo collapse de alumnos modificar-->
                <div class="wrapper">
                    <div class="collapsible">
                        <input type="checkbox" id="collapsible-head8" />
                        <label class="coll" for="collapsible-head8">Modificar o eliminar un alumno</label>
                        <div class="collapsible-text8">
                            <h3>
                                Registrar un Profesor nuevo en el sistema
                            </h3>
                            <p>
                                Primero debes buscarlo en la base de datos para poder validar si
                                esta registrado y posteriormente operar sobre éste.
                            </p>

                            <form action="ProfesorServlet?accion=buscarAlumno" method="POST" autocomplete="off">
                                <label for="b_id_alum">ID del alumno</label>
                                <input type="text" name="buscar_alumno" id="buscar_alumno" />
                                <input class="btn btn-dark" type="submit" name="btnbusacarA" value="Buscar"/>
                            </form>

                        </div>
                    </div>
                </div>

            </div>

            <!--en esta sesión esta la informacion correspondiente a los ACUDIENTES-->
            <div class="col-6 col-s-10" id="acudiente">
                <h1>Gestionar acudientes</h1>
                <p>
                    En esta sesión se podrá modificar la informacion personal
                    correspondiente a un acudiente que tenga un estudiante en el sistema.
                </p>

                <!--primer collapse de acudientes registrar-->
                <div class="wrapper">
                    <div class="collapsible">
                        <input type="checkbox" id="collapsible-head10" />
                        <label class="coll" for="collapsible-head10">Registrar un acudiente</label>
                        <div class="collapsible-text10">
                            <form action="ProfesorServlet?accion=insertarAcudiente" method="POST" autocomplete="off">
                                <h3>
                                    Registrar un nuevo acudiente en el sistema
                                </h3>
                                <table>
                                    <tr>
                                        <td>
                                            <label><strong>DATOS PERSONALES</strong></label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="t_document_acu">Tipo de identificación</label>
                                        </td>
                                        <td>
                                            <select name="tipo_i_acu" id="tipo_i_acu" required>
                                                <option>-seleccionar-</option>
                                                <%
                                                    i = 1;
                                                    try {

                                                        String sql = "select * from tbl_tipo_identidad order by codigo_t_identidad";
                                                        ps = cn.prepareStatement(sql);
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            out.println("<option value='" + rs.getInt("codigo_t_identidad") + "'>" + rs.getString("nombre_t_identidad"));
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
                                            <label for="numero_i_acu">Numero de identificación</label>
                                        </td>
                                        <td>
                                            <input type="text" name="numero_i_acu" id="numero_i_acu" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="nombre_acu">Nombres</label>
                                        </td>
                                        <td>
                                            <input type="text" name="nombre_acu" id="nombre_acu" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="p_apellido_acu">Primer apellido</label>
                                        </td>
                                        <td>
                                            <input type="text" name="p_apellido_acu" id="p_apellido_acu" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="p_apellido_acu">Segundo apellido</label>
                                        </td>
                                        <td>
                                            <input type="text" name="s_apellido_acu" id="s_apellido_acu" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="correo_acu">Correo electrónico(Con este iniciará sesión)</label>
                                        </td>
                                        <td>
                                            <input type="email" name="correo_acu" id="correo_acu" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="nacimiento_acu">Fecha de nacimientos</label>
                                        </td>
                                        <td>
                                            <input type="date" name="nacimiento_acu" id="nacimiento_acu" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="genero_acu">Genero</label>
                                        </td>
                                        <td>
                                            <select name="genero_acu" id="genero_acu">
                                                <option>-seleccionar-</option>

                                                <%
                                                    i = 1;
                                                    try {

                                                        String sql = "select * from tbl_genero order by codigo_genero";
                                                        ps = cn.prepareStatement(sql);
                                                        rs = ps.executeQuery();
                                                        while (rs.next()) {
                                                            out.println("<option value='" + rs.getInt("codigo_genero") + "'>" + rs.getString("nombre_genero") + "</option>");
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
                                            <label for="tf_acu">Telefono fijo</label>
                                        </td>
                                        <td>
                                            <input type="text" name="tf_acu" id="tf_acu" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="tm_acu">Telefono móvil</label>
                                        </td>
                                        <td>
                                            <input type="text" name="tm_acu" id="tm_acu" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label><strong>DATOS PERSONALES DEL ALUMNO</strong></label>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="id_alum_acu">ID del alumno</label>
                                        </td>
                                        <td>
                                            <input type="text" name="id_alum_acu" id="id_alum_acu" />
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label for="parentesco">Parentesco</label>
                                        </td>
                                        <td>
                                            <input type="text" name="parentesco" id="parentesco" />
                                        </td>
                                    </tr>

                                </table>
                                <input class="btn btn-dark" type="submit" name="btnRegistrarAcudiente" value="Registrar"/>
                            </form>
                        </div>
                    </div>
                </div>

                <!--segundo collapse de acudientes modificar-->
                <div class="wrapper">
                    <div class="collapsible">
                        <input type="checkbox" id="collapsible-head11" />
                        <label class="coll" for="collapsible-head11">Modificar o eliminar un acudiente</label>
                        <div class="collapsible-text11">
                            <h3>
                                Modificar las datos de un acudiente registrado en el sistema
                            </h3>
                            <p>
                                Primero debes buscarlo en la base de datos para poder validar si
                                esta registrado y posteriormente operar sobre éste.
                            </p>

                            <form action="ProfesorServlet?accion=buscarAcudiente" method="POST" autocomplete="off">
                                <label for="buscar_acudiente">ID del alumno</label>
                                <input type="text" name="buscar_acudiente" id="buscar_acudiente" />
                                <input class="btn btn-dark" type="submit" name="btnbusacarAcu" value="Buscar"/>
                            </form>

                        </div>
                    </div>
                </div>

            </div>

            <div class="col-3 col-s-11">
                <div class="aside">
                    <h2>Información del Sistema</h2>
                    <table>
                        
                        <tr>
                            <td>
                                <label>Nombre del Software</label>
                            </td>
                            <td>
                                <label>School Master Beta</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Versión</label>
                            </td>
                            <td>
                                <label>1.3.0 beta</label>
                            </td>
                        </tr>
                    </table>
                    <h2>Ayudas</h2>
                    <p>¿Qué puede hacer el administrador?</p>
                    <table>
                        <tr>
                            <td>
                                <label>1. Gestionar la informacion correspondiente a un
                                    profesor en la base de datos de School Master</label>
                            </td>
                        </tr>
                        <tr><td><label> </label></td></tr>
                        <tr>
                            <td>
                                <label>2. Gestionar la información de un nivel de la institucion
                                    en la base de datos, pero le debe asignar un profesor
                                    encargado a este nivel.</label>
                            </td>
                        </tr>
                        <tr><td><label> </label></td></tr>
                        <tr>
                            <td>
                                <label>3. gestionar la informcación en la base de datos 
                                    correspondiente a un alumno que previamente esta estudaindo en la
                                    institución o uno que ingresa nuevo.</label>
                            </td>
                        </tr>
                        <tr><td><label> </label></td></tr>
                        <tr>
                            <td>
                                <label>4. Gestionar la información de un acudiente que tiene uno
                                    o varios alumnos registrados en el sistema</label>
                            </td>
                        </tr>
                    </table>
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
        <script src="popupA.js"></script>
    </body>
</html>

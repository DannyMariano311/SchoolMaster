<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 17/01/2022, 12:46:10 AM
    Author     : Danny
--%>

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
                <a class="navbar-brand" href="#" id="sm">
                    <image
                        src="https://cdn.glitch.me/440365e1-8468-4e6b-95c6-e1ff92360eb1%2Frsz_1rsz_1rsz_1rsz_deberes.png?v=1635425610407"
                        alt="icono"
                        />
                    SchoolMaster
                </a>
                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">A cerca de</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disable" href="#"></a>
                    </li>
                    <button type="button" class="btn" id="btnAbrirPopup">
                        Iniciar sesión
                    </button>
                </ul>
            </nav>
            <%
                String validacion = (String) request.getAttribute("validacion");
                if (validacion != null) {
                    out.print("<div class='d-flex justify-content-center align-items-center flex-column' style='background: red'>");
                    out.print("<h5>"+validacion+"</h5>");
                    out.print("</div>");
                }else{
                    
                }
            %>
            <div class="cover d-flex justify-content-center align-items-center flex-column">
                <h1>SchoolMaster</h1>
                <p>Colombianitos del Futuro</p>
                <button class="btn btn-primary">Conoce más</button>
            </div>
        </header>

        <section>
            <div class="container mt-5 mb-5">
                <div class="row justify-content-center">
                    <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-2">
                        <div class="card">
                            <div
                                title="documentos archivados"
                                class="cover cover-small"
                                style="
                                background-image: url(https://cdn.glitch.me/440365e1-8468-4e6b-95c6-e1ff92360eb1%2Frsz_maarten-van-den-heuvel-8eznkvlqosk-unsplash.jpg?v=1635384476179);
                                "
                                ></div>
                            <div class="card-body">
                                <h5 class="card-title">Matrícula</h5>
                                <p class="card-text">
                                    Consultar el estado de los pagos de la mátricula del
                                    estudiante.
                                </p>
                                <a href="#" class="btn btn-primary" id="btnAbrirPopup2">Iniciar sesión</a>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-2">
                        <div class="card">
                            <div
                                title="niño estudiando"
                                class="cover cover-small"
                                style="
                                background-image: url(https://cdn.glitch.me/440365e1-8468-4e6b-95c6-e1ff92360eb1%2Fl-odyssee-belle-IMtEliM53Lc-unsplash.jpg?v=1635384302875);
                                "
                                ></div>
                            <div class="card-body">
                                <h5 class="card-title">Estudiantes</h5>
                                <p class="card-text">
                                    Consultar las calificaciones y desempeño de un estudiante
                                    matriculado en la institución.
                                </p>
                                <!--<a href="#" class="btn btn-primary">Iniciar sesión</a>-->
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-2">
                        <div class="card">
                            <div
                                title="madre e hijo"
                                class="cover cover-small"
                                style="
                                background-image: url(https://cdn.glitch.me/440365e1-8468-4e6b-95c6-e1ff92360eb1%2Frsz_1ke-atlas-4uyv2fez5pu-unsplash.jpg?v=1635422863499);
                                "
                                ></div>
                            <div class="card-body">
                                <h5 class="card-title">Acudientes</h5>
                                <p class="card-text">
                                    Solicitar una una cita para actualización de los datos
                                    personales del acudiente.
                                </p>
                                <!--<a href="#" class="btn btn-primary">Iniciar sesión</a>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section>
            <div class="container mt-5 mb-5 col-18 col-sm-9 col-lg-8">
                <div class="row justify-content-center">
                    <div class="col-12 col-sm-6 col-lg-5">
                        <img
                            src="https://cdn.glitch.me/440365e1-8468-4e6b-95c6-e1ff92360eb1%2Fundraw_searching_p-5-ux.svg?v=1635462484119"
                            alt="una persona ilustrada con dudas"
                            />
                    </div>

                    <div class="col-12 col-sm-6">
                        <h3>¿Tienes alguna inquietud?</h3>
                        <p>
                            Para mas información envíanos tu correo electrónico.<br />
                            Nos comunicaremos lo mas pronto posible
                        </p>
                    </div>
                </div>
                <form action="">
                    <label for="email">Correo electrónico</label>
                    <div class="d-flex">
                        <div class="flex-fill mr-2">
                            <input type="email" id="email_ayuda" class="form-control" />
                        </div>
                        <bottom type="submit" class="btn btn-primary"> Enviar </bottom>
                    </div>
                </form>
            </div>
        </section>

        <div class="overlay" id="overlay">
            <div class="popup" id="popup">
                <a href="" id="btn-cerrar-popup" class="btn-cerrar-popup">
                    <i class="fas fa-times"></i>
                </a>

                <form action="ProfesorServlet?accion=login" method="POST" autocomplete="off" id="formulario">
                    <h3 id="t">Iniciar sesión</h3>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Correo electrónico</label>
                        <input
                            type="email"
                            class="form-control"
                            id="Email"
                            name="Email"
                            />
                        <div id="emailHelp" class="form-text">
                            Nunca compartiremos su correo electrónico con nadie más.
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                        <input 
                            type="password" 
                            class="form-control" 
                            id="Password1" 
                            name="Password1"
                            />
                    </div>


                    <input class="btn btn-primary" type="submit" name="btnIniciar" id="btnIniciar" value="Iniciar sesión"/>
                </form>
            </div>
        </div>

        <section>
            <div class="container mt-5 mb-5 col-18 col-sm-9 col-lg-8">
                <div class="row justify-content-center">
                    <div class="col-12 col-sm-6 col-lg-5">

                    </div>
                </div>
            </div>
        </section>

        <div class="footer">
            <p>
                <strong>MEDIOS DE CONTACTO</strong><br />
                <strong>Celular: </strong><em>+57-000-000-0000</em><br />
                <strong>Telefono: </strong><em>000-000-00</em><br />
                <strong>Correo: </strong><em>correo-ejemplo@extencion.dominio</em>
            </p>
        </div>
        <script src="popup.js"></script>
    </body>
</html>

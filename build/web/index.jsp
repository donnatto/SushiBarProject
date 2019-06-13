<%--
    Document   : index
    Created on : 08-may-2019, 19:01:00
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/meta.jspf" %>
        <%@include file="WEB-INF/jspf/styles.jspf" %>
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/png" href="resources/img/favico.png" />
        <title>Hamachi Sushi Bar</title>
    </head>

    <body data-spy="scroll" data-target=".navbar" >
        <%@include file="WEB-INF/jspf/nav.jspf" %>
        <%@include file="WEB-INF/jspf/section.jspf" %>

        <!--Modal Login-->
        <div class="modal fade" id="modalLogin" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Ingreso al Sistema</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body pl-4">
                        <form action="system.jsp" method="POST">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="usuario">Usuario</label>
                                    <input type="text" class="form-control" name="usuario" id="usuario" placeholder="Correo electrónico" required>
                                </div>
                                <div class="form-group">
                                    <label for="contraseña">Contraseña</label>
                                    <input type="text" class="form-control" name="contraseña" id="contraseña" placeholder="Ingresa tu contraseña" required>
                                    <small class="form-text text-muted">Si no tiene su contraseña, genere una <a class="text-success" data-toggle="modal" data-target="#modalUsuarioNuevo" href="#modalUsuarioNuevo">aqui</a></small>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Atrás</button>
                                <input type="submit" class="btn btn-success" value="Ingresar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--Modal Nuevo Usuario-->
        <div class="modal fade" id="modalUsuarioNuevo" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Creación de Usuario</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" id="nombre" placeholder="Nombre" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="apellido">Apellidos</label>
                                    <input type="text" class="form-control" id="apellidos" placeholder="Apellidos" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="correo">Correo Electrónico</label>
                                <input type="email" class="form-control" id="correo" placeholder="Dirección de correo electrónico" required>
                            </div>
                            <div class="form-group">
                                <label for="cargo">Area</label>
                                <select class="form-control" id="cargo" name="cargo" >
                                    <option value="Administracion">Administración</option>
                                    <option value="Finanzas">Finanzas</option>
                                    <option value="Contabilidad">Contabilidad</option>
                                    <option value="Recursos Humanos">Recursos Humanos</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="contraseña">Contraseña</label>
                                <input type="password" class="form-control" name="contraseña" id="contraseña" placeholder="Contraseña" required>
                            </div>  
                            <div class="form-group">
                                <label for="codigoTrabajador">Codigo de Trabajador</label>
                                <input type="text" class="form-control" id="codigoTrabajador" name="codigoTrabajador" placeholder="Ingrese su código de trabajador" required>
                            </div>  
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <input type="submit" class="btn btn-success" value="Aceptar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Nosotros -->
        <div class="featured-nosotros" id="nosotros">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 order-lg-2 mb-3 mb-lg-0">
                        <img src="resources/img/bg_2.jpg" alt="Image placeholder" class="img-fluid">
                    </div>
                    <div class="col-lg-4 pr-lg-5">
                        <span class="featured-text mb-3 d-block">Nosotros</span>
                        <h2>Somos tu mejor opcion cuando se trata de comida nikkei</h2>
                        <p class="mb-3">Hamachi Sushi Bar es una nueva propuesta dirigida a todos los amantes de la comida
                            que buscan nuevas y mejores experiencias. Somos un restaurant que mezcla lo mejor de la comida peruana
                            y la comida japonesa, y a través de ello, brindamos a nuestros clientes una experiencia inolvidable.
                            Acompáñanos a conocer más de esta nueva propuesta culinaria interesante.</p>
                        <button type="button" class="btn btn-success py-3 px-5" data-toggle="modal" data-target="#modalReservas">
                            Haz tu reserva aquí
                        </button>

                        <!--Modal Reservas-->
                        <div class="modal fade" id="modalReservas" tabindex="-1" role="dialog">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Realiza tu reserva</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="" method="POST">
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label for="nombre">Nombre</label>
                                                    <input type="text" class="form-control" id="nombre" placeholder="Nombre" required>
                                                </div>
                                                <div class="form-group col-md-6">
                                                    <label for="apellido">Apellidos</label>
                                                    <input type="text" class="form-control" id="apellidos" placeholder="Apellidos" required>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label for="fecha">Fecha</label>
                                                    <input type="date" class="form-control" id="fecha" required>
                                                </div>
                                                <div class="form-group col-md-6">
                                                    <label for="hora">Hora</label>
                                                    <select class="form-control" id="hora">
                                                        <option value="2">2 pm</option>
                                                        <option value="3">3 pm</option>
                                                        <option value="4">4 pm</option>
                                                        <option value="5">5 pm</option>
                                                        <option value="6">6 pm</option>
                                                        <option value="7">7 pm</option>
                                                        <option value="8">8 pm</option>
                                                        <option value="9">9 pm</option>
                                                        <option value="10">10 pm</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label for="cantidad">Cantidad de comensales</label>
                                                    <input type="text" class="form-control" id="cantidad" placeholder="Nro. de comensales" required>
                                                </div>
                                                <div class="form-group col-md-6">
                                                    <label for="nroContacto">Nro de Contacto</label>
                                                    <input type="text" class="form-control" id="nroContacto" placeholder="Telf/Celular" required>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="correo">Correo Electrónico</label>
                                                <input type="email" class="form-control" id="correo" placeholder="Dirección de correo electrónico" required>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                                <input type="submit" class="btn btn-success" value="Aceptar">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <!---Seccion Carta-->
        <div class="site-section" id="carta">
            <div class="container">
                <div class="row mb-4">
                    <div class="col-md-12">
                        <h2>Carta</h2>
                        <p class="mt-2">Estos son algunos de los platos que puede encontrar en nuestra <a class="text-success" target="_blank" href="https://edosushibar.com/app/uploads/2019/03/CARTA-WEB-EDO-SUSHI-BAR.pdf">carta.</a>  </p>
                    </div>
                </div>
                <!--Galería -->
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <a href="resources/img/g_1.jpg" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_1.jpg" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="resources/img/g_2.jpg" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_2.jpg" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="resources/img/g_3.jpg" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_3.jpg" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="resources/img/g_4.jpg" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_4.jpg" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>

                    <div class="col-md-4">
                        <a href="resources/img/g_5.jpg" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_5.jpg" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="resources/img/g_6.jpg" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_6.jpg" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>

                    <div class="col-md-4">
                        <a href="resources/img/g_7.jpg" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_7.jpg" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="resources/img/g_8.png" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_8.png" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="resources/img/g_9.jpg" class=" img-hover">
                            <span class="icon icon-search"></span>
                            <img src="resources/img/g_9.jpg" alt="Image placeholder" class="img-fluid">
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!--Blog-->

        <div class="site-section" id="blog">
            <div class="container">
                <div class="row mb-4">
                    <div class="col-md-12">
                        <h2>Blog</h2>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_1.jpg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>¿Cómo preparar la mesa para comer sushi?</h3>
                                <p class="card-text">Preparar una noche de sushi puede ser una ocasión estresante,
                                    especialmente si es un festejo especial. Por eso, hoy te presentaremos algunos
                                    consejos sobre cómo preparar la mesa para comer sushi. </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_2.jpg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>Vivir 100 años es posible si sigues la dieta</h3>
                                <p class="card-text">Llegar al centenario en la vida es el sueño de muchos y la respuesta
                                    a esta incógnita podría estar en Asia. Japón, en la actualidad, es el país del mundo con un
                                    a mayor esperanza de vida: 88,5 años y con más personas centenarias</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_3.jpg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>15 platos imprescindibles de la cocina japonesa</h3>
                                <p class="card-text">Sobre la comida japonesa sigue existiendo la idea de que todo es o sushi
                                    o tempura, y nada más lejos de la realidad. Japón es un país foodie, como se suele decir ahora,
                                    pero también históricamente un paraíso gourmet con una de las mejores cocinas del mundo.</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_4.jpg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>Curiosidades de la cocina gastronómica nikkei</h3>
                                <p class="card-text">La gastronomía japonesa cada día gana más adeptos, y más y más personas
                                    cada año se hacen fanáticas de esta saludable y sabrosa cocina. Así que para todas las amantes
                                    de la gastronomía de este país traemos algunas curiosidades de la cocina japonesa que las sorprenderán.</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_5.jpg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>Ocho trucos japoneses para adelgazar</h3>
                                <p class="card-text">Asia es un continente con bajo indice de obesidad, esto se debe a sus costumbres
                                    tanto alimenticias como de ejercicio y bienestar físico y mental. En concreto los japoneses son admirados
                                    por su dieta basada en arroz, pescado, vegetales y otros secretos que desvelamos</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_6.jpg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>Cómo comer sushi correctamente</h3>
                                <p class="card-text">Has conseguido dominar los palillos como si fueras del mismísimo centro de
                                    Osaka; ya sabes qué es un nigiri y un uramaki; has leído nuestra guía sobre los platos imprescindibles
                                    de la cocina nipona; e incluso ya no te la cuelan los restaurantes chinos que van de japoneses</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <!-- Staff-->
        <div class="site-section staff" id="staff">
            <div class="container">
                <div class="row mb-4">
                    <div class="col-md-12 text-center">
                        <h2>Nuestro Staff</h2>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 col-lg-3 mb-3">
                        <div class="person text-center bg-light pt-4">
                            <img src="resources/img/person_1.jpg" alt="Image placeholder" class="img-fluid rounded-circle">
                            <div class="person-info">
                                <span>Juan Lopez<br></span>
                                <span>Administrador</span>

                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-3 mb-3">
                        <div class="person text-center bg-light pt-4">
                            <img src="resources/img/person_2.jpg" alt="Image placeholder" class="img-fluid rounded-circle">
                            <div class="person-info">
                                <span>Cristina Gutierrez<br></span>
                                <span>Jefa de Cocina</span>

                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-3 mb-3">
                        <div class="person text-center bg-light pt-4">
                            <img src="resources/img/person_3.jpg" alt="Image placeholder" class="img-fluid rounded-circle">
                            <div class="person-info">
                                <span>Miguel Salazar<br></span>
                                <span>Jefe de Servicio</span>

                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-3 mb-3">
                        <div class="person text-center bg-light pt-4">
                            <img src="resources/img/person_4.jpg" alt="Image placeholder" class="img-fluid rounded-circle">
                            <div class="person-info">
                                <span>Esteban Fernandez<br></span>
                                <span>Jefe de Barra</span>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!---Carousel Instalaciones-->
        <div class="site-section" id="instalaciones">
            <div class="container">
                <div class="row mb-3">
                    <div class="col-md-12">
                        <h2>Nuestras Instalaciones</h2>
                        <p class="mt-2">En Hamachi Sushi Bar contamos con las mejores instalaciones para tu
                            visita, la que estamos seguros que será placentera debido a nuestra gran variedad de sabores
                            para poder satisfacer la diversidad de gustos de nuestros comensales.</p>
                    </div>
                </div>

                <div id="inst-car" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#inst-car" data-slide-to="0" class="active"></li>
                        <li data-target="#inst-car" data-slide-to="1"></li>
                        <li data-target="#inst-car" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="resources/img/inst_1.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="resources/img/inst_2.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="resources/img/inst_3.jpg" alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#inst-car" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#inst-car" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>

            </div>
        </div>


        <!-- Trabaja con Nosotros -->
        <div class="featured-trabaja" id="trabaja">

            <div class="container">
                <div class="row">

                    <div class="col-md-6">
                        <img src="resources/img/bg_3.jpg" alt="Image placeholder" class="img-fluid">
                    </div>

                    <div class="col-md-6 pl-md-5">
                        <span class="featured-text d-block mb-3">Trabaja con Nosotros</span>
                        <h2>Se parte de nuestra creciente familia</h2>
                        <p class="mb-3">Promovemos el trabajo con programas que recluten gente que
                            sienta la pasión por la cocina y las ganas de aprender los secretos de la
                            cocina nikkei</p>
                        <span class="fund-raised d-block mb-5">Tu puedes ser parte de nosotros</span>

                        <p><button type="button" class="btn btn-success py-3 px-5" data-toggle="modal" data-target="#modalTrabaja">Aplica aquí</button></p>
                        <!--Modal Trabaja con Nosotros-->
                        <div class="modal fade" id="modalTrabaja" tabindex="-1" role="dialog">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Unete a nuestro equipo</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <p>¿Te gustaría trabajar con nosotros? Adjunta tu CV y cuéntanos un poco de ti.</p>
                                        <form action="" method="POST">
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="nombreAplicante" placeholder="Nombres">
                                            </div>
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="correoAplicante" placeholder="Correo Electrónico">
                                            </div>
                                            <div class="form-group">
                                                <input type="text" class="form-control" id="telefonoAplicante" placeholder="Nro de Contacto">
                                            </div>
                                            <div class="form-group">
                                                <div class="custom-file">
                                                    <input type="file" class="file-input" id="cvAplicante">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <textarea name="" id="mensajeAplicante" rows="4" class="form-control"
                                                          placeholder="Cuéntanos un poco sobre ti"></textarea>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                        <button type="button" class="btn btn-success">Enviar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!--Contacto-->
        <div class="site-section" id="contacto">
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md-12">
                        <h2>Contáctanos</h2>
                    </div>
                </div>

                <div class="row contacto">
                    <div class="col-md-6 pr-md-5">
                        <form action="#" id="form-contacto">
                            <div class="form-group">
                                <input type="text" class="form-control px-3 py-3" placeholder="Nombre" required>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control px-3 py-3" placeholder="Correo Electrónico" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control px-3 py-3" placeholder="Asunto" required>
                            </div>
                            <div class="form-group">
                                <textarea name=""  cols="30" rows="7" class="form-control px-3 py-3"
                                          placeholder="Mensaje" required></textarea>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Enviar Mensaje" class="btn btn-success py-3 px-5">
                            </div>
                        </form>

                    </div>

                    <div class="col-md-6">
                        <img src="resources/img/postmail.png" alt="PostMail" class="img-fluid d-none d-md-flex">
                    </div>
                </div>
            </div>
        </div>




        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
        <script src="resources/js/main.js" type="text/javascript"></script>
    </body>

</html>

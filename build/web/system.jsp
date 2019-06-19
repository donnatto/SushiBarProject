<%--
    Document   : index
    Created on : 08-may-2019, 19:01:00
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String nombre = (String)request.getSession().getAttribute("nombre"); %>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/meta.jspf" %>
        <%@include file="WEB-INF/jspf/styles.jspf" %>
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/png" href="resources/img/favico.png" />
        <title>Hamachi Sushi Bar - Sistema</title>
    </head>
    
    <body data-spy="scroll" data-target=".navbar" >
        <%@include file="WEB-INF/jspf/nav_system.jspf" %>
        <%@include file="WEB-INF/jspf/section_system.jspf" %>
        
        <div class="container">
                <div class="row mt-5">
                    <div class="col-md-12">
                        <h2>Como estás <%=nombre%>?</h2>
                        <p class="mt-2">Estas son las herramientas para la gestión del restaurant.</p>
                        
                    </div>
                </div>
            
            <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_reserva.jpeg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>Gestión de Reservas</h3>
                                <p class="card-text">Gestiona las reservas existentes por parte de nuestros clientes. </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_postulantes.jpg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>Gestion de Postulantes</h3>
                                <p class="card-text">Evalúa los CVs enviados por las personas que desean trabajar con nosotros.</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-3 card-2">
                            <a href="#"><img class="card-img-top" src="resources/img/img_mensajes.jpg" alt="Image placeholder"></a>
                            <div class="card-body">
                                <h3 class="card-title"><a href="#"></a>Mensajes</h3>
                                <p class="card-text">Consulta toda la mensajería existente y da una respuesta en caso sea necesario.</p>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/footer_logged.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
        <script src="resources/js/main.js" type="text/javascript"></script>
    </body>

</html>
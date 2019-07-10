<%--
    Document   : index
    Created on : 08-may-2019, 19:01:00
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String nombre = (String) request.getSession().getAttribute("nombre"); %>
<% String area = (String) request.getSession().getAttribute("area");%>
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
    <%@include file="WEB-INF/jspf/section_postulantes.jspf" %>

    <div class="container">
      <div class="row mt-5">
        <div class="col-md-6">
          <h2>Genial día cierto <%=nombre%>?</h2>

          <p class="mt-2">Evalúa el talento humano de nuestros postulantes</p>

        </div>
        <div class="d-flex col-md-6 justify-content-end">

          <h3>Área: <%=area%></h3>


        </div>

      </div>

      <table class="table table-striped text-center" id="tablaMensajes">
        <thead class="thead-dark">
          <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Asunto</th>
            <th>Mensaje</th>
            <th>Acciones</th>

          </tr>
        </thead>
        <tbody>
          <c:forEach var="Contacto" items="${sessionScope.lista}">
            <tr id="row${Contacto.id}">
              <td>${Contacto.id}</td>
              <td>${Contacto.nombre}</td>
              <td>${Contacto.correo}</td>
              <td>${Contacto.asunto}</td>
              <td class="text-left">${Contacto.mensaje}</td>

              <td class="row">
                <a class="col-6" href="mailto:${Contacto.correo}"><i class="fa fa-envelope-open-text text-info" aria-hidden="true"></i></a>
                <a class="col-6" href="javascript:void(0);" onclick="eliminarMensaje(${Contacto.id});"><i class="far fa-trash-alt text-danger" aria-hidden="true"></i></a>

              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>

    </div>
    <%@include file="WEB-INF/jspf/footer_logged.jspf" %>
    <%@include file="WEB-INF/jspf/scripts.jspf" %>
    <script src="resources/js/main.js" type="text/javascript"></script>
  </body>

</html>
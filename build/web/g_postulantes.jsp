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
            <th>Nro. Contacto</th>
            <th>Descripción</th>
            <th>CV</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="Postulante" items="${sessionScope.lista}">
            <tr id="row${Postulante.id}">
              <td>${Postulante.id}</td>
              <td>${Postulante.nombre}</td>
              <td>${Postulante.correo}</td>
              <td>${Postulante.telefono}</td>
              <td class="text-left">${Postulante.descripcion}</td>

              <td class="row">
                <a class="col-6" href="file:///${Postulante.curriculm}"><i class="fab fa-readme text-info" aria-hidden="true"></i></a>
                <a class="col-6" href="mailto:${Postulante.correo}"><i class="fa fa-envelope-open-text text-success" aria-hidden="true"></i></a>
                

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
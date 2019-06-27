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
    <%@include file="WEB-INF/jspf/section_reservas.jspf" %>

    <div class="container">
      <div class="row mt-5">
        <div class="col-md-6">
          <h2>Genial día cierto <%=nombre%>?</h2>

          <p class="mt-2">Gestiona aquí las reservas ingresadas por nuestros clientes.</p>

        </div>
        <div class="d-flex col-md-6 justify-content-end">

          <h3>Área: <%=area%></h3>


        </div>

      </div>

      <table class="table table-striped text-center">
        <thead class="thead-dark">
          <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Comensales</th>
            <th>Nro Contacto</th>
            <th>Correo</th>
            <th>Estado</th>
            <th>Acción</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="Reserva" items="${sessionScope.lista}">
          <tr>
            <td>${Reserva.id}</td>
            <td>${Reserva.nombre}</td>
            <td>${Reserva.apellido}</td>
            <td>${Reserva.fecha}</td>
            <td>${Reserva.hora}</td>
            <td>${Reserva.comensales}</td>
            <td>${Reserva.telefono}</td>
            <td>${Reserva.correo}</td>
          <c:if test="${Reserva.estado == 1 }">
            <td class="table-success estado${Reserva.id}">Confirmado</td>
          </c:if>
          <c:if test="${Reserva.estado == 0 }">
            <td class="table-warning estado${Reserva.id}">Sin Confirmar</td>
          </c:if>
          <c:if test="${Reserva.estado == -1 }">
            <td class="table-danger estado${Reserva.id}">Rechazado</td>
          </c:if>
          <td class="row">
            <a class="col-6" href="javascript:void(0);" onclick="cambiarEstado(${Reserva.id}, 1);"><i class="far fa-check-circle text-success" aria-hidden="true"></i></a>
            <a class="col-6" href="javascript:void(0);" onclick="cambiarEstado(${Reserva.id}, -1);"><i class="far fa-times-circle text-danger" aria-hidden="true"></i></a>
            
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
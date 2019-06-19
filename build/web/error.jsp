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
        <title>Hamachi Sushi Bar - Sistema</title>
    </head>
    
    <body data-spy="scroll" data-target=".navbar" >
        <%@include file="WEB-INF/jspf/nav_error.jspf" %>
        <%@include file="WEB-INF/jspf/section_error.jspf" %>
        
        
        <%@include file="WEB-INF/jspf/footer_logged.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
        <script src="resources/js/main.js" type="text/javascript"></script>
    </body>

</html>
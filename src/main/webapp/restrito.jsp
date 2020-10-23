<%-- 
    Document   : restrito.jsp
    Created on : 24/09/2020, 22:58:45
    Author     : Sabrina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Acesso Restrito</h1>
    <br>
    <form action="servletM1" method="POST" target="_blank">
        <input type="hidden" name="m1" value="2" />
        <label for="encerrar">Encerrar sessão?</label><br><input name="encerrar" type="checkbox" id="encerrar"><br><br>
        <input type="submit" value="Enviar">

    </form>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenidos a Bennder</h1>
        <p>Plataforma de beneficios corporativos</p>
        
        <form:form method="POST" action="login.html" commandName="loginForm">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><form:input path="user" autocomplete="off"/> </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:password path="password"/>   </td>
                </tr>
               <tr>
                   <td><input type="submit" value ="Ingresar"/>   
            </table>
        </form:form>
        
    </body>
</html>

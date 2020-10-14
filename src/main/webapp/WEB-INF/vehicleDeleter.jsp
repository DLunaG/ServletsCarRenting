<%-- 
    Document   : vehicleDeleter
    Created on : 8 oct. 2020, 10:03:25
    Author     : tecnara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vehicle deleter</title>
    </head>
    
    
    <body>
        <%@ include file="/WEB-INF/layout/menu.jsp" %>
        <% HttpSession mySession = request.getSession(false);
        String deleteMsg = String.valueOf(mySession.getAttribute("deleteMsg"));
        %>
        <%= deleteMsg %>
        <h1> </h1>
        <a href="http://localhost:8080/CarRenting/vehicles">Back to the car list</a>
        <h1> </h1>
        <a href="http://localhost:8080/CarRenting/">Back to main menu</a>
    </body>
</html>

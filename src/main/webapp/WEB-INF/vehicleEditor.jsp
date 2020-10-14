<%-- 
    Document   : vehicleEditor
    Created on : 9 oct. 2020, 11:23:57
    Author     : tecnara
--%>

<%@page import="java.util.List"%>
<%@page import="com.fullstack888.carrenting.domain.Vehicle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="/WEB-INF/layout/menu.jsp" %>
        <% HttpSession mySession = request.getSession(false);
        Vehicle vehicle = (Vehicle)mySession.getAttribute("vehicle");
        %>
        <h4>Editing vehicle with id <%= vehicle.getId() %></h4>
        <form action="/CarRenting/vehicleEditor" method="post">
            
            <p>Marca: <input type="text" name="brand" pattern="[a-zA-Zö0-9-_\.]{3,20}$" value="<%= vehicle.getBrand() %>" ></p>
            <p>Modelo: <input type="text" name="model" pattern="[a-zA-Z0-9-_\.]{1,40}$" value="<%= vehicle.getModel() %>" ></p>
            <p>Matrícula: <input type="text" name="registration" pattern="[A-Za-z0-9]{6,12}$" value="<%= vehicle.getRegistration() %>"></p>
            <p>Plazas: <input type="number" name="seats" pattern="[0-9]{1,2}$" value="<%= vehicle.getSeats() %>" ></p>
            <p> <input type="submit" value="Submit"> </p>
            <input type="hidden" name="id" value="<%= vehicle.getId() %>">
        </form>
    </body>
</html>

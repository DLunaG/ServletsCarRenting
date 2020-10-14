<%-- 
    Document   : vehicles
    Created on : 7 oct. 2020, 10:30:32
    Author     : tecnara
--%>

<%@page import="java.util.List"%>
<%@page import="com.fullstack888.carrenting.domain.Vehicle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RentingCar List</title>
    </head>
    <body>
        <%@include file="/WEB-INF/layout/menu.jsp" %>
        <form>
           
            <% HttpSession mySession = request.getSession(false);
            List<Vehicle> vehicles = (List<Vehicle>)mySession.getAttribute("vehicles");
            %>
           
            <table border="3">
                <caption>VEHICLES LIST <img src="images/cocheIcono.png" style="width:50px;height:30px;"></caption>
                <tbody>
                    <tr>
                        <th> Id </th>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>Registration</th>
                        <th>Seats</th>
                        <th></th>
                        <th></th>
                    </tr>
            <%
            for(Vehicle v: vehicles){
            %>
                    <tr>
                        <td><%= v.getId() %></td>
                        <td><%= v.getBrand() %></td>
                        <td><%= v.getModel() %></td>
                        <td><%= v.getRegistration() %></td>
                        <td><%= v.getSeats() %></td>
                        <td><a href="http://localhost:8080/CarRenting/vehicleEditor?id=<%=v.getId()%>" title="Edit"><img src="images/edit.png" style="width:50px;height:50px;"></a></td>
                        <td><a href="http://localhost:8080/CarRenting/vehicleRemover?id=<%=v.getId()%>" title="Remove"><img src="images/papelera.png" style="width:50px;height:50px;"></a></td>
                        
                    </tr>               
            <%};%>
            </table>
        </form>
    </body>
</html>

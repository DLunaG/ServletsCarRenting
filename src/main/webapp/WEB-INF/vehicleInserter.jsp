<%-- 
    Document   : vehicleInserter
    Created on : 8 oct. 2020, 13:13:39
    Author     : tecnara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vehicle inserter</title>
    </head>
    
    
    <body>
        <h1><u>Fill the inserter vehicle form, please.</u></h1>
        <form action="/CarRenting/vehicleInserter" method="post">
            
            <p>Marca: <input type="text" name="brand" pattern="[a-zA-Zö0-9-_\.]{3,20}$" ></p>
            <p>Modelo: <input type="text" name="model" pattern="[a-zA-Z0-9-_\.]{1,40}$" ></p>
            <p>Matrícula: <input type="text" name="registration" pattern="[A-Za-z0-9]{6,12}$"></p>
            <p>Plazas: <input type="number" name="seats" pattern="[0-9]{1,2}$" ></p>
            <p> <input type="submit" value="Submit"> </p>
        </form>
    </body>
</html>

<%-- 
    Document   : userLogin
    Created on : 14 oct. 2020, 11:27:11
    Author     : tecnara
--%>

<%@page import="com.fullstack888.carrenting.domain.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form  action="/CarRenting/login" method="post">                
        <p>UserName: <input type="text" name="name" ></p>
        <p>Password: <input type="text" name="password"></p>        
        
        <p> <input type="submit" value="Submit"> </p>
        </form>
        
        <% HttpSession mySession = request.getSession(false);
        Login login = (Login)mySession.getAttribute("login");
        if(login != null){
        if(login.isConnected()){ %>
            <h5>Welcome <%= login.getUser().getName() %></h5>
            <% }else{ %>
            <h5>Username or password incorrect</h5>
        <%}
        }%>
    </body>
</html>

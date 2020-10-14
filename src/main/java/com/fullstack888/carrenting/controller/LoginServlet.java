/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.carrenting.controller;

import com.fullstack888.carrenting.domain.Login;
import com.fullstack888.carrenting.domain.User;
import com.fullstack888.carrenting.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tecnara
 */
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/userLogin.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User(name, password);
        
        boolean connected = us.checkUser(user);
        Login login = new Login(user, connected);
        
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("login", login);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/userLogin.jsp");
        rd.forward(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

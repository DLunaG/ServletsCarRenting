/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.carrenting.controller;

import com.fullstack888.carrenting.domain.Vehicle;
import com.fullstack888.carrenting.services.CarRentingService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DanielLunaGonzález
 */
public class VehiclesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       CarRentingService crs = new CarRentingService();
       List<Vehicle> vehicles = crs.getAllVehicles();
        
       HttpSession mySession = request.getSession(true);
       mySession.setAttribute("vehicles", vehicles);
       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vehicles.jsp");
       rd.forward(request, response);
       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.carrenting.controller;

import com.fullstack888.carrenting.domain.Vehicle;
import com.fullstack888.carrenting.services.CarRentingService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class VehiclesServletEditer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CarRentingService crs = new CarRentingService();
        int id = Integer.parseInt(request.getParameter("id"));
        
        Vehicle vehicle = crs.getOneVehicle(id);
        
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("vehicle", vehicle);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vehicleEditor.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CarRentingService crs = new CarRentingService();
       
        int id = Integer.parseInt(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String registration = request.getParameter("registration");
        int seats = Integer.valueOf(request.getParameter("seats"));
        Vehicle newVehicle = new Vehicle(id, brand, model, registration, seats);
       
        crs.editAVehicle(newVehicle);
        
        List<Vehicle> vehicles = crs.getAllVehicles();
        
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("vehicles", vehicles);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vehicles.jsp");
        rd.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

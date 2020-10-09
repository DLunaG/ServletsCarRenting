package com.fullstack888.carrenting.controller;

import com.fullstack888.carrenting.services.CarRentingService;
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
 * @author DLG
 */
public class VehiclesServletRemover extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CarRentingService crs = new CarRentingService();
        int id = Integer.parseInt(request.getParameter("id"));
        int deletes = crs.deleteAVehicle(id);
        
        String msg = "";
        if(deletes > 0){
            msg = "The vehicle with id "+ id +" has been deleted from the system.";
        }else{
            msg = "The vehicle with id "+ id +" could not be deleted or it doesn't exist in the system";
        }
        
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("deleteMsg", msg);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vehicleDeleter.jsp");
        rd.forward(request, response);
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

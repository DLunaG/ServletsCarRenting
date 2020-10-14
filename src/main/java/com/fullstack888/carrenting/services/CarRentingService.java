package com.fullstack888.carrenting.services;

import com.fullstack888.carrenting.DAO.VehicleDAO;
import com.fullstack888.carrenting.domain.Vehicle;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author DanielLuna
 */
public class CarRentingService {
    
    VehicleDAO dao;
    
    public CarRentingService(){
        this.dao = new VehicleDAO();
    }
    
    public List<Vehicle> getAllVehicles(){
        return dao.selectAllVehicles();
    }  
    
    public Vehicle getOneVehicle(int id){
        return dao.selectAllVehicles()
                .stream()
                .filter(vehicle -> vehicle.getId() == id)
                .collect(Collectors.toList())
                .get(0);
    }
    
    public int deleteAVehicle(int id){
        int result = dao.deleteAVehicle(id);
        return result;
    }
    
    public int insertAVehicle(Vehicle vehicle){
        int result = dao.insertAVehicle(vehicle);
        return result;
    }
    
    public int editAVehicle(Vehicle vehicle){
        return dao.editAVehicle(vehicle);
    }
    
    
}

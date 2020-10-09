package com.fullstack888.carrenting;

import com.fullstack888.carrenting.domain.Vehicle;
import com.fullstack888.carrenting.services.CarRentingService;
import java.util.List;

/**
 *
 * @author tecnara
 */
public class ProbatinasProyecto {
    
    public static void main(String[] args) {
        
        CarRentingService crs = new CarRentingService();
        crs.getAllVehicles().forEach(vehicle -> System.out.println(vehicle.toString()));
        crs.editAVehicle(new Vehicle(20, "Citröen"," Xsarita", "1234BBB", 5));

    }
}

package com.fullstack888.carrenting;

import com.fullstack888.carrenting.domain.User;
import com.fullstack888.carrenting.domain.Vehicle;
import com.fullstack888.carrenting.services.CarRentingService;
import com.fullstack888.carrenting.services.UserService;
import java.util.List;

/**
 *
 * @author tecnara
 */
public class ProbatinasProyecto {
    
    public static void main(String[] args) {
   
        UserService us = new UserService();
        User pepa = new User("pepe", "pepe3");
        System.out.println(us.checkUser(pepa));
        
        us.getUsersList().forEach(user -> System.out.println(user.getName()));
        
        
    }
}

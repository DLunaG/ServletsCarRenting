/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.carrenting.services;

import com.fullstack888.carrenting.DAO.UserDAO;
import com.fullstack888.carrenting.domain.User;
import java.util.List;

/**
 *
 * @author DLG
 */
public class UserService {
    
    private UserDAO udao;
    
    public UserService(){
        
        udao = new UserDAO();
    }
    
    public List<User> getUsersList(){
        return udao.selectUsers();
    }  
     
    public boolean checkUser(User user){
        return getUsersList().stream().anyMatch(listuser -> listuser.getName().equals(user.getName()) && listuser.getPassword().equals(user.getPassword()));
    } 
    
}

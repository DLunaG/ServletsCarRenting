/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.carrenting.DAO;

import com.fullstack888.carrenting.domain.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tecnara
 */
public class UserDAO {
    
    Connection cn;
    
    public UserDAO(){
        try{
        Class.forName("org.postgresql.Driver");
        this.cn = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost/rentingcar", "postgres", "1234");
        }catch(ClassNotFoundException ce){
            System.out.println("Class not found.");
        }catch(SQLException sqle){
            System.out.println("SQL ERROR: " + sqle.getMessage());
        }
    }
    
    public List<User> selectUsers(){
        List<User> users = new ArrayList<User>();
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario ORDER BY id;");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                String password = rs.getString("password");
                
                users.add(new User(name, password));
            }
            st.close();           
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        
        return users;
    }
    
}

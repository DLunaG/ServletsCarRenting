package com.fullstack888.carrenting.DAO;

import com.fullstack888.carrenting.domain.Vehicle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DanielLuna
 */
public class DAO {
    
    Connection cn;
    
    public DAO(){
        try{
        Class.forName("org.postgresql.Driver");
        this.cn = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost/rentingcar", "postgres", "1234");
        }catch(ClassNotFoundException ce){
            System.out.println("Class not found.");
        }catch(SQLException sqle){
            System.out.println("SQL ERROR: " + sqle.getMessage());
        }
    }
    
    public List<Vehicle> selectAllVehicles(){
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM vehiculo ORDER BY id;");
            while(rs.next()){
                int id = rs.getInt("id");
                String brand = rs.getString("marca");
                String model = rs.getString("modelo");
                String registration = rs.getString("matricula");
                int seats = rs.getInt("plazas");
                
                vehicles.add(new Vehicle(id, brand, model, registration, seats));
            }
            st.close();           
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        
        return vehicles;
    }
    
    public int deleteAVehicle(int id){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("DELETE FROM vehiculo WHERE id = ").append(id).append(";");
        try{
            Statement st = cn.createStatement();
            result = st.executeUpdate(sb.toString());
            st.close();
        }catch(SQLException e){
            System.out.println("SQL ERROR: " + e.getMessage());
        }
        return result;
    } 
    
    public int insertAVehicle(Vehicle v){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("INSERT INTO vehiculo(marca, modelo, matricula, plazas) VALUES ('");
        sb.append(v.getBrand()).append("', '").append(v.getModel()).append("', '")
                .append(v.getRegistration()).append("', ").append(v.getSeats()).append(");");
        try{
        Statement st = cn.createStatement();
        result = st.executeUpdate(sb.toString());
        st.close();
        }catch(SQLException e){
            System.out.println("SQL ERROR: " + e.getMessage());
        }
        return result;
    }
    
    public int editAVehicle(Vehicle v){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("UPDATE vehiculo SET marca='").append(v.getBrand()).append("', modelo='").append(v.getModel())
                .append("', matricula='").append(v.getRegistration()).append("', plazas=").append(v.getSeats())
                .append(" WHERE id=").append(v.getId()).append(";");
        try{
            Statement st = cn.createStatement();
            result = st.executeUpdate(sb.toString());
            st.close();
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        return result;
    }
}

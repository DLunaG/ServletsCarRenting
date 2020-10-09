package com.fullstack888.carrenting.domain;

/**
 *
 * @author DanielLuna
 */
public class Vehicle {
    
    private int id;
    private String brand;
    private String model;
    private String registration;
    private int seats;
    
    public Vehicle(int id, String brand, String model, String registration, int seats){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.registration = registration;
        this.seats = seats;
    }
    
    public Vehicle(String brand, String model, String registration, int seats){
        this.brand = brand;
        this.model = model;
        this.registration = registration;
        this.seats = seats;
    }

   @Override
   public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("{\"id\":").append(this.id).append(", \"brand\":\"").append(this.brand)
               .append("\", \"model\":\"").append(this.model).append("\", \"registration\":\"")
               .append(this.registration).append("\", \"seats\":").append(this.seats).append("}");
       return sb.toString();
   }
   
   
    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
   
}

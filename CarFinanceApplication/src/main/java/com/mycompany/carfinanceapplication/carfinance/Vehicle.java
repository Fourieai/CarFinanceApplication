/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carfinanceapplication.carfinance;

/**
 *
 * @author Student
 */
public abstract class Vehicle implements VehicleInterface {

    private String registrationNumber;
    private String make;
    private String model;
    private double price;
    private CarType carType;

// Constructor
    
public Vehicle(String registrationNumber, String make, String model, double price, CarType carType) {

    this.registrationNumber = registrationNumber;
    this.make = make;
    this.model = model;
    this.price = price;
    this.carType = carType;
    
}

// Getters: to send back what is called from these properties for the vehicle selected
    
public String getRegistrationNumber() {
        
    return registrationNumber;
}

public String getMake() {
        
    return make;
}

public String getModel() {
        
    return model;
    
}

public double getPrice() {
        
    return price;
}

public CarType getCarType() {
       
    return carType;
}

// Setters
    
public void setRegistrationNumber(String registrationNumber) {
        
    this.registrationNumber = registrationNumber;
}

public void setMake(String make) {
       
    this.make = make;
}

public void setModel(String model) {
       
    this.model = model;
}

public void setPrice(double price) {
     
    this.price = price;
}

public void setCarType(CarType carType) {
       
    this.carType = carType;
}

// Abstract method

public abstract void displayVehicle();
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carfinanceapplication.carfinance;

/**
 *
 * @author Student
 */

public class Car extends Vehicle {

// Constructor
    
public Car(String registrationNumber, String make, String model, double price, CarType carType) {

super(registrationNumber, make, model, price, carType);
    
}

// Method overriding
    
@Override
    
public void displayVehicle() {
        
    System.out.println("Registration : " + getRegistrationNumber());
    System.out.println("Make: " + getMake());
    System.out.println("Model: " + getModel());
    System.out.println("Price: R" + String.format("%.2f", getPrice()));
    System.out.println("Type: " + getCarType());
    
    }
}
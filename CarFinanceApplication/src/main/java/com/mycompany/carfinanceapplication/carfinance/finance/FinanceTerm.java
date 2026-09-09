/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carfinanceapplication.carfinance.finance;

/**
 *
 * @author Student
 */
public enum FinanceTerm {

    SHORT_TERM(1, 10),
    MEDIUM_TERM(3, 8),
    LONG_TERM(5, 7);

private int years;
private double interestRate;

FinanceTerm(int years, double interestRate) {
        
    this.years = years;
    this.interestRate = interestRate;
    
}

public int getYears() {
        
    return years;
}

public double getInterestRate() {
        
    return interestRate;
    
    }
}
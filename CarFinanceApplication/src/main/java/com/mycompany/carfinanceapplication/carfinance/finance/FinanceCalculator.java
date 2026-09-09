/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carfinanceapplication.carfinance.finance;

/**
 *
 * @author Student
 */

import com.mycompany.carfinanceapplication.carfinance.Car;
import com.mycompany.carfinanceapplication.carfinance.exceptions.InvalidFinanceException;

public class FinanceCalculator {

    private Car car;
    private FinanceTerm financeTerm;

public FinanceCalculator(Car car, FinanceTerm financeTerm) throws InvalidFinanceException {

if (car == null) {
            
    throw new InvalidFinanceException("Car cannot be empty.");
        
}

if (financeTerm == null) {
            
    throw new InvalidFinanceException("Finance term cannot be empty.");
        
}

    this.car = car;
    this.financeTerm = financeTerm;
    
}

public double calculateInterest() {

double interest = car.getPrice() * (financeTerm.getInterestRate() / 100) * financeTerm.getYears();

assert interest >= 0 : "Interest cannot be negative.";

return interest;
    
}

public double calculateTotalRepayment() {

double total = car.getPrice() + calculateInterest();

        assert total >= car.getPrice() :
                "Total repayment should not be less than the car price.";

        return total;
    }

    public double calculateMonthlyPayment() {

        double monthlyPayment =
                calculateTotalRepayment()
                / (financeTerm.getYears() * 12);

        assert monthlyPayment > 0 :
                "Monthly payment must be greater than zero.";

        return monthlyPayment;
    }

    public void displayQuotation() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("       FINANCE QUOTATION");
        System.out.println("=================================");

        System.out.println("Vehicle       : "
                + car.getMake() + " " + car.getModel());

        System.out.println("Price         : R"
                + String.format("%.2f", car.getPrice()));

        System.out.println("Finance Term  : "
                + financeTerm.getYears() + " years");

        System.out.println("Interest Rate : "
                + financeTerm.getInterestRate() + "%");

        System.out.println("---------------------------------");

        System.out.println("Interest      : R"
                + String.format("%.2f", calculateInterest()));

        System.out.println("Total Repay.  : R"
                + String.format("%.2f", calculateTotalRepayment()));

        System.out.println("Monthly Pay.  : R"
                + String.format("%.2f", calculateMonthlyPayment()));

        System.out.println("=================================");
    }
}
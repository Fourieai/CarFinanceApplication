/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.carfinanceapplication;

/**
 *
 * @author Student
 */

import java.util.Scanner;

import com.mycompany.carfinanceapplication.carfinance.Car;
import com.mycompany.carfinanceapplication.carfinance.CarType;
import com.mycompany.carfinanceapplication.carfinance.Vehicle;
import com.mycompany.carfinanceapplication.carfinance.finance.Finance;
import com.mycompany.carfinanceapplication.carfinance.finance.FinanceCalculator;
import com.mycompany.carfinanceapplication.carfinance.finance.FinanceTerm;
import com.mycompany.carfinanceapplication.carfinance.exceptions.InvalidFinanceException;

public class CarFinanceApplication {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Array of Vehicle objects
        Vehicle[] cars = {

            new Car("CA12345", "Toyota", "Corolla",
                    350000, CarType.SEDAN),

            new Car("CA67890", "Haval", "H6",
                    450000, CarType.SUV),

            new Car("GP45678", "Volkswagen", "Tiguan",
                    520000, CarType.SUV),

            new Car("GP11223", "BMW", "320i",
                    650000, CarType.SEDAN),

            new Car("GP99887", "Ford", "Everest",
                    720000, CarType.SUV)
        };

        boolean running = true;

        while (running) {

            displayMenu();

            try {

                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {

                    case 1:
                        viewCars(cars);
                        break;

                    case 2:
                        applyForFinance(cars);
                        break;

                    case 3:
                        viewFinanceTerms();
                        break;

                    case 4:
                        System.out.println();
                        System.out.println("Thank you for using");
                        System.out.println("the Car Finance System.");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option. Please choose 1-4.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a number.");
            }
        }

        scanner.close();
    }

    // Main menu
    public static void displayMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("        CAR FINANCE SYSTEM");
        System.out.println("=================================");
        System.out.println("1. View Available Cars");
        System.out.println("2. Apply for Car Finance");
        System.out.println("3. View Finance Terms");
        System.out.println("4. Exit");
        System.out.println("=================================");
        System.out.print("Enter option: ");
    }

    // View cars
    public static void viewCars(Vehicle[] cars) {

        System.out.println();
        System.out.println("=================================");
        System.out.println("        AVAILABLE CARS");
        System.out.println("=================================");

        for (int i = 0; i < cars.length; i++) {

            System.out.println();
            System.out.println("Car " + (i + 1));
            cars[i].displayVehicle();

            System.out.println("---------------------------------");
        }
    }

    // Apply for finance
    public static void applyForFinance(Vehicle[] cars) {

        viewCars(cars);

        try {

            System.out.println();
            System.out.print("Select a car (1-" + cars.length + "): ");

            int carChoice = Integer.parseInt(scanner.nextLine());

            if (carChoice < 1 || carChoice > cars.length) {

                throw new InvalidFinanceException(
                        "The selected car does not exist.");
            }

            Car selectedCar = (Car) cars[carChoice - 1];

            System.out.println();
            System.out.println("Selected Vehicle: "
                    + selectedCar.getMake() + " "
                    + selectedCar.getModel());

            displayTermMenu();

            System.out.print("Select finance term: ");

            int termChoice = Integer.parseInt(scanner.nextLine());

            FinanceTerm selectedTerm;

            switch (termChoice) {

                case 1:
                    selectedTerm = FinanceTerm.SHORT_TERM;
                    break;

                case 2:
                    selectedTerm = FinanceTerm.MEDIUM_TERM;
                    break;

                case 3:
                    selectedTerm = FinanceTerm.LONG_TERM;
                    break;

                default:
                    throw new InvalidFinanceException(
                            "Invalid finance term.");
            }

            FinanceCalculator calculator =
                    new FinanceCalculator(selectedCar, selectedTerm);

            calculator.displayQuotation();

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid number.");

        } catch (InvalidFinanceException e) {

            System.out.println("Finance Error: " + e.getMessage());
        }
    }

    // Finance term menu
    public static void displayTermMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("        FINANCE TERMS");
        System.out.println("=================================");
        System.out.println("1. Short Term  - 1 year");
        System.out.println("2. Medium Term - 3 years");
        System.out.println("3. Long Term   - 5 years");
        System.out.println("=================================");
    }

    // View terms
    public static void viewFinanceTerms() {

        Finance finance = new Finance();

        finance.displayTerms();
    }
}
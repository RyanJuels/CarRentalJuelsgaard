package carRentalJuelsgaard;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/***************************************************************
* Name : Main class for the Car Rental Program
* Author: Ryan Juelsgaard
* Created 11/27/2021
* Course: CIS 152 - Data Structure
* Version: 1.0
* OS: Windows 10
* IDE: eclipse EE
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description : The Main class in the car rental program that
* allows a person to rent look at the cars the establishment
* has and allows a user to rent one if the choose to.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/
public class Menu {
	private LinkedList<Car> cars;

	// Constructor
	public Menu(LinkedList<Car> cars) {
		this.cars = cars;
	}

	// Sorting the cars by the amount of seats that they have using Insertion Sort
	public void insertionSortCars(LinkedList<Car> cars) {
		for (int i = 1; i < cars.size(); i++) {
			Car key = cars.get(i);
			int j = i - 1;
			while (j >= 0 && cars.get(j).getNumSeats() > key.getNumSeats()) {
				cars.set(j + 1, cars.get(j));
				j -= 1;
			}
			cars.set(j + 1, key);
		}
	}

	// Getting an Input and validates that it is a number.
	public int getInput(int inputAmount) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		try {
			result = sc.nextInt();
		} catch (InputMismatchException E) {
			System.out.println("\nInvalid input, please try again\n");
			getInput(inputAmount);
		}
		while (result < 0 || result > inputAmount) {
			System.out.println("\nInvalid input, please try again\n");
			try {
				result = sc.nextInt();
			} catch (InputMismatchException E) {
				System.out.println("\nInvalid input, please try again\n");
				getInput(inputAmount);
			}
		}
		return result;
	}

	// Shows all the cars and their details and gets user input on what to do next
	public void veiwAllCars() {
		Scanner sc = new Scanner(System.in);
		int listInput;
		String rent;
		// Runs through a loop showing all cars with some minor details as well as
		// whether they are available.
		for (int i = 0; i < cars.size(); i++) {
			System.out.println("\n" + (i + 1) + ". " + cars.get(i).toString());
			if (cars.get(i).isAvalible()) {
				System.out.println("This car is avalible right away.");
			} else {
				System.out.println("This car is not avalible right away.");
			}
		}

		// asks user to choose a car to find out more or return to the menu
		System.out.println(
				"\nPlease Choose a Car From the List to Veiw More About Them or Enter 0 to Return to the Main Menu: ");
		listInput = getInput(cars.size());

		// asks user to decide if they want to rent the car they decided to look at.
		while (listInput != 0) {
			System.out.println(cars.get(listInput - 1).deatiledCar());
			System.out.println("\nWould you like to reserve this car?\n      [Y]es or [N]o");
			rent = sc.next();
			// If they decide to rent it, they will have to enter their name to either join
			// a wait list for the car, or become the renter.
			if (rent.equals("y") || rent.equals("Y")) {
				System.out.println("Please enter your full name: ");
				String name = sc.next();
				rent(name, cars.get(listInput - 1));
				return;
			} else {
				// If they don't want that car, it lets them choose a different one, or enter 0
				// to return to the main menu
				System.out.println(
						"\nPlease Choose a Car From the List to Veiw More About Them or Enter 0 to Return to the Main Menu: ");
				listInput = getInput(cars.size());
			}
		}
	}

	// Add's the renters name to the car, or adds the name to the wait list
	public void rent(String name, Car car) {
		if (car.isAvalible()) {
			car.setRenter(name);
			System.out.println(
					"Thank you for renting with us!\nPlease come to the office and we will have the paperwork ready for your rental.\n");
		} else {
			System.out.println("Your rental should be avalible in about " + (7 + (car.getWaitList().size() * 14))
					+ " days. We will notify you when it is ready.\n Thank you for renting with us!\n");
			car.addToWait(name);
		}
	}

	// The main menu of the function
	public void run() {
		insertionSortCars(cars);
		int result;
		System.out.println("Welcome to the Car Rental Online Center\n");
		// Do while loop having the person enter a number between 1 and 3 to decide what
		// to do.
		do {
			System.out.println(
					"What would you like to do?\n 1. Rent/Veiw the Cars\n 2. Get Contact Information\n 3. Close the Rental Center");
			result = getInput(3);
			// Entering 1 shows runs the veiwAllCars() method to allow them to rent a
			// vehicle
			if (result == 1) {
				veiwAllCars();
				// Choosing 2 shows them contact info and ends the program
			} else if (result == 2) {
				System.out.println("\nGive us a call at: 1-800-Car-Rent");
				System.out.println("Email us at: CarRentalCenter@crc.com");
				System.out.println("Or come visit us at: \n1234 Car Rental Ave.\nCar Rental City, State, Zip\n");
				System.out
						.println("Thank you for your interest in us, and we look forward to doing business with you!");
				result = 3;
			}
			// Choosing 3 ends the program
		} while (result != 3);
	}
}

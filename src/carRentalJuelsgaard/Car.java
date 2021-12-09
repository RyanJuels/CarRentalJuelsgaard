package carRentalJuelsgaard;

import java.util.LinkedList;
import java.util.Queue;
/***************************************************************
* Name : Car class for the Car Rental Program
* Author: Ryan Juelsgaard
* Created 11/27/2021
* Course: CIS 152 - Data Structure
* Version: 1.0
* OS: Windows 10
* IDE: eclipse EE
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description : The Car class to be used in the Car Rental Program
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/
public class Car {

	// Initializing all variables to be used
	private Queue<String> waitList = new LinkedList<String>();
	private String model;
	private String make;
	private int numSeats;
	private String renter;
	private int mpg;
	private int year;

	// Constructor for when there is not prior renter
	public Car(String model, String make, int numSeats, int mpg, int year) {
		this.model = model;
		this.make = make;
		this.numSeats = numSeats;
		this.mpg = mpg;
		this.year = year;
		renter = null;

	}

	// Constructor for if there is a current renter
	public Car(String make, String model, int numSeats, int mpg, int year, String renter) {
		this.model = model;
		this.make = make;
		this.numSeats = numSeats;
		this.mpg = mpg;
		this.year = year;
		this.renter = renter;
	}

	// Adding the name parameter to the waitList
	public void addToWait(String name) {
		waitList.add(name);
	}

	// Checking to see if the Car is Available to rent currently
	public boolean isAvailable() {
		return renter == null;
	}

	// A Detailed view of the car showing all variables
	public String deatiledCar() {
		if (!isAvailable()) {
			return ("Make --------------- " + make + "\nModel -------------- " + model + "\nYear --------------- "
					+ year + "\nMPG ---------------- " + mpg + "\nNumber of Seats ---- " + numSeats
					+ "\nWaitList ----------- " + waitList.size());
		}
		return ("Make --------------- " + make + "\nModel -------------- " + model + "\nYear --------------- " + year
				+ "\nMPG ---------------- " + mpg + "\nNumber of Seats ---- " + numSeats + "\nAvalible ----------- "
				+ isAvailable());
	}
	
	// Decides who the next renter of the car is based on the waitList Queue, or null if there is nobody waiting for the car
	public void nextRenter() {
		if(!waitList.isEmpty()) {
			renter = waitList.remove();
		}
		else {
			renter = null;
		}
	}

	// A less detailed view of the car
	public String toString() {
		return ("Make: " + make + "\nModel: " + model + "\nNumber of Seats: " + numSeats);
	}

	// Getters and Setters for all variables past here

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the numSeats
	 */
	public int getNumSeats() {
		return numSeats;
	}

	/**
	 * @param numSeats the numSeats to set
	 */
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	/**
	 * @return the renter
	 */
	public String getRenter() {
		return renter;
	}

	/**
	 * @param renter the renter to set
	 */
	public void setRenter(String renter) {
		this.renter = renter;
	}

	/**
	 * @return the waitList
	 */
	public Queue<String> getWaitList() {
		return waitList;
	}

	/**
	 * @param waitList the waitList to set
	 */
	public void setWaitList(Queue<String> waitList) {
		this.waitList = waitList;
	}
}

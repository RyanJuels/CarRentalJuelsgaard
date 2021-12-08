package carRentalJuelsgaard;

import java.util.LinkedList;
import java.util.Queue;

public class Car {

	private Queue<String> waitList = new LinkedList<String>();
	private String model;
	private String make;
	private int numSeats;
	private String renter;
	private int mpg;
	private int year;

	public Car(String model, String make, int numSeats, int mpg, int year) {
		this.model = model;
		this.make = make;
		this.numSeats = numSeats;
		this.mpg = mpg;
		this.year = year;
		renter = null;

	}

	public Car(String make, String model, int numSeats, int mpg, int year, String renter) {
		this.model = model;
		this.make = make;
		this.numSeats = numSeats;
		this.mpg = mpg;
		this.year = year;
		this.renter = renter;
	}

	public void addToWait(String name) {
		waitList.add(name);
	}

	public boolean isAvalible() {
		return renter == null;
	}

	public String deatiledCar() {
		if (!isAvalible()) {
			return ("Make --------------- " + make + "\nModel -------------- " + model + "\nYear --------------- "
					+ year + "\nMPG ---------------- " + mpg + "\nNumber of Seats ---- " + numSeats
					+ "\nWaitList ----------- " + waitList.size());
		}
		return ("Make --------------- " + make + "\nModel -------------- " + model + "\nYear --------------- " + year
				+ "\nMPG ---------------- " + mpg + "\nNumber of Seats ---- " + numSeats + "\nAvalible ----------- "
				+ isAvalible());
	}

	public String toString() {
		return ("Make: " + make + "\nModel: " + model + "\nNumber of Seats: " + numSeats);
	}

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

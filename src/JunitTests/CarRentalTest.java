package JunitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carRentalJuelsgaard.Car;
import carRentalJuelsgaard.Menu;

class CarRentalTest {
	/***************************************************************
	* Name : Unit Testing for the Car Rental Program
	* Author: Ryan Juelsgaard
	* Created 12/08/2021
	* Course: CIS 152 - Data Structure
	* Version: 1.0
	* OS: Windows 10
	* IDE: eclipse EE
	* Copyright : This is my own original work 
	* based on specifications issued by our instructor
	* Description : Tests that test the testable methods of the Menu
	* class and the Car class.
	* Academic Honesty: I attest that this is my original work.
	* I have not used unauthorized source code, either modified or
	* unmodified. I have not given other fellow student(s) access
	* to my program.
	***************************************************************/
	LinkedList<Car> cars = new LinkedList<Car>();
	Car car1 = new Car("Ford", "Explorer", 5, 30, 2019, "Rachel");
	Car car2 = new Car("Lexuc", "lc 500", 4, 25, 2016);
	Car car3 = new Car("Subaru", "WRX", 4, 27, 2021);
	Car car4 = new Car("Ford", "Taurus", 4, 30, 2012, "Ryan");
	Car car5 = new Car("Porshe", "Boxster", 2, 25, 2021);
	Car car6 = new Car("Test", "Sort", 1, 2, 2021);
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	//Testing adding to the waitList of an already rented car
	@Test
	void testAddToWait1() {
		Car testCar1 = car1;
		testCar1.addToWait("Ryan");
		assertEquals(1, testCar1.getWaitList().size());
		
		testCar1.addToWait("David");
		assertEquals(2, testCar1.getWaitList().size());
		
	}
	//Testing adding to the waitList of an available car
	@Test
	void testAddToWait2() {
		Car testCar1 = car2;
		testCar1.addToWait("Ryan");
		assertEquals(1, testCar1.getWaitList().size());
		
		testCar1.addToWait("David");
		assertEquals(2, testCar1.getWaitList().size());
		
	}
	
	//Testing the rent() function in Menu class on an already rented car
	@Test
	void testRent1() {
		Menu testMenu = new Menu(cars);
		testMenu.rent("Ryan", car1);
		assertEquals("Ryan", car1.getWaitList().peek());
	}
	
	//Testing the rent() function in Menu class on an available car
	@Test
	void testRent2() {
		Menu testMenu = new Menu(cars);
		testMenu.rent("Ryan", car2);
		assertEquals(null, car2.getWaitList().peek());
		assertEquals("Ryan", car2.getRenter());
		testMenu.rent("Reid", car1);
		assertEquals("Reid", car1.getWaitList().peek());
	}
	
	//Testing the nextRenter() function of the Car class to decide who the next renter is
	@Test
	void testNextRenter1() {
		Menu testMenu = new Menu(cars);
		testMenu.rent("Ryan", car1);
		car1.nextRenter();
		assertEquals("Ryan", car1.getRenter());
	}
	
	//Testing the nextRenter() function of the Car class to decide who the next renter is
	@Test
	void testNextRenter2() {
		Menu testMenu = new Menu(cars);
		testMenu.rent("Ryan", car1);
		car1.nextRenter();
		car1.nextRenter();
		assertEquals(null, car1.getRenter());
	}
	
	//Testing the nextRenter() function of the Car class to see if it makes the car available if there is nobody in the waitList
	@Test
	void testNextRenter3() {
		Menu testMenu = new Menu(cars);
		testMenu.rent("Ryan", car1);
		car1.nextRenter();
		car1.nextRenter();
		assertEquals(true, car1.isAvailable());
	}
	
	
	//Testing the Insertion sort in the menu class that sorts by the number of seats
	@Test
	void testInsertionSort() {
		cars.add(car1);
		cars.add(car3);
		cars.add(car6);
		cars.add(car5);
		cars.add(car2);
		cars.add(car4);
		Menu testMenu = new Menu(cars);
		
		testMenu.insertionSortCars(cars);
		
		assertEquals(1, cars.get(0).getNumSeats());
		assertEquals(5, cars.get(cars.size() - 1).getNumSeats());
	}
	
	
	
	

}

package carRentalJuelsgaard;
/***************************************************************
* Name : Driver class for the Car Rental Program
* Author: Ryan Juelsgaard
* Created 11/27/2021
* Course: CIS 152 - Data Structure
* Version: 1.0
* OS: Windows 10
* IDE: eclipse EE
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description : The driver for the Car Rental Program that
* creates multiple cars to show off to the user and runs
* the main menu of the program.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/
import java.util.LinkedList;

public class carRentalDriver {
	public static void main(String args[]) {
		LinkedList<Car> cars = new LinkedList<Car>();
		Car car1 = new Car("Ford", "Explorer", 5, 30, 2019, "Rachel");
		Car car2 = new Car("Lexuc", "lc 500", 4, 25, 2016);
		Car car3 = new Car("Subaru", "WRX", 4, 27, 2021);
		Car car4 = new Car("Ford", "Explorer", 5, 30, 2019);
		Car car5 = new Car("Ford", "Taurus", 4, 30, 2012, "Ryan");
		Car car6 = new Car("Porshe", "Boxster", 2, 25, 2021);
		Car car7 = new Car("Honda", "Odyssey", 8, 26, 2022, "Pedro");
		Car car8 = new Car("Honda", "Accord LX", 4, 38, 2022, "Tiffany");
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		car5.addToWait("Justin");
		car5.addToWait("Celina");
		cars.add(car5);
		car7.addToWait("CJ");
		cars.add(car7);
		cars.add(car6);
		cars.add(car8);

		Menu menu = new Menu(cars);

		menu.run();
	}
}

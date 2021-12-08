package carRentalJuelsgaard;

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
		car5.addToWait("Tiffany");
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

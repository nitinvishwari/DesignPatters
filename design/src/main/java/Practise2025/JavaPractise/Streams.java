package Practise2025.JavaPractise;

import java.util.*;

public class Streams {
	
	record Car(String name, String brand, int price) {}
	
	public static void main(String[] args) {
		List<Car> list = new ArrayList<>();
		Car car1 = new Car("Camry", "Toyota", 42000);
		Car car2 = new Car("Corolla", "Toyota", 32000);
		Car car3 = new Car("Model 3", "Tesla", 38000);
		list.add(car1);
		list.add(car2);
		list.add(car3);
		List<Car> filteredCars = list.stream().filter((a) -> a.brand.equals("Toyota")).toList();
		System.out.println(filteredCars);
	}
	
}

package Practise2025.JavaPractise;

import java.util.*;
import java.util.stream.*;

public class Streams {
	
	record Car(String name, String brand, int price) {}
	
	public static void main(String[] args) {
		// Created list of Cars
		List<Car> list = new ArrayList<>();
		Car car1 = new Car("Camry", "Toyota", 42000);
		Car car2 = new Car("Corolla", "Toyota", 32000);
		Car car3 = new Car("Model 3", "Tesla", 38000);
		Car car4 = new Car("Camry", "Toyota", 42000);
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		System.out.println(list);
		
		// Filtered Cars based on the brand
		List<Car> filteredCars = list.stream().filter(a -> a.brand.equals("Toyota")).toList();
		System.out.println(filteredCars);
		
		// Changing list to array of cars
		Car[] carArray = list.stream().toArray((size) -> new Car[size]);
		System.out.println(carArray[0]);
		
		// Transforming from one form to another using map
		List<String> nameList = list.stream().map(c -> c.name).toList();
		System.out.println(nameList);
		
		// Count after filter
		System.out.println(list.stream().filter(a -> a.brand.equals("Tesla")).count());
		
		// Distinct in Streams
		List<Car> listOfDistinct = list.stream().distinct().toList();
		System.out.println(listOfDistinct);
		
		// Sort based on the price
		List<Car> sortedList = list.stream().sorted((a, b) -> a.price - b.price).toList();
		System.out.println(sortedList);
	}
	
}

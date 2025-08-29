package Practise2025.JavaPractise;

import java.util.HashMap;
import java.util.HashSet;

public class Streams {
	
	record Car(String name, String brand, int price) {}
	
	public static void main(String[] args) {
		Car car = new Car("Camry", "Toyota", 42000);
		HashSet<Car> hs = new HashSet<>();
		hs.add(car);
		if(hs.contains(new Car("Camry", "Toyota", 42000))) {
			System.out.println("Key Matched");
		}
		else {
			System.out.println("Key Not Matched");
		}
		System.out.println(car);
	}
	
}

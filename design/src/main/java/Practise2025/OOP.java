package Practise2025;

public class OOP {
	public static void main(String[] args) {
		System.out.println("This is the main public file");
	}
}

/* Abstraction */

interface Bird2{
	String description();
	boolean isFly();
}

// This implementation need not be important for user to understand.
class Penguin implements Bird2{
	public String description() {
		return "Penguin lives in cold places.";
	}
	public boolean isFly() {
		return false;
	}
}

class AbstractionTest{
	public static void main(String[] args) {
		Penguin penguin = new Penguin();
		System.out.println(penguin.description());
	}
}

// Encapsulation
class Person{
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
}

class EncapsulationTest{
	
	public static void main(String[] args) {
		Person bestEmployee = new Person();
		bestEmployee.setName("Nitin Vishwari");
		bestEmployee.setAge(25);
		System.out.println(bestEmployee.getName());
	}
	
}
package Practise2025;

public class OOP {
	public static void main(String[] args) {
		System.out.println("This is the main public file");
	}
}

/*
 * Abstract Classes for abstraction
 */

abstract class WildAnimal{
	String wildAnimalVariable = "Lion"; // this is instance variable and not static (this thing is different from interface)
	String warningMessage() {
		return "Please be aware!";
	}
	abstract void setName(String name);
	abstract String getName();
}

class Lion extends WildAnimal{
	
	private String name;
	
	@Override
	void setName(String name) {
		wildAnimalVariable = "king";
		if(wildAnimalVariable.equals("Lion")) {
			this.name = "Bagira";
			return;
		}
		this.name = name;
	}
	
	@Override
	String warningMessage() {
		return "Changed warning message";
	}
	
	@Override
	String getName() {
		return name;
	}
}

class AbstractClassTest{
	
	public static void main(String[] args) {
		WildAnimal lion1 = new Lion();
		WildAnimal lion2 = new Lion();
		lion1.wildAnimalVariable = "lion1";
		System.out.println(lion2.wildAnimalVariable);
	}
}


/* Abstraction */

interface Bird2{
	String birdCategory = "Bird Catergory"; // Even if I am not writing public static but it's public static
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
		Bird2 penguin = new Penguin();
		System.out.println(penguin.description());
		System.out.println(Bird2.birdCategory);
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
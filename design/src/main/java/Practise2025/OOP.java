package Practise2025;

public class OOP {
	public static void main(String[] args) {
		System.out.println("This is the main public file");
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
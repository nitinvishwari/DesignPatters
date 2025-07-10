package Practise2025;

public class SOLID {
	public static void main(String[] args) {
		Bird bird = new Bird("parrot", true);
		System.out.println(bird.whatIsYourName());
	}
}

class Bird{
	String name;
	boolean fly;
	
	public Bird(String name, boolean fly) {
		this.name = name;
		this.fly = fly;
	}
	
	public boolean doYouFly() {
		return this.fly;
	}
	
	public String whatIsYourName() {
		return this.name;
	}
}




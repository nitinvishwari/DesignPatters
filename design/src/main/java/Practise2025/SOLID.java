package Practise2025;

//public class SOLID {
//	public static void main(String[] args) {
//		Bird bird = new Bird("parrot", true);
//		System.out.println(bird.whatIsYourName());
//	}
//}



// OCP Principle

interface Perimeter{
	int cal(int a, int b); 
}

class Square implements Perimeter{
	public int cal(int a, int b) {
		return a * a;
	}
}

class Rectangle implements Perimeter{
	public int cal(int a, int b) {
		return a * b;
	}
}


class Box{
	public static void main(String[] args) {
		Perimeter p = new Rectangle();
		System.out.println(p.cal(2, 3));
	}
}


// Interface segregation principle
interface print{
	void printTheValue();
}

interface page{
	int pageSize();
	String pageType();
}

class OfficePrintPage implements print, page{

	@Override
	public int pageSize() {
		return 4;
	}

	@Override
	public String pageType() {
		// TODO Auto-generated method stub
		return "A";
	}

	@Override
	public void printTheValue() {
		// TODO Auto-generated method stub
		System.out.println("Printer is printing");
	}
	
}

class ISP{
	public static void main(String[] args) {
		OfficePrintPage opp = new OfficePrintPage();
		opp.printTheValue();
	}
}



// LSP Principle
// You should be able to replace you kid then only you are cool dad.

//Bird class
class Bird{
	String name;
	boolean fly;
	
	public Bird() {
	}
	
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
	
	public void color() {
		System.out.println("No info about color");
	}
}


class Parrot extends Bird{
	
	public Parrot(String name, boolean fly) {
		super(name, fly);
	}
	
	public void color() {
		System.out.println("Colorful, parrot generally have multiple colors");
	}
}

public class SOLID {
	public static void main(String[] args) {
		Bird parrot = new Parrot("Parrot", true);
		parrot.color();
	}
}

















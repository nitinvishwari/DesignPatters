package com.nitin.designPatterns;

class Bird{
	
	String name;
	float weight;
	
	static Bird bird = new Bird();
	
	private Bird() {
	}
	
	public static Bird getInstance() {
		return bird;
	}
}

public class Singleton {
	public static void main(String[] args){
		Bird birdObject = Bird.getInstance();
		birdObject.name = "parrot";
		birdObject.weight = (float) 2.5;
		System.out.println(birdObject.name + ", " + birdObject.weight + "pounds");
		
		// this instance is same as above and even variable values are also same.
		Bird birdObject2 = Bird.getInstance();
		System.out.println(birdObject2.name + ", " + birdObject2.weight + "pounds");
	}
}

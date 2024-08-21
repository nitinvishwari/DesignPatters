package com.nitin.designPatterns;

class FlyingBird{
	int wings;
	double weight;
	String name;
	
	public FlyingBird() {
	}
	
	public FlyingBird(int wings, double weight, String name) {
		this.wings = wings;
		this.weight = weight;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + " has " + this.wings + " wings and, is of " + this.weight + " pounds";
	}
}

class FlyingBirdBuilder{
	int wings;
	double weight;
	String name;
	
	public FlyingBirdBuilder setWings(int wings) {
		this.wings = wings;
		return this;
	}
	
	public FlyingBirdBuilder setWeight(double weight) {
		this.weight = weight;
		return this;
	}
	
	public FlyingBirdBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public FlyingBird getInstance() {
		return new FlyingBird(wings, weight, name);
	}
}


public class Builder {
	public static void main(String[] args) {
//		FlyingBird bird = new FlyingBird(2, 3.4, "Parrot");
//		System.out.println(bird.toString());
		FlyingBirdBuilder fbb = new FlyingBirdBuilder().setName("Parrot").setWings(2);
		System.out.println(fbb.getInstance().toString());
	}
}

package com.nitin.designPatterns;

interface Coffee {
	public String recipe();
}

class Espresso implements Coffee{
	public String recipe() {
		return "2 small cup coffee and hot water";
	}
}

class Cappuccino implements Coffee{
	public String recipe() {
		return "1 cup coffee, 1 cup milk and cream";
	}
}

class Latte implements Coffee{
	public String recipe() {
		return "1 cup coffee and 1 cup milk";
	}
}

class Factory{	
	public Coffee getInstance(String type) {
		if(type.equals("Espresso")) {
			return new Espresso();
		}
		else if(type.equals("Latte")) {
			return new Latte();
		}
		else {
			return new Cappuccino();
		}
	}
}

public class UserOfFactory {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Coffee coffee = factory.getInstance("Espresso");
		System.out.println(coffee.recipe());
	}
}

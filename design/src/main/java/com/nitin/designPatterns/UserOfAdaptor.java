package com.nitin.designPatterns;

class Print{
	public void printKaro(String s) {
		System.out.println(s);
	}
}

interface Printer{
	public void printKaro(String s);
}

class Adaptor implements Printer{
	Print printObj = new Print();
	
	public void printKaro(String s) {
		printObj.printKaro(s);
	}
}


public class UserOfAdaptor {
	public static void main(String[] args) {
		Printer printerObj = new Adaptor();
		printerObj.printKaro("Nitin");
	}
}

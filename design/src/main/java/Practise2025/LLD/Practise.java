package Practise2025.LLD;

public class Practise {
	public static void main(String[] args) {
		SingletonClass object1 = SingletonClass.getInstance();
		System.out.println(object1);
		SingletonClass object2 = SingletonClass.getInstance();
		System.out.println(object2);
	}
}


class SingletonClass{
	
	private static SingletonClass singletonClass = new SingletonClass();
	
	private SingletonClass() {}
	
	public static synchronized SingletonClass getInstance() {
		
		return singletonClass;
	}
	
}
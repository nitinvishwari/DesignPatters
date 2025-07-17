package Practise2025.JavaPractise;

public class ThreadCreation {
	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		currentThread.setName("MainGuy");
		currentThread.setPriority(Thread.MAX_PRIORITY);
		printThreadState(currentThread);
	}
	
	public static void printThreadState(Thread thread) {
		System.out.println("--------------------");
		System.out.println("Thread Name: " + thread.getName());
		System.out.println("Thread Group: " + thread.getThreadGroup());
		System.out.println("Thread Priority: " + thread.getPriority());
		System.out.println("Thread Is Alive: " + thread.isAlive());
	}
}
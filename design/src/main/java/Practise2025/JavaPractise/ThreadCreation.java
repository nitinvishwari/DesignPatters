package Practise2025.JavaPractise;

import java.util.concurrent.TimeUnit;

public class ThreadCreation {
	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		currentThread.setName("MainGuy");
		currentThread.setPriority(Thread.MAX_PRIORITY);
		printThreadState(currentThread);
		
		MyThread myThread = new MyThread();
		myThread.start();
		
//		Runnable myRunnable = () ->
		
		for(int j=0; j<=4; j++) {
			System.out.print("M ");
			try {
				TimeUnit.MILLISECONDS.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		
	}
	
	public static void printThreadState(Thread thread) {
		System.out.println("--------------------");
		System.out.println("Thread Name: " + thread.getName());
		System.out.println("Thread Group: " + thread.getThreadGroup());
		System.out.println("Thread Priority: " + thread.getPriority());
		System.out.println("Thread Is Alive: " + thread.isAlive());
	}
}
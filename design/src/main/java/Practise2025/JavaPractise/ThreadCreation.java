package Practise2025.JavaPractise;

import java.util.concurrent.TimeUnit;

public class ThreadCreation {
	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		currentThread.setName("MainGuy");
		printThreadState(currentThread);
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		Runnable myRunnable = () -> {
			for(int i=0; i<10; i++) {
				System.out.print(". ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("newThread interrupted");
					Thread.currentThread().interrupt();
					break;
				}
			}
		};
		
		Thread newThread = new Thread(myRunnable);
		newThread.start();
		
		for(int j=0; j<=4; j++) {
			System.out.print("M ");
			try {
				TimeUnit.MILLISECONDS.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		newThread.interrupt();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(newThread.isInterrupted());
	}
	
	public static void printThreadState(Thread thread) {
		System.out.println("--------------------");
		System.out.println("Thread Name: " + thread.getName());
		System.out.println("Thread Group: " + thread.getThreadGroup());
		System.out.println("Thread Priority: " + thread.getPriority());
		System.out.println("Thread Is Alive: " + thread.isAlive());
	}
}
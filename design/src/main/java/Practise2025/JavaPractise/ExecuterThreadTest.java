package Practise2025.JavaPractise;

import java.util.concurrent.*;

public class ExecuterThreadTest {
	
	public static void main(String[] args) {
		ExecutorService es1 = Executors.newSingleThreadExecutor();
		es1.execute(() -> {
			for(int i=0; i<5; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " Radhe Radhe");
			}
		});
		es1.shutdown();
		
		try {
			// 
			boolean isDone = es1.awaitTermination(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExecutorService es2 = Executors.newSingleThreadExecutor();
		es2.execute(() -> {
			for(int i=0; i<5; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " Ram Ram");
			}
		});
		es2.shutdown();
	}
}

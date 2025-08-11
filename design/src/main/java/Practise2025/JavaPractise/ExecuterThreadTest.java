package Practise2025.JavaPractise;

import java.util.concurrent.*;

public class ExecuterThreadTest {
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(() -> {
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
		es.execute(() -> {
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
		es.shutdown();
	}
}

package Practise2025.JavaPractise;

class Thread1 extends Thread{
	@Override
	public void run(){
		for(int i=2; i<=10; i+=2) {
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Even number interrupted");
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
}

public class ThreadChallenge {
	public static void main(String[] args) {
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(() -> {
			for(int i=1; i<=9; i+=2) {
				System.out.println(i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Odd number interrupted");
					Thread.currentThread().interrupt();
					break;
				}
			}
		});
		
		thread2.start();
		thread1.start();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread1.interrupt();
	}
}

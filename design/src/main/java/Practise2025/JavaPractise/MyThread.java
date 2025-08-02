package Practise2025.JavaPractise;

public class MyThread extends Thread{
	@Override
	public void run() {
		for (int i=0; i<=4; i++) {
			System.out.print("1 ");
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

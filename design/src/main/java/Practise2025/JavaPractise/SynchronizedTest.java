package Practise2025.JavaPractise;

public class SynchronizedTest {
	
	public static void main(String[] args) {
		Bank bank = new Bank(1000);
		Thread thread1 = new Thread(() -> {
			bank.withdraw(250);
		});
		Thread thread2 = new Thread(() -> {
			bank.deposit(500);
		});
		Thread thread3 = new Thread(() -> {
			bank.withdraw(250);
		});
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bank.getAmount());
	}
}

class Bank{
	
	private int amount;
	
	public Bank(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void deposit(int depositAmount) {
		try {
			System.out.println("Talking to banker for deposit....");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this) {
			this.amount += depositAmount;	
		}
		System.out.println("deposited amount:" + depositAmount + ", total:" + amount);
	}
	
	public void withdraw(int withdrawAmount) {
		try {
			System.out.println("Talking to banker for withdraw....");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this) {
			if(withdrawAmount > this.amount) {
				this.amount = 0;
			}
			else {
				this.amount -= withdrawAmount;
			}
		}
		System.out.println("withdraw amount:" + withdrawAmount + ", total:" + amount);
	}

}

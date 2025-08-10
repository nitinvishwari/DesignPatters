package Practise2025.JavaPractise;

import java.util.*;

class Message{
	
	boolean flag;
	String ping;
	
	public Message() {
		flag = false;
		ping = null;
	}
	
	public synchronized void read() {
		while(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = false;
		notifyAll();
		System.out.println("Message Recieved:" + ping);
	}
	
	public synchronized void write(String m) {
		while(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = true;
		ping = m;
		notifyAll();
		System.out.println("Message Send:" + ping);
	}
}

class ReaderThread implements Runnable {
	
	Message message;
	
	public ReaderThread(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<4; i++) {
			message.read();
		}
	}
	
}

class WriterThread implements Runnable {
	
	Message message;
	List<String> items;
	
	public WriterThread(Message message) {
		this.message = message;
		items = new ArrayList<>(Arrays.asList("Apple", "Mango", "Banana", "Papaya"));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<items.size(); i++) {
			message.write(items.get(i));
		}
	}
}

public class DeadlockTest {
	public static void main(String[] args) {
		Message message = new Message();
		Thread readerThread = new Thread(new ReaderThread(message));
		Thread writerThread = new Thread(new WriterThread(message));
		writerThread.start();
		readerThread.start();
	}
}

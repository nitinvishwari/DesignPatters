package Practise2025.CompanyH;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryerMainC1 {
	public static void main(String[] args) {
		AtomicInteger chance = new AtomicInteger(1);
		Retry retry = new Retry(new FixedIntervalStrategy(2), 5);
		retry.callSync(() -> {
			int curr = chance.getAndIncrement();
			if(curr > 2)
				System.out.println("I am giving you success!");
			else
				throw new RuntimeException("I am giving you error!");
			return "success";
		});
	}
}

interface RetryStrategy{
	public int getWaitTime();
}

class FixedIntervalStrategy implements RetryStrategy{
	
	private int waitTime;
	
	public FixedIntervalStrategy(int waitTime) {
		this.waitTime = waitTime;
	}
	
	public int getWaitTime() {
		return waitTime;
	}
}

class ExponentialStrategy implements RetryStrategy{
	
	private int waitTime;
	
	public ExponentialStrategy(int waitTime) {
		this.waitTime = waitTime;
	}
	
	public int getWaitTime() {
		int currWaitTime = waitTime;
		waitTime = waitTime * 2;
		return currWaitTime;
	}
	
}


class Retry{
	
	RetryStrategy rs;
	int maxAttempt;
	
	public Retry(RetryStrategy rs, int maxAttempt) {
		this.rs = rs;
		this.maxAttempt = maxAttempt;
	}
	
	public String callSync(Callable<String> task) {
		int currAttempt = 0;
		while(true) {
			try {
				task.call();
				return "SUCCESS!";
			} catch (Exception e) {
				currAttempt++;
				System.out.println("Attempt " + currAttempt + ": " +  e.getMessage());
				if(currAttempt >= maxAttempt) {
					break;
				}
				int waitTime = rs.getWaitTime();
				try {
					TimeUnit.SECONDS.sleep(waitTime);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return "FAILED!";
	}
	
}



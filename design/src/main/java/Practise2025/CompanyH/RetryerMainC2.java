//package Practise2025.CompanyH;
//
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class RetryerMainC1 {
//	public static void main(String[] args) {
//		AtomicInteger chance = new AtomicInteger(1);
//		Retry retry = new Retry(5);
//		retry.callSync(() -> {
//			int curr = chance.getAndIncrement();
//			if(curr > 2)
//				System.out.println("I am giving you success!");
//			else
//				throw new RuntimeException("I am giving you error!");
//			return "success";
//		}, new ExponentialStrategy(2));
//		
//		AtomicInteger chance2 = new AtomicInteger(1);
//		retry.callAsync(() -> {
//			int curr = chance2.getAndIncrement();
//			if(curr > 2)
//				System.out.println("I am giving you success!");
//			else
//				throw new RuntimeException("I am giving you error!");
//			return "success";
//		}, new ExponentialStrategy(2));
//		System.out.println("Am I sync or async");
//	}
//}
//
//interface RetryStrategy{
//	public int getWaitTime();
//}
//
//class FixedIntervalStrategy implements RetryStrategy{
//	
//	private int waitTime;
//	
//	public FixedIntervalStrategy(int waitTime) {
//		this.waitTime = waitTime;
//	}
//	
//	public int getWaitTime() {
//		return waitTime;
//	}
//}
//
//class ExponentialStrategy implements RetryStrategy{
//	
//	private int waitTime;
//	
//	public ExponentialStrategy(int waitTime) {
//		this.waitTime = waitTime;
//	}
//	
//	public int getWaitTime() {
//		int currWaitTime = waitTime;
//		waitTime = waitTime * 2;
//		return currWaitTime;
//	}
//	
//}
//
//
//class Retry{
//
//	int maxAttempt;
//	
//	public Retry(int maxAttempt) {
//		this.maxAttempt = maxAttempt;
//	}
//	
//	public String callSync(Callable<String> task, RetryStrategy rs) {
//		int currAttempt = 0;
//		while(true) {
//			try {
//				task.call();
//				return "SUCCESS!";
//			} catch (Exception e) {
//				currAttempt++;
//				System.out.println("Attempt " + currAttempt + ": " +  e.getMessage());
//				if(currAttempt >= maxAttempt) {
//					break;
//				}
//				int waitTime = rs.getWaitTime();
//				try {
//					TimeUnit.SECONDS.sleep(waitTime);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		}
//		return "FAILED!";
//	}
//	
//	public void callAsyncHelper(Callable<String> task, int attempt, ExecutorService es, RetryStrategy rs) {
//		CompletableFuture.supplyAsync(() -> {
//			try {
//				return task.call();
//			}
//			catch(Exception e) {
//				throw new RuntimeException("Attempt "+ attempt + ": " + "I am failed async");
//			}
//		}, es).thenAccept(result -> {
//			es.shutdown();
//		}).exceptionally(ex -> {
//			System.out.println(ex.getMessage());
//			if(attempt < maxAttempt) {
//				int waitTime = rs.getWaitTime();
//				try {
//					TimeUnit.SECONDS.sleep(waitTime);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//				callAsyncHelper(task, attempt + 1, es, rs);
//				return null;
//			}
//			else {
//				es.shutdown();
//				return null;
//			}
//		});
//	}
//	
//	public void callAsync(Callable<String> task, RetryStrategy rs) {
//		ExecutorService es = Executors.newSingleThreadExecutor();
//		callAsyncHelper(task, 0, es, rs);
//	}
//	
//}
//
//

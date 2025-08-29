package Practise2025.JavaPractise;

import java.util.concurrent.*;
import java.util.*;

public class CallableAndFuturePractise {
	
	public static Double randomNumber() {
		return Math.random();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newCachedThreadPool();
		Callable<Double> callable = () -> {
			return randomNumber();
		};
		Future<Double> future = es.submit(callable);
		Double r = future.get();
		System.out.println(r);
	}
}

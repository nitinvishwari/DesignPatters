package Practise2025.CompanyH;

import java.util.concurrent.*;
import java.util.function.Supplier;


public class RetryerMain {
	public static void main(String[] args) {
        Retryer<String> retryer = new Retryer<>(3, 1000, Retryer.Strategy.EXPONENTIAL_BACKOFF);

        // ✅ Synchronous Task
        try {
            String result = retryer.run(() -> {
                if (Math.random() < 0.7) throw new RuntimeException("Random fail");
                return "Sync Success!";
            });

            System.out.println("Sync Result: " + result);
        } catch (Exception e) {
            System.out.println("Sync Task Failed: " + e.getMessage());
        }

        // ✅ Asynchronous Task
        retryer.runAsync(() -> CompletableFuture.supplyAsync(() -> {
            if (Math.random() < 0.7) throw new RuntimeException("Async fail");
            return "Async Success!";
        })).thenAccept(result -> {
            System.out.println("Async Result: " + result);
        }).exceptionally(ex -> {
            System.out.println("Async Task Failed: " + ex.getMessage());
            return null;
        });
    }
}

class Retryer<T> {

    public enum Strategy {
        FIXED,
        EXPONENTIAL_BACKOFF
    }

    private final int maxAttempts;
    private final long delayMillis;
    private final Strategy strategy;

    public Retryer(int maxAttempts, long delayMillis, Strategy strategy) {
        this.maxAttempts = maxAttempts;
        this.delayMillis = delayMillis;
        this.strategy = strategy;
    }

    // ✅ Synchronous retry
    public T run(Callable<T> task) throws Exception {
        int attempt = 1;
        long delay = delayMillis;

        while (true) {
            try {
                return task.call(); // try the task
            } catch (Exception e) {
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage());

                if (attempt >= maxAttempts) {
                    throw e;
                }

                Thread.sleep(delay);

                if (strategy == Strategy.EXPONENTIAL_BACKOFF) {
                    delay *= 2;
                }

                attempt++;
            }
        }
    }

    // ✅ Asynchronous retry
    public CompletableFuture<T> runAsync(Supplier<CompletableFuture<T>> task) {
        CompletableFuture<T> result = new CompletableFuture<>();
        retryAsync(task, result, 1, delayMillis);
        return result;
    }

    private void retryAsync(Supplier<CompletableFuture<T>> task,
                            CompletableFuture<T> result,
                            int attempt, long delay) {

        task.get().whenComplete((value, error) -> {
            if (error == null) {
                result.complete(value);
            } else {
                System.out.println("Async attempt " + attempt + " failed: " + error.getMessage());

                if (attempt >= maxAttempts) {
                    result.completeExceptionally(error);
                } else {
                    long nextDelay = (strategy == Strategy.EXPONENTIAL_BACKOFF) ? delay * 2 : delay;

                    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
                    scheduler.schedule(() -> {
                        retryAsync(task, result, attempt + 1, nextDelay);
                        scheduler.shutdown();
                    }, delay, TimeUnit.MILLISECONDS);
                }
            }
        });
    }
}
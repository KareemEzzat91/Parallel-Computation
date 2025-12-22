package sec9;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {

        // ===== ThreadPoolExecutor =====
        @SuppressWarnings("resource")
        ExecutorService executor = new ThreadPoolExecutor(
                2, // corePoolSize
                5, // maximumPoolSize
                10, // keepAliveTime
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        try {
            executor.execute(() -> {
                System.out.println("Task executed by ThreadPoolExecutor");
            });
        } finally {
            executor.shutdown();
        }

        // ===== ScheduledThreadPoolExecutor =====
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // run once after delay
        scheduler.schedule(() -> {
            System.out.println("Run after 3 seconds");
        }, 3, TimeUnit.SECONDS);

        // run repeatedly at fixed rate
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Run every 2 seconds");
        }, 1, 2, TimeUnit.SECONDS);

        // run repeatedly with fixed delay
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Run with delay after finishing");
        }, 1, 3, TimeUnit.SECONDS);
    }
}

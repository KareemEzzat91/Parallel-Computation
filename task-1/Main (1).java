import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Runnable> tasks = Arrays.asList(
            () -> System.out.println(Thread.currentThread().getName() + " -> Task 1 running..."),
            () -> {
                System.out.println(Thread.currentThread().getName() + " -> Task 2 running...");
                int x = 10 / 0; 
            },
            () -> System.out.println(Thread.currentThread().getName() + " -> Task 3 finished successfully.")
        );

        // Default Uncaught Exception Handler (لكل Threads)
        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            System.out.println("⚠️ Global Handler caught exception from " +
                    thread.getName() + ": " + ex.getMessage());
        });

        MultiExecutor executor = new MultiExecutor(tasks);
        executor.executeAll();


        Thread.sleep(1500);

        System.out.println("✅ All tasks executed (main thread done).");
    }
}

class MultiExecutor {
    private List<Runnable> tasks;

    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void executeAll() {
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.setName("Worker-" + thread.getId()); 
            thread.setUncaughtExceptionHandler((t, e) -> {
                System.out.println("🚨 Local Handler caught exception in " +
                        t.getName() + ": " + e.getMessage());
            });

            thread.start();
        }
    }
}

// Sec3.3
import java.util.List;

class ThreadTypes {
    public static void main(String[] args) {
        System.out.println("=== Daemon vs User Thread Example ===");
        runDaemonExample();

        System.out.println("\n=== MultiExecutor Example ===");
        runMultiExecutorExample();
    }

    // Daemon and User Threads Ex
    private static void runDaemonExample() {
        Thread userThread = new Thread(() -> {
            System.out.println("User thread is running...");
            try {
                Thread.sleep(2000);
                System.out.println("User thread finished work.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running in background...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); 

        userThread.start();
        daemonThread.start();

        System.out.println("Main method finished (Daemon will stop once User thread ends).");
    }

    // MultiExecutor Ex
    private static void runMultiExecutorExample() {
        List<Runnable> tasks = List.of(
                () -> System.out.println("Task 1 running in " + Thread.currentThread().getName()),
                () -> System.out.println("Task 2 running in " + Thread.currentThread().getName()),
                () -> System.out.println("Task 3 running in " + Thread.currentThread().getName())
        );

        MultiExecutor executor = new MultiExecutor(tasks);
        executor.executeAll();

        System.out.println("All tasks started!");
    }
}

class MultiExecutor {
    private final List<Runnable> tasks;

    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void executeAll() {
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}

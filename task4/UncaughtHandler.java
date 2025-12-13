//sec4.2
class WorkerThread extends Thread {
    public WorkerThread(String name) {
        super(name);
    }
    public void run() {
        System.out.println("Thread started: " + getName());
        int x = 10 / 0; 
        System.out.println("Result: " + x); 
    }
}

public class UncaughtHandler {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread("Custom-Worker-1");

        t1.setUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("Exception in " + thread.getName() + " :");
            System.out.println("  Message: " + exception.getMessage());
            System.out.println("  Handled by Thread-Specific Handler.");
        });

        t1.start();
    }
}
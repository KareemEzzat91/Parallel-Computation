//sec4.3
public class DefaultHandler {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("Global handler caught exception in: " + thread.getName());
            System.out.println("Error: " + exception.getMessage());
        });

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running...");
            throw new RuntimeException("Thread crashed!");
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running...");
            throw new ArithmeticException("Division by zero!");
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
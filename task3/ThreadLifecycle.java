// Sec3.2 - Thread Lifecycle and Thread Group Example

class ThreadLifecycle {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread State Example ===");

        // Thread State Ex
        ThreadStateExample t = new ThreadStateExample("StateThread");

        System.out.println("Before start: " + t.getState()); // NEW
        t.start();
        Thread.sleep(100); 
        System.out.println("After start: " + t.getState());  // RUNNABLE
        t.join();
        System.out.println("After finish: " + t.getState()); // TERMINATED

        System.out.println("\n=== Thread Group Example ===");

        // Group Ex
        ThreadGroup group = new ThreadGroup("MyThreadGroup");

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " running in " +
                    Thread.currentThread().getThreadGroup().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(group, task, "Thread-1");
        Thread t2 = new Thread(group, task, "Thread-2");
        Thread t3 = new Thread(group, task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        // List threads in the group
        group.list();
    }
}

class ThreadStateExample extends Thread {
    public ThreadStateExample(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " state: " + getState());
            Thread.sleep(500);
            System.out.println(getName() + " is running...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

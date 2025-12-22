// Sec3.1 - Thread Naming and Priority Example

class ThreadBasics {
    public static void main(String[] args) {
        // name in the constructor
        Thread t1 = new Thread(() -> {
            System.out.println("Running thread: " + Thread.currentThread().getName());
        }, "ConstructorNamedThread");

        // Changing name after creation using setName()
        Thread t2 = new Thread(() -> {
            System.out.println("Running thread: " + Thread.currentThread().getName());
        });
        t2.setName("SetNameThread");

        // name thread when using Runnable
        Runnable task = () -> System.out.println("Running thread: " + Thread.currentThread().getName());
        Thread t3 = new Thread(task, "RunnableNamedThread");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("\n--- Thread Priority Example ---");
        PriorityThread low = new PriorityThread("LowPriorityThread");
        PriorityThread normal = new PriorityThread("NormalPriorityThread");
        PriorityThread high = new PriorityThread("HighPriorityThread");

        low.setPriority(Thread.MIN_PRIORITY);      // 1
        normal.setPriority(Thread.NORM_PRIORITY);  // 5
        high.setPriority(Thread.MAX_PRIORITY);     // 10

        low.start();
        normal.start();
        high.start();
    }
}

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running with priority " + getPriority());
    }
}

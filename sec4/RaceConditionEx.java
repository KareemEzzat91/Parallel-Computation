// sec4.4
public class RaceConditionEx {

    // المورد المُشترك (Shared resource)
    static int counter = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(new MyTask(), "Thread-1");
        Thread t2 = new Thread(new MyTask(), "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nFinal Counter Value: " + counter + " (Expected: 10)");
    }

    static class MyTask implements Runnable {
        public void run() {
            for (int i = 0; i < 5; i++) {

                int current = counter;

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                
                int updated = current + 1;
                counter = updated;

                System.out.println(Thread.currentThread().getName()
                        + " -> Current: " + current + ", Updated: " + counter);
            }
        }
    }
}
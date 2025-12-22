package sec8;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        // Allow only 3 threads to access the resource concurrently
        Semaphore semaphore = new Semaphore(3);

        semaphore.acquire();
        try {
            // critical section (read/write allowed for limited threads)
            System.out.println("Thread acquired semaphore");
        } finally {
            semaphore.release();
            System.out.println("Thread released semaphore");
        }
    }
}
import java.util.concurrent.locks.ReentrantLock;

public class ReentantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void criticalSection(){
        lock.lock();
        try{
            System.out.println("Executing critical section");
        }finally {
            lock.unlock();
        }
    }

}
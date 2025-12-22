import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionVariableDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Queue<String> queue = new LinkedList<>();

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await(); // Releases lock and waits
            }
            queue.remove();
        } finally {
            lock.unlock();
        }
    }

    public void produce(String item) {
        lock.lock();
        try {
            queue.add(item);
            notEmpty.signal(); // Wakes up one waiting thread
        } finally {
            lock.unlock();
        }
    }
}
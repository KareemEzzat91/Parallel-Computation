import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();

        // Reading (Multiple threads can enter if no write lock is held)
        readLock.lock();
        try {
            // read data code here
            System.out.println("Reading data...");
        } finally {
            readLock.unlock();
        }

        // Writing (Exclusive access)
        writeLock.lock();
        try {
            // write data code here
            System.out.println("Writing data...");
        } finally {
            writeLock.unlock();
        }
    }
}
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public interface Lock {
    void lock();
    void unlock();
    boolean trylock();
    boolean trylock(long time, TimeUnit unit) throws InterruptedException;

    void lockInterruptibly() throws InterruptedException;
    Condition newCondition();

}
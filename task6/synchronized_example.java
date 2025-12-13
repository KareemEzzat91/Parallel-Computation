public class SynchronizedExample {
    private final Object monitor = new Object();

    public void criticalSection(){
        synchronized (monitor){
            System.out.println("Executing critical section");
        }
    }
}
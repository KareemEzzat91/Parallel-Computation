class Counter{
    private int count = 0;
    public synchronized void increment(){
        count++;
    }

    public synchronized int getCount(){
        return count;
    }
}

public class Main_counter {
    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.increment();
        counter.increment();
        counter.increment();

        System.out.println("Count = " + counter.getCount());
    }
}
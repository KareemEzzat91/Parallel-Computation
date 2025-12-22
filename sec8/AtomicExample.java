package sec8;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger X = new AtomicInteger(34);
        int expectedValue = 34;
        int newValue = 99;

        // Compare And Set: If current value is 34, set it to 99
        boolean success = X.compareAndSet(expectedValue, newValue);
        
        System.out.println("Update successful? " + success); // true
        System.out.println("New Value: " + X.get()); // 99
    }
}
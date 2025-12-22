package sec8;
class SharedData {
    volatile boolean flag = false;
}

public class VolatileExample {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        // Thread 1: Updates the flag
        new Thread(() -> {
            data.flag = true;
            System.out.println("Flag changed to true");
        }).start();

        // Thread 2: Reads the flag
        new Thread(() -> {
            // Busy wait until flag becomes true
            while (!data.flag) {
                // If flag wasn't volatile, this loop might run forever due to caching
            }
            System.out.println("Flag updated detected!");
        }).start();
    }
}
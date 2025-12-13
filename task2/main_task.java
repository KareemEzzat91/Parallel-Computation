class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello From MyTask");
    }
}

public class Main_Task {
    public static void main(String[] args) {
        Runnable task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();
    }
}
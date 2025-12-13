class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello From MyThread");
    }
}

public class Main_Thread {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
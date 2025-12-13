// sec4.1
class Worker extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started.");
        try {
            int result = 100 / 0; 
            System.out.println("Result: " + result); 
        } catch (ArithmeticException e) {
            System.out.println(Thread.currentThread().getName() + " caught: " + e.getMessage());
        } catch (Exception e) {
             System.out.println(Thread.currentThread().getName() + " caught general exception: " + e);
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}

public class Try_Catch {
    public static void main(String[] args) {
        Worker t1 = new Worker();
        Worker t2 = new Worker();
        Worker t3 = new Worker();

        t1.setName("Worker-1");
        t2.setName("Worker-2");
        t3.setName("Worker-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
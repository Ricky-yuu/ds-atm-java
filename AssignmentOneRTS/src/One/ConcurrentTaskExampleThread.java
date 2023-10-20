package One;
public class ConcurrentTaskExampleThread {
    public static void main(String[] args) {
        for(int i=0 ; i<10 ; i++) {
            Thread t1 = new Thread(new Task1());
            Thread t2 = new Thread(new Task2());
            Thread t3 = new Thread(new Task3());
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
class Task1 implements Runnable {
    // @Override
    public void run() {
        System.out.println("Task 1");
    }
}
class Task2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 2 is running on thread ");
    }
}
class Task3 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 3 is running on thread ");
    }
}

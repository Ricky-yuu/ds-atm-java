package One;

public class ConcurrentTaskExamplePriority {
    public static void main(String[] args) {
        for(int i=0 ; i<10 ; i++) {
            Thread t1 = new Thread(new Task1());
            t1.setPriority(Thread.MIN_PRIORITY); // set Task1 to lowest priority
            Thread t2 = new Thread(new Task2());
            t2.setPriority(Thread.NORM_PRIORITY); // set Task2 to default priority
            Thread t3 = new Thread(new Task3());
            t3.setPriority(Thread.MAX_PRIORITY); // set Task3 to highest priority
            t1.start();
            t2.start();
            t3.start();
            try {
                t1.join(); // wait for Task1 to complete before starting next iteration
                t2.join(); // wait for Task2 to complete before starting next iteration
                t3.join(); // wait for Task3 to complete before starting next iteration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 1 is running on thread ");
        try {
            Thread.sleep(2000); // simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 2 is running on thread ");
        try {
            Thread.sleep(1000); // simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task3 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 3 is running on thread ");
        try {
            Thread.sleep(1000); // simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

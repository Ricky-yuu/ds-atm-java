package One;
public class PriorityThreadExample {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            try {
                for(int i=0 ; i<10 ; i++) {
                    Thread.sleep(1000);
                    System.out.println("Task 1 is running");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            try {
                for(int i=0 ; i<10 ; i++) {
                    Thread.sleep(1000);
                    System.out.println("Task 2 is running");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task3 = () -> {
            try {
                for(int i=0 ; i<10 ; i++) {
                    Thread.sleep(1000);
                    System.out.println("Task 3 is running");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("All tasks completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

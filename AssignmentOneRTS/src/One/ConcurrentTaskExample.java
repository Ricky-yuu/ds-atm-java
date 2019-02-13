package One;
// Write a Java program to perform execution of at least three concurrent tasks without using thread

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTaskExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        for(int i=0 ; i<10 ; i++) {
          executorService.execute(new Task1());
          executorService.execute(new Task2());
          executorService.execute(new Task3());
        }

        executorService.shutdown();
    }
}

class Task1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 1 is running");
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 2 is running");
    }
}

class Task3 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task 3 is running");
    }
}
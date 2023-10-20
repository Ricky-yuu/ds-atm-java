package Two;

import java.util.ArrayList;
import java.util.Scanner;

public class StopThreadExample {

    public static void main(String[] args) {
        // Create a list to hold the tasks
        ArrayList<Runnable> tasks = new ArrayList<Runnable>();
        tasks.add(new Task("Task 1", 5000));
        tasks.add(new Task("Task 2", 3000));
        tasks.add(new Task("Task 3", 8000));
        
        // Create a list to hold the threads
        ArrayList<Thread> threads = new ArrayList<Thread>();
        
        // Create and start a thread for each task
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }
        
        // Wait for user to press Enter to stop each thread
        Scanner scanner = new Scanner(System.in);
        for (Thread thread : threads) {
            System.out.println("Press Enter to stop " + thread.getName());
            scanner.nextLine();
            thread.interrupt();
        }
        
        System.out.println("All threads stopped.");
    }
    
    private static class Task implements Runnable {
        private String name;
        private int duration;
        
        public Task(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
        
        public void run() {
            System.out.println(name + " started.");
            
            // Simulate some work by sleeping for the specified duration
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted.");
                return;
            }
            
            System.out.println(name + " completed.");
        }
    }
}


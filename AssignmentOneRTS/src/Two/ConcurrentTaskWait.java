package Two;
import java.util.ArrayList;

public class ConcurrentTaskWait {
    
    public static void main(String[] args) {
        ArrayList<Runnable> tasks = new ArrayList<>();
        
        tasks.add(new Task("Task 1"));
        tasks.add(new Task("Task 2"));
        tasks.add(new Task("Task 3"));
        
        // Create threads for each task
        ArrayList<Thread> threads = new ArrayList<>();
        for (Runnable task : tasks) {
            threads.add(new Thread(task));
        }
        
        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }
        
        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("All tasks completed.");
    }
    
    static class Task implements Runnable {
        private final String name;
        private boolean shouldWait = false;
        
        Task(String name) {
            this.name = name;
        }
        
        public void run() {
            System.out.println("Starting task " + name);
            
            synchronized (this) {
                while (shouldWait) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            
            try {
                // Simulate some work
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Completed task " + name);
        }

        public void setShouldWait(boolean shouldWait) {
            synchronized (this) {
                this.shouldWait = shouldWait;
            }
        }

        public boolean getShouldWait() {
            synchronized (this) {
                return shouldWait;
            }
        }

        public String getName() {
            return name;
        }

    }
}

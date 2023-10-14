package One;
import java.util.concurrent.*;

public class ConcurrentTaskExample2 {

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        // Create three Callable tasks
        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Task 1 completed";
        };
        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Task 2 completed";
        };
        Callable<String> task3 = () -> {
            Thread.sleep(3000);
            return "Task 3 completed";
        };
        
        // Submit the tasks to the ExecutorService
        Future<String> future1 = executorService.submit(task1);
        Future<String> future2 = executorService.submit(task2);
        Future<String> future3 = executorService.submit(task3);
        
        // Wait for the tasks to complete and print their results
        try {
            String result1 = future1.get();
            System.out.println(result1);
            String result2 = future2.get();
            System.out.println(result2);
            String result3 = future3.get();
            System.out.println(result3);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // Shutdown the ExecutorService
        executorService.shutdown();
    }
}

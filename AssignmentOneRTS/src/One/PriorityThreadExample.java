package One;
public class PriorityThreadExample {

  public static void main(String[] args) {
      // Create three tasks
      Runnable task1 = () -> {
          try {
              Thread.sleep(2000);
              System.out.println("Task 1 completed");
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      };
      Runnable task2 = () -> {
          try {
              Thread.sleep(1000);
              System.out.println("Task 2 completed");
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      };
      Runnable task3 = () -> {
          try {
              Thread.sleep(3000);
              System.out.println("Task 3 completed");
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      };
      
      // Create threads for each task and set their priorities
      Thread thread1 = new Thread(task1);
      Thread thread2 = new Thread(task2);
      Thread thread3 = new Thread(task3);
      
      thread1.setPriority(Thread.MIN_PRIORITY);
      thread2.setPriority(Thread.NORM_PRIORITY);
      thread3.setPriority(Thread.MAX_PRIORITY);
      
      // Start the threads
      thread1.start();
      thread2.start();
      thread3.start();
      
      // Wait for the threads to complete and display their completion sequence
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

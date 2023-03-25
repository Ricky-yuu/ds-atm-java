public class ThreadJoinExample {
  public static void main(String[] args) {
      Thread thread1 = new Thread(new Task("Task 1"));
      Thread thread2 = new Thread(new Task("Task 2"));
      
      thread1.start();
      thread2.start();
      
      try {
          thread1.join();
          thread2.join();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      
      System.out.println("All tasks completed");
  }
}

class Task implements Runnable {
  private String taskName;
  
  public Task(String name) {
      this.taskName = name;
  }
  
  @Override
  public void run() {
      System.out.println("Task " + taskName + " started");
      try {
          Thread.sleep(1000); // Simulate some work
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      System.out.println("Task " + taskName + " completed");
  }
}

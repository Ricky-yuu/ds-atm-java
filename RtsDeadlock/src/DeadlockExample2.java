public class DeadlockExample2 {
  private Object lock1 = new Object();
  private Object lock2 = new Object();
  
  public void method1() {
      synchronized (lock1) {
          System.out.println("Acquired lock1 in method1");
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          synchronized (lock2) {
              System.out.println("Acquired lock2 in method1");
          }
      }
  }
  
  public void method2() {
      synchronized (lock1) { // changed lock2 to lock1
          System.out.println("Acquired lock1 in method2");
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          synchronized (lock2) {
              System.out.println("Acquired lock2 in method2");
          }
      }
  }
  
  public static void main(String[] args) {
      final DeadlockExample2 obj = new DeadlockExample2();
      
      Thread thread1 = new Thread(new Runnable() {
          @Override
          public void run() {
              obj.method1();
          }
      });
      
      Thread thread2 = new Thread(new Runnable() {
          @Override
          public void run() {
              obj.method2();
          }
      });
      
      thread1.start();
      thread2.start();
  }
}

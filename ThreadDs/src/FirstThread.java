public class FirstThread implements Runnable {
  private Thread secondThread;
  static public void main(String args[]) {
    FirstThread firstThread = new FirstThread();
    firstThread.FirstThread();
  }

  public void FirstThread() {
    secondThread = new Thread(this);
    secondThread.start();
    while (true) {
      System.out.println("FirstThread");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        System.exit(0);
      }
    }
  }
  
  @Override
  public void run() {
    while (true) {
      System.out.println("SecondThread");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        System.exit(0);
      }
    }
  }
}
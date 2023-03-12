public class SecondThread {
  static public void main(String args[]){
    new Thread(new ThreadBody("FirstThread", 800)).start();
    new Thread(new ThreadBody("SecondThread", 1200)).start();
    new Thread(new ThreadBody("ThirdThread", 1600)).start();
  }
}

class ThreadBody implements Runnable {
  private final String passedString;
  private final int passedInterval;
  public ThreadBody(String s, int i) {
    passedString = s;
    passedInterval = i;
  }

  public void run() {
    while(true) {
      System.out.println(passedString + " thread");
      try {
        Thread.sleep(passedInterval);
      } catch (InterruptedException e) {
        e.printStackTrace();
        System.exit(0);
      }
    }
  }
}

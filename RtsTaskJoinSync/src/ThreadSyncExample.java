public class ThreadSyncExample {
    private static int count = 0;
    
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        System.out.println("Final count: " + count);
    }
    
    public static synchronized void increment() {
        count++;
    }
    
    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                increment();
            }
        }
    }
}

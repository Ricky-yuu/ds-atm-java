import java.util.concurrent.locks.*;

public class DiningPhilosophers {
    
    private static final int NUM_PHILOSOPHERS = 5; // jumlah filsuf
    private static final Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
    private static final ReentrantLock[] forks = new ReentrantLock[NUM_PHILOSOPHERS]; // menggunakan reentrant lock untuk mewakili garpu
    
    public static void main(String[] args) {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
        }
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % NUM_PHILOSOPHERS]); // setiap filsuf diinisialisasi dengan dua garpu yang berbeda
            new Thread(philosophers[i]).start(); // menjalankan thread untuk setiap filsuf
        }
    }
    
    // inner class untuk merepresentasikan setiap filsuf
    private static class Philosopher implements Runnable {
        
        private final int id;
        private final ReentrantLock leftFork;
        private final ReentrantLock rightFork;
        
        public Philosopher(int id, ReentrantLock leftFork, ReentrantLock rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }
        
        public void run() {
            try {
                while (true) {
                    // berpikir selama beberapa waktu acak
                    long thinkingTime = (long) (Math.random() * 10000);
                    long eatingTime = (long) (Math.random() * 10000);
                    System.out.println("Philosopher " + id + " is thinking for " +  thinkingTime + " ms.");
                    Thread.sleep(thinkingTime);
                    
                    // mencoba untuk mengambil dua garpu
                    leftFork.lock();
                    System.out.println("Philosopher " + id + " picked up left fork.");
                    rightFork.lock();
                    System.out.println("Philosopher " + id + " picked up right fork.");
                    
                    // makan selama beberapa waktu acak
                    System.out.println("Philosopher " + id + " is eating for " + eatingTime + " ms.");
                    Thread.sleep(eatingTime);
                    
                    // meletakkan kembali dua garpu
                    rightFork.unlock();
                    System.out.println("Philosopher " + id + " put down right fork.");
                    leftFork.unlock();
                    System.out.println("Philosopher " + id + " put down left fork.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

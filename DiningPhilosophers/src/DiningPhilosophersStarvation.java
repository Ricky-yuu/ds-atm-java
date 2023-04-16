import java.util.concurrent.locks.*;

public class DiningPhilosophersStarvation {
    
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
                    // mencoba untuk mengambil dua garpu
                    boolean leftForkTaken = leftFork.tryLock();
                    boolean rightForkTaken = rightFork.tryLock();
                    
                    if (leftForkTaken && rightForkTaken) {
                        System.out.println("Philosopher " + id + " picked up both forks.");
                        
                        // makan selama beberapa waktu acak
                        System.out.println("Philosopher " + id + " is eating.");
                        Thread.sleep((long) (Math.random() * 10000));
                        
                        // meletakkan kembali dua garpu
                        rightFork.unlock();
                        leftFork.unlock();
                        System.out.println("Philosopher " + id + " put down both forks.");
                        
                        // berpikir selama beberapa waktu acak
                        System.out.println("Philosopher " + id + " is thinking.");
                        Thread.sleep((long) (Math.random() * 10000));
                    } else {
                        System.out.println("Philosopher " + id + " couldn't pick up both forks.");
                        Thread.sleep((long) (Math.random() * 1000)); // mengurangi kesempatan untuk kembali mencoba agar tidak mengalami starvation
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

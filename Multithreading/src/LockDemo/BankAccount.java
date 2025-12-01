package LockDemo;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 1000;

    // ReentrantLock implementation (advanced synchronization mechanism)
    // Unlike synchronized, here we explicitly acquire and release the lock.
    private final ReentrantLock rl = new ReentrantLock();

    // If this account object is shared by multiple threads,
    // then without synchronization, balance may become inconsistent.
    // To avoid this, we use ReentrantLock.
    public void withdraw(String threadName, int amount) {
        rl.lock();  // 1️⃣ Acquire the lock before accessing shared resource
        try {
            System.out.println(threadName + " is trying to withdrawl " + amount);
            if (balance >= amount) {
                // Simulating delay → so that thread scheduling issue is visible
                Thread.sleep(2000);

                balance = balance - amount; // Critical section (shared resource update)
                System.out.println("Withdrawal: " + amount + " | Remaining Balance: " + balance);
            } else {
                System.out.println("Insufficient Balance");
            }
        } catch (InterruptedException e) {
            // If thread is interrupted while sleeping
            throw new RuntimeException(e);
        } finally {
            rl.unlock(); // 2️⃣ Always release the lock (even if exception occurs)
        }
    }
}

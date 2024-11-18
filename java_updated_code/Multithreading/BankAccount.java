package Multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            try {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " saying, proceeding with withdrawls.");
                    Thread.sleep(3000);
                    balance -= amount;
                    System.out.println("Balance left " + balance);
                }
                else {
                    System.out.println(Thread.currentThread().getName() + " saying, insufficient balance.");
                }
            } catch (Exception e) {
                System.out.println("Some issue occurred in " + Thread.currentThread().getName() + " ::: " + e);
            }
            finally {
                lock.unlock();
            }
        }
    }

    public int balanceLeft() {
        return balance;
    }
}

/*
Since withdraw() is a sync method, only one thread at a time can be able to access it at a time.
Even though the thread will sleep for 3 sec in between, until the thread is done with the work, the
other threads won't be able to access this method.

However, the issue with this is what if the ongoing thread slept for a longer period of time... then
the other threads won't be able to do their job until this is up and done. So the whole process will
get stuck. Here we have hard coded to make the thread sleep for 3 sec, but what if any internal operation
got stuck, then the thread will keep on waiting until the job is done.

This is where we should be using Explicit locks, to manually control when these kinda situation arrives.

To do so, we will be removing "synchronized"... instead we will use a Lock object.
 */


/*
The withdraw() method with synchronized :::

public synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " saying, proceeding with withdrawls.");
            Thread.sleep(3000);
            balance -= amount;
            System.out.println("Balance left " + balance);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " saying, insufficient balance.");
        }
    }
 */


/*
Explicit lock code :::

public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            try {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " saying, proceeding with withdrawls.");
                    Thread.sleep(3000);
                    balance -= amount;
                    System.out.println("Balance left " + balance);
                }
                else {
                    System.out.println(Thread.currentThread().getName() + " saying, insufficient balance.");
                }
            } catch (Exception e) {
                System.out.println("Some issue occurred in " + Thread.currentThread().getName() + " ::: " + e);
            }
            finally {
                lock.unlock();
            }
        }

Here first, we are using lock.tryLock() method -- which has 2 variants.
if we directly use it without any arguments, then threads will check if lock is there or not. It won't wait.
For the one where we are passing the time in milliseconds, there it will wait for that time to check if
any lock is there or not.
For both the cases, if there isn't any lock it will get inside and access the code. And as the thread is waiting
and if any error occurred, then we need to catch it. Hence, the catch block is added.

In the tryLock() if the thread is not waiting, then this catch block won't be needed. But when it is waiting
for some time, then this catch block is useful to handle if any errors occurred. Because that thread which is
waiting, might get interrupted by another thread which is also checking if any lock is there.

Also, inside the tryLock() block --- we need one try-catch-finally block. Because, the lock which we have
locked, we need to unlock it as well so that other threads can come inside and access the code. So this
finally block is very important to unlock the current lock and current thread will be released.

 */
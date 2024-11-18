package Multithreading;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        // instead of creating a class and extending it to Threads class, here we are
        // creating an anonymous class and implemented Runnable interface. Now using that we
        // will be creating threads.
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    bankAccount.withdraw(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

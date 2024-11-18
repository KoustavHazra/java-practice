package Multithreading;

public class Test1 {
    public static void main(String[] args) {
        World2 world2 = new World2();

        // world.start();  // in case of extending Thread class
        Thread t1 = new Thread(world2);  // in case of implementing Runnable interface
        t1.start();

        for (; ; ) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

/*
Whenever we run a java program, by default a thread will be started to run the main program or the
main method - which is called the main thread.

Also, when the program is finished running we can see "Process finished with exit code 0" --- it means,
that a process of the program ran and, now it is finished. So whenever we run a program, a process of that
program runs.


To create a new thread in java, we can either extend the Thread class or implement the Runnable interface.
 */
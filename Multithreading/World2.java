package Multithreading;

public class World2 implements Runnable {
    @Override
    public void run() {
        for (; ; ) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

/*
Whenever we are extending the Thread class, we should be overriding the run() method.
We need to override this method to define the code which needs to run in the new thread.
After the code is done, we can use the start() method on the object of that class and start
this new thread.

The other way of doing this is implementing Runnable interface. Here also we have to override the
run() method. However, here we cannot directly use the start() method to run the new thread.
Here, we have to explicitly create a thread object and inside it, we have to pass the object
of this class. And then we can use the start() method on that object of that thread.
 */


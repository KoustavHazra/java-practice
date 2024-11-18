package Multithreading;

public class MyThread3 extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
        // pausing the t1 thread for 2 seconds
        try {
            Thread.sleep(2000);

            // after sleep, it is again in RUNNABLE state
            System.out.println(this.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // main thread
        System.out.println(Thread.currentThread().getName());
        // creating a new thread
        MyThread3 t1 = new MyThread3();
        System.out.println(t1.getState());  // NEW state
        t1.start();
        System.out.println(t1.getState());  // RUNNABLE state

        // pausing main thread for 2 mill seconds, to execute the t1 thread explicitly
        Thread.sleep(200);
        // since main thread is asleep, run() method of t1 will run.

        // when run() is executing, t1 thread will go to sleep for 2 sec, checking the state of t1 thread
        System.out.println(t1.getState());  // TIMED_WAITING

        // since t1 is asleep for 2 sec, main thread should wait for it to arise again.
        t1.join();  // .join() is performed on t1 thread, so that main thread awaits for it to be finished.
        // since t1 is ultimately run by main thread, main will wait for it to be finished.

        // after the join(), t1 will be terminated.
        System.out.println(t1.getState());  // TERMINATED

    }
}

/*
Thread lifecycle ::
The lifecycle of a thread in java, can consist of several states, which a thread can move through
during its execution.

1. New: In this state a thread is created, but not yet started.
2. Runnable: After this method is called, the thread becomes runnable. It is ready to run and waiting for
            CPU time.  ---  this means, either the thread is ready to execute or being executed.
3. Running: This is the state when a thread is being executed.  --- this does not exist inside java.
4. Blocked/ Waiting: A thread stays in this state when it is waiting for some resource to arrive, or
                        waiting for another thread to perform an action.
5. Timed_Waiting: When a thread is asleep, then this is the state of a thread.
5. Terminated: It is the state when the thread has finished executing.
 */


/*
in the run() method (which we are overriding), while pausing the t1, we used try-catch to handle the
InterruptedException. However, in main method, we are directly using "throws InterruptedException" ... why?

Because in the run() method, since we are overriding it... the actual method doesn't have it (the
throws InterruptedException ) part in it. So we cannot use that in run() method. Thus manually, we have
to add the try-catch block to handle the exception.

But in case of main method, this issue is not there. Thus, we can do both - either use a try-catch block
or use "throws InterruptedException".


 */
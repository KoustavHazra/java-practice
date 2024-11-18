package Multithreading;

public class MyThread4 extends Thread {
    // giving a name for our thread t1 -- using a constructor of this class, which will call the
    // constructor of the Thread class.
    public MyThread4(String name) {
        super(name);
    }

    @Override
    public void run() {
        // whatever we code here, will be executed by t1 thread
        System.out.println("Running... " + Thread.currentThread().getName());
//        for (int i = 0; i < 5; i++) {
//            String a = "";
//            for (int j = 0; j < 100000; j++) {
//                a += "a";
//            }
//            System.out.println(Thread.currentThread().getName() + " - Priority "
//                    + Thread.currentThread().getPriority() + " - count " +
//                    i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            System.out.println("Error occurred :: " + e);
//        }

//        for (int i = 0; i < 5; i++) {
//            System.out.println(Thread.currentThread().getName() + " is running.");
//            // this is to let the scheduler know that after every iteration, give a chance
//            // to run the other thread, so that both runs simultaneously.
//            Thread.yield();
//        }

//        while (true) {
//            System.out.println("still running");
//        }



    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread4 t1 = new MyThread4("low priority thread");
//        MyThread4 t2 = new MyThread4("mid priority thread");
//        MyThread4 t3 = new MyThread4("max priority thread");
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.NORM_PRIORITY);
//        t3.setPriority(Thread.MAX_PRIORITY);
//        t1.start();
//        t2.start();
//        t3.start();


//        t1.start();
        // by using this, main thread can interrupt this method and stop it's ongoing process
//        t1.interrupt();

//        MyThread4 t1 = new MyThread4("thread 1");
//        MyThread4 t2 = new MyThread4("thread 2");
//        t1.start();
//        t2.start();


        // Daemon thread -- a thread which runs in the background (like garbage collector)
        // this is not like the user thread, which we use to complete some tasks.
        // unlike user thread, jvm or main thread doesn't stop for it get over.
        // we can make a user thread into a daemon thread, which we can check if runs
        // or not, when the main thread is over executing.
//        MyThread4 t1 = new MyThread4("daemon");
//        t1.setDaemon(true);  // setting the user thread as a daemon thread
//        t1.start();
        // stopping main thread for 1 sec, so that t1 starts running
//        Thread.sleep(1000);
//        System.out.println("main thread over");
        // and we can see, when jvm sees that main thread is over, it stops the daemon
        // thread, even though it was in an infinite loop.

    }
}

/*
Thread methods::
.start()
.run()
.sleep()
.join()
.setPriority()
.interrupt()
.yield()
.setDaemon()

 */


/*

// Daemon thread -- a thread which runs in the background (like garbage collector)
// this is not like the user thread, which we use to complete some tasks.
// unlike user thread, jvm or main thread doesn't stop for it get over.
// we can make a user thread into a daemon thread, which we can check if runs
// or not, when the main thread is over executing.
        MyThread4 t1 = new MyThread4("daemon");
        t1.setDaemon(true);  // setting the user thread as a daemon thread

// here if we start one more user thread and run this,
        MyThread4 t2 = new MyThread4();
        t2.start();

// since, t2 is running an infinite loop, main thread will never reach t1.. thus it
// won't start. Thus, the program never ends.

        t1.start();
// stopping main thread for 1 sec, so that t1 starts running
        Thread.sleep(1000);
        System.out.println("main thread over");
// and we can see, when jvm sees that main thread is over, it stops the daemon
// thread, even though it was in an infinite loop.
 */
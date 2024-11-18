package Multithreading;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();
        MyThread5 t1 = new MyThread5(count);
        MyThread5 t2 = new MyThread5(count);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Total count is " + count.getCount());
        // the output here is always random. Which is because there is a single object, count.
        // And that single object is accessed by two different threads. Both are trying
        // to increase the count of the counter object. So by this, the total count should
        // always be 2000 (since both threads are going to increase the count by 1000).
        // But that is not the case.

        // What is happening here is because the same resource (same object) is being used
        // by two different threads, and in some of the cases both the threads trying to
        // increase the count simultaneously, and thus in some of the cases only one of the
        // thread is able to increase the value... hence this random results.

        // These phenomena, when two threads sharing the same resource and trying
        // to the same task simultaneously - is called race condition. Because both
        // the threads starts a racing situation, where both are tying to achieve something
        // before the other one. The relative timing of the threads were miss matching,
        // and since threads are running concurrently, the result becomes unpredictable.

        // To stop this, we can use a keyword in that increment() method -- "synchronized".
        // And because of this the race condition won't occur, and when one thread is trying
        // to use the same resource, the other one will wait for it to be done.

        // that prt of the code, where a shared resource is getting accessed or modified by
        // two different threads (here it is the increment() method of Counter class) ---
        // is called a critical section. These are the part of the code, where we should be
        // using the "synchronized" keyword. And when because of using
        // "synchronized" in a section of the code, which is only getting accessed / modified
        // by one thread at a time is called Mutual Exclusion.
    }

}

/*
LOCKING ::

When we use synchronized in our code, only one thread can access that part of the code at a time. While
one thread is accessing that part of the code, the other threads won't be able to, and it happens because
of Locking.

There are 2 types of locking: Intrinsic and Explicit.

Intrinsic --- These are built-in locks which is available in every object in Java. We don't see them, but they
                are available. When we use synchronized, these are the locks we are using.
Explicit --- These are manual locks, basically we have control over it. This is available in
                java.util.concurrent.locks package. Using this we can explicitly control when to lock or
                unlock the critical section part of our code.


 */
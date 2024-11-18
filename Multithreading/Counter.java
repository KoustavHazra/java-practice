package Multithreading;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

/*
Either we can make an entire method "synchronized" or we can make a sync block
inside a method, and tha part alone will be synchronized and will stop from
occurring race condition. Like this:

public void increment() {
    synchronized(this) {
        count++;
    }
 }

In this block, whatever code we will write, will be synchronized. We passed the "this" and
because of that, only one (current) instance will be able to go through that part of the code.

 */
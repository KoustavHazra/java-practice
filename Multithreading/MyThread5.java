package Multithreading;

public class MyThread5 extends Thread {
    private Counter counter;

    // injecting the counter object as a parameterized constructor inside the class (whenever an object is created)
    public MyThread5(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

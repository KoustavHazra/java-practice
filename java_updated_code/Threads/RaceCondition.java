package Threads;

class Counter {
    int count;
    public synchronized void increment() {
        count++;
    }
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter();

        Runnable obj1 = () -> {
            for (int i = 0; i < 1000; i++) {
                c1.increment();
            }
        };

        Runnable obj2 = () -> {
            for (int i = 0; i < 1000; i++) {
                c1.increment();
            }
        };

        Thread th1 = new Thread(obj1);
        Thread th2 = new Thread(obj2);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(c1.count);
    }
}

/*
Race condition is when multiple threads are trying to access one same value and actually changing it.

Here we have a counter class, and everytime we call a method from the class the count variable is updated.
And here both our threads are calling the same class at the same time. Thus, every time we are trying to
print the count, it is printing a different value or sometime it will always come 0.

Although both the threads are running for 1000 + 1000 = 2000 times, the output is different everytime.
It is because, when both the threads are started and, they are executing, main() doesn't have anything to
do anything, so it goes and prints the value of c1.count. And by the time it is printing the value, some
number of execution was done by the threads and that is the count we can see. That is why it is different
every time or sometime it will always come 0.

So we should tell main() to stop until the threads are done executing and then only print the c1.count.
To do so, we can use .join() method on both the threads, and also use the Interrupted exception with it
so that it doesn't throw error.

Once again, even though we are using the .join() we can still get random values sometimes because both the
threads are trying to access the same variable and change its value. Now when both tries to do the same thing
at the same time, only one value will be updated, hence the other one is lost. And that is why we are not able
to reach the total count of 2000 within 2000 iterations. If we increase the number of iterations by 10k and 10k,
the difference will be even more.

That is why we need to make the change in count thread safe, which means that value can be accessed by only
one thread at a time.
To do so, we just need to add the "synchronized" keyword with the method declaration. And it won't get
affected my multiple threads anymore.

Now all the time, we will get the count as 2000.


-------------------------------------------



Thread states ::

In life cycle of a thread, we have different states -- New, Runnable, Running, Waiting, and Dead.

New -- Thread th1 = new Thread(obj1);
Runnable -- th1.start();
Waiting -- th1.sleep(10);  ||   th1.wait();
Dead -- th1.stop();


Runnable is when the thread is executing or waiting for the scheduler (in waiting state).

Running is when it is actually running in the CPU; when thread is running with run() method, it is
in Running state.


sleep() will make the thread wait for the given time and again start running after that time.
wait() will make the thread wait for the given time and after that it will make the thread into Runnable
state, instead of running it again.
Also, while using wait() , we have to use th1.notify() to bring it to Runnable state, otherwise it will
go to the Running state.

 */

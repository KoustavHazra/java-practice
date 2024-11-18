package Threads;

public class LearnThreads {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

        C obj3 = new C();
        D obj4 = new D();

        // here first obj1 is executed, and then obj2
        // obj1.show();
        // obj2.show();

        // we want to run the object methods simultaneously - in parallel
        // obj3.start();
        // obj4.start();
        // they are been executed in parallel - but we can do more here.
        // we can check the priority on a thread .
        System.out.println(obj3.getPriority());

        // set our own priority on threads
        obj3.setPriority(Thread.MIN_PRIORITY);
        obj4.setPriority(10);  // if we put any number 1 < or > 10, it will throw a run-time error.
        System.out.println(obj3.getPriority());
        // obj3.start();
        // obj4.start();

        E obj5 = new E();
        // obj5.start();  // start we cannot use since we are not extending Thread
        Thread th = new Thread(obj5);
        // th.start();

        // anonymous class
        Runnable obj10 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("make way for ");
                    try { Thread.sleep(10);}
                    catch (InterruptedException e) {throw new RuntimeException(e); }
                }
            }
        };

        // since Runnable is a functional interface, we can create lambda expression to create the object
        Runnable obj11 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Noddy !!");
                try { Thread.sleep(10);}
                catch (InterruptedException e) {throw new RuntimeException(e); }
            }
        };

        Thread th1 = new Thread(obj10);
        Thread th2 = new Thread(obj11);
        th1.setPriority(1);
        th2.setPriority(10);
        th1.start();
        th2.start();

    }
}

class A {
    public void show() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Ola !!");
        }
    }
}

class B {
    public void show() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello !!");
        }
    }
}

class C extends Thread {
    // any class which is extending Thread, should have a method name "run"
    // because to start that class's object as a thread, we must run this command: obj.start()
    // and internally in the start() method, this "run" method will be triggered.
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Ola !!");
            try { Thread.sleep(10);}
            catch (InterruptedException e) {throw new RuntimeException(e); }
        }
    }
}

class D extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello !!");
            try { Thread.sleep(10);}
            catch (InterruptedException e) {throw new RuntimeException(e); }
        }
    }
}

class E extends A implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello Hello !!");
            try { Thread.sleep(10);}
            catch (InterruptedException e) {throw new RuntimeException(e); }
        }
    }
}


/*

When we check thread priority, we run this code:  System.out.println(obj3.getPriority());

Now the priority varies from 1 to 10, where 1 being the lowest priority and 10 being the highest
priority.
Priority of 5 is usually default, which every thread will get.

To change or set priority for a thread we can use setPriority() and we can manipulate the code
as we want it to run.
We can use it like:  obj3.setPriority(1);
or obj3.setPriority(Tread.MAX_PRIORITY);  ---  these are available values in Thread class which we can use.

--------------------------

Scheduler is something which actually runs these threads simultaneously, based on the priority. However,
not only priority is checked, but also sometimes it checks which methods is taking more time to execute,
or other scenarios.


When we write this code, obj3.setPriority(Tread.MAX_PRIORITY); -- we are just telling scheduler to give this
thread the most priority. But, it's not like scheduler is actually going to give that priority.
Different scheduler has different algorithm, and based on them and based on how much a take is taking time,
it will decide when to give priority to which task.

---------------------------

Here on our above example, even though we have mentioned obj3 with the lowest priority and obj4 as highest,
still parallel the methods are running. And if we really want to control this flow, we can add a method
called sleep, where we can mention for how many milliseconds we want to stop the thread after executing once.

About the sleep() method, it actually throws Interrupted exception, so we should keep it inside a try-catch
block.
As a programmer, we can only optimize the threads, we cannot actually control it.
---------------------------

Sometimes we have a child class which we need to extend with a Thread, but it has to extend a parent
class as well, there we cannot do that since Java doesn't supports multiple inheritance.

So actually instead of extending Thread class, we can implement an interface named Runnable. If we go
inside the Thread class, it is also implementing the same Runnable class and with this class only that
Run() method is there. Also, here the start() won't work, since we are not extending the Thread class.

There is actually another option. Inside the Thread class, there is one constructor which can take
a runnable object inside it. So if we pass a runnable object inside it, then on that object the start()
will work.

But is the object we will be creating a runnable object, yes. When our class is implementing the Runnable
interface, we can actually create the object like this::  Runnable obj = new ClassName();
or we can write like this also,  ClassName obj = new ClassName();
--- both will work.

And then we can create a Thread object while passing this Runnable obj inside it::
Thread th = new Thread(obj)

And now on this th, we can use the start() and it will run the "run()" method.


So now we can extend the parent class while implementing the Runnable interface.

---------------------------

We can implement the threads directly using an anonymous class as well, which will directly implement
the Runnable class.
 */
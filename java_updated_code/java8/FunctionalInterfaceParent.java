package java8;

// annotation to show it is a functional interface (optional, but if more than
// one abstract method is written or no abstract method is written, it will throw compile error.)
@java.lang.FunctionalInterface
public interface FunctionalInterfaceParent {
    // single abstract method
    public void sayHello();

    // default method
    default void bye() {};
    // will throw error if there is no function body

    // static method
    public static void okay() {};
}

interface Baap {
    // void oye() {};
    default void oye() {
        System.out.println("oye");
    }
}

class Beta implements Baap {

}

interface A {
    default void ohio() {
        System.out.println("ohio");
    }
}

interface B {
    default void ohio() {
        System.out.println("ohio");
    }
}

class Check implements A, B {
    @Override
    public void ohio() {
        A.super.ohio();
    }
}


/*
Abstract method --- An abstract method is a method, which doesn't have a body.

What is functional interface --- A functional interface is an interface which have exactly one abstract method,
                                    but can have any number of default and static methods.
                                    If we have more than one abstract method or no abstract method at all,
                                    then it won't be called a functional interface.
                                    Before java 8, only public abstract methods were allowed inside an interface.
                                    After java 8, default and static methods are also allowed.
                                    We can invoke lambda expression by using functional interface.


What's the advantage of @FunctionalInterface annotation:
- It restricts the interface to be a functional interface. So if people have already used lambda expressions or
any new abstract method is added (after the single one), or if there is no abstract method at all - it will throw
error.


How to use lambda expression using functional interface:
- We use inheritance in functional interface.
Let's say there is a parent functional interface, and there one abstract method within it.
Now we have another interface child which extends the parent interface. And because of that, child is also
a functional interface. To check if child is a functional interface, we can just use the @FunctionalInterface
on top of it and check.
However, if we create a new abstract method inside the child interface, then it isn't a functional interface anymore.
Also, if we add the same abstract method which is inside the parent interface, then also child won't be a
functional interface anymore.
And in child if we add any number of default or static methods, then it is fine, it is still a functional interface.


-------------------

Default methods inside functional interface:
- Till java 1.7, only public abstract methods were allowed inside an interface.
But after java 8, we can have concrete methods as well - a method with a body.
For interface Baap, if we create a method without the "default" modifier, then it will throw error because
it will think of it as an abstract method, which shouldn't have a body.
Now if we implement the Baap interface on a Beta class, and create an object of Beta, then that method
which was present inside the Baap, can be used by the object of Beta. We can also override the method of
Baap inside Beta and use it - as per our usage.

But let's say in Baap the method was printing "hello" and we override it inside Beta and now inside Beta
it prints "Hi", and we create a parent object with child class like this:
    Parent p = new Child();
Then here also if we use the method, then the child overridden method will run and print "Hi".

And if we do this:
    Parent p = new Parent(); --- it won't work since parent is an interface, we can't create objects of
an interface.



-------------------

interface A {
    default void ohio() {
        System.out.println("ohio");
    }
}

interface B {
    default void ohio() {
        System.out.println("ohio");
    }
}

class Check implements A, B {}

For something like this, if a class implements two interfaces and both the interface have an exact same
method inside them, then while implementing it will throw error. Because when we are going to create an object
of the class and use the method (which is exactly same in both the interfaces including the number and type of
arguments, the type of return), then it will throw error cause of ambiguity. As compiler is unable to detect
which one of the method to use since both are same.

We can use it using super() keyword like this ---- A.super.ohio(); or B.super.ohio(); in the class which is
implementing both the interfaces. Like this:

class Check implements A, B {
    @Override
    public void ohio() {
        A.super.ohio();  // method from interface A will run
        B.super.ohio();  // method from interface B will run
        System.out.print("konnichiwa");  // a new output will be printed instead of A or B
    }
}


 */
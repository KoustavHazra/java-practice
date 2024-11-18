package oops4;

public class LearnAnonymousClass {

    public static void main(String[] args) {
        // lambda expression
        MyFunctionalInterface object = () -> {
            // now here we can implement the myMethod within this.
            System.out.println("lambda expression working");
        };
        object.myMethod();
        Walkable object2 = (int steps) -> 2 * steps;
        int op = object2.walks(4);
        System.out.println(op);
    }

    // creating an anonymous class of OuterClassOne
    OuterClassOne obj = new OuterClassOne() {
        // now this is an anonymous class - we can add methods and fields in it
        void sing() {

        }

        int number = 19;

        // override the outerMethod()
        @Override
        public void outerMethod() {
            System.out.println("override is possible in anonymous class");
        }

    };

    OuterClass obj2 = new OuterClass() {
        // another anonymous class
    };


    // we can do the same with interface as well
    SuperInterface int1 = new SuperInterface() {
        @Override
        public void helloMethod() {
            System.out.println("new body hahaha");
        }
    };
}

class OuterClassOne {
    public void outerMethod() {
        System.out.println("outer method");
    }
}

interface SuperInterface {
    void helloMethod();
}

// functional interface
@FunctionalInterface
interface MyFunctionalInterface {  // only one method
    void myMethod();
}

@FunctionalInterface
interface Walkable {  // only one method
    int walks(int steps);
}

/*

anonymous class ::
In Java, an anonymous class is a class without a name that is defined and instantiated
in a single step. Anonymous classes are useful when you need to create a class that
implements an interface or extends a class and is used only once.

We can only create an anonymous class when we are creating a subclass inside an outer class or if we are
creating a class while extending from a parent class, then also we can make the child an anonymous class.


Functional interface ::
In Java, a functional interface is an interface that contains only one abstract method.
Functional interfaces are also known as SAM (Single Abstract Method) interfaces.

Functional interfaces are important in Java because they can be used with lambda expressions,
which provide a concise way to implement the abstract method of the interface.


*/
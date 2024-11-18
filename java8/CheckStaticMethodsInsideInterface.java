package java8;

public class CheckStaticMethodsInsideInterface implements C {
    public static void main(String[] args) {
        CheckStaticMethodsInsideInterface obj = new CheckStaticMethodsInsideInterface();
        // obj.ohio();
        C.ohio();
    }
}

interface C {
    static void ohio() {
        // will throw error if there is no function body
        System.out.println("ohio!!");
    }
}

/*
In the same package, we have 2 different class. But we cannot create 2 interfaces with same name in different
class. If interface A exists in class A, then in class B interface A cannot exist.

Static methods:
- Methods which are defined with the static keyword.
Like default methods, static methods also have the complete body of the method inside the functional interface.
Static methods cannot be overridden in the implementation class.

If a class implements an interface and that interface has a static method, then any object of that class
cannot access the static methods. Only way to use those static methods which is inside an interface, is using
the interface name.
So for interface C, it will be:
    C.ohio();

However, the default methods inside an interface can be called using object reference of a class which implements
that interface.

Because of this behavior of implementation class (which is implementing an interface) that it is unable to access
the static method of the interface, if we try to override that static method inside the implementation class -
it won't throw error. Because for that class, that static method inside the interface doesn't even exist.
So here the override will not work, and it will be like creating a new method. That's why we should not call it
overriding a static method from an interface.
This is like a new implementation of a new method - we can change the modifier, make it non-static or add arguments
-- nothing will throw error.



One more thing is inside an interface, we can actually call a main method also. So if we create an interface, and
inside it, we run "public static void main () {}" -- it will run. It is also a java 8 feature.


 */
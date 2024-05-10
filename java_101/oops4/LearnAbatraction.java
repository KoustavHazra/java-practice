package oops4;

public class LearnAbatraction {
    public static void main(String[] args) {
//        Vehicle v1 = new Vehicle();  // 'Vehicle' is abstract; cannot be instantiated
        Car c1 = new Car();
        c1.accelerate();
        c1.brake(4);
        c1.honks();
    }
}

// abstract class
abstract class Vehicle {
    // abstract method
    abstract void accelerate(); // Abstract methods cannot have a body
    abstract int brake(int wheels);

    // non-abstract method
    void honks() {
        System.out.println("honka honka :>");
    }
    // as it is a non-abstract method, we need to define its body
    // also it's not mandatory to define or override this method in the child classes,
    // since it is not an abstract method
}

// child of the abstract class
class Car extends Vehicle {
    // since it is a child class of an abstract class, then either it has to implement all the abstract
    // method of the parent class, or declare it as an abstract class - otherwise it will throw error.
    // if we define it as an abstract class, then it will also be just like another abstract class, where
    // we don't need to code any method, we can just declare it.

    @Override  // it is an annotation that we are overriding this next method from parent class
    // if we write this same annotation above a new method which was never created in a parent, it will throw error
    void accelerate() {
        System.out.println("car is moving.");
    }

    @Override
    int brake(int wheels) {
        System.out.println("car needs to break");
        return wheels;
    }
    // now these methods we can use normally by crating an object of Car class.
    // so basically we use abstract class when

}

/*

Java Abstract class ::

In Java, abstract classes serve as templates for concrete subclasses. While we can't
instantiate an abstract class directly or define concrete methods within it, abstract
classes provide a way to define common behavior and enforce a structure for subclasses to follow.

Normal classes can achieve many of the same goals as abstract classes, however, abstract classes offer
specific advantages in terms of enforcing structure, promoting code reusability, enabling polymorphism,
and facilitating future extensibility. They are particularly useful in scenarios where we
want to define a common interface or structure for a group of related classes.

1. enforcing a proper structure
2. code reusability
3.  polymorphism - Abstract classes can be used in polymorphic scenarios, where a reference to
        an abstract class can point to an instance of a subclass. This allows for flexibility
        in designing and using class hierarchies.
4. future extensibility - abstract classes can be helpful when we anticipate that the class hierarchy
        might change or new functionality might be added in the future. By providing a structure through
        abstract classes, we can make it easier to extend and modify the hierarchy later on.

A method which doesn't have a body is an abstract method. Also, if there is a normal class within which
we want to define an abstract method, it will throw error - because to create an abstract method, that
class also needs to be an abstract class.

---------------------------------------------------------------------------------------------------------------

Java abstraction ::

abstraction is an important concept of oops that allows us to hide unnecessary details and only show the
needed ones. This helps in managing complexity by hiding details with a simple, higher-level data.

---------------------------------------------------------------------------------------------------------------

Java Interfaces ::

An interface is a fully abstract class. It includes a group of abstract methods( methods without body ).
Like abstract classes we cannot create objects of interfaces. To use an interface, other classes must implement
it. We use the "implements" keyword to implement an interface.

One big difference here in interface and class is - in class multiple inheritance is not allowed in java ( one class
cannot inherit from more than one parent class ), whereas in case of interfaces it is possible ( one class can
inherit from more than one interfaces ).
*/

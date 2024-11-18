package MemoryInJava;

import java.util.Objects;

public class LearnObjectClass {
    public static void main(String[] args) {
        Car car = new Car("BMW", 4);
        Car car2 = new Car("BMW", 4);
//        System.out.println(car.toString());  // toString() is a default method, while printing an object
        // even if we don't use it, it will be used.

        // toString is override
        System.out.println(car);
        System.out.println(car.toString());  // as toString is default and we have overridden it,
        // with it or without using it, the same value we created is returned.


        // compare two objects
//        System.out.println(car.equals(car2));  // false, as stored in different memory location

        // equals is overridden
        System.out.println(car.equals(car2));  // returns true


        // hashcode, a unique id - if two classes are same (using equals) then hashcode will also be same
        System.out.println(car.hashCode());
        System.out.println(car2.hashCode());  // here it is not

    }
}

class Car {
    int wheels;
    String model;

    void runs() {
        System.out.println("vroom vroom");
    }

    public Car(String model, int wheels) {
        this.model = model;
        this.wheels = wheels;
    }

    // overriding toString()
    @Override
    public String toString() {
        return "Car model is " + model + " with " + wheels + " wheels.";
    }

    @Override
    public boolean equals(Object obj) {
        Car that = (Car)obj;
        if (Objects.equals(this.model, that.model) && this.wheels == that.wheels) {
            return true;
        }
        return false;
    }

}


/*

Object Class ::

Object class is present in java.lang package. Every class in java is directly or indirectly derived from
Object class. If a class does not extend any other class, then it is a direct child of the Object class, and
if extends (means a child class of another class) then it is indirectly derived from Object class. That's why
when we create an object of a class, beside our own fields and methods we can see there are some extra methods
available, which actually comes from the Object class.

Object class acts as a root of the inheritance hierarchy in any java program.

-------------------------------------------------------------------------------------------------------------

Polymorphism ::

Polymorphism allows to perform a single action in different ways. In java, it helps by defining one interface
and having multiple implementation.

2 types of polymorphism --
1. compile-time polymorphism
2. runtime polymorphism

Method overriding is an example of runtime polymorphism, as methods which are created in a parent class
we can override them in child class and through this what we achieve is runtime polymorphism.
Method overriding is called runtime polymorphism.

Method overloading is an example of compile time polymorphism. Here when we have multiple methods of same name,
but all of them will have different number and datatype of params. Each of them must have a unique param, which
the others' doesn't, otherwise it will throw error.
So method overloading is called compile time polymorphism.
*/
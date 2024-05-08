package inheritance.oops2;

public class Vehicle {
    int wheelCount;

    void Start() {  // a parent class
        System.out.println("vehicle started.");
    }

    // constructor
    Vehicle() {
        System.out.println("creating a vehicle instance");
    }

    // parameterized constructor
    Vehicle(int wheelCount) {
        this.wheelCount = wheelCount;
        System.out.println("Vehicle with " + wheelCount + " wheels is getting created.");
    }

    final int gears = 5; // final variable
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
    }

    // final method  --  we can use it, but we cannot override it from child class
    final void Acclerate() {
        System.out.println("speeding things up");
    }

}



/*

Java Inheritance ::

Inheritance is one of the key features in OOP that allows us to create new class from the existing
class.
The new class that is created using an existing class, is called a child class.
And the existing class is called a super class( parent class ).

While inheriting from parent to child, in java,
one parent can have multiple child class, but one child class can have only one parent class.
if one parent has 2 or more child, then it is called hierarchical inheritance.
So in java we have multi-level inheritance, but multiple inheritance is not available.



*/

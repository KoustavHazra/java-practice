package oops1;

public class LearnConstructors {
    public static void main(String[] args) {
        ComplexNumber obj1 = new ComplexNumber(2, 4);
        System.out.println(obj1);
        ComplexNumber obj2 = new ComplexNumber(4, 6);
        ComplexNumber result = obj1.add(obj2);
        System.out.println("adding both the complex numbers -- ");
        result.print();
    }
}

class ComplexNumber {
    int a, b;

    // how default constructor looks like
//    public ComplexNumber() {
//        a = 0;
//        b = 0;
//    }
    // it will create an object with these default values of a and b here.


    // user defined constructor
//    public ComplexNumber() {
//        a = 8;
//        b = 15;
//    }
    // now as we have created our own constructor, this is the one which will be called while creating an
    // object, and as we can see, that object will always be created these a = 8 and b = 15 values.
    // this basically changes the default behaviour of constructor, and it is known as overriding the constructor.

    // not only this, we can also pass values while calling the constructor.
    public ComplexNumber(int real, int imaginary) {
        a = real;
        b = imaginary;
    }
    // now everytime we create an object, we can directly create it with our own values.

    // as we know we can overload a constructor ---
    public ComplexNumber(int real) {
        a = real;
        b = 4;
    }

    void print() {
        System.out.println(a + " + " + b + "i");
    }

    //    creating a method of complex number return type
    ComplexNumber add(ComplexNumber num2) {
        print();  // prints current object, here we called add() on obj1, so obj1 will be printed.
        this.print();  // does the same job as above, but its more clear about what value it is going to print
        System.out.println(this);  // this stores the reference of the current object, here it is obj1
        // that's why if in main() we print obj1 and here we print "this", both will print the same ref value.

        num2.print();  // prints the object passed as argument, here we passed obj2 as num2 in add()
        return new ComplexNumber(a + num2.a, b + num2.b);
    }
}

/*

Constructors ::
1. Constructors are invoked implicitly when we instantiate a new object.
2. The 2 rules to create a constructor are --
    1. the name of the constructor should be the same as the class.
    2. a java constructor must not have a return type.
3. If a class doesn't have a constructor, the java compiler automatically creates a default constructor during
run-time. The default constructor initializes instance variables with default values.
4. Default constructor - it is a constructor which is automatically created by java compiler, if it is not explicitly
defined.
5. A constructor cannot be abstract or static or final.
6. A constructor can be overloaded but cannot be overridden.

when we are writing, ComplexNumber obj1 = new ComplexNumber(); --- here ComplexNumber() is the default constructor.
It is being called as a function, but constructors are not a function.
new ComplexNumber() means, in runtime java automatically called the default constructor ( ComplexNumber() ) to create
an instance of the class.
However, we can create our own constructor as well. Again, it doesn't have any return type.


This ::
In java, this keyword is used to refer to the current object inside a method or a constructor.
Let's say in this case:

int a, b;
public ComplexNumber(int real, int imaginary) {
        a = real;
        b = imaginary;
    }

we wanted to write the param name as a, b -- then it will not be able to understand which is which a and b.
Because java wouldn't know how to access the current object's a and b. And this is where "this" is used, it helps
to address the current object's values.

so here it will be like:
int a, b;
public ComplexNumber(int a, int b) {
        this.a = a;
        this.b = b;
    }

this.a == current object's a
this.b == current object's b

we can also use "this" to invoke the method of the current class or to invoke the constructor of the current class.
So current class's method also we can invoke into another method of the same class.
Basically, we can call the print() method inside the add() method of the ComplexNumber class.


*/
package encapsulation.oops3.learnPackage;


public class LearnEncapsulation {
    static {
        System.out.println("first static block");
    }
    public static void main(String[] args) {
        Teacher obj = new Teacher();
        obj.teachingClass = 12;  // public, so accessible in outer class
//        obj.id = 124; // private, so inaccessible in outer class

        Person obj1 = new Person();
        obj1.setAge(12);  // set the value of age
        System.out.println(obj1.getAge());

        // using static field
        System.out.println(obj1.count);  // using object
        System.out.println(Person.count);  // using class name
//        Person.count = 30;  // it's like the changes done will be showing globally
        Person newObj = new Person();
        System.out.println(obj1.count);
        System.out.println(newObj.count);

        System.out.println(Math.PI);
    }

    static {
        System.out.println("second static block");
    }

}

/*

Packages in java ::

A package is just like a container that groups related types ( java classes, interfaces, enumerations,
and annotations ).
To define package in java, we use the keyword "package". Java uses system directories to store packages.

Packages are like folders, but they provide lot more stuff than just a folder - which is encapsulation.

Now if we have multiple packages, then we can import them from one package to another. For that we use
the keyword "import" and all the available classes within that package will be imported.

Anytime we import a library in java, like a List library so that we can use all the List props and methods,
this is exactly what we do - we import the List package ( import java.util.List; ).
Not only we can import the whole List package, we can also import some particular methods from that package,
basically we use it to keep our code more clear, readable and easy to maintain. Also, it will improve compilation
time and reduce memory usage.

importing all the classes within a package :  import java.io.*;
importing only the necessary classes within a package :  import java.util.List;

---------------------------------------------------------------------------------------------------------

Access Modifiers ::

In java, access modifiers are something which keeps a track of all the props and methods in a class is
public or private.
So basically this is used to set the accessibility of classes, interfaces, variables, methods, constructors,
data members and the setter methods. If we create any class, then we can use it to set whether the props
within it should be public or private.

class Animal {
    public void method1() {}  // accessible by other classes
    private void method2() {}  // not accessible by other classes
}

There are different access modifiers:
1. public - this prop/ method is available for every class and packages.
        public String teacherName;
2. private - this prop/ method is available only in the same class, not even any other class of the same package.
        private int teacherAge;
3. default - this prop/ method is available in all the same class of the same package.
        String teacherDegree;  -- nothing is added in front
4. protected - this prop/ method is only available for those cases where we have 2 class with parent child
                relationship, and for some reason the child went to another package, then also if we want the
                immediate child to have the access of some prop/ method of parent class, then protected is used.
        protected int totalStudents;

---------------------------------------------------------------------------------------------------------

Encapsulation ::

Encapsulation refers to bundling of same fields and same methods together in a same class.
It means preventing outer classes from accessing and changing fields and methods of a particular
class. This basically helps in data hiding.

---------------------------------------------------------------------------------------------------------

Data hiding ::

Data hiding is a way of restricting the access of our data members by hiding the implementation details.
Encapsulation also provides a way for data hiding. We can use access modifiers to achieve data hiding.

NB:  Encapsulation doesn't mean data hiding, as it refers to bundle multiple similar fields and methods
together. This helps to achieve data hiding, but encapsulation in itself is not data hiding.

Also, the class fields and methods we are trying to hide, also needs to be used by other classes - that is where
getter and setter comes into picture.

---------------------------------------------------------------------------------------------------------

Static keyword ::

if we want to access class members without creating an instance, then we can use static to declare those
class members.
Static variables can be access by calling the class name of the class. There is no need to create an instance
of this class for accessing static variables, because static variables are the class variables and are shared
among all the class instances.

Static variables and method :
1. Only a single copy of static variable is created and shared among all the instance of that class.
2. Because it is a class level variable, memory allocation of such variables only happens when the class
    is loaded in the memory.
3. If any object or through the class also we change the value of a static variable, that value will reflect
    globally across all the object of that class.
4. these variables can be used in both static and non-static methods.
5. Non-static variables cannot be used inside a static method, it will throw compile time error because at the
    time the method will be loaded a non-static variable will not be, thus it will throw error. But in a
    non-static method, we can call a static method or use a static variable.
6. in a static method, "this" and "super" keywords are not used, as to use both if this keyword we need to
    create an instance or object of the class.
7. the modification of a static field value is not a good practice, as it might lead to a data mismatch. So what
    we can do is make that static variable a final one. Example ---
    public static final double PI = 3.141592653589793; --- now no one can change it,
    but it will be accessible globally.

Static block :

This block is something which runs even before the main method starts executing, it will run when the class is
loaded inside memory.
*/
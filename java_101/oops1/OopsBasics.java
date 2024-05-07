package oops1;

public class OopsBasics {
    public static void main(String[] args) {
        // creating an object of the class Car
        Car porche = new Car();
        porche.carColor = "metal grey";
        porche.carName = "porche 911";
        porche.carSpeedLimit = 400;
        porche.run();

    }
}

class Car {
    // properties
    String carName;
    String carColor;
    Integer carSpeedLimit;

    // methods
    void run() {
        System.out.println("Car is moving.");
    }
    void playMusic() {
        System.out.println("Car is playing music now.");
    }
}


/*
In one file, we can create n number of classes, but only one of them will be a "public" class and that public class
will have the file name. Here the file name is OopsBasics, so the public class name is OopsBasics.

Class we can say is like a factory, and the products made out of it are called Objects.
Here we have a Car class or a Car factory. In it, we have some defined properties of cars such as which color it
will be, is it going to be automatic or manual controlled, what is its top speed, is there going to be a nitro boost
in it. All these will be there in car class, but the values of them will be empty.
When we need to create a car ( or we can say a car object ), then we will fill these values and based on these values
our car will be created.

Also, beside these properties a class has some methods within it, and anytime an object is created with that class,
those methods will be available for that object too. So for a car class a car can run, it can honk, it can play music
within it.

While creating an object of a class,
Car porche = new Car(); --> First we mention the class name( Car ) - class is also of non-primitive data type, that's
why we cannot create a class object like this, car porche = "porche 911" - which we can do with int, int age = 21;

Next we give the object name, here it is porche.
Then we use the "new" keyword, which helps to create a new instance of the car class.
And finally the Car() is called constructor, so when we use a constructor after "new", the constructor will construct
a new object of that particular class.


Things we should know about class and objects ::
1. A class does not allocate any memory when it is created, whereas when an object is created a memory will be
        allocated for it.
2. A class is a logical entity, and an object is a physical entity.
3. A class is declared only once, while from a single class we can create n number of objects.


When our code runs, first it is compiled and then it runs. So while compiling at first the class is stored in a
memory ( but we saw class doesn't allocate any memory ), then how ?
Actually beside stack and heap memory, there is another memory called meta space - it is used to store the classes
or the metadata of classes. In this memory the class is stored.
When our program get loaded in memory that time classes within metadata is also loaded. And when program is done and
is cleared from memory, then classes are also deleted from metadata.

*/

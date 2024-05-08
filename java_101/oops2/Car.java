package inheritance.oops2;

public class Car extends Vehicle {  // a child class of Vehicle class
    // since Car is a child of vehicle, it has access to vehicle's props and methods
    public static void main(String[] args) {
//        Car car1 = new Car();
//        car1.wheelCount = 4;
//        System.out.println(car1.wheelCount);
//        car1.Start();
//        car1.model = "sedan";
//        System.out.println(car1.model);

        Car car2 = new Car();
        System.out.println(car2.wheelCount);  // given value while creating vehicle object will be printed
        car2.model = "formula 1";
        car2.wheelCount = 6;
        System.out.println(car2.wheelCount);  // new value of wheel count will be printed
        System.out.println(car2.model);
        car2.Nitro();
        car2.Start();
    }

    // car class's own props  -- these props and methods will be unavailable to parent class
    String model;

    // car class's own methods
    void Nitro() {
        if (this.model == "formula 1") {
            // [this.model == "formula 1"] == [Objects.equals(model, "formula 1")]
            super.Start();  // invoking parent's method
            System.out.println("Nitro activated !!");
        } else {
            System.out.println("Nitro bosse unavailable for this model.");
        }
    }

    // overriding the start() method of vehicle class
    void Start() {
        System.out.println("And the car goes vroom vroom vroom..");
        // now that in this class also we have start(), while using car1.start() -- this one will run.

        // here if we want to use the Breaking class, first create an object of it
        Breaking breakingObj = new Breaking();
        // as it takes a car object in it, we can pass that using "this", as "this" contains the current obj or class
        breakingObj.breaking(this);
    }

    // constructor
    Car() {
        // super should be called at the first line, always
        super(4);  // parent's default constructor is getting called here
//        super(4);  // parent's parameterized constructor is getting called here

        // in a single class, either we can use "super" or "this" -- cannot use both
        // as both "this" and "super" needs to be at the first line
        // like here super() is used to call the vehicle constructor,
        // we can use this() to call the Car constructor as well.

        System.out.println("Car getting created");
    }

    Car(int wheelsCount) {

    }

    // we can use "this" as a return object as well
    Car honking() {
        System.out.println("honka honka !!");
        return this;
    }
    // we can return "this" like such way, however, we cannot do the same with "super"
    // super is not a physical object which we can use as a param or return it,
    // we can only use to access parent's props.



}

// creating another class
class Breaking {  // this class takes a car object and then returns something
    void breaking(Car car) {
        System.out.println(car.model + " car is breaking due to over speed.");
    }
}


/*

Method Overriding ::
If a subclass provides the specific implementation of the method that has been declared by one of its parent
class, then it is known as method overriding.
Method overriding is also known as runtime polymorphism, which means we can achieve polymorphism in java
with the help of inheritance.

Polymorphism means multiple form but same name, like here the Start() method in vehicle and car class
has the same name, but they works differently.

--------------------------------------------------------------------------------------------

this vs super ::

We use "this" to current element, and we use "super" to access parent's properties.
"super" is a special keyword in java that is used to refer to the instance of the immediate parent class.

Immediate parent class means, let's say we have a machine class, and a vehicle class in inheriting the machine class.
Also, there is a car class, which is inheriting both the machine and vehicle class, then the structure would look like
machine -> vehicle -> car. So the immediate parent for car class is vehicle class.

Usage of super --
1. used to refer an instance variable of the immediate parent class.
2. used to invoke a method of the immediate parent class.
3. used to invoke a constructor of the immediate parent class.

So here let's say we want to use vehicle class's start method inside car class( while we also have a same method
defined in car class as well), then we can do it using super --- super.start();

Also, if we check the constructor we have defined for both Vehicle and Car, if we now run the Car class,
automatically at first the Vehicle constructor will run, and then the Car constructor -- because when we are
creating a car object, always the parent constructor will be called first, then the child constructor and then
the object on child class will be initiated. ( And this constructor calling thing is not for just the immediate
parent, but it will keep on calling all the parent in hierarchical manner. And when all the parent class will be
done, at last the Object class's constructor will be called. )

Now if we have 2 constructor one without param, one with param in vehicle class. And by default if run the car
class, the without param one will run by default. But if we want to run the constructor with param of vehicle
class, then we can do that using super ---- super(4) -- where, 4 = wheelCount.
And if we just keep super() --- it will run the default constructor.
Remember, for every object created in Car class, the Vehicle constructor will run.

--------------------------------------------------------------------------------------------

Final keyword ::

In java, final keyword is a non-access modifier that is used to define entities that cannot be changed
or modified.

Final can be used in multiple places --
1. Final variable -- variable with final keyword cannot be assigned a new value again
2. Final method -- method with final keyword cannot be overridden by its subclass
3, Final class -- class with final keyword cannot be extended to or inherited from other classes


*/

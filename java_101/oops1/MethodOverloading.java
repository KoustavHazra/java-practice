package oops1;

public class MethodOverloading {
    public static void main(String[] args) {
        Greet obj1 = new Greet();
        obj1.greetings();

        Greet obj2 = new Greet();
        obj2.greetings("sakuna");
    }
}

class Greet {
    void greetings() {
        System.out.println("Ohioo");
    }

    void greetings(String name) {
        System.out.println("Konnichiwa, " + name + " chan, ohiooo!!");
    }
}

/*

Method Overloading ::
Two or more methods can have same name if they accept different arguments - this feature is called as method
overloading.
Method overloading can be achieved by --
1. changing the number of arguments of each of the method with same name ( or )
2. changing the data type of arguments
It is not method overloading if we only change the return type of methods. There must be difference in the number
of params. So if we create void greetings() {} and String greetings() {} --- then it will not work.

Similarly, if we create methods like - void greetings(String name) {} and void greetings(String fullName) {} --- this
will also not work.  Because Java will not understand the difference between the methods since both are taking
same datatype params.

*/

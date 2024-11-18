package java8.MethodAndConstructorReference;

import java.util.Arrays;
import java.util.List;

public class MethodRef {
    public static void print(String s) { System.out.println(s); }

    public static void main(String[] args) {
        List<String> students = Arrays.asList("coldplay", "the weekend", "nsync");
        students.forEach(x -> System.out.println(x));

        students.forEach(MethodRef::print);
        // System.out.println(hello());
        students.forEach(MethodRef::hello);

        MethodRef ref = new MethodRef();
        students.forEach(ref::log);
    }

    public static void hello(String s) {
        System.out.println(s);
    }

    public void log(String s) {
        System.out.println(s);
    }
}

/*
Method Reference is something which refers a method, and can be used in place of a lambda expression.

x -> System.out.println(x) == public static void print(String s) { System.out.println(s); };

how?
because of method reference we can use that function as a lambda function. Like this,
students.forEach(MethodRef::print);

That "::" is an operator, aka method reference operator.

The difference between:
students.forEach(MethodRef::print);
System.out.println(hello());

is in the MethodRef - we are giving the reference of the print() method present inside the MethodRef class.
in the hello(), we are directly invoking the hello() method.

Also inside the forEach we cannot invoke the hello() --- because there is a loop going on, where on every element
in the array some work to be done. Now if we directly use hello() inside forEach, where we will be putting those
elements?
students.forEach(hello()); -- where we are going to pass the elements? And also the hello() is going to invoke
directly.
However, like this we can use hello() ---- students.forEach(x -> hello(x));
or we can just refer this method ---- students.forEach(x -> MethodRef::hello);

And if the method is not a static method, then obviously it will throw error if we try to reference it
directly, since for that method to be able to run, an object is needed. So we will create an object of the
class and using that object we can refer that (non-static) method.


 */
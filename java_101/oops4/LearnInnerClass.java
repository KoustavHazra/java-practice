package oops4;

public class LearnInnerClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        // since we cannot access a non-static class inside a static method,
        // first we need to make an object of outer class, then from that an object of inner class
        inner.display(); // Output: Outer variable: 10

        OuterClass2.NestedStaticClass nested = new OuterClass2.NestedStaticClass();
        // since the inner one is a static, we can directly instantiate its objects inside main static class
        nested.display(); // Output: Outer variable: 10
    }
}

class OuterClass {  // Inner Class
    private int outerVar = 10;

    public class InnerClass {
        public void display() {
            System.out.println("Outer variable: " + outerVar);
        }
    }
}

class OuterClass2 {  // Nested Static Class
    private static int outerVar = 10;

    public static class NestedStaticClass {
        public void display() {
            System.out.println("Outer variable: " + outerVar);
        }
    }
}

/*
In Java, you can define a class within another class. Depending on how you define the nested class,
it can be an inner class or a nested static class.

1. Inner Class: An inner class is a non-static nested class. It is associated with an instance of the
outer class and has access to the instance variables and methods of the outer class. Inner classes are
typically used for logical grouping of classes and can be instantiated only within an instance of the
outer class.

2. Nested Static Class: A nested static class is a static nested class. It is not associated with an
instance of the outer class and can be instantiated independently. Static nested classes can access
only static members of the outer class. They are typically used to logically group classes that are
only relevant to the outer class.


*/

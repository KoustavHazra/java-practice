package java8.functionalProgramming;

import java8.AnonymousVSLambda;

public class MainMain {
    int a = 22;  // instance var - as this is a field of the class MainMain
    public static void main(String[] args) {
        doSomething();
    }

    int c = 1;  // instance var
    int d = 9;  // instance var

    private static void doSomething() {
        int a = 2;  // local var - as this is used inside a method

        // lambda expression
        AnonymousVSLambda avl = () -> {
            int b = 3;  // local var

            // a = 3;  // this will throw error because once we have declared a var outside the lambda
            // expression, we cannot modify it inside the lambda exp. It has become like a final var.

            b = 6;  // however if a variable is declared inside the lambda exp, we can modify it.

            // c = 0;  // this can be modified inside a lambda exp, because c is an instance var of class MainMain
            int d = 2;  // the d var inside lambda exp and the d var in class (instance var) are different var.
            int x = 11;

            // System.out.println(this.x);  // as this is a method body, "this" doesn't work here. If we
            // print x only then it will be able to print.
            return "HI";
        };
        System.out.println(avl.sayHi());


        // anonymous class body
        AnonymousVSLambda avl1 = new AnonymousVSLambda() {
            int x = 10;  // the x inside the lambda exp and x inside anonymous class are totally different.
            // however the x inside lambda exp is a local variable, as lambda exp is a method
            // and the x inside this anonymous class is an instance var, since anonymous class is a class
            // thus, we can access the x in this class body inside the sayHi method using "this"
            // since x here is an instance variable and this is a class body
            @Override
            public String sayHi() {
                System.out.println(this.x);
                int y = 11;
                // System.out.println(this.y);  // throw error because y is declared inside a method body, "this"
                // doesn't work ... since y is a local var.
                return "OLA";
            }
        };
        System.out.println(avl1.sayHi());
    }
}

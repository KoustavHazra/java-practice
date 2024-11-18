package java8.BiInterfaces;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class LearnBiInterface {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x % 2 == 0 & y % 2 != 0;
        System.out.println(biPredicate.test(2,1));

        BiPredicate<String, Integer> biPredicate1 = (x, y) -> x.length() == y;
        System.out.println(biPredicate1.test("Hello", 5));

        BiFunction<String, String, Integer> biFunction = (x, y) -> x.length() + y.length();
        System.out.println(biFunction.apply("ola", "olu"));

        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + y);
        biConsumer.accept(2, 3);
    }
}

/*
We know that Predicate, Function and Consumer interfaces takes a single argument of any type and
do some work upon it.
But sometimes, we need to give 2 inputs instead of one. That's why BiPredicate, BiFunction, BiConsumer
comes into picture. The two inputs can be of different types as well.

There is no "BiSupplier" - why?
Any function or method we can have, it will always return a single value. The get() method in supplier returns
a single value. Now if there is a BiSupplier, then the get() method has to return 2 values - which is not
possible. That's why BiSupplier doesn't exist.


 */
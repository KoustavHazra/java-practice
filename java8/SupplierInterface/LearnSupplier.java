package java8.SupplierInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LearnSupplier {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }
        // first it is accepting the value passed to suppler -> supplier.get() -> 100
        // then on that 100, predicate will run the test() method. If 100 is even,
        // again supplier.get() will become 100
        // and function will get the 100 as input and run the apply method
        // lastly the output of function will be accepted by consumer, and it will print that value.
    }
}


/*

Supplier is an interface, which supplies any value written into it. It has a get() method,
which we can use to send any data. Whatever we pass as a data, it will accept that; and it doesn't return anything,



 */
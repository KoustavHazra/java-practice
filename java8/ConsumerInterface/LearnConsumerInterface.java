package java8.ConsumerInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LearnConsumerInterface {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("konnichiwa");

        Consumer<List<Integer>> listConsumer = li -> {
            for (int i : li) {
                System.out.println(i + 101);
            }
        };
        listConsumer.accept(Arrays.asList(1,2,3,4,5,6));

        Consumer<List<Integer>> elements = ele -> {
            for (int i : ele) {
                System.out.println(ele);
            }
        };
        elements.andThen(listConsumer).accept(Arrays.asList(1,3,4,2));
        // first elements ran on the accept() list.
        // then, the listConsumer ran on the accept list.
    }

}

/*
Consumer interface is an interface which has one method, accept() which can take any type of
input and returns nothing.

This is used when we want to store some data in the database, at that time we use this to pass the
data and save it in the db. Also, we can perform some operation on the data before saving it in the
db.

andThen() another method in consumer interface.

 */
package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LearnStream {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8};
        int sum = 0;
        // imperative approach
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        System.out.println("sum " + sum);

        // declarative approach (using stream)
        int newSum = Arrays.stream(arr).filter(x -> x % 2 == 0).sum();
        System.out.println("newSum " + newSum);

        // ----------------------------------------------------------

        // converting a list into stream
        List<String> list = Arrays.asList("A", "B", "C");
        Stream<String> listStream = list.stream();

        // converting array to stream
        int[] arr2 = {12, 3, 4};
        IntStream arrStream = Arrays.stream(arr2);

        // creating a stream
        Stream<Integer> integerStream = Stream.of(2, 3, 4, 5);

        // creating a stream using iterate of n numbers
        Stream<Integer> limitStream = Stream.iterate(0, n -> n + 1).limit(11);

        // creating a stream of random numbers -- giving a supplier inside generate()
        Stream<Integer> limitNum = Stream.generate(() -> (int) (Math.random() * 100)).limit(1000);

        // ----------------------------------------------------------

        // filter in stream -- takes a predicate
        List<Integer> list1 = Arrays.asList(1, 23, 0, 4, 5, 6, 89, 3, 69, 2, 2, 55, 3, 67, 14, 5624, 7, 14, 36, 00);
        List<Integer> evenList = list1.stream().filter(x -> x % 2 == 0).toList();
        System.out.println(evenList);

        // map in stream -- takes a function
        List<Integer> doubleList = evenList.stream().map(x -> x * 2).toList();
        System.out.println(doubleList);

        // distinct in stream
        List<Integer> distinctList = doubleList.stream().distinct().toList();
        System.out.println(distinctList);

        // sorted in stream -- sorts in ascending order by default.
        List<Integer> sortedList = distinctList.stream().sorted().toList();
        System.out.println(sortedList);
        // sort in descending order -- comparator we can use here to sort as our needs.
        List<Integer> sortedList2 = distinctList.stream().sorted((a, b) -> b - a).toList();

        // limit in stream -- used to limit the number of output we are getting from starting
        List<Integer> limited = sortedList2.stream().limit(2).toList();

        // skip in stream -- used to skip the number of output we are getting from starting
        List<Integer> skippedList = sortedList2.stream().skip(2).toList();

        // using all the previous stream functions together


        List<Integer> list2 = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .skip(1)
                .toList();
        // System.out.println(list2);

        List<Integer> peek = Stream.iterate(0, x -> x + 2)
                .limit(30)
                 .skip(2)
                 .map(x -> x * 2)
                 .distinct()
                 .sorted((a, b) -> b - a)
                 // .peek(System.out::println)
                .toList();
        // System.out.println(peek);

        // max in stream -- works like sorted()
        // if (a - b) then, ascending order. If (b - a) then descending order.
        // similarly min is also there...
        Integer intVal = Stream.iterate(0, x -> x + 4)
                .limit(101)
                .map(x -> x / 20)
                .distinct()
                .peek(System.out::println)  // method reference
                .max((a, b) -> (a - b))
                .get();
        System.out.println(intVal);

        // count in stream -- gives the count of elements in array.
        // But by default, the type of count() is long, not Integer.
        long total = Stream.iterate(0, x -> x + 4)
                .limit(101)
                .map(x -> x / 20)
                .distinct()
                .count();
        System.out.println(intVal);

        // ----------------------------------------------------------

        // parallel stream
        List<Integer> list3 = Arrays.asList(2,3,4,1,4,6,7,23,8,9,23,778,23,67,2457,686,141,868,658888);
        list3.parallelStream();
    }
}

/*
Stream -->
any collection like list, array - we can convert then into a stream. After converting them into a stream,
we can use declarative and functional programming on them.
we can think stream is like a sequence of elements, on which we can run different functions. Functions like map,
filter, reduce etc.


 */
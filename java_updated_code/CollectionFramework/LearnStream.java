package CollectionFramework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LearnStream {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(3,1,2,5,6,2,3,6,7,8);
        // iterating through array using regular for loop
        // for (int i = 0; i < l.size(); i++) System.out.println(l.get(i));

        // iterating through advanced for loop
        // for (int n: l) System.out.println(n);

        // iterating using streamAPI - forEach
        // l.forEach(n -> System.out.println(n));

        // using stream
        Stream<Integer> s1 = l.stream();
        // s1.forEach(n -> System.out.println(n));

        // so basically stream we use to do some complex operation in a small line of code
        // also, if we use stream to do some operation on a mutable object like array, the main
        // array will remain the same. So it will not hamper the main object.
        // also, stream objects can be used once at a time. If we write a stream then only on
        // that line it will work and to use it again, we need to create a new object and then
        // perform operations on it.

        // filter method of stream

        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);  // returns a stream
        Stream<Integer> s3 = s2.map(n -> n * 2);  // returns a stream
        int res = s3.reduce(0, (n, s) -> n + s);  // returns an int

        // same reduce with lambda expression :::: int res = s3.reduce(0, Integer::sum); 
        System.out.println(res);

        // using all the stream method with .
        Stream<Integer> s = l.stream();
        int result = s.filter(n -> n % 2 == 0).map(n -> n * 2).reduce(0, (n, v) -> n + v);
        System.out.println(result);
    }
}

package java8.PredicateInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LearnPredicate {
    public static void main(String[] args) {
        Predicate<Integer> salaryMoreThanOneLac = x -> x > 100000;
        // System.out.println(salaryMoreThanOneLac.test(10000000));

        // check even numbers
        Predicate<Integer> isEven = x -> x % 2 == 0;
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        for (int i: numbers) {
            if (isEven.test(i)) {
                // System.out.println(i);
            }
        }

        // string matching
        Predicate<String> startsWithLetterK = x -> x.toLowerCase().charAt(0) == 'g';
        String name = "gustavo";
        if (startsWithLetterK.test(name)) {
             // System.out.println(true);
        }


        // predicate interface's default and static methods
        // and
        Predicate<String> endsWithLetterO = x -> x.toLowerCase().charAt(x.length() - 1) == 'o';
        Predicate<String> and = startsWithLetterK.and(endsWithLetterO);
        System.out.println(and.test(name));

        // or
        Predicate<String> or = startsWithLetterK.or(endsWithLetterO);
        System.out.println(or.test(name));

        // negate -- it is like a filter, which will filter out the given input from the passed list or any input
        System.out.println(startsWithLetterK.negate().test("Gustavo"));
        // it will return false, because with startsWithLetterK, this should have returned true. But because
        // of negate, now the opposite will return. It is like a NOT gate.

        // isEqual  --  static method
        Student gustavo = new Student("Gustavo", 1);
        Student koustav = new Student("Koustav", 2);
        Predicate<Student> studentPredicate = x -> x.getId() > 1;  // we can use predicate in a class object as well

        Predicate<Student> predicate = Predicate.isEqual(gustavo);  // checks if both objects are equal or not
        // underneath it uses the .equals() method of Object class.
        System.out.println(predicate.test(koustav));

    }

    private static class Student {
        String name;
        Integer id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Student(String name, Integer id) {
            this.name = name;
            this.id = id;
        }
    }
}

/*
Predicate is a functional interface which represents a boolean valued function. We can write a lambda
expression on that function, and it will give us a boolean output.
The abstract method in Predicate interface is :  boolean test(T t);  Where T is the type of argument, which
as per our need we can change.

Basically, in a predicate we are holding a condition in a variable where we can pass any value and
get an output based on the condition is correct or wrong.
Predicate<Integer> salaryMoreThanOneLac = x -> x > 100000;

But we can do that using a method as well:
public boolean fun(int i) { return i > 100000; }

What's the point of using predicate then ????
It is useful while using stream api in java. Because there in the runtime we can pass a function, and that
too on a list of elements.
List<Integer> numbers = Array.asList(1,2,3,4,5,6,7,8,9);
int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum();

Just look at the filter method, where we are sending the function that too in the runtime and, we are getting the
sum of all the even numbers in the "numbers" list.


 */
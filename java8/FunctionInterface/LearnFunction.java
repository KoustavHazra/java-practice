package java8.FunctionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LearnFunction {
    public static void main(String[] args) {
        Function<String, Integer> getLength = x -> x.length();
        // System.out.println(getLength.apply("Hello"));

        Function<String, String> getFirstChar = x -> x.substring(0, 1);
        // System.out.println(getFirstChar.apply("boom baam"));

        Function<List<Student>, List<Student>> studentsWithK = stud -> {
            List<Student> students = new ArrayList<>();
            for (Student s : stud) {
                if (getFirstChar.apply(s.getName()).equalsIgnoreCase("k")) {
                    students.add(s);
                }
            }
            return students;
        };

        Student s1 = new Student("koustav", 1);
        Student s2 = new Student("Walter", 2);
        Student s3 = new Student("Kozy", 3);
        List<Student> students = Arrays.asList(s1, s2, s3);
        List<Student> filteredStudents = studentsWithK.apply(students);
        // System.out.println(filteredStudents);




        // function default and static methods
        // andThen
        Function<String, String> toUpperCase = x -> x.toUpperCase();
        Function<String, String> andThen = getFirstChar.andThen(toUpperCase);
        // System.out.println(andThen.apply("ravi"));

        Function<Integer, Integer> function1 = i -> 2 * i;
        Function<Integer, Integer> function2 = i -> i * i * i;
        // System.out.println(function2.andThen(function1).apply(2));  // 16
        // System.out.println(function1.andThen(function2).apply(2));  // 64

        // compose -- it is an opposite of andThen()
        System.out.println(function2.andThen(function1).apply(2));  // 16
        System.out.println(function1.compose(function2).apply(2));  // 16
        // function2 and then using function1 == function1 compose function2

        // Identity
        Function<String, String> identity = Function.identity();
        System.out.println(identity.apply("Koustav"));
        // it just returns whatever is given in the argument.
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

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}

/*
Function is also a functional interface which has an abstract method, apply. Predicate was used to check a
condition and return a boolean value.
But Function is an interface using which we can actually do some stuffs and return them. Stuffs like getting
all the odd numbers, or changing all the lower case to upper case etc. etc.

Function<T, R>  -->  T means any type of input we can give, R means any type of output we can ask for.


If we try to write Identity method in the old way, it is like:
private String identity(String s) {
    return s;
}

that is all the Identity method does here.
 */
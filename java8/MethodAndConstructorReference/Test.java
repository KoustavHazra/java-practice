package java8.MethodAndConstructorReference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("naruto", "minato", "itachi", "jiraya", "obito");
        names.stream().map(x -> new Student(x)).collect(Collectors.toList());
        // in the map() we are using lambda function to pass every name in the list to the constructor
        // of the Student class.
        // using constructor reference also we can do that ---
        List<Student> students = names.stream().map(Student::new).collect(Collectors.toList());

        // also this "collect(Collectors.toList())" can now be written as toList() only.

    }
}

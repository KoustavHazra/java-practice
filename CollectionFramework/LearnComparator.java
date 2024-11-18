package CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LearnComparator {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(24);
        l.add(31);
        l.add(19);
        l.add(32);

        // sort on the basis of the second digit of every element in the list
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 10 > o2 % 10) return 1;
                else return -1;
            }
        };

        // Collections.sort(l);  // normal sorting
        l.sort(com);  // sorting based on the second digit of every element in the list
        System.out.println(l);


        // sort a string array based on the length of each of the string
        List<String> s = new ArrayList<>();
        s.add("soo");
        s.add("awesome !!");
        s.add("I");
        s.add("am");

        Comparator<String> com2 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1;
                else return -1;
            }
        };

        s.sort(com2);
        System.out.println(s);

        // the .sort() is implemented by the Integer class, that's why it works on the int values.
        // however if we try to use it on a custom object like Car, it won't work because it doesn't
        // implement the .sort() method.

        List<Student> stud = new ArrayList<>();
        stud.add(new Student(12, "ola"));
        stud.add(new Student(14, "otis"));
        stud.add(new Student(11, "maeve"));
        stud.add(new Student(15, "Ruby"));

        Comparator<Student> compo = (o1,  o2) -> o1.age > o2.age ? 1 : -1;

        // sort
        Collections.sort(stud, compo);

        for (Student person: stud) {
            System.out.println(person);
        }
    }
}

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "Student [age = " + age + ", name = " + name + "]";
    }

}

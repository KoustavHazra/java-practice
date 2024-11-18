package java8.functionalProgramming;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Employee employee = () -> {
            return "Software Engineer";
        };
        // System.out.println(employee.getName());

        Employee employee1 = () -> "SDE 2";
        // System.out.println(employee1.getName());


        // thread
        // SoftwareDeveloper dev = new SoftwareDeveloper();
        // to use the runnable interface we use thread class
        // Thread thread = new Thread(dev);
        // so here the class which is implementing the Runnable interface is now part of a thread object.
        // thread.run();

        // we can do the same above thing without using a class and using a lambda expression instead
        // Runnable runnable = () -> {
        //     for (int i = 0; i < 10; i++) {
        //         System.out.println("Ohiooo!!");
        //     }
        // };
        // Thread thread = new Thread(runnable);
        // thread.run();


        // comparator
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(1);
        list.add(6);
        list.add(2);
        list.add(5);
        // Collections.sort(list);  // sorts the list in ascending order
        // System.out.println(list);

        // we want to sort in descending order and for that we can use Comparator interface which has an
        // abstract method named compare. Now we can use a class to define it and use it, or we can directly use
        // lambda expression to do that.

        // using class
        Collections.sort(list, new SoftwareDeveloper());
        // System.out.println(list);

        // using lambda expression
        Collections.sort(list, (a, b) -> b - a);
        // System.out.println(list);

        // we can do the same in set or map as well
        Set<Integer> set1 = new TreeSet<>();  // unlike hashset, in tree set the order remains intact
        set1.add(12);
        set1.add(1);
        set1.add(10);
        // System.out.println(set1);  // without sorting

        Set<Integer> set2 = new TreeSet<>((a,b) -> b-a);
        set2.add(12);
        set2.add(1);
        set2.add(10);
        // System.out.println(set2);  // with sorting


        // map
        Map<Integer, String> m1 = new TreeMap<>();  // unlike hashmap, in tree map the order remains intact
        m1.put(2, "ad");
        m1.put(4, "af");
        m1.put(1, "af");
        // System.out.println(m1);  // default sorting - ascending

        Map<Integer, String> m2 = new TreeMap<>((a,b) -> b-a);
        m2.put(2, "ad");
        m2.put(4, "af");
        m2.put(1, "af");
        // System.out.println(m2);  // with manual sorting - descending


        // sort some class objects using lambda expression
        Student stud1 = new Student(1, "ola");
        Student stud2 = new Student(2, "otis");
        Student stud3 = new Student(3, "Maeve");
        List<Student> l = new ArrayList<>();
        l.add(stud1);
        l.add(stud2);
        l.add(stud3);
        Collections.sort(l, (a, b) -> b.id - a.id);  // a and b are objects, and we are comparing the id
        // System.out.println(l);
    }
}

class Student {
    public Integer id;
    public String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +  "id=" + id +  ", name='" + name + '\'' +  '}';
    }
}

/*
For using the getName() method from the Employee interface, we created a class, and implemented into the main,
and then ran the method.
Employee employee = new SoftwareDeveloper();
System.out.println(employee.getName());

We can remove this middle SoftwareDeveloper class and use a functional interface to directly implement the
getName() method.
Fos using a functional interface we can use it like:
Employee employee = () -> {};  ---->  here the "Employee employee" is the functional interface which is acting
here as the type for the lambda expression ( () -> {} ).
And within the lambda expression we will implement the abstract method written inside the functional interface.
Here it is getName().
So it will be like:
Employee employee = () -> { return "Software Engineer"; };

So we can say, functional interface reference can be used to hold a lambda expression. Like here the
"Employee employee" is the functional interface which is holding the lambda expression ( () -> {} ).
And also because of the lambda expression, we don't need the SoftwareDeveloper class anymore to implement the
abstract method.

Now because the functional interface has only one abstract method, we can just directly implement its body.
If there were more than 1 abstract method then we wouldn't be able to do so. Because if there are more than 1
abstract methods, compiler will be confused which one of them to implement here.

 */
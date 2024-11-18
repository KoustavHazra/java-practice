package CollectionFramework;

import java.util.*;

class MyCatComparator implements Comparator<AnimalForComparable> {

    @Override
    public int compare(AnimalForComparable o1, AnimalForComparable o2) {
        return o1.age - o2.age;
    }
}

public class ComparableAndComparator {
    public static void main(String[] args) {
        AnimalForComparable a1 = new AnimalForComparable("leo", 14, 2);
        AnimalForComparable a2 = new AnimalForComparable("barb", 17, 4);
        AnimalForComparable a3 = new AnimalForComparable("cynthia", 12, 3);
        AnimalForComparable a4 = new AnimalForComparable("duck", 11, 1);
        AnimalForComparable a5 = new AnimalForComparable("dock", 11, 1);

        List<AnimalForComparable> cats = new ArrayList<>();
        cats.add(a1);
        cats.add(a2);
        cats.add(a3);
        cats.add(a4);
        cats.add(a5);
        // System.out.println(cats);

        // now we want to sort these cats on the basis of age.
        // but to make these cats comparable we need to make the Animal class comparable
        // by using "implements comparable" interface.
        // Collections.sort(cats);  // sort using comparable
        // System.out.println(cats);

        // sort using comparators - it is like a custom comparator
        cats.sort(new Comparator<AnimalForComparable>() {
            @Override
            public int compare(AnimalForComparable o1, AnimalForComparable o2) {
                return o1.weight - o2.weight;
            }
        });
        // System.out.println(cats);

        cats.sort(new MyCatComparator());
        // System.out.println(cats);

        // using lambda expression to compare object values
        cats.sort((o1, o2) -> o1.name.compareTo(o2.name));
        // System.out.println(cats);

        cats.sort(Comparator.comparing(o -> o.age));  // another way of comparing objects
        // System.out.println(cats);

        // best way to compare
        cats.sort((o1, o2) -> {
            return o1.name.compareTo(o2.name);  // we can make our own logic of comparing
        });



        // compare a 2D list on the basis of 1st element of each row
        int[][] arr = {{8, 2, 3}, {1, 3, 5}, {8, 9, 1}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];  // 0th index, 1st element for each row
            }
        });
        for (int[] r: arr) {
            System.out.println(java.util.Arrays.toString(r));
        }
    }
}

/*

Comparable and Comparator ::

WIth the help of these, we can sort custom objects in java.

Let's say we have a list of students, and we need to sort them in some order. Here we need some explicit
logic.

To achieve this, java provides the comparable and comparator interface, which lets us do custom sorting
on objects, including sorting based on multiple data members.


The comparable interface ::

This interface is found in java.lang package and contains only one method, compareTo(Object). It provides
a single sequence only, i.e. we can sort the elements based on a single data member only. For example,
it may be rollNo, name, age or anything else.

public int compareTo(Object obj) --- it is used to compare the current object with the specified object.
It returns -
1. positive integer, if the current object is greater than the specified object.
2. negative integer, if the current object is less than the specified object.
3. zero, if the current object is equal to the specified object.

The current object here is "this", the object on which it is called. And the Object o is passed, that is
what the current is compared to.


Comparators ::

This is an interface, but it is a functional interface. And this only have one abstract method in it, and
these are called functional interface. So we can use it as an argument in Collection.sort(cats, ...here...)
It is used to define our own custom logic to sort things which are non-primitive, like an object or a
2D array etc.

1.
Collections.sort(cats, new Comparator<AnimalForComparable>() {
            @Override
            public int compare(AnimalForComparable o1, AnimalForComparable o2) {
                return 0;
            }
        });

we can either write like this or we can directly create a class for it and pass the class as argument.

2.
class MyCustomCatComparator implements Comparator<AnimalForComparable> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.weight - o2.weight;
    }
}
 --->  Collections.sort(cats, new MyCustomCatComparator());  // sort on the basis of weight

So the main need for the comparator is we don't need to modify the Animal class, instead we
can create our own class to compare the objects.

Also, while using sort() in this way, we can use current object.sort() --- cats.sort(new MyCustomCatComparator)
(or)
cats.sort(new Comparator<AnimalForComparable>() {
            @Override
            public int compare(AnimalForComparable o1, AnimalForComparable o2) {
                return o1.weight - o2.weight;
            }
        });

And instead of using o1.age - o2.age --- we can also use something like this: Integer.compare(o1.age, o2.age) ---
this is actually a better way to compare because in the previous one we might face integer overflow issue.
For example, if we are trying to minus System.MIN_VALUE with -5, then it will revert back to a positive number,
which we don't want. Thus, it is better to go for the .compare() method.

Also, since Java 8 we can use these as a lambda function as well -
cats.sort((o1, o2) -> o1.name.compareTo(o2.name));


*/
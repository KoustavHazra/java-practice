package CollectionFramework;

import java.util.*;

public class CollectionBasics {
    public static void main(String[] args) {
        Collection nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        // System.out.println(nums);
        // there is an issue with this code, even though it will run properly.
        // usually while creating arrays we declare the item types within it, but here we haven't.
        // That's why those yellow lines are coming beneath.
        // And since we haven't declared what the item types will be all the 1,2,3 elements within
        // the array are actually an object.

        // the int, float, double all are under the Object class, and by default Collection API works
        // with objects, hence all the elements inside the array are objects.

        // To solve this problem, we need to mention the types of elements the arrays is going to
        // store, inside a <> while creating the array.
        // Collection<Integer> nums = new ArrayList<>();
        Collection<Integer> nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(2);
        nums2.add(3);
        // System.out.println(nums2);

        // why this mentioning type is important is because it might happen that the array is containing
        // a number in string, or a number of double or char, and later while doing some operation
        // in the runtime it will throw exception, which we don't want.
        // And if we mention the type while creating the array itself, we won't even be able to add
        // the number in String or double or char, because it will throw a compile time error while adding
        // them.


        // in Collection, we cannot access the index of the array, so we can move to List.
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(4);
        System.out.println(l.get(1));

        // get index of any element
        System.out.println(l.indexOf(4));  // returns -1 if not found.

        // Set
        // this index also doesn't work in hashset. There as elements are stored randomly
        // we cannot access them with the help of index.
        // However, if we want to store element in an order, we can use TreeSet class which is also an
        // implementation of Set interface.


        // Iterable - this is what implemented by Collections
        // this also we can implement
        Iterator<Integer> val = l.iterator();

        // it has a method next() which prints the next value
        System.out.println(val.next());

        // we can run while loop on the iterator
        while (val.hasNext()) {
            System.out.println(val.next());
        }

    }
}

/*

3 things: Collection API, Collection, Collections.

Collection API - some topic or concept where we have multiple classes and interfaces to work with.
Collection - an interface which has many methods within it. So we cannot just use it to create an
        anonymous class to use it as a data structure. So we go for Collections class.

        The Collection interface is actually implemented by some more interfaces like - list, Queue, Set.
        And all these interfaces have their own class implementation. Like list has array list, linked list,
        Set has hashSet, Queue has Deque and much more.
Collections - class.
 */

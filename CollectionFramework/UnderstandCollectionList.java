package CollectionFramework;

import java.util.ArrayList;
import java.util.List;

public class UnderstandCollectionList {
    public static void main(String[] args) {

        // *** collection interface methods ***
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list.add(12);  // appends one element at a time
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains(12));  // TC = O(N)
        System.out.println(list);

        list.add(13);
        list.add(14);
        list.add(2);
        list.add(4);
        list.add(5);
        // remove - 2 types - we can put an object, and it will delete that / or we can put an index number
        list.remove(13);  // index based remove is from List interface
        list.remove(2);  // will it remove the 2 object or the 2nd index - here it will remove the index
        System.out.println(list);

        list.remove(Integer.valueOf(4));  // here it will remove the 4 object from the list
        // object based remove is from Collection interface, and overridden in List interface

        list2.add(23);
        list2.add(34);
        list2.add(14);

        // append the list2 inside the list
        list.addAll(list2);  // list = [12, 13, 14, 2, 4, 5, 23, 34, 4]

        // remove all similar elements from list and list2
        list.removeAll(list2); // list = [12, 13, 14, 2, 5]  -- similar element 4 is removed

        // remove all the unique elements from list, which are not present in list2
        list.retainAll(list2); // list = [4]

        // clear a list
        list2.clear();  // list2 = [] || TC = O(1)

        // if we want to convert our list into an object array
        Object[] arr = list.toArray();  // converts a list to an array
        for (Object e: arr) {
            // change the type Object to Integer type
            Integer t = (Integer) e;
            System.out.println(t);
        }

    }
}



/*

Collection framework ::

The java collection framework provides a set of interfaces and classes to implement various
data structures and algorithms. These interfaces include several methods to perform different
operations on collections.


Collection interface ::

The collection interface is the root interface of java collection framework.
This includes various methods that can be used to perform various operations ---
1. int size() --- returns the number of elements inside the collection.
2. boolean isEmpty() --- returns true if the collection is empty.
3. boolean contains(Object obj) --- returns true if the collection contains specified element.
4. boolean add(E e) --- Adds the specified element (of data type E) to the collection. Returns true if
                    the collection changed as a result.
5. boolean remove(Object obj) --- removes a single instance of the specified element from the collection,
                    if it is present.
6. boolean containsAll(Collection<> c) --- returns true, if the collection contains all elements of the
                    specified collection.
etc. ...

 */
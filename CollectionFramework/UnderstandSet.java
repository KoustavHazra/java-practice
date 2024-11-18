package CollectionFramework;

import java.util.*;

public class UnderstandSet {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();  // mostly this is what we'll be using
        // elements in hash set will be stored in random order
        s.add(12);
        s.add(12);  // only contains non-duplicate elements
        s.add(130);
        s.add(1);
        s.add(2);
        s.add(11);
        // System.out.println(s);
        s.remove(2);
        // System.out.println(s);
        // in hashset the operations take O(1) .

        // linked hash set
        Set<Integer> ls = new LinkedHashSet<>();
        ls.add(12);
        ls.add(13);  // in linked hash set, it takes O(1) to add an element
        // System.out.println(ls);
        ls.remove(13);  // in linked hash set, it takes O(n) to remove
        // System.out.println(ls);

        // tree set
        Set<Integer> ts = new TreeSet<>();
        // this internally uses binary search tree, thus elements in it stored in sorted order
        ts.add(11);
        ts.add(1);
        ts.add(15);
        // System.out.println(ts);
        ts.remove(12);
        // System.out.println(ts.contains(1));
        // in tree set, the operations take O(logN)


        // enum
        // EnumSet is commonly used in situations where we need to work with a fixed set of constants
        System.out.println(Color.RED);
        EnumSet<Color> e = EnumSet.allOf(Color.class);
        // not sure where it is used.
    }

    public enum Color {
        RED, GREEN, BLUE
    }
}


/*

Set ::

The set interface in java collection framework provides the features of mathematical
set. It extends the collection interface.
Unlike the list interface, set cannot contain duplicate items in it.

Set is again extended by 4 other classes - EnumSet, HashSet, LinkedHashSet, TreeSet.

Set props --
1. add() --- add a specific element to the Set.
2. addAll() --- add all the elements of the specified collection to the set.
3. remove() --- remove the specified element from the set.
4. removeAll() --- remove all the elements form the set which is present in another specified set.
5. retainAll() --- retains all the elements in the set that are also present in another specified set.
6. clear() --- removes all the elements from the set.
7. size() --- returns the size of the set.
8. contains() --- returns true, if the passed element is available in the set.


HashSet --
HashSet in java is commonly used to store data in a random order. It is because elements in hash table
are accessed using hash codes.
The hash code of an element is unique that helps to identify elements in a hash table.
HashSet cannot contain duplicate element, hence each element in hash table has a unique hash code.


Java Hashset of custom objects --
When using Set and hashset to store any primitive data type, we don't need to worry about implementing
any hashcode or duplicate checking logic.
However, if we want to use a set with custom class putting custom objects inside the set, then our custom
class has to implement hashcode() and equals() methods in order for the hashset to work. Otherwise, there
will not be any hashcode to be generated for every new element, also there won't be any duplicate checking.

So there these hashcode and equals method are already available in Object class, all we need is to implement
them in our class, and it will start working as a normal set.


*/

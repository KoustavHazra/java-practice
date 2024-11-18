package CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListMethods {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(14);
        list.add(2);
        list.add(4);
        list.add(5);

        // *** List interface methods ***
        System.out.println(list.get(3));  // get element at 3rd index || TC = O(1)
        list.set(2, 54);  // replace the current 2nd index element with 54 || TC = O(N)
        list.add(4, 89);  // add 89 at 4th index || TC = O(N)
        list.remove(3);  // remove element at 3rd index || TC = O(N)
        System.out.println(list.indexOf(54));
        System.out.println(list.lastIndexOf(3));

        // iterate over a list - 1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // iterate over a list - 2
        for (int num : list) {
            System.out.println(num);
        }

        // iterate over a list - 3
        Iterator<Integer> it = list.iterator();  // using this we can iterate inside any collection
        while (it.hasNext()) {  // if next element present, keep printing them - useful in linked list
            System.out.println(it.next());
        }  // iterator comes from Collection

        ListIterator<Integer> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());  // works exactly same like Iterator
            // just Iterator comes from Collection interface and ListIterator from List interface
        }

        // sub list
        list.subList(2, 5);  // from 2nd index to 4th index (5th index exclusive)
    }
}



/*

List interface ::

The list interface extends the collection interface and adds methods that are specific to lists, which
are ordered collection that allow duplicate elements.
And the List interface is being extended by 4 different classes - ArrayList, LinkedList, Stack and Vector.
1. get(int index) --- retrieve the element of the specified index.
2. set(int index, E element) --- replaces the element at the specific index, with the passed E element.

3. add(int index, E element) --- inserts the passed element in the past index, by shifting the current
                                elements to the right.
4. remove(int index) --- remove the specific element present on the passed index, and then shift
                                remaining elements to the left.

5. indexOf(Object o) --- returns the index of the element ( first occurred element ), if it is not present
                            returns -1.
6. lastIndexOf(Object o) --- returns the index of the element ( last occurred element ), if it is not present
                            returns -1.
7. listIterator() --- returns a list iterator over the elements of the list.
8. listIterator(int index) --- returns a list iterator over the elements of the list, starting at
                               the specified index.
9. subList(int fromIndex, int toIndex) --- create a sublist from the given list, starting from the start index
                                            (inclusive) and till the toIndex (exclusive).



ArrayList ::

In java, we can create dynamic sized array using array list.
But how does it change its size dynamically ??

ArrayLists internally uses a normal array only, and when we create an arrayList, it actually creates an
array of a particular size (let's say 10). Now when all the 10 indexes are filled, there is something
called resizing occurs. Actually there is a threshold value, anytime that limit is crossed, automatically
it resizes the array size. If threshold value is 0.75, then if the array is filled 75%, then automatically
it will be resized.
There is actually a formula of resizing an array ---
newSize = ((oldSize * 3) / 2 ) + 1 --- for oldSize = 10, newSize = 30 / 2 + 1 = 16

So a new array of 16 size will be created and then all the existing values from the old array will be
copied to the new one, and after that if we add a new value, 11th index will be available there.
This resizing process is hidden to the user, so all these things happens internally.

However, frequent resizing operations can lead to performance overhead, so array list increases the
capacity by a certain factor to minimize the frequency of resizing.
 */
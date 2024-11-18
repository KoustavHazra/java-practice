package CollectionFramework;

import java.util.Stack;

public class LinkedList {
    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();
        fruits.push("apple");
        fruits.push("banana");
        fruits.push("mango");
        System.out.println(fruits);

        System.out.println(fruits.pop());
        System.out.println(fruits.peek());
        System.out.println(fruits.empty());

    }


}


/*

Linked list ::

In java, linked list class of Collection framework provides the functionality of linked list
data structure.
Elements in linked list are actually not stored in sequence. Instead, they are scattered and
connected through links (prev and next).

--------------------------------------------------------------------------------------

Vector ::

The vector class synchronizes each individual operation. This means whenever we want to perform
any operation on a vector, Vector class automatically applies a lock on that operation.

It is because one thread is accessing a vector, and at the same time another thread tries to
access it - thus an exception occur, ConcurrentModificationException.
Hence, vector uses a lock; but, this constant usage of lock makes vector less efficient.

Why Vector applies that lock is because many times in multithreading environment, multiple
threads might try to access a single list simultaneously. Because of this, due to race condition
we might see inconsistency in data. What will happen is if 2 threads are trying to access the same
list and tries to update it, then the actual list might get updated in a wrong way - which we don't
want -- that's why we use Vector to protect our data from this kinda problems.

However, in array lists methods are not synchronized - so if we work in a multithreaded environment
with an array list, it might affect the data.

--------------------------------------------------------------------------------------

Stack ::

Stack is a LIFO type data structure in java.
1. void push(E item) --- push an item onto the top of stack.
2. E pop() --- removes and returns the top element from the top of stack.
               Throws an exception if stack is empty.
3. E peek() --- only returns an element from the top of stack, without removing it.
                    Throws an exception if stack is empty.
4. boolean empty() --- return true if stack is empty.
 */
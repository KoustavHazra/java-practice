package CollectionFramework;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class UnderstandDeque {
    public static void main(String[] args) {
        // creating an ArrayDeque object
        ArrayDeque<Integer> deck = new ArrayDeque<>();
        Queue<Integer> q = new ArrayDeque<>();

        deck.offerFirst(12);
        deck.offerLast(19);
        deck.offer(20);
        deck.offerFirst(13);
        // System.out.println(deck);

        // System.out.println(deck.peekFirst());
        // System.out.println(deck);

        // System.out.println(deck.pollLast());
        // System.out.println(deck);

        // implementing stack using ArrayDeque
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // System.out.println(stack);
        // System.out.println(stack.pop());
        // System.out.println(stack);

        // we can use all the queue prop as well, as ultimately it is an object of ArrayDeque only
        // System.out.println(stack.peek());


        // priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(20);
        pq.offer(23);
        pq.offer(10);
        pq.offer(13);
        pq.offer(40);
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);

    }
}


/*

ArrayDeque ::

ArrayDeque or doubly ended queue is a data structure, where we can perform any add/ remove operation
from the both the end of the queue.
Normally in queue, we can do such operations from one side only. We will add from one side and remove
from opposite side of it. Because of this versatile nature of ArrayDeque, we can implement stack
as well with it.
This kinda data structure is helpful to solve problems like sliding window.

In Queue interface, there is one interface which extends Queue, called Deque. And from Deque, we get
ArrayDeque class. So in ArrayDeque we can use both Queue and ArrayDeque functionality.


We can create an array deque object in both way,
ArrayDeque<Integer> deck = new ArrayDeque<>();
Deque<Integer> d = new Deque<>();
Queue<Integer> q = new ArrayDeque<>();

However, if we create it with the first or second one, then we can use both Queue and ArrayDeque props
on that object, but if we create the object with Queue, then only Queue props will be available for that
object.
This happens because of compilation, as the left part is created while compilation time only.


ArrayDeque props --
1. addFirst(E e) or offerFirst(E e) --- adds an element in front of the queue.
2. addLast(E e) or offerLast(E e) --- adds an element at the end of the queue.
3. removeLast(E e) or pollLast(E e) --- removes an element from the end of the queue.
4. removeFirst(E e) or pollFirst(E e) --- removes an element from the front of the queue.
5. getFirst(E e) or peekFirst(E e) --- returns the first element from the queue, without removing it.
6. getLast(E e) or peekLast(E e) --- returns the last element from the queue, without removing it.

--------------------------------------------------------------

Stack and queue implementation using ArrayDeque --
Stack operations :
1. push(E e) --- pushes an element onto the stack represented by the deque.
2. pop() --- pops an element from the stack represented by the deque.

Queue operations :
1. add(E e) or offer(E e) --- add an element in the end of the deque, making it behaving like a queue.
2. remove() or poll() --- remove an element from the front of the deque, making it behaving like a queue.

It is always a recommended practice to use ArrayDeque to solve stack problems because this has the stack props
within it, and also as the other Stack class we have as it extends the Vector interface and Vector class implements
locks on each operations making it a run slowly. Hence, it is better to use ArrayDeque to implement stack.

--------------------------------------------------------------

Priority Queue ::

This is like the same queue, only difference here is we can prioritize which element is going to
get out first. Like for a priority queue of integers, the lowest integer will have the highest
priority.

We can also set our custom priority while creating a priority queue --
PriorityQueue<Integer> pq = new PriorityQueue<>();  -- in the last () we can add that custom functionality.


 */
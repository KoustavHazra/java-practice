package CollectionFramework;

import java.util.LinkedList;
import java.util.Queue;

public class UnderstandQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // Because Queue is an interface, we had to create an object of its child class.

        q.add(10);
        q.add(20);
        q.offer(30);  // better to use offer, since it doesn't throw any error
        q.offer(40);
        q.offer(50);
        System.out.println(q);

        System.out.println(q.poll());
        System.out.println(q);

        System.out.println(q.peek());
        System.out.println(q);

        // traverse in queue
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
        // now that queue is empty
        System.out.println(q.poll()); // returns null
        // System.out.println(q.remove()); // throws exception, as q is empty


    }
}


/*

Queue ::

The queue interface of java collection framework provides the functionality of queue data
structure, which is first in first out (FIFO). It extends the Collection interface.
And Queue is further extended by ArrayDeque, LinkedList, and PriorityQueue.

As we saw in List also there is a child class Linked list, a linked list class actually inherits
both List and Queue interface.

Queue methods --
1. boolean add(E e) --- insert specified element into the queue. Throws an exception if
                    queue is already full, or add operation was failed for some reason.
2. boolean offer(E e) --- inserts specified element into the queue. Returns true if element was
                            inserted successfully, and returns false if queue was full.
3. E remove() --- removes and returns the element at front of the queue. Throws an exception if
                    queue is already empty.
4. E poll() --- removes and returns the element at front of the queue. Returns a null if queue is
                empty.
5. E element() --- retrieves, but doesn't remove element at front of the queue. Throws an exception if
                    queue is already empty.
6. E peek() --- retrieves, but doesn't remove element at front of the queue. Returns a null if queue is
                empty.

*/
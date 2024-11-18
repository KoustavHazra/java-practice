package java8.functionalProgramming;

import java.util.Comparator;

public class SoftwareDeveloper implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

/*
Before we were implementing the Employee interface in it. Now that we have lambda expression,
now we are implementing Runnable interface in it to understand lambda expressions in a better way.

Runnable interface has one abstract method run(), and this is used to create threads. So Runnable interface should
be implemented by those class whose instances are intended to be executed by a thread.

Next we are now implementing Comparator interface and as here we are going to return an integer, we
have mentioned implements Comparator<Integer> {}.


 */
package exception;

import java.io.File;
import java.io.IOException;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            System.out.println(12/0);
        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());;
            System.out.println(ex.getMessage());
//        } catch (ArithmeticException a){    // multiple catch blocks can be used
//            System.out.println();
        } finally {
            System.out.println("it will always run.");
        }


        // we can use try-finally as well, but exception will not be handled
//        try {
//            int[] arr = {1,2,3,4};
//            System.out.println(arr[8]);
//        } finally {
//            System.out.println("exceptions are not caught");
//        }

        int[] arr = {1,2};
//        getArrEle(arr);  // throws error because of "throws" keyword
    }

    static int getArrEle(int[] arr) throws IOException {
       return arr[9];
    }
}
/*

Exception handling ::

In java, we have 2 types of exception --
1. Runtime exception.
2. I/O exception.

Runtime exception means, when there is an issue within the code.
These exceptions are not checked at compile time, but on run-time. Some of the common exceptions are --
1. Null pointer access (missing the initialization of a variable)
2. out-of-bound access ( trying to find that index of array which doesn't exist )
3. dividing a number by 0.

"If it is a runtime exception, it is our fault."

I/O exception is also known as checked exception. They are checked by the compiler at the compile-time.
Some of the exceptions are --
1. trying to open a file that doesn't exist results in FileNotFoundException
2. trying to read past the end of a file

Handle exception ::
1. try-catch block --- in the catch block we can use different exception class to handle the exceptions,
                        we can go for both runtime exception and IO exception. All the runtime exceptions
                        and IO exception actually is a child class of class exception.
                        So wither we can give different exception based on the scenario, or we can just
                        give Exception in catch block, and it will work for all types of exception.

2. try-catch-finally --- it is just like try-catch block, just here after catch block there is a final
                        block. And this block will always execute whether there is an exception inside the
                        try block or not.

                        However, there are some scenarios, where final block will not execute, when --
                        1. use of System.exit() before this block.
                        2. exception occurred in final block itself.
                        3. death of a thread.

3. throw and throws --- we use "throws" keyword in starting of a method ( in the method declaration ) to declare
                        the type of exceptions that might occur within it.
                        -->  static int getArrEle(int[] arr) throws IOException {
                               return arr[9];
                            }

                        "throw" we use to explicitly throw a single exception.
                        -->  throw new Exception("exception");
*/

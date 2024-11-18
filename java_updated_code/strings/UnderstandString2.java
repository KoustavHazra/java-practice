package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class UnderstandString2 {
    public static void main(String[] args) {
        System.out.println(20);
        System.out.println("ABC");
        System.out.println(Arrays.toString(new int[]{1,2,3,4}));

        String name = null;
        System.out.println(name);

        System.out.printf("My name is %s and I'm a %s", "Koustav", "software engineer");
        // formatted string
        // %s: - for string
        // %d: - for integers
        // %f: - for floating-point numbers
        // %c: - for characters
        // %b: - for booleans

        System.out.println('a' + 'b');  // sumup the ASCII value of both a and b
        System.out.println("a" + "b");  // concatinates both the string
        System.out.println('a' + 3);  // sums up ASCII value of a with 3
        System.out.println((char) 'a' + 3);  // converting the ascii sum value of 'a' and 3 yo char

        System.out.println("a" + 3);  // a3
        // here the int data (3) is concatenating with the string (a). It happens because in this case
        // the int data is converted to its wrapper class (Integer), and as the wrapper class has the
        // toString() method, the int value (3) is converted into a string and thus getting concatenated
        // with "a".

        // similarly for arrays also it happens
        System.out.println("array: " + new ArrayList<>());
        // the array list will call the toString(), and the empty array, [], will be converted into
        // a string []. So it will be like "array: " + "[]"

        // so basically everytime we are trying to concatenate a string with an object,
        // the object will automatically call the toString() method and it will
        // concatenate as a string.

        // the "+" we can use to either on primitive data types (int, float, double) or on a String.
        // other than that if we use it one any other data or objects, it will throw error -- unless,
        // one of the item in that total concatenation is a String.

        // System.out.println(new ArrayList<>() + new ArrayList<>()); // throw error as + cannot use here
        System.out.println(new ArrayList<>() + "" + new ArrayList<>());  // now with the string it will work

        // so the operator "+" is changing its nature while concatenating with a string
        // and only the "+" operator does this. Other operators we can only use for primitive
        // data types only, not even String can use them.
        // This is known as Operator overloading. In java, only the "+" has this option to
        // overload when it comes to String data type.

        System.out.println("a" + 'a');  // returns a string, "aa"

    }
}

/*

In System.out.println -- whatever data we pass in it, it calls the valueOf() method, which
internally calls the toString() method.

If we run this same System.out.print and within this valueOf() and then the toString() -- it won't work.
For arrays, it is better to go for the toString() defined within that class. That is there to print array.
So, Arrays.toString(new int[]{1,2,3,4})  --  will print the array properly.
This is actually an example of function overriding, where in Arrays class the toString() method is
modified according to the needs.
Similarly, we can modify the toString() with our needs.

Also, if we check the toString() method, if the object on which it is being called is a null, it will
return null; otherwise it will convert it into a string and then print it.



 */
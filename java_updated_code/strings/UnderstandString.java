package strings;

import java.util.Scanner;

public class UnderstandString {
    public static void main(String[] args) {
        String str1 = new String("hello world!");
        String str2 = "hello world!";
        String str3 = "hello world!";
        String str4 = new String("hello world!");

//        compare two strings
//        if (str2 == str3) System.out.println("both pointing at same reference");
//        if (str1 != str4) System.out.println("both not pointing at same reference");
        // in case of String, since it is a non-primitive data type
        // the == or != doesn't check the value, they compare the references
        // whereas for int (primitive data type), == or != compares the value

//        compare string values (not reference)
//        if (str1.equals(str2)) System.out.println("both have same value");

//        compare string values while ignoring cases
        String str5 = "HELLO WORLD!";
//        if (str2.equalsIgnoreCase(str5)) System.out.println("Yep, they have the same value, but different cases.");

//        take user input and print
//        Scanner sc = new Scanner(System.in);
//        System.out.println("give first name");
//        String firstName = sc.nextLine();
//        System.out.println("give last name");
//        String lastName = sc.nextLine();

//        System.out.println("Your full name is " + firstName + " " + lastName);
//        System.out.println(STR."Your full name is \{firstName} \{lastName}");  // using string template


//        to upper or lower case
//        System.out.println(str1.toUpperCase());
//        System.out.println(str5.toLowerCase());

//        trim
        String str = "   abc   ";
//        System.out.println(str.trim());

//        starts or ends with
//        System.out.println(str2.startsWith("he"));
//        System.out.println(str2.endsWith("d"));

//        char present at what position
//        System.out.println("sunlight".charAt(3));

//        convert int or double value to string
        int val = 2;
//        String op = String.valueOf(val);
//        System.out.println(val);

//        replace any char or string within a string -- returns a new string, old one remains same
//        System.out.println(str3.replace("hello", "ola"));

//        contains a particular string in a string
//        System.out.println(str1.contains("!"));

//        substring -- get a part of a string
        String subString = str1.substring(0, 5);
//        System.out.println(subString);

//        split
        String words[] = str1.split(" ");
//        for (String word: words) System.out.println(word);

//        string to char array
        char letters[] = str3.toCharArray();
//        for (char letter: letters) System.out.println(letter);

//        empty string ?
//        System.out.println(str1.isEmpty());  // returns false
//        System.out.println("  ".isEmpty());  // returns false

//        is blank ?
//        System.out.println(str1.isBlank());  // returns false
//        System.out.println("  ".isBlank());  // returns true

    }
}


/*
String in a non-primitive data type in java.

How to create a Java String:
1. By string literal  --> String str1 = new String("hello world!");
2. By new keyword  --> String str2 = "hello world!";  --> the double quotes are called string literal ( " )
                        anything inside these " " will become a string.

Now both will literally the same way, the only difference in these 2 is how they are stored in the memory.

We have 2 types of memory where data is stored - Stack and heap memory.
In stack memory the reference objects are stored, such as "str1" which is a reference of a String object
and in heap the actual object which is created for "str1" will be stored. The "hello world!" will also be
stored in heap memory.

To understand how these 2 str1 and str2 is stored differently, think of heap memory as a block. And within that block
there is another block named String-pool or String-constant-pool. So when we created the str2, the "hello world!" value
is stored in that pool and the str2 is stored in stack.
Now let's say we created another str object: String str3 = "hello world!";
What will happen here is since both str2 and str3 is having the same string value, both str2 and str3 is going to
point at the same "hello world!". In java as we need to create string many-many times, this is something java people
came up with to store and use String more efficiently.
Usually what will happen is even if str2 and str3 has the same value, both will have different memory reference.

Now when we created the str1, here also str1 will be stored in stack, but the value "hello world!" will be stored
outside the string-pool. It will be stored in the heap memory block only, but not inside the string pool.
So if we have another str object: String str4 = new String("hello world!");
Here even though str1 and str4 is having the same value, because they're created with the "new" keyword, for
both of them there will be different "hello world!" reference in heap memory. Basically little less efficient.

So when creating a string, using string literal is always preferred.


String objects are immutable in Java. So if we create a string object "hello world!", then we cannot change it again.
We cannot change it to something like -- "hello--world!".

So once we create a string object we cannot change it. Until there is no reference left for that object from stack
memory, it will be there. Then garbage collector will remove it where there is no reference left.
*/
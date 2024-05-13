package genericAndWrapperClass;

import java.util.ArrayList;

public class UnderstandWrapperClass {
    public static void main(String[] args) {
        Integer a = 12;
        // creating integer with wrapper class
        Integer obj = Integer.valueOf(12);  // same as Integer a = 12; here also underneath valueOf is used
        Integer obj1 = 12;  // auto-boxing
        int obj2 = obj1; // unboxing - directly assigning an object inside a normal primitive data type var

        // since primitive data types cannot be used inside collection framework
        ArrayList<Integer> arr = new ArrayList<>();

        // valueOf also helps to convert data type while creating an object and assigning a value
        Integer obj4 = Integer.valueOf("123");
        Boolean obj5 = Boolean.valueOf("true");

        // Integer obj6 = Integer.valueOf("1aBc789");
        // naturally, if we pass anything other than 0-9 in strings like a-b, it will throw error


    }
}

/*

Wrapper class ::

A wrapper class in java is a class whose object wraps or contains primitive data types. When we create
an object to a wrapper class, it contains a field and in this field, we can store primitive data types.

Example:
int -> Integer
char -> Character
short -> Short
byte -> Byte
long -> Long
float -> Float
double -> Double
boolean -> Boolean

If we try to understand one of them, we can understand all of them, as all the wrapper class are created
for the same reason only.

In case of Integer wrapper class -->
The Integer class wraps a value of the primitive type int in an object. An object of type Integer
contains a single field whose type is int.
In addition, this class provides several methods for converting an int to a String and a String to an int,
as well as other constants and methods useful when dealing with an int.

ALl the number type wrapper class (int, short, long, float, double) actually extends the Number class.
And the Number class, as well as the Character, Boolean, Byte class extends the java.io.Serializable class.

Need of wrapper class --
1. The classes in java.util package handles only objects, hence to use any primitive data type is not possible,
    hence we use these wrapper classes there.
2. Data structures like collection framework (ArrayList, vectors) store only object, not any primitive data
    types, hence wrapper class exists.

-------------------------------------------------------------------------------------

Autoboxing and unboxing ::

The automatic conversion of primitive types to the object of their corresponding wrapper class, is
called as autoboxing. Ex: conversion of int to Integer, float to Float, double to Double.

Whereas, the reverse process of autoboxing is called unboxing. Automatically converting an object of a
wrapper class to its corresponding primitive data type is known as unboxing.
Conversion of Integer to int, Boolean to boolean, Character to char.

-------------------------------------------------------------------------------------

*/

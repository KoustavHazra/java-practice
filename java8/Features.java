package java8;

public class Features {

}


/*
Why Java 8?
- Java 8 was introduced to bring these 3 main features in java programming.
1. Concise and minimal code.
2. Functional programming -- introduced the features of functional programming benefits (lambda function). But java
                                is still a OOP language.
3. Parallel programming -- introduced code compatibility with multicore processors.


Features of Java 8.
- There are a lot of features introduced in java 8.
1. Lambda expression -- aka, anonymous function, function which we don't need to define and can be used anywhere.
                        Basically it is a function with a single line which we can implement inside any method.
                        ex: (x, y) -> x*y;
2. Stream API -- For bulk data operations on Collections. Let's say we have a list of elements, and we want to
                    get all the even numbers inside that list, we can use stream api for it.
3. Data and time API -- Inside the java.time package some new features were introduced.
4. base64 encode - decode -- Now within the java.util package we have inbuilt base64 encoding decoding features.
5. Method reference and Constructor reference -- It is like a new kinda operator ( :: operator ).
6. Default methods in Interfaces -- Before inside an interface, we only had public abstract method. Now we also have
                                    default methods and static methods.
7. Functional Interface -- It is one kind of interface that has exactly 1 abstract method. To designate a functional
                            an interface as a functional interface we don't need to use @FunctionalInterface
                            annotation. It is also known as Single Abstract Method.
8. Optional Class -- A class which we can use to get data from any let's say a db call, and if we are not sure if the
                        data will come or not, there we can use optional as a data type.
                        ex:  List<Optional> op = db.call();

 */
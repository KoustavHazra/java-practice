package genericAndWrapperClass;

public class GenericMethods {

    public static void main(String[] args) {
        print("abc");
        dynamicPrint(123);
        dynamicPrint(false);

        // in objects also we can use it
        GenericMethods obj = new GenericMethods();
        obj.doubleData(121);
        // needed to create an object since a non-static method cannot be used inside a static method

        // objects can also be passed as a data
        CustomClass custom = new CustomClass();
        dynamicPrint(custom);
        dynamicPrint(obj);
        obj.doubleData(custom);

        // bounded generic method
        onlyNumber(12);
        onlyNumber(0.9876);
    }

    // normal method
    static void print(String data) {
        System.out.println(data);
    }

    // we can create a generic method even outside a class
    static <E> void dynamicPrint(E data) {
        System.out.println(data);
    }

    <P> void doubleData(P data) {
        System.out.println(data);
    }

    // bounded generic method
    static <E extends Number> void onlyNumber(E num) {
        System.out.println(num);
    }
}

class CustomClass {
    // just a custom class with no body or nobody .. ?
}

// bounded generics -- where we define only these kinds data types are allowed
class BoundedGenerics <T extends Number> {
    // only T (number - integer, float, double) will be allowed
}

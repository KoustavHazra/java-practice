package genericAndWrapperClass;

public class UnderstandGenerics {
    public static void main(String[] args) {
        Dog d1 = new Dog("12");

        // calling the Cat class, we have to define the data types of E and V within a <>
        // previously, in the second <> also we had to define the types, but now it is not needed
        // so, we kept the second <> empty.
        Cat<Integer, String> c1 = new Cat<>(12, "synthia");
        Cat<String , Boolean> c2 = new Cat<>("123", true);
        System.out.println(c1.getId());


    }
}

// without generics
class Dog {
    String id;
    public Dog(String id) {
        this.id = id;
        System.out.println(this.id);
    }
}

// with generics
class Cat<E, V> {  // "E" is just a placeholder, we can use anything we want instead of "E"
    // now when we create this class, and pass an id of any type, that will be the type of "E" and
    // id will adapt accordingly.
    E id;
    V name;
    public Cat(E id, V name) {
        this.id = id;
        this.name = name;
        System.out.println(this.id + " " + this.name);
    }
    E getId() {  // in methods also we can use these independent data types to return something
        return id;
    }
}



/*

Generics ::

Generics means parameterized types. Using generics, it is possible to create classes that work with different
data types. An entity such as class, interface or method that operates on a parameterized type is a generic
entity.

Through this we can define any data type for a particular field in a class. For example, for a Dog class, we can
create id of let's say, "E" type; now "E" can be string or int or long whatever we want.

To understand better, when we create an ArrayList we can define what data type we will be passing in it --
this is the exact same concept. ArrayList<Integer> for a list of integers, ArrayList<String> for a list of
strings etc.


*/
package oops4;

public class LearnInterface {
    public static void main(String[] args) {
        // Animal a1 = new Animal(); // cannot create an object of an interface
        // since we cannot create any object, we need to make a child of the interface to use it
        Monkey m1 = new Monkey();
        m1.eats();
        m1.walks();
        System.out.println(Animal.legs);  // but since it is final, we cannot change its value

    }


}

interface Animal {
    void eats();
    // public abstract void eats() == void eats() -- public/ abstract are redundant in interface
    // redundant because in interface by default all the methods are public and abstract.
    // by default abstract because interfaces were created because of abstracts, since we cannot create
    // objects of an interface.
    // public by default because what's the point of creating a private method within an interface, because
    // then it won't even be utilized by the child classes.

    int legs = 4;

    default void breathe() {
        System.out.println("o2 needed");
    }  // because this is default, we can create its body as well.
}

interface Sapiens {
    void walks();
}

class Monkey implements Animal, Sapiens {
    // now we have multiple inheritance because of interface - one child can have multiple parents

    @Override
    public void eats() {
        System.out.println("eating is important.");
    }

    @Override
    public void walks() {
        System.out.println("walking or climbing ?");
    }
}

/*

Importance of interface ::
1. similar to abstract class, this helps us to achieve abstraction in java.
2. interface also helps to achieve multiple inheritance in java.
3. All method inside an interface are implicitly public and abstract, and all fields are
    implicitly public static final - fields are kept final because there might be a situation where
    the values of the fields will change, which we don't want, thus final.

Now that we have multiple inheritance, what if there is one child class and it has 2 parent classes. What will
happen if both the parent class have a same method ?
Well as both the parent will be an interface, when we are creating the child class, there only we can implement
that method in our own way, thus there will be no conflict between a same method of two different methods.


Let's say we created an interface with some methods in it and many classes are not inheriting from it. But now
if we add a new method to that interface, because of the new method all the child classes will throw error
until we go to each of the class and implement the new method -- which is not a good idea.
That's why we have default implementation for interfaces, so that when this kinda situation arrives we can
add new methods but that will not throw any error and also later if we want to override the method in any
of the class we can do it.
*/

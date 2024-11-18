package MemoryInJava;

class Data {
    int num;
}

public class Memory {
    public static void main(String[] args) {
        int n = 1;
//        changeNum(n);
        System.out.println(n);  // still prints 1
        // because the n = 1 is stored in stack, not heap
        // all the primitive type data is stored in stack memory
        // and the non-primitive data goes into heap

        // if we create an object (non-primitive data) like this --
        Integer num = 5; // now it should store in heap, but it won't. WHY ?? check auto-boxing and un-boxing below

        Data obj1 = new Data();
        obj1.num = 50;
        changeNum(n, obj1);
        System.out.println(obj1.num);  // prints 100
    }

    static void changeNum(int n, Data obj) {
        n = 10;
        obj.num = 100;
    }
}

/*

Stack and heap memory ::

Stack is a memory where the data is stored in an organized manner, like a list of things.
This is where the variables and its values, reference of objects are stored.
Also, the functions are stored in stack. Everytime we call a function, it is stored in
a stack and if within that function another
function is called, then the second function will be on top of the previous function. And when the
inner function returns something, or it's work is done, it gets clear from the stack, and then the
outer function (when it is done), gets cleared from the stack.
Stack memory is thread safe.

Heap memory is where the data is stored in unorganized manner. The actual objects are stored here.
Object obj = new Object();  -- this new object we created, its reference (obj) will be stored in the stack,
and the actual object created (new Object()) will be stored in heap.
One advantage of objects getting stored in heap memory is if we have its reference with us, we can use
it from any functions.
Heap memory is not thread safe, so here we need to do thread synchronization and use lock.

if the obj we created, is passed as an argument in a function - then the function as usual will be
stored in stack, and that argument will be created inside stack (let's say param), but it will still be
pointing to the actual object. So the obj as well as the param variable both is pointing to the same
object in heap.

Also, for String specifically we have an extra space in java which is inside heap memory only,
called as String pool.

-----------------------------------------------------------------------------------------------------------

Garbage collector ::

Garbage collector in java runs on the heap memory, and keeps on checking if there is any object which
doesn't have any reference anymore, then it will delete that object. Since stack memory is a short-lived
memory, garbage collector doesn't check there.

-----------------------------------------------------------------------------------------------------------

auto-boxing and un-boxing ::

Integer num = 5  --  is auto-boxing, ultimately the data is an int data, so it won't behave like an object and
stored inside heap.
If we want to store an int data in heap, then we need to create a class and an int field there. And then if we
create an object of the class and change the int field data, then it will be stored inside heap.

-----------------------------------------------------------------------------------------------------------

Object Class ::

Object class is present in java.lang package. Every class in java is directly or indirectly derived from
Object class. If a class does not extend any other class, then it is a direct child of the Object class, and
if extends (means a child class of another class) then it is indirectly derived from Object class. That's why
when we create an object of a class, beside our own fields and methods we can see there are some extra methods
available, which actually comes from the Object class.

Object class acts as a root of the inheritance hierarchy in any java program.
*/
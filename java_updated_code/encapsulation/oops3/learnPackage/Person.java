package encapsulation.oops3.learnPackage;

public class Person {
    private String name;
    private int age;
    public static int count = 0;  // static field

    public static String job = "software developer";  // we can create n number of static fields

    public Person() {
        count++;
    }
    // setter
    public void setAge(int age) {
        boolean canBeChanged = true;
        if (canBeChanged) {
            if (age > 0) {
                this.age = age;
            }
        }
        // now through this the private age field can be accessible
        // but, we directly cannot change anything inside this class
        // which means we have the control over assigning values inside age
    }

    // getter

    public int getAge() {
        boolean canBeChanged = true;
        if (canBeChanged) return age;
        else return -1;
        // through this we can get the value we set using setter
    }
}

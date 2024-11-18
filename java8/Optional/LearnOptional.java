package java8.Optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class LearnOptional {
    public static void main(String[] args) {
        // String name = getName0(1);
        // System.out.println(name.toLowerCase());

        // what if we run the same method, and instead of a string a null value is returned.
        // String name2 = getName0(2);
        // System.out.println(name2.toLowerCase());  // throws null pointer exception, because we are trying to
        // use the .toLowerCase() method on a null value.
        // so getting a null value to a String name2 is not throwing error. But trying to use some method
        // on a null value is giving this error.


        // but to avoid this, either we can check if the return is a null or a string
//        if (name2 != null) {
//            System.out.println(name2.toLowerCase());
//        }


        // or we can use Optional. First we need to modify the getName method to return an Optional
        // value, and based on that we can avoid this error.
        Optional<String> name = getName(2);
        if (name.isPresent()) {  // checks null value
            System.out.println(name.get());  // using get() we can get the string value
        }

        name.ifPresent(System.out::println);

        Optional<String> city = getName2(1);
        city.ifPresent(System.out::println);

        Optional<String> name2 = getName2(2);
        System.out.println(name2.map(x -> x.toUpperCase()).get());

        // if a null value is returned in optional, we can actually set a default value in that case.
        String nameToBeUsed = name.isPresent() ? name.get() : "NA";
        String nameToBeUsed2 = name.orElse("NA");
        System.out.println(nameToBeUsed2);

        // we can also use orElseGet() -- but we should use that when we have some operation to do on the output.
        String nameToBeUsed3 = name.orElseGet(() -> {
            // some operation is performed
            return "NA";
        });
        System.out.println(nameToBeUsed3);

        String nameToBeUsed4 = name.orElseThrow(() -> new NoSuchElementException());
        System.out.println(nameToBeUsed4);
    }

    public static String getName0(int id) {
        return null;
    }

    public static Optional<String> getName(int id) {
        String name = "Tokyo";
        return Optional.of(name);
    }
    // but if we use this, again we have to keep a if check condition (isPresent()) -- which we don't want.
    // also using of() may still coz null pointer exception.

    public static Optional<String> getName2(int id) {
        String name = "Osaka";
        return Optional.ofNullable(name);
        // using ofNullable() already knows if it is returning null, thus the null pointer exception is not
        // going to happen.
    }
}

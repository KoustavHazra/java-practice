package java8;

public interface AnonymousVSLambda {
    String sayHi();

//    String sayHello();
}


/*
Now here we have 2 abstract function, so definitely it is not a functional interface. Which means to
use these methods we definitely need to use a class to implement them at first.

However, there is a workaround, anonymous class. Just like we implement one method inside lambda expression...
similarly we can define multiple methods inside an anonymous class without even using a separate class.

It will look like:
AnonymousVSLambda avl = new AnonymousVSLambda() {
        // this is the anonymous class body where we can directly implement multiple abstract methods
        @Override
        public String sayHi() {
            return "";
        }

        @Override
        public String sayHello() {
            return "";
        }
    };
 */
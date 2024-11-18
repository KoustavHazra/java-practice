package java8;

public class LambdaExpression {
    // regular function
    private void sayHello() {
        System.out.println("Hello");
    }
    // converting into lambda expression
    // () -> { System.out.println("Hello"); }

    // regular function
    public int sum(int a, int b) {
        return a + b;
    }
    // lambda expression
    // (int a, int b) -> {return a + b;}


    public static void main(String[] args) {
        // anonymous vs lambda
        AnonymousVSLambda avl = new AnonymousVSLambda() {
            // this is the anonymous class body where we can directly implement multiple abstract methods
//            @Override
            public String sayHi() {
                return "Hi";
            }

//            @Override
            public String sayHello() {
                return "Hello";
            }
        };
        System.out.println(avl.sayHi());
//        System.out.println(avl.sayHello());
    }


}

/*
Lambda expression --- it is an anonymous function which doesn't have a name, a return type and any modifier (public,
                        private, default, protected).

Steps to convert any regular function to a lambda expression --
1. remove the modifier
2. remove return type
3. remove method name
4. place an arrow

How to make lambda expression look more minimal:
1. if only 1 line of code is there within the function body {}, then we can remove the {}.
        (int a, int b) -> {return a + b;}  ---->  (int a, int b) -> return a + b;
        (String str) -> { return str.length(); }  ---->  (String str) -> return str.length();

2. Use type inference, because compiler guesses the argument data types.
        (int a, int b) -> return a + b;  ---->  (a, b) -> return a + b;
        (String str) -> return str.length();  ---->  (str) -> return str.length();

3. No need to use return keyword.
        (a, b) -> return a + b;  ---->  (a, b) -> a+b;
        (str) -> return str.length();  ---->  (str) -> str.length();

4. If only one input param is there, then no need to use the parenthesis.
        (str) -> str.length();  ---->  str -> str.length();


Benefits of lambda expression:
1. concise, readable and minimal code
2. because code is smaller, the jar size will decrease.
3. enables parallel processing.
4. enables functional programming.
 */
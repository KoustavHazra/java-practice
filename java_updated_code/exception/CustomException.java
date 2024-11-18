package exception;

import ch.qos.logback.core.encoder.EchoEncoder;

import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) throws MyException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter age");
        try {
            int age = sc.nextInt();
            if (age > 100) {
                throw new MyException("age more than 100");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    static class MyException extends Exception {
        public MyException(String message) {

            super(message);
        }
    }
}



/*

3. throw and throws --- we use "throws" keyword in starting of a method ( in the method declaration ) to declare
                        the type of exceptions that might occur within it.
                        -->  static int getArrEle(int[] arr) throws IOException {
                               return arr[9];
                            }

                        "throw" we use to explicitly throw a single exception.
                        -->  throw new Exception("exception");
 */
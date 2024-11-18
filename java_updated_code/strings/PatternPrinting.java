package strings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public class PatternPrinting {
    public static void main(String[] args) {
        int n = 4;
        // pattern1(n);
        // pattern2(n);
        // pattern3(n);
        // pattern4(n);
        // pattern5(n);
        // pattern6(n);
    }


    // pattern 1
    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // pattern 2
    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // pattern 3
    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = n; col >= row ; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // pattern 4
    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    // pattern 5
    static void pattern5(int n) {
        // row = 0 -> 2n - 1
        //
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int row = 1; row <= n; row++) {
            for (int col = n-1; col >= row; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col < row; col++) {
                System.out.println("a");
            }
        }
    }
}


/*

step 1: run the outer for loop the number of time, I'm having the lines.
        No of lines = No of rows = No of outer loop will run.
        Ex:
            *
            * *
            * * *
            * * * *
        Here the outer loop will run for 4 times, since, --> No of lines = No of rows = 4

step 2: how many columns are there with each row. Identify for each row, how many columns are there.

step 3: Check types of elements we need to print in each column,
        it can be string or an int value or anything. Sometimes we need to add a new line,
        so check for that situation as well.
 */
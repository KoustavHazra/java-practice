package strings;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String name = "  Koustav  Hazra";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(Arrays.toString(name.split(" ")));
        System.out.println(name.toLowerCase());
        System.out.println(name.substring(2, 4));
        System.out.println(name.trim());
        System.out.println(name.strip());

        // check a string is palindrome
        String s = "kjajk";
        boolean res = isPalindrome(s);
        System.out.println(res);

    }

    // palindrome method
    static boolean isPalindrome(String s) {
        if (s == null) return false;
        char[] arr = s.toLowerCase().toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}

package strings;

public class StringPerformance {
    public static void main(String[] args) {

        String s = "";
        // a - z using character
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);  // 'a' + int-value = int-value -> converted to char
            // 'a' + 1 = 98 -> (char) 98 -> b  -- this is how we are getting all the alphabets
            // System.out.println(ch);

            s = s + ch;
        }
        // System.out.println(s);  // now it is a string value

        // if we look at this code, every time a new alphabet is added to the string s,
        // the previous one is just kept in the memory, while the new value is getting
        // referenced by s. So by the end of the iteration, there will be 25 different string
        // kept in the memory which are not referenced by any object.
        // it is actually having a time complexity of O(n^2), since in every iteration
        // a new character is added. --> 1 + 2 + 3 + 4 + ... + N --> N (N + 2) = N^2 + 2N / 2
        // --> O(N^2) .

        // thus we need another data structure, which can actually keep on adding the
        // new values inside the old one, so that the memory wastage is not there
        // so this same thing would be done in N iterations only.
        // it will be like: a --> ab --> abc --> abcd ...

        // that is why "StringBuilder" comes into picture. Where the string data actually
        // behaves like a mutable object, which means it can be modified (unlike String).
        // and here even though the data is getting changed, the reference will stay the same.


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            sb.append(ch);
        }
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.deleteCharAt(1);
        System.out.println(sb);
    }
}

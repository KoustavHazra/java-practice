
public class FunctionProblems {
    public static void main(String[] args) {
        average(2, 5, true);
        System.out.println(args[0]);
        random(2, 4);
    }

    static void average(float a, float b, boolean really) {
        float avg = (a + b) / 2;
        System.out.println("The average is " + avg);
        System.out.println("yes it is " + really);
    }

    static void random(int min, int max) {
        int num = (int) (Math.random() * (max - min + 1) + min);
        System.out.println(num);
    }
}

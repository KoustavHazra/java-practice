
public class ProblemOnArrays {
    public static void main(String[] args) {
       int[] numbers = {1,2,3,4,5,6,7,8,9};
       int sum = 0;
       for (int number: numbers) {
           sum += number;
       }
       System.out.println("total sum is " + sum);

       int max = Integer.MIN_VALUE;
       for (int number: numbers) {
           if (number > max) {
               max = number;
           }
       }
       System.out.println("Maximum number is " + max);
    }
}

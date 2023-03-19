public class SumOf2ndRowIn2DArray {
    public static void main(String args[]) {
        int nums[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        int sum = 0;
        for (int i = 0; i < nums[0].length; i++) {
            sum += nums[1][i];
        }
        System.out.println("Sum of 2nd Row Element is " + sum);
    }
}
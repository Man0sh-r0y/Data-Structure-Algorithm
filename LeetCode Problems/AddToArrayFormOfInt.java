import java.util.*;
import java.math.BigInteger;

public class AddToArrayFormOfInt {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            number.append(num[i]);
        }
        BigInteger bd = new BigInteger(number.toString());
        BigInteger sum = bd.add(BigInteger.valueOf(k));
        System.out.println(sum);
        int i = 0;
        int size = sum.toString().length();
        while (i < size) {
            result.add(sum.mod(BigInteger.valueOf(10)).intValue());
            sum = sum.divide(BigInteger.valueOf(10));
            i++;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        // int num[] = { 2, 7, 4 };
        // int k = 181;
        // List<Integer> result = addToArrayForm(num, k);// 274 + 181 = 455
        // int num[] = { 1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3 };
        // int k = 516;
        // List<Integer> result = addToArrayForm(num, k);
        int num[] = { 2, 1, 5 };
        int k = 806;
        List<Integer> result = addToArrayForm(num, k);
        System.out.println(result);
    }
}

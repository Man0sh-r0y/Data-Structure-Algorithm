import java.util.*;

public class _36_KthPermutationFind {

    public static void findPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fact *= (i + 1);
            numbers.add(i + 1);// As indexing starts from 0 so numbers adding will start from 1
        }
        fact = fact / numbers.size();// 4!=24, every numbers set (1,2,3,4) has 24/4=6 permutations
        k = k - 1;/*
                   * kth permutation means we have to find (k-1)th permutation as here indexing
                   * starts from 0
                   */
        String ans = new String("");
        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            k = k % fact;
            if (numbers.size() == 0)
                break;
            fact = fact / numbers.size();
        }
        System.out.println(ans);

    }

    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        findPermutation(n, k);
    }
}

import java.util.*;

// Question Link: https://www.spoj.com/problems/EKO/

class Solution {

    public static long findMax(long[] arr) {
        long max = arr[0];

        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public static long requiredWood(long[] treeHight, long bladeHight) {
        long woods = 0; // measurement unit in meters

        for(int i=0; i<treeHight.length; i++) {
            if(treeHight[i] >= bladeHight) {
                woods += treeHight[i] - bladeHight;
            }
        }

        return woods;
    }

    public static long maxHightOfBlade(long[] treeHight, long M) {
        long maxHight = Integer.MIN_VALUE;

        long low = 1, high = findMax(treeHight);

        while(low <= high) {
            long mid = low + (high - low) / 2;
            long woods = requiredWood(treeHight, mid);

            if(woods < M) {
                high = mid - 1;
            }
            else {
                maxHight = mid;
                low = mid + 1;
            }
        }

        return maxHight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();// number of trees
        long M = sc.nextInt();// number of woods required
        long[] treeHight = new long[(int)N]; // Hights of each tree

        for(int i=0; i<N; i++) {
            treeHight[i] = sc.nextInt();
        }

        System.out.println(maxHightOfBlade(treeHight, M));

        sc.close();
    }
}

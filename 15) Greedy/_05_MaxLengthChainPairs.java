import java.util.Comparator;
import java.util.Arrays;

public class _05_MaxLengthChainPairs {

    // Question: Given an array of pairs of numbers of size N. In every pair, the
    // first number is always smaller than the second number. A pair (a, b) can
    // follow another pair (c, d) if b < c. The chain of pairs can be formed in this
    // fashion. The task is to find the length of the longest chain which can be
    // formed from a given set of pairs.

    // Approach:

    // (i) Make Pair Class to store pair of numbers in Array
    // (ii) Make an array which can store this all pairs
    // (iii) sort them based on their second number of each pair
    // (iv) Take a variable which will be storing the 1st Pair object's (1st array
    // element) second number
    // (v) We will take a loop where We check if next pair object's first number is
    // greater than this variable. Then this variable will be updated again

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int findMaxLength(Pair[] p) {
        // Sorting array based on each pair object's second element
        Arrays.sort(p, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.second - b.second;// sorting in increasing order
            }
        });

        // Pick up the first pair and assign the value of second element of pair
        int lastEnd = p[0].second;
        int maxLength = 1;// As 1 Pair object has been assigned that's why maxLength is initialized with 1

        // Now Running a loop and checking weather next pair object's first number is
        // greater than lastEnd
        for (int i = 1; i < p.length; i++) {
            if (p[i].first > lastEnd) {
                maxLength++;
                lastEnd = p[i].second;
            }
        }
        return maxLength;// returning the max length
    }

    public static void main(String[] args) {
        int arr[][] = { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };
        int N = 5;
        // The longest chain that can be formed is of length 3, and the chain is
        // {{5, 24}, {27, 40}, {50, 90}}

        // Now creating Pair array
        Pair[] p = new Pair[arr.length];// an Array that can store Pair type object

        // Now Inserting Pair element into this array
        for (int i = 0; i < arr.length; i++) {
            p[i] = new Pair(arr[i][0], arr[i][1]);
        }

        // prinitng
        System.out.println(findMaxLength(p));
    }
}

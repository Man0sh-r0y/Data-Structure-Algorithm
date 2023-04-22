import java.util.PriorityQueue;
import java.util.Comparator;

public class _12_HalfArraySum {
    // Steps to be followed:

    // 1st Step: Calculate sum of the array element

    // 2nd step: Add all the Array Element into PriorityQueue (max heap)

    // 3rd step: Pick the largest element from PriorityQueue
    // and half it until sum is getting less than its half

    public static int halfArraySum(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());// max heap
        double sum = 0.0;// taking sum as a double
        // 1st step & 2nd step combined together
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];// Sum of the all array element
            pq.add(nums[i] * 1.0);// Add all the Array Element into PriorityQueue
            // converting all array elements from int to double by multiplying with 1.0
        }
        // 3rd step
        double temp = sum;
        int operations = 0;// counting the number of operation taken to half the sum of array
        while (temp > sum / 2) {
            double element = pq.remove(); // getting the largest element
            temp -= element / 2;// doing half of the largest element
            pq.add(element / 2);
            operations++;
        }
        return operations;
        // We are taking all elements as double insetad of taking int
        // Because temp is double as we are storing element / 2 every time (in Loop)
        // while changing from double to int, some data is lost (decimal points)
        // so wrong ans might come
        // if we take double all matical calculations will be appropriate
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 8, 19 };
        System.out.println("The Number of Operation to half the Array sum is " + halfArraySum(nums));
    }
}

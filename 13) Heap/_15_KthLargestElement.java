import java.util.PriorityQueue;
import java.util.Comparator;

public class _15_KthLargestElement {

    public int findKthLargest(int[] nums, int k) { // O(NlogN) 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < nums.length; i++) 
            pq.add(nums[i]);
        
        while(k-- > 1) {
            pq.remove();
        }

        return pq.remove();
        
    }

    public int findKthLargestII(int[] nums, int k) { // O(NlogN) 
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert First k elements
        for(int i=0; i<k; i++) 
            pq.add(nums[i]);
        
        // Run the loop for rest of the elements
        for(int i=k; i<nums.length; i++) {
            if(pq.peek() < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
        
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new _15_KthLargestElement().findKthLargest(nums, k));
        System.out.println(new _15_KthLargestElement().findKthLargestII(nums, k));
    }
}

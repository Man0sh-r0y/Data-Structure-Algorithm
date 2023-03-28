import java.util.PriorityQueue;

public class _10_KthLargestElement {

    static class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;// I have to find Kth Largest Element

        KthLargest(int k, int[] nums) {// constructor
            this.k = k;
            pq = new PriorityQueue<>();
            // adding all array element into Priority Queue
            for (int i = 0; i < nums.length; i++)
                pq.add(nums[i]);
            // keeping only k elements in PQ so we can easily get the Kth Largest Element
            while (pq.size() > k)
                pq.remove();
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k)
                pq.remove();
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 8, 2 };
        int k = 3;

        KthLargest obj = new KthLargest(k, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}
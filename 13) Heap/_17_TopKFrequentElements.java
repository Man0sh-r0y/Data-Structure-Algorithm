import java.util.*;

public class _17_TopKFrequentElements {

    public static int[] topKFrequent(int[] arr, int k) {// NlogK
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        int[] ans = new int[k];
        int count = 0;

        for(int i=0; i<arr.length; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (count < k) {
                pq.add(entry);
                count++;
                continue;
            } 
            
            if(entry.getValue() > pq.peek().getValue()) {
                pq.remove();
                pq.add(entry);
            }
        }
        
        while(!pq.isEmpty()) ans[--k] = pq.remove().getKey();

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;
        int[] ans = topKFrequent(arr, k);

        for(int i: ans) System.out.print(i + " ");

    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _46_SubArrayXOR {

    // Better Solution
    public static int countSubArray(List<Integer> A, int B) {
        int count = 0;// count the subarray

        for(int i=0; i<A.size(); i++) {
            int xor = 0;
            for(int j=i; j<A.size(); j++) {
                xor ^= A.get(j);
                if(xor == B)
                    count++;
            }
        }

        return count;
    }

    // Optimal Solution
    public static int countSubArray2(List<Integer> A, int B) {
        int count = 0, xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int i=0; i<A.size(); i++) {
            xor ^= A.get(i);

            if(xor == B) {
                count++;
            }

            if(map.containsKey(xor ^ B)){
                count += map.get(xor ^ B);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(4, 2, 2, 6, 4);
        System.out.println(countSubArray2(A, 6));
    }
}

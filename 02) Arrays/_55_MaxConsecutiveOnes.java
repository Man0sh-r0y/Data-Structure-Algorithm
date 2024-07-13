public class _55_MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) { // O(N) T.c, O(1) S.C
        int count = 0; // count consecutive ones
        int maxOnes = 0; // maximum number of consecutive ones

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) count++;
            else count = 0;

            maxOnes = Math.max(maxOnes, count);
        }

        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}

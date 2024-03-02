public class _25_SingleNumber {

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }
        return xor; 
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
}

public class _52_MaxProductSubArray {

    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        int prefixProduct = 1, suffixProduct = 1;

        for(int i=0; i<nums.length; i++) {
            if(prefixProduct == 0) 
                prefixProduct = 1;
            if(suffixProduct == 0)
                suffixProduct = 1;
            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }

        return maxProduct;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
}

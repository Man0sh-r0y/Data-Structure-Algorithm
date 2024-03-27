public class _23_SplitArrayLargestSum {

    public static int splitInSubArray(int[] nums, int sumLimit) {// this function determines how many subarray will be formed if I set the sumLimit
        int subArray = 1; // start with the 1st subarray
        int sum = 0; // initially, sum not calculated

        // sum limit is bassically minimum possible largest sum among all the subarray

        for(int i=0; i<nums.length; i++) {
            if(sum + nums[i] <= sumLimit) {
                sum += nums[i];
            }
            else {
                sum = nums[i]; 
                subArray++; // starting of the next subarray (array is splitted)
            }
        }

        return subArray;
    }

    // Brute Force
    public static int splitArray(int[] nums, int k) {
        int min = 0, max = 0;

        if(nums.length < k) // if array size is smaller than k then spliting isn't possible
            return -1;

        for(int i=0; i<nums.length; i++) {
            min = Math.max(min, nums[i]);
            max += nums[i];
        }

        // If there are 4 size of array and I've to split the array into 4 subarray
        // Then if someone take the element which is largest in the array, 
        // Then it will be the minimum possible largest sum among all the subarray after spliting the array into 4 parts
        // So Range starts from max(nums)
        // Range ends at sum(nums)
        // if there is an array and I have to divide it in 1 part, then it means the whole array is treated is like a single subarray 
        // so, in this case minimum possible largest sum is summation of whole array elements

        int sum = min; // starting of the range

        for(int i=min; i<=max; i++) {
            // finding the minimum possible largest subarray sum
            // I'm trying to find how many subarray is going to form if I set the sumLimit as i
            // There will be a certain point when I set the sumLimit as i, and for this sumLimit I'm able to divide the array into k subarray
            // I'm setting the sum limit because there will be a subarray who will have sum in this limit for which it will be the minimum possible largest subarray sum
            if(splitInSubArray(nums, i) == k){
                sum = i; // I gpt the minimum possible largest subarray sum
                break;
            }
        }

        return sum; // return the minimum possible largest subarray sum
    }

    // Optimal 
    public static int splitArray2ndApproach(int[] nums, int k) {
        int low = 0, high = 0;

        for(int i=0; i<nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        int sum = low; // starting of the range

        while(low <= high) {
            int mid = low + (high - low) / 2; // minimum possible largest subarray sum

            int cntSubArray = splitInSubArray(nums, mid); // how many subarray formed

            if(cntSubArray <= k){
                sum = mid;
                high = mid - 1; // Reduce the value of sum limit (largest subarray sum) 
                // if subarray formed < k, Why did it happen? => the reason is I have set the sum limit (largest subarray sum) so high that I'm not able to divide the array into k subarray
                // If subarray formed == k, then for this sumLimit I'm able to divide the array into k subarray But still, I want the lesser value of sum limit (largest subarray sum) 
            } 
            else {
                low = mid + 1; // increase the value of sum limit (largest subarray sum)
                // if subarray formed > k, Why did it happen? => the reason is I have set the sum limit (largest subarray sum) so less that I divied the subarray more than the requirement (k subarray)
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 1, 1, 1};
        int k = 5;
        System.out.println(splitArray(nums, k));
        System.out.println(splitArray2ndApproach(nums, k));
    }
}

public class RemoveDublicateFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int k = 0;// indx
        int element = nums[k];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != element) {
                element = nums[i];
                nums[++k] = element;
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

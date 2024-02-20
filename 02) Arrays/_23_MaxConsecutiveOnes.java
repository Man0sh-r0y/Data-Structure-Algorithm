public class _23_MaxConsecutiveOnes {

  public static int maxConsecutiveOnes(int[] nums) {
    int consecutive = 0, maxConsecutive = 0;
    for(int i=0; i<nums.length; i++) {
      if(nums[i] == 1) {
        consecutive++;
      } else {
        maxConsecutive = Math.max(consecutive, maxConsecutive);
        consecutive = 0;
      }
    }
    return Math.max(consecutive, maxConsecutive);
  }
  
  public static void main(String[] args) {
    int[] nums = new int[]{1,1,0,1,1,1};
    System.out.println(maxConsecutiveOnes(nums));
  }
}
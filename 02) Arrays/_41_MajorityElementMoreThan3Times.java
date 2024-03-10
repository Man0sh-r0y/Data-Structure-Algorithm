import java.util.ArrayList;
import java.util.List;

public class _41_MajorityElementMoreThan3Times {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE, cnt1 = 0, cnt2 = 0;

        for(int i=0; i<nums.length; i++) {
            if(cnt1 == 0 && el2 != nums[i]){
                el1 = nums[i];
                cnt1++;
            } else if(cnt2 == 0 && el1 != nums[i]){
                el2 = nums[i];
                cnt2++;
            } else if(nums[i] == el1){
                cnt1++;
            } else if(nums[i] == el2){
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // check if the elements are actually majority elements
        cnt1 = 0;
        cnt2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == el1) {
                cnt1++;
            } else if(nums[i] == el2) {
                cnt2++;
            }
        }

        if(cnt1 > nums.length/3) {
            ans.add(el1);
        }
        if(cnt2 > nums.length/3) {
            ans.add(el2);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,2,2,2,2,3};
        System.out.println(majorityElement(nums));
    }
}

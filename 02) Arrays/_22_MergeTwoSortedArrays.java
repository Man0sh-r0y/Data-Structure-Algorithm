import java.util.ArrayList;
import java.util.List;

public class _22_MergeTwoSortedArrays {

  public static boolean matchLastElement(ArrayList<Integer> arr, int element) { // match the arraylist's last element with the given element
    if(!arr.isEmpty() && arr.get(arr.size() -1) == element) 
      return true;

    return false;
  }

  public static List< Integer > sortedArray(int []a, int []b) { // 2 pointer approach
    ArrayList<Integer> ans = new ArrayList<>();
    int i = 0, j = 0;

    while(i < a.length && j < b.length) {
      if(a[i] <= b[j]) {
        if(matchLastElement(ans, a[i])) // if this current element already exits in the arraylist
          i++; // in this case we will not add any duplicate element to our ans list
        else 
          ans.add(a[i++]); // add the element to our ans list
      } else {
        if(matchLastElement(ans, b[j])) // if this current element already exits in the arraylist
          j++; // in this case we will not add any duplicate element to our ans list
        else 
          ans.add(b[j++]); // add the element to our ans list
      }
    }

    while(i < a.length) { // if any element left in 1st array
      if(matchLastElement(ans, a[i])) // if this current element already exits in the arraylist
        i++;
      else 
        ans.add(a[i++]);
    }

    while(j < b.length) { // if any element left in 2nd array
      if(matchLastElement(ans, b[j])) // if this current element already exits in the arraylist
        j++;
      else 
        ans.add(b[j++]);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 4, 6};
    int[] b = new int[]{2, 3, 5};
    System.out.println(sortedArray(a,b));
  }
}
import java.util.ArrayList;
import java.util.List;

public class _22_MergeTwoSortedArrays {

  public static boolean matchLastElement(ArrayList<Integer> arr, int element) { // match the arraylist's last element with the given element
    if(!arr.isEmpty() && arr.get(arr.size() -1) == element) 
      return true;

    return false;
  }

  public static List< Integer > sortedArray(int []a, int []b) {
    ArrayList<Integer> ans = new ArrayList<>();
    int indx1 = 0, indx2 = 0;

    while(indx1 < a.length && indx2 < b.length) {
      if(a[indx1] <= b[indx2]) {
        if(matchLastElement(ans, a[indx1])) // if this current element already exits in the arraylist
          indx1++; // in this case we will not add any duplicate element to our ans list
        else 
          ans.add(a[indx1++]); // add the element to our ans list
      } else {
        if(matchLastElement(ans, b[indx2])) // if this current element already exits in the arraylist
          indx2++; // in this case we will not add any duplicate element to our ans list
        else 
          ans.add(b[indx2++]); // add the element to our ans list
      }
    }

    while(indx1 < a.length) { // if any element left in 1st array
      if(matchLastElement(ans, a[indx1])) // if this current element already exits in the arraylist
        indx1++;
      else 
        ans.add(a[indx1++]);
    }

    while(indx2 < b.length) { // if any element left in 2nd array
      if(matchLastElement(ans, b[indx2])) // if this current element already exits in the arraylist
        indx2++;
      else 
        ans.add(b[indx2++]);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 4, 6};
    int[] b = new int[]{2, 3, 5};
    System.out.println(sortedArray(a,b));
  }
}
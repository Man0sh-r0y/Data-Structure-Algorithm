import java.util.Arrays;

public class _21_MoveZerosToEnd {

  public static int[] moveZeros(int n, int []arr) {
    int indx=0;
    int[] ans = new int[n];

    for(int i=0; i<n; i++){
      if(arr[i]==0) continue;
      ans[indx++]=arr[i];
    }

    for(int i=indx; i<n; i++) ans[i]=0;

    return ans;
  }
  
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 0, 0, 2, 3};
    System.out.println(Arrays.toString(moveZeros(arr.length, arr)));
  }
}
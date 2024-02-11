import java.util.Arrays;

public class _19_LeftRotateArray {

    public static int[] rotateArray(int[] arr, int n) {
      if(n == 1) return arr;

      int firstElement = arr[0];

      for(int i=0; i<n; i++){
        if(i==n-1){
          arr[i]=firstElement;
        } else {
          arr[i]=arr[i+1];
        }
      }

      return arr;

    }

  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5};
    System.out.println(Arrays.toString(rotateArray(arr, arr.length)));
  }
}
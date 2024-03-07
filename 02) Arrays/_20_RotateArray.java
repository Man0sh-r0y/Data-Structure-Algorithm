import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
 public class _20_RotateArray{

  public static void leftRotateArray(int[] arr, int k) {
    // It may possible that k > arr.length, so, I will do k = k % arr.length
    k = k % arr.length;
    Queue<Integer> q = new LinkedList<>();
    // add first k elements to the queue
    for(int i=0; i<k; i++){
      q.add(arr[i]);
    }
    // shift the remaining elements to the left by k places in the array
    for(int i=k; i<arr.length; i++){
      arr[i-k] = arr[i];
    }

    // add the elements from the queue to the end of the array
    for(int i=arr.length-k; i<arr.length; i++){
      arr[i] = q.remove();
    }

  }

  public static void rightRotateArray(int[] arr, int k) {
    // It may possible that k > arr.length, so, I will do k = k % arr.length
    k = k % arr.length;
    Queue<Integer> q = new LinkedList<>();
    // add last k elements to the queue
    for(int i=arr.length-k; i<arr.length; i++){
      q.add(arr[i]);
    }
    // shift the remaining elements to the right by k places in the array
    for(int i=arr.length-k-1; i>=0; i--){
      arr[i+k] = arr[i];
    }
    // add the elements from the queue to the front of the array
    for(int i=0; i<k; i++){
      arr[i] = q.remove();
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int[] arr2 = new int[]{1, 2, 3, 4, 5};
    int k = 2; // left rotate by 2 places
    leftRotateArray(arr, k);
    rightRotateArray(arr2, k);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arr2));
  }
}
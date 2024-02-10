import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _20_RotateArray{
  public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
    Queue<Integer> q = new LinkedList<>();

    for(int i=0; i<k; i++){
      q.add(arr.remove(0));
    }

    while(!q.isEmpty()){
      arr.add(q.remove());
    }

    return arr;
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    System.out.println(rotateArray(arr, 3));
  }
}
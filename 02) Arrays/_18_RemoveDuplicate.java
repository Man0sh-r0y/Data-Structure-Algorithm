import java.util.HashMap;

class _18_RemoveDuplicate{
  public static int removeDuplicates(int[] arr,int n) {
    if(arr.length == 1) return 1;

    HashMap <Integer, Integer> map = new HashMap<>();

    for(int i=0; i<n; i++) {
      if(map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i])+1);
      } else {
        map.put(arr[i], 1);
      }
    }

    return map.size();
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1,2,2,2,3};
    System.out.println(removeDuplicates(arr, arr.length));
  }
}
import java.util.HashMap;
import java.util.Set;

public class _06_GetMajorityElement {

    public static int majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // We will map every array element with their frequency

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            // frequency will be incremented by 1
        }
        // map.getOrDefault() is used to get the value mapped with specified key.
        // If no value is mapped with the provided key
        // then the default value is returned. (here default value is givven as 0)
        int maxElement = arr[0];// maxElement => the element whoose frequency is maximum
        // it's initialized with first element of array.
        // We can initialize with any value of array
        for (Integer key : map.keySet()) {
            maxElement = map.get(key) > map.get(maxElement) ? key : maxElement;
            // checking which key's value is biggest
        }

        return maxElement;// return the most frequency element
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        System.out.println(majorityElement(arr));
    }
}

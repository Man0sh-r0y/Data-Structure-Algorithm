import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfSumK {

    public static boolean printSubSequence(int indx, List<Integer> list, int s, int sum, int arr[]) {
        if (indx == arr.length) {
            if (s == sum) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i) + " ");
                }
                return true;
            }
            return false;
        }

        list.add(arr[indx]);
        s += arr[indx];
        if (printSubSequence(indx + 1, list, s, sum, arr) == true) {
            // picking the element
            return true;
        }

        s -= arr[indx];
        list.remove(list.size() - 1);
        if (printSubSequence(indx + 1, list, s, sum, arr) == true) {
            // not picking the element
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        int sum = 2;
        boolean isPresent = printSubSequence(sum, new ArrayList<>(), sum, sum, arr);
        System.out.println(isPresent);
    }
}

import java.util.*;
import java.util.Collections;

public class _03_SortingArrayList {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        System.out.print(list);// [5, 1, 4, 2, 3]
        Collections.sort(list);
        System.out.println();
        System.out.print(list);// [1, 2, 3, 4, 5]
        Collections.sort(list, Collections.reverseOrder());
        System.out.println();
        System.out.println(list);// [5, 4, 3, 2, 1]
    }
}

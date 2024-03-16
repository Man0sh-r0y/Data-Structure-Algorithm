import java.util.ArrayList;
import java.util.Collections;

public class _01_ArrayListMethods {

    public static void swap(ArrayList<Integer> list, int indx1, int indx2) {
        int temp = list.get(indx1);
        list.set(indx1, list.get(indx2));
        list.set(indx2, temp);
    }

    public static void main(String args[]) {
        // Basic Operations
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);// [1, 2, 3, 4, 5]

        int getElement = list.get(2);// Element at index 2
        System.out.println(getElement);// 3

        list.remove(2);// remove element at index 2
        System.out.println(list);// [1, 2, 4, 5]

        list.set(2, 10);// set new element 10 at index 2
        System.out.println(list);// [1, 2, 10, 5]
        System.out.println(list.contains(1));// true
        System.out.println(list.contains(3));// false

        list.add(4, 20);// add 20 at index 4

        System.out.println(list);// [1, 2, 10, 5, 20]
        System.out.println(list.size());// 5

        for (int i = 0; i < list.size(); i++) {// print ArrayList
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Reverse an ArrayList
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

        // Find Max in ArrayList
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        System.out.println("\nMax is = " + max);

        // Swap 2 Numbers
        System.out.println(list);// [1, 2, 10, 5, 20]-->Before Swap
        swap(list, 0, 1);
        System.out.println(list);// [2, 1, 10, 5, 20]-->After Swap

        // Sort an ArrayList
        Collections.sort(list);
        System.out.println(list);// [1, 2, 5, 10, 20]

        // remove all elements in ArrayList
        list.clear();
        System.out.println(list);

    }
}
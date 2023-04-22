import java.util.*;

public class _05_SearchInLinkedList {

    public static int recursiveSearch(LinkedList<Integer> ll, int indx, int element) {
        // recursive search
        if (indx >= ll.size()) {
            return -1;
        }
        if (ll.get(indx) == element) {
            return 0;
        }
        int elementIndx = recursiveSearch(ll, indx + 1, element);
        return elementIndx + 1;
    }

    public static int iterativeSearch(LinkedList<Integer> ll, int element) {
        // Iterative Search
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i) == element) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        System.out.println(recursiveSearch(ll, 0, 6));
        System.out.println(iterativeSearch(ll, 6));
    }
}

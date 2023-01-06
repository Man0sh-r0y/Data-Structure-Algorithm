import java.util.LinkedList;

public class getMidNode {
    public static void main(String[] args) {
        // Using JAVA Collection
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        int size = ll.size();
        int mid = size / 2;
        int midNode = ll.get(mid);
        System.out.println("LinkedList Size is " + size);
        System.out.println("Mid Node is " + midNode);
    }
}

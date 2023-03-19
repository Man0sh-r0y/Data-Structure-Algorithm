import java.util.ArrayList;
import java.util.TreeMap;

/* Before going through this code please watch its One more Approach which is done by Level Order Traversing */
public class VerticalOrderByPreOrder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {// to store Nodes with its vertical line value or Column index
        Node node;
        int key; // will store each Node's Column index

        Pair(Node node, int key) {
            this.node = node;
            this.key = key;
        }
    }

    public static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

    public static void verticalOrder(Pair pair) {
        if (pair.node == null) {
            return;
        }
        Node currNode = pair.node;
        int colIndex = pair.key;
        if (!map.containsKey(colIndex)) {
            map.put(colIndex, new ArrayList<>());
        }
        map.get(colIndex).add(currNode.data);

        verticalOrder(new Pair(currNode.left, colIndex - 1));
        verticalOrder(new Pair(currNode.right, colIndex + 1));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        verticalOrder(new Pair(root, 0));
        System.out.println(map.values());
    }
}

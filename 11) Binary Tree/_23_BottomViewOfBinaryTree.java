import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Queue;

public class _23_BottomViewOfBinaryTree {

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

    // I'll use level order traverse to get the Bottom View
    public static void bottomView(Node root) {
        // I want to map each Node with its vertical index (Column index)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Difference between TreeMap and HashMap in Java is Mostly Tree map stores the
        // data in sorted order key wise where the HashMap doesn't.
        // here we needed the key in Sorted order so we used TreeMap.
        // Here, Key is the Column index and value is last Node at each column
        // we have to take each columns's last Node
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair currPair = q.remove();
            Node currNode = currPair.node;
            int colIndex = currPair.key;
            map.put(colIndex, currNode.data);
            // if any key (column index) present in TreeMap then its value will be replaced
            // with the new key Value with remaining key in TreeMap
            // As I want last node of each column. That's bottom view
            if (currNode.left != null) {
                q.add(new Pair(currNode.left, colIndex - 1));// traversing in left decrease the colIndex
            }
            if (currNode.right != null) {
                q.add(new Pair(currNode.right, colIndex + 1));// // traversing in right increase the colIndex
            }
        }

        System.out.println(map.values());// printing the bottom view nodes
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        bottomView(root);
    }
}

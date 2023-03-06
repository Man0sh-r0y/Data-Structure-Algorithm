import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Queue;

public class VerticalOrderByLevelOrder {

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

    // printing vertical order By traversing in level order
    public static void verticalOrder(Node root) {
        // I want to map each Node with its vertical index (Column index)
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // Difference between TreeMap and HashMap in Java is Mostly Tree map stores the
        // data in sorted order key wise where the HashMap doesn't.
        // here we needed the key in Sorted order so we used TreeMap.
        // In this TreeMap, Key is the Column index and value is Nodes at each column
        // Here in each key, it might have multiple values because:
        // in the each column there might have multiple Nodes So we took ArrayList
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));// root with its column index = 0
        // now we will do level order traversal
        while (!q.isEmpty()) {
            Pair currPair = q.remove(); // getting out the current Pair
            Node currNode = currPair.node; // current Node
            int colIndex = currPair.key; // column indx or vertical line number of current node

            if (!map.containsKey(colIndex)) {
                // containsKey() method checks:
                // if the mapping for the specified key is present in the hashmap.
                map.put(colIndex, new ArrayList<>());
            }
            map.get(colIndex).add(currNode.data);// adding node in the map according to its column index
            if (currNode.left != null) {
                q.add(new Pair(currNode.left, colIndex - 1));// traversing in left decrease the colIndex
            }
            if (currNode.right != null) {
                q.add(new Pair(currNode.right, colIndex + 1));// // traversing in right increase the colIndex
            }
        }

        System.out.println(map.values());// printing the Vertical Order Traversal
        // values will be printed according to the sorted order of column Index
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        verticalOrder(root);
    }
}

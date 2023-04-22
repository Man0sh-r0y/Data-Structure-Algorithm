import java.util.ArrayList;

public class _26_RootToNodePath {

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

    public static ArrayList<Integer> path = new ArrayList<>();

    public static boolean rootToNode(Node root, int nodeData) {
        if (root == null) {
            return false; // not present our required node
        }

        path.add(root.data);// adding nodes (Paths to reach out to the required node)

        if (root.data == nodeData) {
            return true;
        }

        boolean leftSearch = rootToNode(root.left, nodeData);
        boolean righSearch = rootToNode(root.right, nodeData);

        if (leftSearch || righSearch) {
            return true; // if any of them is true then return true
        }

        path.remove(path.size() - 1); // if both are false then this path shouldn't include

        return false; // not found
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        rootToNode(root, 7);
        System.out.println(path);
    }
}

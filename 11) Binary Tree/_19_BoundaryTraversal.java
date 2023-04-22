import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class _19_BoundaryTraversal {

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

    public static Queue<Integer> result = new LinkedList<>();

    public static boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    public static void addLeftBoundary(Node root) {
        Node currNode = root.left;
        while (currNode != null) {
            if (!isLeafNode(currNode)) {
                result.add(currNode.data);
            }
            if (currNode.left != null) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }

        }
    }

    public static void addRightBoundary(Node root) {
        Node currNode = root.right;
        Stack<Node> s = new Stack<>();
        while (currNode != null) {
            if (!isLeafNode(currNode)) {
                s.push(currNode);
            }
            if (currNode.right != null) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }
        // As we want reverse oder (anticlockwise)
        while (!s.isEmpty()) {
            result.add(s.pop().data);
        }
    }

    public static void addLeafNodes(Node root) {
        if (root == null) {
            return;
        }
        if (isLeafNode(root)) {
            result.add(root.data);
        }
        addLeafNodes(root.left);
        addLeafNodes(root.right);
    }

    public static void printBoundary(Node root) {
        result.add(root.data);
        addLeftBoundary(root);
        addLeafNodes(root);
        addRightBoundary(root);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printBoundary(root);
        System.out.println(result);
    }
}

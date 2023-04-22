import java.util.*;

public class _12_PreInPostOrderTraversal {

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

    static ArrayList<Integer> preOrder = new ArrayList<>();
    static ArrayList<Integer> postOrder = new ArrayList<>();
    static ArrayList<Integer> inOrder = new ArrayList<>();

    // Using Recursive Approach
    public static void preInPostTraverse(Node root) {
        if (root == null) {
            return;
        }
        // post order traversal
        preOrder.add(root.data);
        preInPostTraverse(root.left);
        // inOrder Traversal
        inOrder.add(root.data);
        preInPostTraverse(root.right);
        // post Order Traversal
        postOrder.add(root.data);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preInPostTraverse(root);
        System.out.println("PreOder Traversal " + preOrder);
        System.out.println("InOder Traversal " + inOrder);
        System.out.println("PostOder Traversal " + postOrder);
    }
}

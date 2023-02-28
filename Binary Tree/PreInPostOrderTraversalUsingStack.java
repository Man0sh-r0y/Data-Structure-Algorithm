import java.util.ArrayList;
import java.util.Stack;

public class PreInPostOrderTraversalUsingStack {

    static class Node {
        int data;
        int num;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.num = 1; // special type tree for this type of traversal
            // Although without applying this method,
            // we can try by using java inbuilt pair class
        }
    }

    static ArrayList<Integer> preOrder = new ArrayList<>();
    static ArrayList<Integer> postOrder = new ArrayList<>();
    static ArrayList<Integer> inOrder = new ArrayList<>();

    // Iterative Approach
    public static void preInPostTraverse(Node root) {
        Stack<Node> s = new Stack<>();
        s.push(root);
        Node node = root;
        while (!s.isEmpty()) {
            node = s.pop();

            // Pre Order raversal
            if (node.num == 1) {
                preOrder.add(node.data);
                node.num++;
                s.push(node);
                if (node.left != null) {
                    s.push(node.left);
                }
            }
            // In Order raversal
            else if (node.num == 2) {
                inOrder.add(node.data);
                node.num++;
                s.push(node);
                if (node.right != null) {
                    s.push(node.right);
                }
            }
            // Post Order raversal
            else if (node.num == 3) {
                postOrder.add(node.data);
            }
        }
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

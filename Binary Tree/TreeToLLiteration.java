import java.util.Stack;

public class TreeToLLiteration {
    // Binary Tree to LinkedList using Iteration

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

    // Iterative Approach
    public static void changeToLinkedList(Node root) {
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node curr = s.pop();
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
            if (!s.isEmpty()) {
                curr.right = s.peek();
            }
            curr.left = null;
        }
    }

    public static void printLinkedList(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printLinkedList(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        changeToLinkedList(root);
        printLinkedList(root);

    }
}

public class TreeToLLrecursive {
    // Binary Tree to LinkedList using Recursion

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

    public static Node prevNode = null;

    // recursive Approah (Method-1)
    public static void changeToLinkedList(Node root) {
        if (root == null) {
            return;
        }
        // reverse preOrder method => right,left,root
        changeToLinkedList(root.right);
        changeToLinkedList(root.left);

        root.right = prevNode;
        root.left = null;
        prevNode = root;
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

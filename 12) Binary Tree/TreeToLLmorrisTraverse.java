public class TreeToLLmorrisTraverse {
    // Binary Tree to LinkedList using Morris Traversal
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

    public static void changeToLinkedList(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node currLeft = curr.left;
                // traversing to the most right Node of the currLeft Node
                while (currLeft.right != null) {
                    currLeft = currLeft.right;
                }
                currLeft.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
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

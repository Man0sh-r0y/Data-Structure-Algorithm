public class _15_DiameterOfBinaryTree {

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

    public static int max = 0; // maximum of sum of left and right height of nodes

    public static int heightOfBinaryTree(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        max = Math.max(max, leftHeight + rightHeight); // diameter
        return 1 + Math.max(leftHeight, rightHeight); // height of a tree node
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        heightOfBinaryTree(root);
        System.out.println("Diameter of the Binary Tree is: " + max);
    }
}
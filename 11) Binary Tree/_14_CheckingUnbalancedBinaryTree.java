public class _14_CheckingUnbalancedBinaryTree {

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

    // the approach is if it's balanced binary tree then it will return the height
    // if it's not then it'll return -1
    public static int checkIfBalanced(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkIfBalanced(root.left);
        int rightHeight = checkIfBalanced(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            // If any of them returns -1 then whole tree isn't balanced
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            // The abs() method returns the absolute (positive) value of a number.
            // If the subtraction comes in -ve then it will return its +ve value
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);

        if (checkIfBalanced(root) == -1) {
            System.out.println("Binary Tree isn't Balanced");
        } else {
            System.out.println("Binary Tree is Balanced");
        }
    }
}

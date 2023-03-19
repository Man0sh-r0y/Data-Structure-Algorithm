public class MaxPathSum {
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

    public static int max = Integer.MIN_VALUE;

    // I have to find a path whose sum of the nodes's data is maximum
    public static int maxPathSum(Node root) {
        if (root == null) {
            return 0;
        }
        // there might have some node whose data is -ve.
        // so if leftSum or rightSum becomes -ve then we will not take it.
        // Instead of that we will take 0 for that case;
        // As counting -ve root data will not give maximum path
        int leftSum = Math.max(0, maxPathSum(root.left));
        int rightSum = Math.max(0, maxPathSum(root.right));
        max = Math.max(max, root.data + leftSum + rightSum);
        return root.data + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        // Node root = new Node(-10);
        // root.left = new Node(9);
        // root.right = new Node(20);
        // root.right.left = new Node(15);
        // root.right.right = new Node(7);

        // Another Tree
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.right.left = new Node(-30);
        root.right.right = new Node(-15);
        maxPathSum(root);
        System.out.println(max);

    }
}
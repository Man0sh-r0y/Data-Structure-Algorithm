public class _25_SymmetricBinaryTreeChecking {

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

    public static boolean helper(Node left, Node right) {
        // left => left subtree
        // right => right subtree
        if (left == null || right == null) {
            return left == right; // if both null then true will be returned
        }

        if (left.data != right.data) {
            return false; // if value doesn't match then false will be returned
        }

        // checking left child of left Subtree with right child of right subtree
        boolean leftRightChecking = helper(left.left, right.right);
        // checking right child of left Subtree with left child of right subtree
        boolean rightLeftChecking = helper(left.right, right.left);

        return leftRightChecking && rightLeftChecking; // if both true the it'll be true
    }

    public static boolean isSymmetric(Node root) {
        return root == null || helper(root.left, root.right);
        // helper will help to check
        // if left subtree and right subtree of the root are same or not
        // Here root.left => left subtree
        // root.right => right subtree
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root));
    }
}

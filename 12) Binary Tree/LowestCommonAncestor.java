public class LowestCommonAncestor {

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

    // LCA => Lowest Common Ancestor
    public static Node findLCA(Node root, Node p, Node q) {
        // Searching LCA of Node p & q
        if (root == null || root == p || root == q) {
            // According to the condition whatever value of root would be
            // that'll be returned
            return root;
        }

        Node leftSearch = findLCA(root.left, p, q);
        Node rightSearch = findLCA(root.right, p, q);

        if (leftSearch == null) {
            return rightSearch; // if rightSearch is null then null will be return
        } else if (rightSearch == null) {
            return leftSearch; // if leftSearch is null then null will be return
        } else {
            // both left & right are not null so we found our result
            return root;
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

        Node p = root.left.left;
        Node q = root.right.right;

        System.out.println(findLCA(root, p, q).data);
    }
}

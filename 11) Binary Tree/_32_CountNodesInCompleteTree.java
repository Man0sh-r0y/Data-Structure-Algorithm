public class _32_CountNodesInCompleteTree {

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

    public static int getLeftHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return getLeftHeight(node.left) + 1;
    }

    public static int getRightHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return getLeftHeight(node.right) + 1;
    }

    public static int countTotalNodes(Node root) {
        if (root == null) {// base case
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int righHeight = getRightHeight(root);

        if (leftHeight == righHeight) {
            return (int) Math.pow(2, leftHeight) - 1;// number of nodes calculation formula
            // Math.pow by default return double so I have to change it in int
        } else {
            return countTotalNodes(root.left) + countTotalNodes(root.right) + 1;// according to formula
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

        System.out.println(countTotalNodes(root));
    }
}

public class _29_ChildSumProperty {

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

    public static boolean isLeafNode(Node node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    // the root's data should be the sum of its childs. That's the problem state
    // and I can increment the node's data as many time as I wish
    // but I can't decrement

    public static void changeTree(Node root) {
        if (root == null) {// base condition
            return;
        }

        int sumOfChilds = 0;
        sumOfChilds += (root.left != null) ? root.left.data : sumOfChilds;
        sumOfChilds += (root.right != null) ? root.right.data : sumOfChilds;

        if (sumOfChilds >= root.data) {
            root.data = sumOfChilds;
        } else {
            // assigning root's data to its child if they are not null
            if (root.left != null) {
                root.left.data = root.data;
            }
            if (root.right != null) {
                root.right.data = root.data;
            }
        }

        changeTree(root.left); // traverse for left
        changeTree(root.right); // traverse for right

        sumOfChilds = 0;
        sumOfChilds += (root.left != null) ? root.left.data : sumOfChilds;
        sumOfChilds += (root.right != null) ? root.right.data : sumOfChilds;

        if (!isLeafNode(root)) {
            // in case of leaf node we don't need to change the data
            root.data = sumOfChilds;
        }
    }

    public static void printTree(Node root) {
        // preOrder Traversal
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(35);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(2);

        changeTree(root);
        printTree(root);
    }
}

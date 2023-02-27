public class PostOrderTraversal {

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

    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node leftChildrn = new Node(2);
        Node rightChildrn = new Node(3);
        root.left = leftChildrn;
        root.right = rightChildrn;

        Node leftLeftChildrn = new Node(4);
        Node leftRightChildrn = new Node(5);
        leftChildrn.left = leftLeftChildrn;
        leftChildrn.right = leftRightChildrn;

        Node rightLeftChildrn = new Node(7);
        Node rightRightChildrn = new Node(8);
        rightChildrn.left = rightLeftChildrn;
        rightChildrn.right = rightRightChildrn;

        postOrder(root);
    }
}

public class PreOrderTraverse {

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

    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraverse(Node root) {
        if (root == null)
            return;
        inOrderTraverse(root.left);
        System.out.print(root.data + " ");
        inOrderTraverse(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node childrn1 = new Node(2);
        Node childrn2 = new Node(3);
        root.left = childrn1;
        root.right = childrn2;

        Node leftLeftChildrn = new Node(4);
        Node leftRightChildrn = new Node(5);
        childrn1.left = leftLeftChildrn;
        childrn1.right = leftRightChildrn;

        Node rightLeftChildrn = new Node(7);
        Node rightRightChildrn = new Node(8);
        childrn2.left = rightLeftChildrn;
        childrn2.right = rightRightChildrn;

        preOrderTraversal(root);
        System.out.println();
        inOrderTraverse(root);
    }
}
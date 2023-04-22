import java.util.Scanner;

public class _01_CreateBinaryTreeWithUserInput {

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

    public static Scanner sc = new Scanner(System.in);

    public static Node createBinaryTree(Node root) {
        System.out.println("\n--------Press 1 for inserting Node--------\n------------Press 0 to Stop-------- ");
        int choice = sc.nextInt();
        if (choice == 0) {
            return null;
        }
        // Root Node inserting
        System.out.println("\nEnter the data of root Node: ");
        int data = sc.nextInt();
        root = new Node(data);
        // Left Child inserting
        System.out.println("\nEnter the Left Child data of " + root.data);
        root.left = createBinaryTree(root.left);
        // Right Child inserting
        System.out.println("\nEnter the Right Child data of " + root.data);
        root.right = createBinaryTree(root.right);
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = createBinaryTree(null);
        System.out.println("\nThe Binary Tree is: ");
        preOrder(root);
    }
}

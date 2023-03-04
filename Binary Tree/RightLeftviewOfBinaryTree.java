import java.util.ArrayList;

public class RightLeftviewOfBinaryTree {

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

    public static ArrayList<Integer> resultForRightView = new ArrayList<>();
    public static ArrayList<Integer> resultForLeftView = new ArrayList<>();

    public static void rightView(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == resultForRightView.size()) {
            resultForRightView.add(root.data);
        }
        // I'll do reverse preOrder traversal.
        // Root, Right, Left
        // level => level of the binary tree
        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }

    public static void leftView(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == resultForLeftView.size()) {
            resultForLeftView.add(root.data);
        }
        // I'll do preOrder traversal.
        // Root, Left, Right
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        leftView(root, 0);
        rightView(root, 0);

        System.out.println("Left View of Binary Tree: " + resultForLeftView);
        System.out.println("Right View of Binary Tree: " + resultForRightView);
    }
}

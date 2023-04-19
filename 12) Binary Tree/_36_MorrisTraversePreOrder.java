import java.util.ArrayList;

public class _36_MorrisTraversePreOrder {
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

    public static ArrayList<Integer> result = new ArrayList<>();

    // We do Morris Traversal by making the Binary tree to Threaded Binary Tree
    // After completing the traversal we normalize it
    public static ArrayList<Integer> MorrisTraversal(Node root) {
        // doing preOrder traversal using MorrisTraversal
        Node curr = root;// current Node
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.data);
                curr = curr.right;
            } else {
                Node currLeft = curr.left;// left node of current node
                // I will go at the most of the Right Node of this currLeft node
                while (currLeft.right != null && currLeft.right != curr) {
                    currLeft = currLeft.right;
                }

                if (currLeft.right == null) {
                    currLeft.right = curr;// making Thread
                    result.add(curr.data);
                    curr = curr.left;
                } else {
                    currLeft.right = null;// breaking Thread
                    curr = curr.right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        System.out.println(MorrisTraversal(root)); // preOrder Traversal Printing
    }
}

import java.util.ArrayList;
import java.util.Stack;

public class _06_PreOrderTraversalUsingStack {

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

    public static ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        if (root == null) {
            return result;
        }
        s.push(root);
        Node node;
        while (!s.isEmpty()) {
            node = s.pop();
            result.add(node.data);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
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
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(preOrder(root));
    }
}

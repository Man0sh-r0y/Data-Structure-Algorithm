import java.util.ArrayList;
import java.util.Stack;

public class _08_PostOrderUsing2Stack {

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

    public static ArrayList<Integer> postOrder(Node root) {
        // using 2 stacks
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if (root == null) {
            return result;
        }

        Node currNode = root;
        s1.push(currNode);
        while (!s1.isEmpty()) {
            currNode = s1.pop();
            s2.push(currNode);
            if (currNode.left != null) {
                s1.push(currNode.left);
            }
            if (currNode.right != null) {
                s1.push(currNode.right);
            }
        }
        while (!s2.isEmpty()) {
            result.add(s2.pop().data);
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

        System.out.println(postOrder(root));
    }
}

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderUsing1Stack {

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
        // using 1 stacks
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s = new Stack<>();

        if (root == null) {
            return result;
        }

        Node currNode = root;
        Node temp;
        while (currNode != null || !s.isEmpty()) {
            if (currNode != null) {
                s.push(currNode);
                currNode = currNode.left;
            } else {
                temp = s.peek().right;
                if (temp == null) {
                    temp = s.pop();
                    result.add(temp.data);
                    while (!s.isEmpty() && temp == s.peek().right) {
                        temp = s.pop();
                        result.add(temp.data);
                    }
                } else {
                    currNode = temp;
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
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(postOrder(root));
    }
}

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class _18_SpiralTraversal {

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

    public static ArrayList<LinkedList<Integer>> spiralTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Node currNode = root;
        q.add(currNode);
        boolean rightToLeft = false; // that's mean it's left to right
        // if it's true that's mean it's right to left
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                // storing nodes according to left to Right or Right to left direction
                if (rightToLeft) {
                    subList.addFirst(q.remove().data);
                } else {
                    subList.addLast(q.remove().data);
                }
            }
            rightToLeft = !rightToLeft;// changing the direction
            result.add(subList);
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

        System.out.println(spiralTraverse(root));
    }
}

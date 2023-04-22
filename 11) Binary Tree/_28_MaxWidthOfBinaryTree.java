import java.util.Queue;
import java.util.LinkedList;

public class _28_MaxWidthOfBinaryTree {

    static class Pair {
        Node node;
        int index;

        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

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

    public static int calculateMaxWidth(Node root) {
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0;
        if (root == null) {
            return maxWidth;
        }
        q.add(new Pair(root, 0));// root with index 0 uploaded
        while (!q.isEmpty()) {
            int size = q.size();
            int firstIndx = 0, lastIndx = 0;
            int minIndx = q.peek().index; // to make the index starting from 0
            // minIndex is the minimum index of a node in each level

            // for every level this for loop will run 1 time
            for (int i = 0; i < size; i++) {
                Node node = q.peek().node;
                int j = q.peek().index - minIndx; // calculating index of the node
                firstIndx = (i == 0) ? j : firstIndx; // if i==0 then only it'll be updated
                lastIndx = (i == size - 1) ? j : lastIndx;// if i==size-1 then only it'll be updated
                if (node.left != null) {
                    q.add(new Pair(node.left, j * 2 + 1));// left child index formula: (2*j+1)
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, j * 2 + 2));// right child index formula: (2*j+2)
                }
                q.remove();
            }
            maxWidth = Math.max(maxWidth, lastIndx - firstIndx + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(calculateMaxWidth(root));
    }
}

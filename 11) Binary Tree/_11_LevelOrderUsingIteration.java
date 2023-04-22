import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class _11_LevelOrderUsingIteration {

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

    // [Method-1]: In this method, the each level is divied in each ArrayList and
    // these arraylist are stored in a result arraylis
    public static ArrayList<ArrayList<Integer>> levelOder(Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                temp.add(q.remove().data);
            }
            result.add(temp);
        }

        return result;
    }

    // [Method-2]: Here each level isn't divied in the result ArrayList.
    // Just printing according to the level order
    public static ArrayList<Integer> levelOrderTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        // level order traversal
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                continue;
            }
            result.add(currNode.data);
            q.add(currNode.left);
            q.add(currNode.right);
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

        System.out.println(levelOder(root)); // [[1], [2, 3], [4, 5, 6, 7]]
        System.out.println(levelOrderTraversal(root));// [1, 2, 3, 4, 5, 6, 7]

    }
}

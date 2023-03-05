import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;

public class MinTimeToBurnBinaryTree {

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

    // our required data structures to solve this problem
    public static HashMap<Node, Node> trackParents = new HashMap<>();// it'll be storing parents of each nodes
    public static HashMap<Node, Boolean> visitedNode = new HashMap<>();// It'll track if node is visited or not

    public static void markParent(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode.left != null) {
                trackParents.put(currNode.left, currNode);// key: left child, value: currentNode
                q.add(currNode.left);
            }
            if (currNode.right != null) {
                trackParents.put(currNode.right, currNode);// key: right child, value: currentNode
                q.add(currNode.right);
            }
        }
    }

    public static int getMinTime(Node root, Node targetNode) {
        markParent(root);
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        visitedNode.put(targetNode, true);
        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            Boolean isChecked = false;// if Nodes are checked then it'll be false

            for (int i = 0; i < size; i++) {
                Node currNode = q.remove();
                // left checking
                if (currNode.left != null && visitedNode.get(currNode.left) == null) {
                    isChecked = true;
                    visitedNode.put(currNode.left, true);
                    q.add(currNode.left);
                }
                // right checking
                if (currNode.right != null && visitedNode.get(currNode.right) == null) {
                    isChecked = true;
                    visitedNode.put(currNode.right, true);
                    q.add(currNode.right);
                }

                // parent checking
                Node parentNode = trackParents.get(currNode);
                if (parentNode != null && visitedNode.get(parentNode) == null) {
                    isChecked = true;
                    visitedNode.put(parentNode, true);
                    q.add(parentNode);
                }
            }
            // incrementing time
            if (isChecked) {
                time++;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        System.out.println(getMinTime(root, root.left));
    }
}

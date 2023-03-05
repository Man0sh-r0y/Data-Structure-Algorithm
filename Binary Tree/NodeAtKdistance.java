import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class NodeAtKdistance {

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
    public static ArrayList<Integer> result = new ArrayList<>(); // for storing our result nodes
    public static HashMap<Node, Node> trackParents = new HashMap<>();// it'll be storing parents of each nodes
    public static HashMap<Node, Boolean> visitedNode = new HashMap<>();// It'll track if node is visited or not

    public static void markParents(Node root) {
        // Mark the parents of each node
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

    // applying BFS method (Breadth First Search)
    public static ArrayList<Integer> findNodes(Node root, Node targetNode, int k) {
        markParents(root); // Mark the parents of each node
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        visitedNode.put(targetNode, true);
        int currLevel = 0;// current Level as I have to go to only k=2 distance
        while (!q.isEmpty()) {
            int size = q.size();

            if (currLevel++ == k) {// 1st checking will be done then increment
                break;
            }

            for (int i = 0; i < size; i++) {
                Node currNode = q.remove();
                // left checking
                if (currNode.left != null && visitedNode.get(currNode.left) == null) {
                    q.add(currNode.left);
                    visitedNode.put(currNode.left, true);
                }
                // right checking
                if (currNode.right != null && visitedNode.get(currNode.right) == null) {
                    q.add(currNode.right);
                    visitedNode.put(currNode.right, true);
                }
                // parent checking
                Node parentNode = trackParents.get(currNode);// parent Node of the Current Node
                if (parentNode != null && visitedNode.get(parentNode) == null) {
                    q.add(parentNode);
                    visitedNode.put(parentNode, true);
                }
            }
        }

        while (!q.isEmpty()) {
            result.add(q.remove().data);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        findNodes(root, root.left, 2);// find nodes at distance k from the given node
        System.out.println(result);
    }
}

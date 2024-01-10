import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _31_MinTimeToBurnBinaryTree {

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

    public static int getMinTime(Node root, Node startNode, HashMap<Node, Node> trackParents) {
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Boolean> visitedNode = new HashMap<>();// It'll track if node is visited or not
        q.add(startNode); // adding the starting node
        visitedNode.put(startNode, true); // marking the starting node as visited
        int time = 0; // it'll be the time to burn the whole tree

        while (!q.isEmpty()) {

            int size = q.size();
            Boolean isChecked = false;// if Nodes aren't checked then it is false

            for (int i = 0; i < size; i++) { // all the adjacent nodes will be burnt in one time
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
            if (isChecked) time++;
        }

        return time;
    }

    public static Node markParent(Node root, int start, HashMap<Node, Node> trackParents) {
        Queue<Node> q = new LinkedList<>();
        Node startNode = new Node(-1); // it'll be the starting node from where the fire starts
        q.add(root); // adding root node

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode.data == start) 
                startNode = currNode; // mark the starting node
            if (currNode.left != null) {
                trackParents.put(currNode.left, currNode);// key: left child, value: currentNode
                q.add(currNode.left);
            }
            if (currNode.right != null) {
                trackParents.put(currNode.right, currNode);// key: right child, value: currentNode
                q.add(currNode.right);
            }
        }
        return startNode; // returning the starting node from where the fire starts
    }

    public static int timeToBurnBinaryTree(Node root, int start){
        HashMap<Node, Node> trackParents = new HashMap<>();// it'll be storing parents of each nodes
        Node startNode = markParent(root, start, trackParents); // startNode defines the node from where the fire starts
        int minTimeToBurn = getMinTime(root, startNode, trackParents); // minimum time to burn the whole tree
        return minTimeToBurn;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        //System.out.println(getMinTime(root, root.left));

        System.out.println(timeToBurnBinaryTree(root, 2)); // sending the root node and the starting node from where the fire starts
    }
}

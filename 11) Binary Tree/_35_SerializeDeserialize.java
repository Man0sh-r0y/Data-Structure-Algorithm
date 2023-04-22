import java.util.LinkedList;
import java.util.Queue;

public class _35_SerializeDeserialize {

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

    public static String serialize(Node root) {
        StringBuilder str = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        // level order traversal
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                str.append("# ");
                continue;
            }
            str.append(currNode.data + " ");
            q.add(currNode.left);
            q.add(currNode.right);
        }

        return str.toString();
    }

    public static Node deSerialize(String str) {
        Queue<Node> q = new LinkedList<>();
        String[] values = str.split(" ");
        // The split() method divides the string at the specified regex
        // and returns an array of substrings.
        // Here regex given is " ". (Blank Space)
        Node root = new Node(Integer.parseInt(values[0]));
        // Integer.parseInt(String_value) helps in changing string to integer
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            Node currNode = q.remove();
            if (!values[i].equals("#")) {
                currNode.left = new Node(Integer.parseInt(values[i]));
                q.add(currNode.left);
            }
            if (!values[++i].equals("#")) {
                currNode.right = new Node(Integer.parseInt(values[i]));
                q.add(currNode.right);
            }
        }

        return root;
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        // level order traversal
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                continue;
            }
            System.out.print(currNode.data + " ");
            q.add(currNode.left);
            q.add(currNode.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(13);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String str = serialize(root);
        System.out.println("Serialize form: " + str);

        Node TreeRoot = deSerialize(str);
        levelOrderTraversal(TreeRoot);

    }
}
import java.util.HashMap;

public class _33_ConstructBinaryTree_1 {
    // Construct a Binary Tree from Preorder and Inorder Traversal
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

    // This HasMap stores index with of its each nodes values inOrder array
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static int[] inOrder = { 40, 20, 50, 10, 60, 30 };
    public static int[] preOrder = { 10, 20, 40, 50, 30, 60 };
    // Given preOrder and inOrder array, with help of these
    // I have to construct Unique Binaty Tree

    public static HashMap<Integer, Integer> mapIndexWithNodes(int[] inOrder) {
        // I have to map indexes of each with node with its nodes values
        // from inOrder Array
        for (int i = 0; i < inOrder.length; i++) {// for-each loop
            map.put(inOrder[i], i);
        }
        return map;
    }

    public static Node buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        Node root = new Node(preOrder[preStart]);// found root from preOrder Array
        int rootIndex = map.get(root.data);// Root index in inOrder Array
        int numsLeft = rootIndex - inStart;// Numbers who are in the left of the root in inOrder Array

        root.left = buildTree(preStart + 1, preStart + numsLeft, inStart, rootIndex - 1);
        root.right = buildTree(preStart + numsLeft + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        // inStart => defining the index from where I have to start traverse
        // (in the inOrder Array)
        // inEnd => defining the index from where till I have to traverse
        // (in the inOrder Array)
        // preStart => defining the index from where I have to start traverse
        // (in the preOrder Array)
        // preEnd => defining the index from where till I have to traverse
        // (in the preOrder Array)
        int preStart = 0;
        int preEnd = preOrder.length - 1;
        int inStart = 0;
        int inEnd = inOrder.length - 1;

        mapIndexWithNodes(inOrder);
        Node root = buildTree(preStart, preEnd, inStart, inEnd);
        inOrderTraversal(root);
    }
}

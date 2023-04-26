import java.util.ArrayList;

public class _01_UndirectedGraphRepresentation {

    // To store Graph Nodes we will follow List Adjacency Approach
    public static void main(String[] args) {
        int n = 3, m = 3;// n = number of Nodes, m = number of edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();// will store the graph nodes

        // Here thw below for loop condition is i<=n,
        // as we need the nth index also which can refer the nth node
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());// added empty arraylist
        }

        // For each node of graph, I'll be adding all neigherhood nodes
        // Here are 3 nodes: 1, 2 and 3
        // .....1
        // ..../ \
        // ...2___3
        // Storing nodes in List Adjacency Approach will be like this:
        // 1,2
        // 2,3
        // 3,1
        // So for 1, all neigherhood nodes are 2 and 3
        // So for 2, all neigherhood nodes are 1 and 3
        // So for 3, all neigherhood nodes are 1 and 2
        // The each node will be reffered at the index of the its respective value
        // All neigherhood nodes of that node will be stored at that node's index

        // for storing the edge 1---2
        adj.get(1).add(2);// getting the empty arraylist at index 1 and added 2
        adj.get(2).add(1);// getting the empty arraylist at index 2 and added 1
        // As it's a undirected graph, here is a edge between 1 and 2.
        // So we will store both the paths: 1---2 and 2---1
        // For node 1, this node is reffered at the index 1 and its neigherhood node 2
        // is stored in this index and same goes for node 2

        // for storing the edge 2---3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // for storing edge 3---1
        adj.get(3).add(1);
        adj.get(1).add(3);

        // Print all the edges
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
        // This method is taking O(2Xm) space complexity, where m is the number of edges
        // We can see for each edges we are taking 2 space to store for both the nodes
    }
}
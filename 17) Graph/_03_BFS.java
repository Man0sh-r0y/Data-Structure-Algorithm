import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _03_BFS {

    // make adjacency list of graph
    // adding an en edge of an undirected graph
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);// adding v to u's list
        adj.get(v).add(u);// adding u to v's list
    }

    public static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V + 1]; // size will be equal to (the number of nodes +1)
        // as it's a 1 based indexing graph and arraylist is 0 based indexing
        ArrayList<Integer> bfs = new ArrayList<>();
        q.add(1);// inserted 1st node
        // Breadth First Traversal of this graph starting from 0.
        visited[1] = true; // 0 node has been visited

        // running loop
        while (!q.isEmpty()) {
            int node = q.poll(); // popping the node
            bfs.add(node);
            for (Integer adjNode : adj.get(node)) {// As these are 1 based indexing graph so node index is equal to the
                // value of the node
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int V = 5;// number of nodes or Vertexs
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();// adjacency list of graph
        // At dirst I have to check if the graph is 1 based indexing or not
        // if it's 1 based index then:
        for (int i = 1; i <= V + 1; i++)
            adj.add(new ArrayList<Integer>());

        // adding edges of the graph
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 4, 5);

        System.out.println("Adjacency list of graph:" + adj);

        // BFS traversal of graph
        System.out.println("BFS traversal of graph:" + bfs(V, adj));// [1, 2, 3, 4, 5]
    }
}

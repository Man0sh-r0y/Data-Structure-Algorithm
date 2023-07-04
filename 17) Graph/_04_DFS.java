import java.util.ArrayList;

public class _04_DFS {

    // creating adjacency list by adding edges
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v); // adding v to u's list
        adj.get(v).add(u); // adding u to v's list
    }

    // DFS
    public static void DFS(int node, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true; // as it's a 1 based indexing graph so (node index = node value)
        // as example 1 node will stored at index 1
        dfs.add(node);
        for (Integer adjNode : adj.get(node)) {
            if (!visited[adjNode])
                DFS(adjNode, dfs, adj, visited);
        }
    }

    public static void main(String[] args) {
        int V = 5; // number of vertex
        boolean visited[] = new boolean[V + 1];// it will mark if any node is visited or not while DFS
        ArrayList<Integer> dfs = new ArrayList<>(); // DFS traversal list will be stored here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();// adjacency list
        // Here I'll be having 1 based indexing graph
        for (int i = 0; i <= V + 1; i++)
            adj.add(new ArrayList<>());// adding empty arraylist to each node's index

        // adding edges of the graph
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 4, 5);

        // DFS
        DFS(1, dfs, adj, visited);

        // printing the traversal
        System.out.println(dfs);
    }
}

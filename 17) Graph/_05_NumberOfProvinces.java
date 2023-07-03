import java.util.ArrayList;

public class _05_NumberOfProvinces {

    // creating adjacency list by adding edges
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v); // adding v to u's list
        adj.get(v).add(u); // adding u to v's list
    }

    public static int V = 8; // number of vertex (vertex from 1 to 8 : 1 based indexing graph)
    public static boolean visited[] = new boolean[V + 1];// it will mark if any node is visited or not while DFS
    public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();// adjacency list

    // DFS
    public static void DFS(int node) {
        visited[node] = true; // as it's a 1 based indexing graph so (node index = node value)
        // as example 1 node will stored at index 1
        for (Integer it : adj.get(node)) {
            if (!visited[it])
                DFS(it);
        }
    }

    public static int checkProvinces() {
        int count = 0;// number of the provinces
        for (int i = 1; i <= V; i++) {// as it's 1 based indexing graph
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        for (int i = 0; i <= V + 1; i++)
            adj.add(new ArrayList<>());// adding empty arraylist to each node's index

        // adding edges of the graph
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 7, 8);

        System.out.println(checkProvinces());

    }
}

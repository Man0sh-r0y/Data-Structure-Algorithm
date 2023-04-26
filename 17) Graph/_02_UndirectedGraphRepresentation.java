public class _02_UndirectedGraphRepresentation {
    // To store Graph Nodes we will follow Adjacency Matrix Approach
    public static void main(String[] args) {
        int n = 3, m = 3;// n = number of Nodes, m = number of edges
        int[][] adj = new int[n + 1][n + 1];// matrix
        // We did (n+1) as we need the nth index also which can refer the nth node

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                adj[i][j] = 0;// initialize with 0
            }
        }

        // for storing the edge 1---2
        adj[1][2] = 1;
        adj[2][1] = 1;
        // for storing edge 2---3
        adj[2][3] = 1;
        adj[3][2] = 1;
        // for storing edge 3---1
        adj[3][1] = 1;
        adj[1][3] = 1;
        // rest of the all space will be 0

        // Print all the edges
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (adj[i][j] == 1) {
                    System.out.println(" Edge " + i + "--" + j);// undirected graph
                }
            }
        }

        // but this method will take O(N*N) space complexity,
        // as we are taking 2d array of n+1 and n+1 size

    }
}

import java.util.ArrayList;

public class _10_DetectCycleDFS {

    static class Pair {
        int node, parentNode;

        Pair(int node, int parentNode) {
            this.node = node;
            this.parentNode = parentNode;
        }
    }

    public static int V = 7;// number of vertex
    public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public static boolean[] visited = new boolean[V + 1];

    public static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static boolean detectCycle(int node, int parentNode) {// DFS method
        visited[node] = true;
        for (Integer adjNode : adj.get(node)) {// adjacent Node
            if (!visited[adjNode]) {
                if (detectCycle(adjNode, node))// 'node' is parent of 'adjacent node'
                    return true;
                else if (parentNode != adjNode)
                    return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int startNode) {
        for (int node = startNode; node <= V; node++) {
            if (detectCycle(node, -1)) {// starting node does not have any parent
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());// adding empty arrayList
            visited[i] = false;
        }

        // add edge
        addEdge(1, 2);
        addEdge(2, 5);
        addEdge(5, 7);
        addEdge(7, 6);
        addEdge(6, 3);
        addEdge(3, 1);
        addEdge(3, 4);

        int startNode = 1;

        System.out.println(isCycle(startNode));
    }
}

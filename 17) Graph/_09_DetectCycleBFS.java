import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _09_DetectCycleBFS {

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

    public static boolean detectCycle(int startNode) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startNode, -1)); // starting node does not have any parent
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parentNode = q.peek().parentNode;
            q.remove();

            for (Integer adjNode : adj.get(node)) {// adjacent node
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(new Pair(adjNode, node)); // adjacent node's parent is 'node'
                } else if (parentNode != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int startNode) {
        // If graph is connected component
        for (int node = startNode; node <= V; node++) {
            if (!visited[node]) {
                if (detectCycle(node))
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

        // check cycle
        System.out.println(isCycle(startNode));
    }
}

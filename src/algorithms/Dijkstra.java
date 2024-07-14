package algorithms;

import java.util.*;

public class Dijkstra {
    private static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.cost, node2.cost);
        }
    }

    public static int[] dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        PriorityQueue<Node> pq = new PriorityQueue<>(n, new Node());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.remove().node;
            if (!visited[u]) {
                visited[u] = true;

                for (int v = 0; v < n; v++) {
                    if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
        }

        return dist;
    }
}

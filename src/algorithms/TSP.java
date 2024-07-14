package algorithms;

public class TSP {
    private static final int V = 4;

    public static int tsp(int[][] graph, boolean[] visited, int currPos, int n, int count, int cost, int ans) {
        if (count == n && graph[currPos][0] > 0) {
            return Math.min(ans, cost + graph[currPos][0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[currPos][i] > 0) {
                visited[i] = true;
                ans = tsp(graph, visited, i, n, count + 1, cost + graph[currPos][i], ans);
                visited[i] = false;
            }
        }

        return ans;
    }

    public static int findTSP(int[][] graph) {
        boolean[] visited = new boolean[V];
        visited[0] = true;
        return tsp(graph, visited, 0, V, 1, 0, Integer.MAX_VALUE);
    }
}

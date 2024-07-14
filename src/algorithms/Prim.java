package algorithms;

import java.util.Arrays;

public class Prim {
    public static int primMST(int[][] graph) {
        int n = graph.length;
        int[] key = new int[n];
        boolean[] mstSet = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        int totalWeight = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, mstSet, n);
            mstSet[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            totalWeight += key[i];
        }

        return totalWeight;
    }

    private static int minKey(int[] key, boolean[] mstSet, int n) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}

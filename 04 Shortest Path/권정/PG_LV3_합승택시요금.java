import java.io.*;
import java.util.*;

class Solution {
    static List<int[]>[] graph;
    static boolean[] v;

    static int[] bellmanFord(int n, int s) {
        int[] dist = new int[n + 1]; Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        int v, w;
        for (int k = 1; k <= n - 1; k++) {
            for (int i = 1; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) continue;
                for (int[] j: graph[i]) {
                    v = j[0]; w = j[1];
                    if (dist[v] > dist[i] + w) {
                        dist[v] = dist[i] + w;
                    }
                }
            }
        }
        return dist;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        v = new boolean[n + 1];

        int c, d, f;
        for (int i = 0; i < fares.length; i++) {
            c = fares[i][0]; d = fares[i][1]; f = fares[i][2];
            graph[c].add(new int[]{d, f});
            graph[d].add(new int[]{c, f});
        }

        int[] distS = bellmanFord(n, s);
        int[] distA = bellmanFord(n, a);
        int[] distB = bellmanFord(n, b);

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            result = Math.min(result, distS[i] + distA[i] + distB[i]);
        }

        return result;
    }
}
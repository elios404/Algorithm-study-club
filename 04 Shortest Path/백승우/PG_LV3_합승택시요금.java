import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        /* 전체 시간복잡도 - O(N**3) */
        int[][] dist = new int[n + 1][n + 1];

        /* O(N**2) : Arrays.fill N번 수행*/
        for (int i = 1; i < n + 1; i++) {
            /* O(N) */
            Arrays.fill(dist[i], 100000 * n);
            dist[i][i] = 0;
        }

        /* O(N**2) : 최대 N * (N - 1) / 2 번 수행*/
        for (int[] fare: fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }

        /* Floyd-Warshall */
        /* O(N**3) */
        for (int k = 1; k < n + 1; k++) {
            for (int j = 1; j < n + 1; j++) {
                for (int i = 1; i < n + 1; i++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minValue = dist[s][a] + dist[s][b];

        /* O(N) */
        for (int i = 1; i < n + 1; i++) {
            if (minValue > dist[s][i] + dist[i][a] + dist[i][b]) {
                minValue = dist[s][i] + dist[i][a] + dist[i][b];
            }
        }

        return minValue;
    }
}
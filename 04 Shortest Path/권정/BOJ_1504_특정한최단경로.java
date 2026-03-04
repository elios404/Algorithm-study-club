import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static List<int[]>[] g;
    static int v1, v2;

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] v = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 1; i <= N; i++) {
            int minValue = Integer.MAX_VALUE;
            int idx = 0;

            for (int j = 1; j <= N; j++) {
                if (!v[j] && minValue > dist[j]) {
                    minValue = dist[j]; idx = j;
                }
            }
            v[idx] = true;
            for (int[] next: g[idx]) {
                int node = next[0];
                int weight = next[1];

                if (!v[node] && dist[node] > dist[idx] + weight) {
                    dist[node] = dist[idx] + weight;
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE) return -1;
        return dist[end];
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        g = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        int a, b, c;
        int V1ToV2;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            g[a].add(new int[]{b, c});
            g[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        V1ToV2 = dijkstra(v1, v2);

        int startToV1, V2ToEnd;
        startToV1 = dijkstra(1, v1);
        V2ToEnd = dijkstra(v2, N);

        int startToV2, V1ToEnd;
        startToV2 = dijkstra(1, v2);
        V1ToEnd = dijkstra(v1, N);

        if (V1ToV2 == -1 || startToV1 == -1 || V2ToEnd == -1 || startToV2 == -1 || V1ToEnd == -1) {
            System.out.println(-1);
            System.exit(0);
        }
        int result = Math.min(startToV1 + V1ToV2 + V2ToEnd, startToV2 + V1ToV2 + V1ToEnd);
        System.out.println(result);
    }
}
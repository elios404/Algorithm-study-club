import java.io.*;
import java.util.*;

public class Main_g4_9251_LCS {
    static String a;
    static String b;
    static int N, M;
    static int[][] memo;

    /* O(1) */
    static void lcs(int i, int j) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            memo[i][j] = memo[i - 1][j - 1] + 1;
        } else {
            memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
        }
    }

    /* O(N * M) */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        a = br.readLine();
        b = br.readLine();
        N = a.length(); M = b.length();

        memo = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                lcs(i, j);
            }
        }
        System.out.println(memo[N][M]);
    }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2293 {
	static int N;
	static int K;
	static int[] coins;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        coins = new int[N];
        
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
        
        dp = new int[K + 1];
        dp[0] = 1;

        // O(N * K)
        for (int i = 0; i < N; i++) {
            int coin = coins[i];
              
            for (int j = coin; j <= K; j++) {
                dp[j] += dp[j - coin];
            }
        }
        
        System.out.println(dp[K]);
	}
}

/*
순서대로 코인을 처리할 때 그 순서의 코인들로 만들 수 있는 경우의 수를 DP에 저장
ex) N => 2, 3, 5 // K = 10
			0 1 2 3 4 5 6 7 8 9 10
	coin[0]	1 0 1 0 1 0 1 0 1 0 1  -> coin[0] 만 사용해서 만든 경우
	coin[1]	1 0 1 1 1 1 2 1 2 2 2  -> coin[0~1] 사용해서 만든 경우
	coin[2]	1 0 1 1 1 2 2 2 3 3 4  -> coin[0~2] 사용해서 만든 경우
*/
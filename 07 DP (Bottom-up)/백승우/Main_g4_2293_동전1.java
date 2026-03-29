import java.io.*;
import java.util.*;

public class Main_g4_2293_동전1 {
	static int MAX_K = 10000;
	static int[] currDP = new int[MAX_K + 1];
	static int[] nextDP = new int[MAX_K + 1];
	
	static int solve(int N, int K, int[] coins) {
		currDP[0] = 1;
		for (int i = 0; i < N; i++) {
			Arrays.fill(nextDP, 0);
			for (int dk = ((K / coins[i]) * coins[i]); dk >= 0; dk -= coins[i]) {
				for (int k = K - dk; k >= 0; k--) {
					nextDP[k + dk] += currDP[k];
				}
			}
			int[] dp = currDP;
			currDP = nextDP;
			nextDP = dp;
		}
		return currDP[K];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solve(N, K, coins));
	}
}


import java.io.*;
import java.util.*;


public class Main_2293 {
	static final int MAX_K = 10_000;
	// Space : O(K)
	static int[] currDP  = new int[MAX_K+1];
	static int[] nextDP  = new int[MAX_K+1];
	static int[] coins ;
	static int solve(int N, int K) {
		currDP[0] = 1;
		// Time : O(KN) ~ 10000* 100  < 0.5 * 100_000_000
		for (int i = 0 ; i< N; i++) {
			Arrays.fill(nextDP, 0);
			// O(K)//최대치
			for( int dk = ((K/coins[i]) * coins[i]); dk >= 0; dk -= coins[i]) {
				for(int k = K -dk ; k >= 0;k--) {
					nextDP[k+dk] += currDP[k];
				}	
			}
			int[] dp = currDP;
			currDP = nextDP;
			nextDP = dp;
		}
		return currDP[K];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		coins = new int[N];
		for( int i = 0; i< N; i++) {
			coins[i] = sc.nextInt();
		}
		
		System.out.println(solve(N,K));

	}

}

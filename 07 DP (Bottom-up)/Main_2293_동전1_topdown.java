package DP;

import java.io.*;
import java.util.*;

public class Main_2293_동전1_topdown {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static int[] coin;
	
	static int dp[][];
	static boolean isCached[][];
	
	static int solve(int n, int k) {
		if(isCached[n][k])
			return dp[n][k];
		if(n == 1) {
			if(k % coin[n] == 0)
				return 1;
			else
				return 0;
		}
		
		for(int i = 0; i <= k/coin[n] ; i++)
			dp[n][k] += solve(n-1, k-i*coin[n]);
		isCached[n][k] = true;
		
		return dp[n][k];
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			coin[i] = Integer.parseInt(br.readLine().trim());
		}
		dp = new int[N+1][K+1];
		isCached = new boolean[N+1][K+1];
	}
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(solve(N,K));
	}

}

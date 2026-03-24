/*
3 10
1
2
5
 */
import java.io.*;
import java.util.*;

public class Main_2293_동전 {
	
	static int[] dp; // space O(K), 4byte * 10,000
	static int[] values; // space O(N), 4byte * 100
	
	// O(N*K) -> N*K= 1,000,000 (0.01초) 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		values = new int[N];
		dp = new int[K+1];
		// O(N)
		for(int i=0; i<N; i++) {
			values[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		// O(N) N<=100
		for (int i=0; i<N; i++) {
			int coinValue = values[i];
			
			// O(K)
			for (int j = coinValue; j <= K; j++) {
				dp[j] += dp[j-coinValue];
			}
			
//			System.out.println(Arrays.toString(dp));
//			System.out.println(dp[K]);
		}
		
		System.out.println(dp[K]);
		br.close();
	}

}

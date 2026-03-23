package DP;

import java.io.*;
import java.util.*;

public class Main_2293_동전1_bottomup {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int coin;
		
		coin = Integer.parseInt(br.readLine().trim());
		int[] curr = new int[K+1];
		for(int k = 0 ; k <= K ; k += coin)
			curr[k] = 1;
//		System.out.println(Arrays.toString(curr));
		for(int i = 2 ; i <= N ; i++) {
			coin = Integer.parseInt(br.readLine().trim());
			int[] next = new int[K+1];
			for(int k = 0 ; k <= K ; k++)
				for(int j = 0 ; j <= k/coin ; j++)
					next[k] += curr[k - j*coin];
			curr = next;
//			System.out.println(Arrays.toString(curr));
		}
		
		System.out.println(curr[K]);
	}

}

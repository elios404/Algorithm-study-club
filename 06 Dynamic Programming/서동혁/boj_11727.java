package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_11727 {
	static int MOD = 10007;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        arr[0] = 1;
        arr[1] = 1;
        
        System.out.println(tile(N));
	}
	
	static int tile(int n) {
		if (arr[n] != 0) return arr[n];
		
		arr[n] = (tile(n - 1) + 2*tile(n - 2)) % MOD;
		
		return arr[n];
	}
}

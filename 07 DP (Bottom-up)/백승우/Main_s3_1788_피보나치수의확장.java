import java.io.*;

public class Main_s3_1788_피보나치수의확장 {
	static int MAX_N = 1000000;
	static int MOD = 1000000000;
	
	static int[] F = new int[MAX_N * 2 + 2];
	
	static int posFib(int n) {
		int pp = 0;
		int p = 1;
		int c = 0;
		for (int i = 0; i <= n - 2; i++) {
			c = (pp + p) % MOD;
			pp = p;
			p = c;
		}
		return c;
	}
	
	static int negFib(int n) {
		int pp = 1;
		int p = 1;
		int c = 0;
		for (int i = 0; i >= n; i--) {
			c = (pp - p + MOD) % MOD;
			pp = p;
			p = c;
		}
		return c;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		if (N >= 0) {
			result = posFib(N);
		} else {
			result = negFib(N);
		}
		
		if (result > 0) {
			System.out.printf("%d\n%d", 1, result);
		} else if (result == 0) {
			System.out.printf("%d\n%d", 0, 0);
		} else {
			System.out.printf("%d\n%d", -1, Math.abs(result));
		}
	}
}


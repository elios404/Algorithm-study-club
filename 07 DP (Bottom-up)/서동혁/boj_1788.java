package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1788 {
	static int MOD = 1000000000;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if (n == 0) {
        	System.out.println(0);
        	System.out.println(0);
        }
        else if (n > 0) {
        	int[] plus = new int[3];
        	plus[1] = 1;
        	
        	if (n > 1) {
        		for (int i = 2; i < n + 1; i++) {
        			plus[i % 3] = (plus[(i - 1) % 3] + plus[(i - 2) % 3]) % MOD;
        		}
        	}
        	System.out.println(1);
        	System.out.println(plus[n % 3]);
        }
        else {
        	n = -n;
        	
        	int[] minus = new int[3];
        	minus[1] = 1;
        	
        	if (n > 1) {
        		for (int i = 2; i < n + 1; i++) {
        			minus[i % 3] = (minus[(i - 2) % 3] - minus[(i - 1) % 3]) % MOD;
        		}
        	}
        	if (minus[n % 3] < 0) System.out.println(-1);
        	else System.out.println(1);
        	System.out.println(Math.abs(minus[n % 3]));
        }
	}
}
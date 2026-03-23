import java.io.*;
import java.util.*;

public class Main_9251_LCS_이종대 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static String a, b;
	
	private static int[][] cacheValue;
	private static boolean[][] isCached;
	
	private static int lcs(int i, int j) {
		if(i == -1 || j == -1) {
			return 0;
		}
		
		if(!isCached[i][j]) {
			if(a.charAt(i) == b.charAt(j)) {
				cacheValue[i][j] = lcs(i-1, j-1) + 1;
			} else {
				cacheValue[i][j] = Math.max(lcs(i-1, j),  lcs(i,j-1));
			}
            isCached[i][j] = true;
		}
		
		return cacheValue[i][j];
	}
	
	public static void main(String[] args) throws Exception {
		a = br.readLine().trim();
		b = br.readLine().trim();
		int N = a.length();
		int M = b.length();
		cacheValue = new int[N][M];
		isCached = new boolean[N][M];
		lcs(N-1, M-1);
		System.out.println(cacheValue[N-1][M-1]);
	}

}

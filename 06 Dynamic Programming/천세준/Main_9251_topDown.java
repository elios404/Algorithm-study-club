import java.util.*;

public class Main_9251_topDown {
	
	static String l1, l2;
	static int[][] dp;

	// O(N * M) - 문자열 입력 처리 O(N + M) 후, 크기가 N * M인 2차원 배열을 초기화합니다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l1 = sc.nextLine();
		l2 = sc.nextLine();
		
		dp = new int[l1.length()][l2.length()];
		
		// O(N * M) - N개의 행에 대해 각각 M개의 요소를 -1로 채웁니다.
		for(int i=0; i<l1.length(); i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(solve(0,0));
		sc.close();
	}
	
	// O(N * M) - 계속해서 재귀가 발생하지만, 게산 된 값은 O(1)로 불러와 지기에, 결국 dp 배열을 전부 채우는 만큼 시간복잡도가 발생한다고 계산함.
	static int solve(int idx1, int idx2) {
		if(idx1 == l1.length() || idx2 == l2.length()) return 0;
		
		if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
		
		if(l1.charAt(idx1) == l2.charAt(idx2)) {
			dp[idx1][idx2] = 1 + solve(idx1+1, idx2+1);
		} else {
			dp[idx1][idx2] = Math.max(solve(idx1+1, idx2), solve(idx1, idx2+1));
		}
		
		return dp[idx1][idx2];
	}

}

import java.io.*;
import java.util.*;

public class Main {
	static String a ,b;

	static int[][] all;
	static int[][] allv;
	

	
    // O(NM)
	static int solve(int al, int bl) {
		// 현재 두개가 같을때 +1
		// 안같을때 두개 +1 로 분할
		// 끝날때 0
		if(al == a.length() ||bl == b.length()) return 0;
        
	
        if(allv[al][bl]==0){
	
        allv[al][bl] =1;
		if(a.charAt(al) == b.charAt(bl)) {
            all[al][bl] = solve(al+1,bl+1)+1;
            }
            else{all[al][bl] = Math.max(solve(al+1,bl),solve(al,bl+1));
            }
        }
		return all[al][bl];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 a = br.readLine();
		 b = br.readLine();
		
		all = new int[a.length()][b.length()];
		allv = new int[a.length()][b.length()];
		

	
        solve(0,0);
        System.out.println(all[0][0]);
//		
//		for(int[] i : all) {
//			System.out.println(Arrays.toString(i));
//		}
		
	}

}

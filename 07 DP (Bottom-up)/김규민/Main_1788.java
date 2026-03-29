import java.io.*;
import java.util.*;


public class Main_1788 {
	static final int RES = 1_000_000_000;
	static long calc(boolean k, long a, long b) {
		if(k) { return (a%RES + b%RES) %RES;}
		return (a%RES - b%RES) %RES;
		
	}
	//Space :O(1) , Time : O(N);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		boolean flag = true;
		int cnt ;
		long[] arr = new long[] {0,1,1};
		long result = 0;
		
		if(i >2) {
			cnt = 2;
			while(cnt < i) {
				cnt++;
				arr[0] = arr[1];
				arr[1] = arr[2];
//				arr[2] = arr[1] + arr[0];
				arr[2] = calc(flag,arr[1],arr[0]);
			}
			result = arr[2];
		}
		else if(i < 0) {
			flag = false;
			cnt = 0;
			while(cnt > i) {
				cnt--;
				arr[2] = arr[1];
				arr[1] = arr[0];
//				arr[0] = arr[1] - arr[2];
				arr[0] = calc(flag,arr[2],arr[1]);
			}
			result = arr[0];
		}
		else {
			result = arr[i];
		}

		if(result >0) {			System.out.println(1);	}
		if(result ==0) {			System.out.println(0);	}
		if(result <0) {			System.out.println(-1); result = result* -1;	}
		System.out.println(result);
		
		//  1 -1 0 1
		 
	}
}

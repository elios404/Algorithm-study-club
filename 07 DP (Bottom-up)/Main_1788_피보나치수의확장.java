package DP;

import java.util.Scanner;

public class Main_1788_피보나치수의확장 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean negative = Math.signum(n) < 0;
		n = Math.abs(n);
		int a = 0, b = 1;
		if(n == 0) {
			b = 0;
		} else if(!negative) {
			for (int i = 2; i <= n ;i++) {
				int temp = b;
				b = (a + b) % 1000_000_000;
				a = temp;
			}
		} else {
			for(int i = 1 ; i <= n ; i++) {
				int temp = a;
				a = (b - a) % 1000_000_000;
				b = temp;
			}
			b = a;
		}
		System.out.println((int) Math.signum(b));
		System.out.println(Math.abs(b));
		sc.close();
	}

}

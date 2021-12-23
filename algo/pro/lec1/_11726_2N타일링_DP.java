package com.algo.pro.lec1;

import java.util.Scanner;

public class _11726_2N타일링_DP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[1001];
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
			d[i] %= 10007;
		}
		System.out.println(d[n]);
	}
}

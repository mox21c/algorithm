package com.algo.pro.lec1;

import java.util.Scanner;

public class _11058_크리보드_DP {
	static long[] d = new long[1001];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i <= 6; i++) {
			d[i] = i;
		}
		for (int i = 7; i <= n; i++) {
			for (int j = 1; i - j - 2 >= 0; j++) {
				long cur = d[i - j - 2] * (j + 1);
				if (cur > d[i]) {
					d[i] = cur;
				}
			}
		}
		System.out.println(d[n]);
	}
}

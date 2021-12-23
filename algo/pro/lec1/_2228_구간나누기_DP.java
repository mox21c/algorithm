package com.algo.pro.lec1;

import java.util.Scanner;

public class _2228_구간나누기_DP {
	public static int min = -32786 * 101;

	public static int go(int[] a, int[] s, boolean[][] c, int[][] d, int n,
			int m) {
		if (m == 0) {
			return 0;
		}
		if (n <= 0) {
			return min;
		}
		if (c[n][m]) {
			return d[n][m];
		}
		c[n][m] = true;
		d[n][m] = go(a, s, c, d, n - 1, m);
		for (int i = 1; i <= n; i++) {
			int temp = go(a, s, c, d, i - 2, m - 1) + (s[n] - s[i - 1]);
			d[n][m] = Math.max(d[n][m], temp);
		}
		return d[n][m];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n + 1];
		int[] s = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
			s[i] = s[i - 1] + a[i];
		}
		int[][] d = new int[n + 1][m + 1];
		boolean[][] c = new boolean[n + 1][m + 1];
		System.out.println(go(a, s, c, d, n, m));
	}
}

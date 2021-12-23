package com.algo.pro.lec1;

import java.util.Arrays;
import java.util.Scanner;

public class _10942_팰린드롬_DP_TopDown {
	public static int go(int[] a, int[][] d, int x, int y) {
		if (x == y) {
			return 1;
		} else if (x + 1 == y) {
			if (a[x] == a[y]) {
				return 1;
			} else {
				return 0;
			}
		}
		if (d[x][y] != -1) {
			return d[x][y];
		}
		if (a[x] != a[y]) {
			return d[x][y] = 0;
		} else {
			return d[x][y] = go(a, d, x + 1, y - 1);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 0 : ?, 1 : not palin, 2 : palin
		int[] a = new int[n];
		int[][] d = new int[n][n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			Arrays.fill(d[i], -1);
		}
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sb.append(go(a, d, x - 1, y - 1));
			sb.append('\n');
		}
		System.out.println(sb);
	}
}

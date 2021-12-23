package com.algo.pro.lec1;

import java.util.Scanner;

public class _2099_TheGameOfDepth_ {
	static boolean[][] mul(boolean[][] a, boolean[][] b) {
		int n = a.length;
		boolean[][] ans = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (a[i][k] && b[k][j]) {
						ans[i][j] = true;
					}
				}
			}
		}
		return ans;
	}

	static boolean[][] pow(boolean[][] a, int m) {
		int n = a.length;
		boolean[][] ans = new boolean[n][n];
		for (int i = 0; i < n; i++)
			ans[i][i] = true;
		while (m > 0) {
			if (m % 2 == 1) {
				ans = mul(ans, a);
			}
			a = mul(a, a);
			m /= 2;
		}
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] a = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[i][x - 1] = true;
			a[i][y - 1] = true;
		}
		boolean[][] ans = pow(a, k);
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (ans[x - 1][y - 1]) {
				// System.out.println("death");
				sb.append("death\n");
			} else {
				// System.out.println("life");
				sb.append("life\n");
			}
		}
		System.out.print(sb);
	}
}

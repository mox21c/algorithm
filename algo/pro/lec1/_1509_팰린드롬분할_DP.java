package com.algo.pro.lec1;

import java.util.Scanner;

public class _1509_팰린드롬분할_DP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().trim();
		int n = s.length();
		s = " " + s;
		boolean[][] c = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			c[i][i] = true;
		}
		for (int i = 1; i <= n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				c[i][i + 1] = true;
			}
		}
		for (int k = 2; k < n; k++) {
			for (int i = 1; i <= n - k; i++) {
				int j = i + k;
				c[i][j] = (s.charAt(i) == s.charAt(j) && c[i + 1][j - 1]);
			}
		}
		int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			d[i] = -1;
			for (int j = 1; j <= i; j++) {
				if (c[j][i]) {
					if (d[i] == -1 || d[i] > d[j - 1] + 1) {
						d[i] = d[j - 1] + 1;
					}
				}
			}
		}
		System.out.println(d[n]);
	}
}

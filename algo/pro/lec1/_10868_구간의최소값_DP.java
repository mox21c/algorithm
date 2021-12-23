package com.algo.pro.lec1;

import java.util.Scanner;

public class _10868_구간의최소값_DP {
	static int[] a = new int[100000];
	static int[][] d = new int[100000][17];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			d[i][0] = a[i];
		}
		for (int j = 1; j < 17; j++) {
			for (int i = 0; i < n; i++) {
				if (i + (1 << j) - 1 < n) {
					d[i][j] = Math.min(d[i][j - 1],
							d[i + (1 << (j - 1))][j - 1]);
				} else {
					break;
				}
			}
		}
		while (m-- > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			start -= 1;
			end -= 1;
			int ans = a[start];
			int k = 16;
			while (start <= end && k >= 0) {
				if (start + (1 << k) - 1 <= end) {
					ans = Math.min(ans, d[start][k]);
					start += (1 << k);
				}
				k -= 1;
			}
			System.out.println(ans);
		}
	}
}

package com.algo.pro.lec2;

import java.util.Arrays;
import java.util.Scanner;

public class _11066_파일합치기 {
	static int s[] = new int[501];
	static int acc[] = new int[501];
	static long d[][] = new long[501][501];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			int K = sc.nextInt();
			for (int i = 1; i <= K; i++)
				s[i] = sc.nextInt();

			for (int i = 1; i <= K; i++)
				acc[i] = acc[i - 1] + s[i];

			for (int i = 1; i <= K; i++) {
				Arrays.fill(d[i], Long.MAX_VALUE / 2);
				d[i][i] = 0;
			}

			for (int len = 2; len <= K; len++)
				for (int i = 1; i <= K - len + 1; i++) {
					int l = i, r = i + len - 1;
					for (int m = i; m < r; m++) {
						d[l][r] = Math.min(d[l][r], d[l][m] + d[m + 1][r]
								+ acc[r] - acc[l - 1]);
					}
				}

			System.out.println(d[1][K]);
		}
	}
}

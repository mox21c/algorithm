package com.algo.pro.lec2;

import java.util.Scanner;

public class _9465_스티커_DP {
	static int d[][] = new int[100001][3];
	static int s[][] = new int[100001][2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			for (int i = 0; i < 2; i++)
				for (int j = 1; j <= N; j++)
					s[j][i] = sc.nextInt();

			for (int i = 1; i <= N; i++) {
				d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
				d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + s[i][0];
				d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + s[i][1];
			}

			System.out.println(Math.max(d[N][0], Math.max(d[N][1], d[N][2])));
		}
	}
}

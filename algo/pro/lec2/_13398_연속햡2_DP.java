package com.algo.pro.lec2;

import java.util.Scanner;

public class _13398_연속햡2_DP {

	static int a[] = new int[100001];
	static int d[][] = new int[100001][2];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++)
			a[i] = sc.nextInt();

		a[0] = d[0][0] = d[0][1] = -1001;
		int ans = d[0][0];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 2; j++) {
				if (d[i - 1][j] < 0)
					d[i][j] = a[i];
				else
					d[i][j] = d[i - 1][j] + a[i];
			}
			d[i][1] = Math.max(d[i][1], d[i - 1][0]);
			ans = Math.max(ans, Math.max(d[i][0], d[i][1]));
		}
		System.out.println(ans);
	}
}

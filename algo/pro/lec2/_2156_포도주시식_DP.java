package com.algo.pro.lec2;

import java.util.Scanner;

public class _2156_포도주시식_DP {
	static int d[][] = new int[10001][3];
	static int a[] = new int[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++)
			a[i] = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
			d[i][1] = d[i - 1][0] + a[i];
			d[i][2] = d[i - 1][1] + a[i];
		}

		System.out.println(Math.max(d[N][0], Math.max(d[N][1], d[N][2])));
	}
}

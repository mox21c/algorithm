package com.algo.pro.lec2;

import java.util.Scanner;

public class _11053_가장긴증가하는부분수열_DP {
	static int a[] = new int[1000];
	static int d[] = new int[1000];

	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++)
			a[i] = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int len = 0;
			for (int j = 0; j < i; j++)
				if (a[j] < a[i])
					len = Math.max(len, d[j]);
			d[i] = len + 1; // { , , , } + a[i]
		}

		int ans = 0;
		for (int i = 0; i < N; i++)
			ans = Math.max(ans, d[i]);

		System.out.println(ans);
	}
}

package com.algo.pro.lec2;

import java.util.Scanner;

public class _11055_가장큰증가하는부분수열_DP {
	static int arr[] = new int[1000];
	static int d[] = new int[1000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int maxd = 0;
			for (int j = 0; j < i; j++)
				if (arr[j] < arr[i])
					maxd = Math.max(maxd, d[j]);
			d[i] = maxd + arr[i];
		}

		int ans = 0;
		for (int i = 0; i < N; i++)
			ans = Math.max(ans, d[i]);

		System.out.println(ans);
	}
}

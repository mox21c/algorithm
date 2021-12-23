package com.algo.pro.lec2;

import java.util.Scanner;

public class _1912_연속햡_DP {

	static int a[] = new int[100001];
	static int d[] = new int[100001];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++)
			a[i] = sc.nextInt();

		int ans = a[0] = -1001;
		for (int i = 1; i <= N; i++) {
			if (d[i - 1] < 0)
				d[i] = a[i];
			else
				d[i] = d[i - 1] + a[i];
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}
}

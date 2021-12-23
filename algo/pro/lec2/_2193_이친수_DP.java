package com.algo.pro.lec2;

import java.util.Scanner;

public class _2193_이친수_DP {
	static long d[] = new long[91];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		d[1] = d[2] = 1;
		for (int i = 3; i <= N; i++){
			d[i] = d[i - 1] + d[i - 2];
		}
		System.out.println(d[N]);
	}
}

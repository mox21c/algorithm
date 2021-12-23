package com.algo.pro.lec2;

import java.util.Arrays;
import java.util.Scanner;

public class _2294_동전2_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int c[] = new int[N];
		for (int i = 0; i < N; i++)
			c[i] = sc.nextInt();

		int d[] = new int[K + 1];
		Arrays.fill(d, -1);
		d[0] = 0;

		for (int i = 1; i <= K; i++)
			for (int j = 0; j < N; j++) {
				if (i - c[j] < 0)
					continue;
				if (d[i - c[j]] < 0)
					continue;
				if (d[i] < 0)
					d[i] = d[i - c[j]] + 1;
				else
					d[i] = Math.min(d[i], d[i - c[j]] + 1);
			}

		System.out.println(d[K]);
	}
}

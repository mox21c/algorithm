package com.algo.pro.lec2;

import java.util.Scanner;

public class _9095_123더하기_DP {
	static int d[] = new int[12];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		calc();
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			System.out.println(d[N]);
		}
	}

	public static void calc() {
		d[0] = 1;
		for (int i = 1; i <= 11; i++)
			for (int j = 1; j <= 3; j++)
				if (j <= i)
					d[i] += d[i - j];
	}
}

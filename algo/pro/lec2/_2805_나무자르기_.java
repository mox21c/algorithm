package com.algo.pro.lec2;

import java.util.Scanner;

public class _2805_나무자르기_ {
	static int n[] = new int[1000000];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int i = 0; i < N; i++)
			n[i] = sc.nextInt();

		int l = 0, r = 1000000000, m, ans = 0;
		while (l <= r) {
			m = (l + r) / 2;

			long sum = 0;
			for (int i = 0; i < N; i++)
				if (m < n[i])
					sum += n[i] - m;

			if (M <= sum) {
				if (ans < m)
					ans = m;
				l = m + 1;
			} else
				r = m - 1;
		}

		System.out.println(ans);
	}
}

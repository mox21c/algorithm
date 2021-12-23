package com.algo.pro.lec2;

import java.util.Scanner;

/*
 * 이분탐색을 이용하여 1~10000 까지의 숫자가 들어올수 있으므로
 * 중간값을 구간의 최대-최소값을 가지는 카운트를 셈.
 * */
public class _13397_구간나누기2 {
	static int a[] = new int[5000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int i = 0; i < N; i++)
			a[i] = sc.nextInt();

		int l = 0, r = 9999, m, ans = -1;
		while (l <= r) {
			m = (l + r) / 2;
			//System.out.println("l=" + l + ", r=" + r+ ", m=" + m);
			
			int cnt = 1, min = a[0], max = a[0];
			for (int i = 1; i < N; i++) {
				min = Math.min(min, a[i]);
				max = Math.max(max, a[i]);
				if (m < max - min) {
					min = max = a[i];
					cnt++;
				}
			}
			//System.out.println("cnt=" + cnt);

			if (cnt <= M) {
				ans = m;
				r = m - 1;
			} else
				l = m + 1;
		}

		System.out.println(ans);
	}
}

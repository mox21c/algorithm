package com.algo.pro.lec2;

import java.util.Scanner;

public class _1182_부분집합의합 {
	static int N, S;
	static int a[] = new int[20];
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		for (int i = 0; i < N; i++)
			a[i] = sc.nextInt();

		search_sub(0, 0);
		System.out.println((S == 0) ? cnt - 1 : cnt);
	}

	static void search_sub(int idx, int sum) {
		if (idx == N) {
			if (sum == S)
				cnt++;
			return;
		}
		search_sub(idx + 1, sum);
		search_sub(idx + 1, sum + a[idx]);
	}
}

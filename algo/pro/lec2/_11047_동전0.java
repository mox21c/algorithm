package com.algo.pro.lec2;

import java.util.Scanner;

public class _11047_동전0 {
	static int N, S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		int[] pan = new int[N + 1];
		for (int i = 0; i < N; i++) {
			pan[i] = sc.nextInt();
		}

		int ans = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (S < pan[i]) {
				continue;
			}
			ans += S / pan[i];
			S = S % pan[i];
		}

		System.out.println(ans);

	}
}

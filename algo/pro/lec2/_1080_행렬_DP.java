package com.algo.pro.lec2;

import java.util.Scanner;

public class _1080_행렬_DP {

	static int a[][] = new int[50][50];
	static int b[][] = new int[50][50];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++)
				a[i][j] = s.charAt(j) - '0';
		}

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++)
				b[i][j] = s.charAt(j) - '0';
		}

		int ans = 0;
		for (int i = 0; i < N - 2; i++)
			for (int j = 0; j < M - 2; j++)
				if (a[i][j] != b[i][j]) {
					ans++;
					for (int r = 0; r < 3; r++)
						for (int c = 0; c < 3; c++)
							a[i + r][j + c] = 1 - a[i + r][j + c];
				}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (a[i][j] != b[i][j])
					ans = -1;

		System.out.println(ans);
	}
}

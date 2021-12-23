package com.algo.pro.lec2;

import java.util.Scanner;

public class _2098_외판원순회_DP_topdown {
	static int d[][] = new int[16][1 << 16];
	static int w[][] = new int[16][16];
	static int N, all;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		all = (1 << N) - 1;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				w[i][j] = sc.nextInt();

		System.out.println(calcMinCost(0, 1));
	}

	public static int calcMinCost(int cur, int visited) {
		if (d[cur][visited] != 0)
			return d[cur][visited];
		if (visited == all) {
			if (w[cur][0] == 0)
				return 987654321;
			else
				return w[cur][0];
		}

		int minc = 987654321, bi = 2;
		for (int i = 1; i < N; i++) {
			if ((visited & bi) == 0 && w[cur][i] != 0)
				minc = Math.min(minc, calcMinCost(i, visited + bi) + w[cur][i]);
			bi <<= 1;
		}

		return d[cur][visited] = minc;
	}
}

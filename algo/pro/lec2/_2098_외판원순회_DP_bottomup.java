package com.algo.pro.lec2;

import java.util.Arrays;
import java.util.Scanner;

public class _2098_외판원순회_DP_bottomup {
	static int d[][] = new int[16][1 << 16];
	static int w[][] = new int[16][16];
	static int bit[] = new int[16];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				w[i][j] = sc.nextInt();

		bit[0] = 1;
		for (int i = 1; i < N; i++)
			bit[i] = bit[i - 1] * 2;

		for (int i = 0; i < N; i++)
			Arrays.fill(d[i], 987654321);
		d[0][1] = 0;

		int all_visited = (1 << N) - 1;
		for (int visited = 1; visited <= all_visited; visited++) {
			for (int cur = 0; cur < N; cur++) {
				if ((visited & bit[cur]) == 0)
					continue;
				for (int next = 0; next < N; next++) {
					if ((visited & bit[next]) != 0)
						continue;
					if (w[cur][next] == 0)
						continue;
					d[next][visited | bit[next]] = Math.min(d[next][visited
							| bit[next]], d[cur][visited] + w[cur][next]);
				}
			}
		}

		int ans = 987654321;
		for (int i = 1; i < N; i++)
			if (w[i][0] != 0)
				ans = Math.min(ans, d[i][all_visited] + w[i][0]);

		System.out.println(ans);
	}
}

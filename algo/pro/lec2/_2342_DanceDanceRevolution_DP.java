package com.algo.pro.lec2;

import java.util.Scanner;

public class _2342_DanceDanceRevolution_DP {
	static int d[][][] = new int[100000][5][5];
	static int cost[][] = { { 0, 2, 2, 2, 2 }, { 0, 1, 3, 4, 3 },
			{ 0, 3, 1, 3, 4 }, { 0, 4, 3, 1, 3 }, { 0, 3, 4, 3, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 100000; i++)
			for (int l = 0; l < 5; l++)
				for (int r = 0; r < 5; r++)
					d[i][l][r] = 987654321;

		int N = 0;
		for (int i = 1; i < 5; i++) {
			d[N][i][0] = cost[0][i];
			d[N][0][i] = cost[0][i];
		}

		int next;
		int past = sc.nextInt();
		if (past == 0) {
			System.out.println(0);
			return;
		}

		while (true) {
			next = sc.nextInt();
			if (next == 0)
				break;

			N++;
			for (int i = 0; i < 5; i++) {
				if (next != i && past != i) {
					d[N][next][i] = Math.min(d[N][next][i], d[N - 1][past][i]
							+ cost[past][next]);
					d[N][i][next] = Math.min(d[N][i][next], d[N - 1][i][past]
							+ cost[past][next]);
				}
				if (past != next && past != i) {
					d[N][past][next] = Math.min(d[N][past][next],
							d[N - 1][past][i] + cost[i][next]);
					d[N][next][past] = Math.min(d[N][next][past],
							d[N - 1][i][past] + cost[i][next]);
				}
			}
			past = next;
		}

		int ans = 987654321;
		for (int i = 0; i < 5; i++)
			ans = Math.min(ans, Math.min(d[N][past][i], d[N][i][past]));

		System.out.println(ans);
	}
}

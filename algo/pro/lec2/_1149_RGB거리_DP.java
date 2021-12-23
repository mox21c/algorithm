package com.algo.pro.lec2;

import java.util.Arrays;
import java.util.Scanner;

public class _1149_RGB거리_DP {
	static int d[][] = new int[1001][3];
	static int cost[][] = new int[1001][3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++){
			for (int j = 0; j < 3; j++){
				cost[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++){
			Arrays.fill(d[i], 987654321);
		}

		for (int i = 1; i <= N; i++){
			for (int j = 0; j < 3; j++){
				for (int k = 0; k < 3; k++){
					if (j != k) {
						d[i][j] = Math.min(d[i][j], d[i - 1][k] + cost[i][j]);
					}
				}
			}
		}

		System.out.println(Math.min(d[N][0], Math.min(d[N][1], d[N][2])));
	}
}

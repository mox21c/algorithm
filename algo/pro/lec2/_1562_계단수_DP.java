package com.algo.pro.lec2;

import java.util.Scanner;

public class _1562_계단수_DP {
	static int d[][][] = new int[101][10][1 << 10];
	static int bit[] = new int[10];
	static int mod = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		bit[0] = 1;
		for (int i = 1; i <= 9; i++)
			bit[i] = bit[i - 1] * 2; // 1 << i, 2^i

		int N = sc.nextInt();

		// 1, 2, 3, 4 .. , 9
		// 1: 0000000010 => 2^1
		// 2: 0000000100 => 2^2
		// 3: 0000001000 => 2^3
		// i: 2^i
		for (int i = 1; i <= 9; i++) {
			d[1][i][bit[i]] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int used = 0; used <= 1023; used++) {
					// d[i][j - 1][used] => d[i + 1][j][used | bit[j]]
					if (j != 0)
						d[i + 1][j][used | bit[j]] = (d[i + 1][j][used | bit[j]] + d[i][j - 1][used])
								% mod;
					// d[i][j + 1][used] => d[i + 1][j][used | bit[j]]
					if (j != 9)
						d[i + 1][j][used | bit[j]] = (d[i + 1][j][used | bit[j]] + d[i][j + 1][used])
								% mod;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i <= 9; i++)
			ans = (ans + d[N][i][1023]) % mod;

		System.out.println(ans);
	}
}

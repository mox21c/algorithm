package com.algo.pro.lec2;

import java.util.Scanner;

public class _10844_쉬운계단수_DP {
	static int d[][] = new int[101][10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= 9; i++){
			d[1][i] = 1;
		}

		for (int i = 2; i <= N; i++){
			for (int j = 0; j <= 9; j++) {
				if (0 < j){
					d[i][j] += d[i - 1][j - 1];
				}
				if (j < 9){
					d[i][j] += d[i - 1][j + 1];
				}
				d[i][j] %= 1000000000;
			}
		}
		int ans = 0;
		for (int i = 0; i <= 9; i++){
			ans = (ans + d[N][i]) % 1000000000;
		}
		System.out.println(ans);
		
	}
}

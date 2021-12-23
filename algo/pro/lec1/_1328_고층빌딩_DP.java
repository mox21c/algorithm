package com.algo.pro.lec1;

import java.util.Scanner;

public class _1328_고층빌딩_DP {
	static long[][][] d = new long[101][101][101];
	static long mod = 1000000007L;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		d[1][1][1] = 1L;
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= l; j++) {
				for (int k = 1; k <= r; k++) {
					if (j + 1 <= l) {
						d[i + 1][j + 1][k] += d[i][j][k];
						d[i + 1][j + 1][k] %= mod;
					}
					if (k + 1 <= r) {
						d[i + 1][j][k + 1] += d[i][j][k];
						d[i + 1][j][k + 1] %= mod;
					}
					d[i + 1][j][k] += d[i][j][k] * (i - 1);
					d[i + 1][j][k] %= mod;
				}
			}
		}
		System.out.println(d[n][l][r]);
	}
	
	/*public static long mod = 1000000007L;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        long[][][] d = new long[n+1][n+1][n+1];
        d[1][1][1] = 1L;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=l; j++) {
                for (int k=1; k<=r; k++) {
                    d[i][j][k] = d[i-1][j-1][k] + d[i-1][j][k-1] + d[i-1][j][k] * (i-2);
                    d[i][j][k] %= mod;
                }
            }
        }
        System.out.println(d[n][l][r]);
    }*/
}

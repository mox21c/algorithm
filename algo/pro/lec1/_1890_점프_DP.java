package com.algo.pro.lec1;

import java.util.Scanner;

public class _1890_점프_DP {
	static int[][] a = new int[100][100];
	static long[][] d = new long[100][100];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		d[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				// (i,k+a[i][k]) -> (i,j)
				for (int k = 0; k < j; k++) {
					if (k + a[i][k] == j) {
						d[i][j] += d[i][k];
					}
				}
				// (k+a[k][j],j) -> (i,j)
				for (int k = 0; k < i; k++) {
					if (k + a[k][j] == i) {
						d[i][j] += d[k][j];
					}
				}
			}
		}
		System.out.println(d[n - 1][n - 1]);
	}
	
	/*static int[][] a = new int[100][100];
    static long[][] d = new long[100][100];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        d[0][0] = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 0) continue;
                // (i,j) -> (i,j+a[i][j])
                if (j+a[i][j] < n) {
                    d[i][j+a[i][j]] += d[i][j];
                }
                // (i,j) -> (i+a[i][j],j)
                if (i+a[i][j] < n) {
                    d[i+a[i][j]][j] += d[i][j];
                }
            }
        }
        System.out.println(d[n-1][n-1]);
    }*/
}

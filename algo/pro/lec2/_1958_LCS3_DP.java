package com.algo.pro.lec2;

import java.util.Scanner;

public class _1958_LCS3_DP {
	static int d[][][] = new int[101][101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();
		String C = sc.next();

		char a[] = A.toCharArray();
		char b[] = B.toCharArray();
		char c[] = C.toCharArray();

		int la = A.length();
		int lb = B.length();
		int lc = C.length();

		for (int i = 1; i <= la; i++)
			for (int j = 1; j <= lb; j++)
				for (int k = 1; k <= lc; k++) {
					d[i][j][k] = d[i - 1][j - 1][k - 1];
					if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1]) {
						d[i][j][k]++;
					} else {
						for (int dec1 = 0; dec1 < 2; dec1++)
							for (int dec2 = 0; dec2 < 2; dec2++)
								for (int dec3 = 0; dec3 < 2; dec3++)
									d[i][j][k] = Math.max(d[i][j][k], d[i - dec1][j - dec2][k - dec3]);
					}
				}

		System.out.println(d[la][lb][lc]);
	}
}

package com.algo.pro.lec2;

import java.util.Scanner;

public class _9251_LCS_DP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		int la = a.length();
		int lb = b.length();

		int lcs[][] = new int[la + 1][lb + 1];
		for (int i = 1; i <= la; i++) {
			for (int j = 1; j <= lb; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
//					if (lcs[i - 1][j] < lcs[i][j - 1]) {
//						lcs[i][j] = lcs[i][j - 1];
//					} else {
//						lcs[i][j] = lcs[i - 1][j];
//					}
					lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
				}
			}
		}

		System.out.println(lcs[la][lb]);
	}
}

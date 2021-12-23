package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day2_최장공통부분수열LCS {
	static int[][] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s1 = String.valueOf(br.readLine().trim()).toCharArray();
		char[] s2 = String.valueOf(br.readLine().trim()).toCharArray();

		int s1Len = s1.length;
		int s2Len = s2.length;
		d = new int[s1Len + 1][s2Len + 1];
		for (int i = 1; i <= s1Len; i++) {
			for (int j = 1; j <= s2Len; j++) {
				if (s1[i - 1] == s2[j - 1]) {
					d[i][j] = d[i - 1][j - 1] + 1;
				} else {
					d[i][j] = Math.max(d[i][j - 1], d[i - 1][j]);
				}
			}
		}

		System.out.println(d[s1Len][s2Len]);

		br.close();
	}
}

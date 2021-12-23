package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1_폐지줍기 {
	static int N;
	static int ans;
	static int[][] d;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());

		d = new int[N + 1][N + 1];
		ans = 0;

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int c = 1; c <= N; c++) {
				d[r][c] = Math.max(d[r - 1][c], d[r][c - 1]) + Integer.valueOf(st.nextToken());
			}
		}

		System.out.println(d[N][N]);
		br.close();
	}
}

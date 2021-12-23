package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Day1_숫자삼각형 {
	static int N;
	static int ans;
	static int[][] a, d;
	static StringTokenizer st;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());

		a = new int[N + 1][N + 1];
		d = new int[N + 1][N + 1];
		ans = 0;

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int c = 1; c <= r; c++) {
				a[r][c] = Integer.valueOf(st.nextToken());
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= r; c++) {
				d[r][c] = d[r - 1][c] + a[r][c];
				d[r][c] = Math.max(d[r][c], d[r - 1][c - 1] + a[r][c]);
			}
		}

		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, d[N][i]);
		}

		System.out.println(ans);

		br.close();
	}
}

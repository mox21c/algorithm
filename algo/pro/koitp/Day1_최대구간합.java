package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1_최대구간합 {
	static int N;
	static long[] a;
	static long[] d;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());

		a = new long[N + 1];
		d = new long[N + 1];

		st = new StringTokenizer(br.readLine().trim());
		for (int c = 1; c <= N; c++) {
			a[c] = Integer.valueOf(st.nextToken());
		}

		d[1] = a[1];
		for (int c = 2; c <= N; c++) {
			d[c] = Math.max(a[c], a[c] + d[c - 1]);
//			d[c] = Math.max(a[c]+a[c-1], Math.max(a[c], a[c]+d[c-1]));
		}
		long ans = d[1];
		for (int c = 1; c <= N; c++) {
			ans = Math.max(d[c], ans);
		}

		System.out.println(ans);

		br.close();
	}
}

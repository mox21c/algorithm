package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_최장증가부분수열LIS {
	static int N;
	static int[] a;
	static int[] d;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());

		a = new int[N + 1];
		d = new int[N + 1];

		st = new StringTokenizer(br.readLine().trim());
		for (int c = 1; c <= N; c++) {
			a[c] = Integer.valueOf(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			d[i] = 1;
			for (int j = 1; j < i; j++) {
				if (a[j] < a[i] &&  d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, d[i]);
		}
		System.out.println(ans);

		br.close();
	}
}

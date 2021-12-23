package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day2_1이되고싶어 {
	static int N;
	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());

		d = new int[1000001];

		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;
			if (i % 2 == 0) {
				d[i] = Math.min(d[i / 2] + 1, d[i]);
			}
			if (i % 3 == 0) {
				d[i] = Math.min(d[i / 3] + 1, d[i]);
			}
		}

		System.out.println(d[N]);
		br.close();
	}
}

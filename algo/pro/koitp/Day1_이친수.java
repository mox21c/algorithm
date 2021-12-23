package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 유형 : DP
 * N자리수 일때 갯수를 세어보면.. 
 * 1자리 : 1개
 * 2자리 : 1개
 * 3자리 : 2개
 * 4자리 : 3개
 * 
 * D[n] = D[n-1] + D[n-2]
 * 
 */
public class Day1_이친수 {
	static int N;
	static long[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());

		d = new long[90];

		d[0] = d[1] = 1;

		for (int i = 2; i < N; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}

		System.out.println(d[N - 1]);

		br.close();
	}
}

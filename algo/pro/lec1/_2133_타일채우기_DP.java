package com.algo.pro.lec1;

import java.util.Scanner;

public class _2133_타일채우기_DP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[n + 1];
		d[0] = 1;
		for (int i = 2; i <= n; i += 2) {
			d[i] = d[i - 2] * 3;
			for (int j = i - 4; j >= 0; j -= 2) {
				d[i] += d[j] * 2;
			}
		}
		System.out.println(d[n]);
	}
}

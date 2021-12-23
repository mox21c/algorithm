package com.algo.pro.lec1;

import java.util.Scanner;

public class _1720_타일코드_DP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long[] a = new long[31]; // 대칭 포함
		long[] d = new long[31]; // 대칭 없음
		a[1] = 1;
		a[2] = 3;
		for (int i = 3; i <= 30; i++) {
			a[i] = a[i - 1] + a[i - 2] * 2L;
		}
		d[1] = 1;
		d[2] = 3;
		for (int i = 3; i <= 30; i++) {
			long b = 0;
			if (i % 2 == 1) {
				b = a[(i - 1) / 2];
			} else {
				b = a[i / 2] + 2 * a[(i - 2) / 2];
			}
			d[i] = (a[i] + b) / 2;
		}
		int n = sc.nextInt();
		System.out.println(d[n]);
	}
}

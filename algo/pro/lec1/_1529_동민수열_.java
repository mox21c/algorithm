package com.algo.pro.lec1;

import java.util.HashSet;
import java.util.Scanner;

public class _1529_동민수열_ {
	static final long mod = 1234567891L;

	static long[][] multiplication(long[][] a, long[][] b) {
		int n = a.length;
		long[][] c = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c[i][j] = 0;
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
				c[i][j] %= mod;
			}
		}
		return c;
	}

	static boolean check(int x) {
		if (x == 0)
			return true;
		if (x % 10 == 4 || x % 10 == 7) {
			return check(x / 10);
		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		HashSet<Integer> s = new HashSet<>();
		long[][] ans = { { 1, 0 }, { 0, 1 } };
		long[][] a = { { 0, 0 }, { 0, 0 } };
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (s.contains(x))
				continue;
			s.add(x);
			if (check(x)) {
				char[] temp = String.valueOf(x).toCharArray();
				if (temp[0] == '4') {
					if (x % 10 == 4) {
						a[0][0] += 1;
					} else {
						a[0][1] += 1;
					}
				} else {
					if (x % 10 == 4) {
						a[1][0] += 1;
					} else {
						a[1][1] += 1;
					}
				}
			}
		}
		while (l > 0) {
			if (l % 2 == 1) {
				ans = multiplication(ans, a);
			}
			a = multiplication(a, a);
			l /= 2;
		}
		System.out.println((ans[0][0] + ans[0][1] + ans[1][0] + ans[1][1])
				% mod);
	}
}

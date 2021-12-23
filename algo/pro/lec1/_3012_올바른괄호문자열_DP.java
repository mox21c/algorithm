package com.algo.pro.lec1;

import java.util.Arrays;
import java.util.Scanner;

public class _3012_올바른괄호문자열_DP {
	static int n;
	static String s;
	static long[][] d = new long[200][200];
	static final long mod = 100000;
	static boolean over = false;
	static char[] open = { '(', '{', '[' };
	static char[] close = { ')', '}', ']' };

	static long go(int i, int j) {
		if (i > j)
			return 1;
		long ans = d[i][j];
		if (ans != -1)
			return ans;
		ans = 0;
		for (int k = i + 1; k <= j; k += 2) {
			for (int l = 0; l < 3; l++) {
				if (s.charAt(i) == open[l] || s.charAt(i) == '?') {
					if (s.charAt(k) == close[l] || s.charAt(k) == '?') {
						long temp = go(i + 1, k - 1) * go(k + 1, j);
						if (ans + temp > mod) {
							over = true;
						}
						ans += temp;
						ans %= mod;
					}
				}
			}
		}
		d[i][j] = ans;
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		s = sc.nextLine();
		for (int i = 0; i < 200; i++) {
			Arrays.fill(d[i], -1);
		}
		long ans = go(0, n - 1);
		if (over) {
			System.out.printf("%05d\n", ans);
		} else {
			System.out.println(ans);
		}
	}
}

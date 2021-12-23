package com.algo.pro.lec1;

import java.util.Arrays;
import java.util.Scanner;

public class _1126_같은탑_DP {
	static final int inf = 10000000;
	static int[] a = new int[50];
	static int[][] d = new int[50][250001];
	static int n;

	static int go(int k, int diff) {
		if (diff > 250000) {
			return -inf;
		}
		if (k == n) {
			if (diff == 0) {
				return 0;
			} else {
				return -inf;
			}
		}
		int ans = d[k][diff];
		if (ans != -1) {
			return ans;
		}
		ans = go(k + 1, diff);
		ans = Math.max(ans, go(k + 1, diff + a[k]));
		if (a[k] > diff) {
			ans = Math.max(ans, diff + go(k + 1, a[k] - diff));
		} else {
			ans = Math.max(ans, a[k] + go(k + 1, diff - a[k]));
		}
		d[k][diff] = ans;
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			Arrays.fill(d[i], -1);
		}
		int ans = go(0, 0);
		if (ans == 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}

package com.algo.pro.lec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11066_파일합치기_DP {
	public static int go(int[] a, int[] s, int[][] d, int i, int j) {
		if (i == j) {
			return 0;
		}
		if (d[i][j] != -1) {
			return d[i][j];
		}
		int ans = -1;
		for (int k = i; k <= j - 1; k++) {
			int temp = go(a, s, d, i, k) + go(a, s, d, k + 1, j) + s[j] - s[i - 1];
			if (ans == -1 || ans > temp) {
				ans = temp;
			}
		}
		d[i][j] = ans;
		return ans;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(bf.readLine());
		while (t-- > 0) {
			int n = Integer.valueOf(bf.readLine());
			String[] nums = bf.readLine().split(" ");
			int[] a = new int[n + 1];
			int[] s = new int[n + 1];
			int[][] d = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				a[i] = Integer.valueOf(nums[i - 1]);
				s[i] = s[i - 1] + a[i];
				Arrays.fill(d[i], -1);
			}
			System.out.println(go(a, s, d, 1, n));
		}
	}
}

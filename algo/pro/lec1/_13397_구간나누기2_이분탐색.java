package com.algo.pro.lec1;

import java.util.Scanner;

public class _13397_구간나누기2_이분탐색 {
	public static int go(int[] a, int mid) {
		int n = a.length;
		int t1 = a[0];
		int t2 = a[0];
		int ans = 1;
		for (int i = 1; i < n; i++) {
			if (t1 > a[i]) {
				t1 = a[i];
			}
			if (t2 < a[i]) {
				t2 = a[i];
			}
			if (t2 - t1 > mid) {
				ans += 1;
				t1 = a[i];
				t2 = a[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		int l = 0;
		int r = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (r < a[i]) {
				r = a[i];
			}
		}
		int ans = r;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (go(a, mid) <= k) {
				r = mid - 1;
				if (ans > mid) {
					ans = mid;
				}
			} else {
				l = mid + 1;
			}
		}
		System.out.println(ans);
	}
}

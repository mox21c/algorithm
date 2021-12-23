package com.algo.pro.lec1;

import java.util.Scanner;

public class _1285_동전뒤집기_ {
	static char flip(char x) {
		if (x == 'H') {
			return 'T';
		} else {
			return 'H';
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.next();
		}
		int ans = n * n;
		for (int state = 0; state < (1 << n); state++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int i = 0; i < n; i++) {
					char cur = a[i].charAt(j);
					if ((state & (1 << i)) != 0) {
						cur = flip(cur);
					}
					if (cur == 'T') {
						cnt += 1;
					}
				}
				sum += Math.min(cnt, n - cnt);
			}
			if (ans > sum)
				ans = sum;
		}
		System.out.println(ans);
	}
}

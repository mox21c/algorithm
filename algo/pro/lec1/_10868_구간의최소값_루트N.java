package com.algo.pro.lec1;

import java.util.Scanner;

public class _10868_구간의최소값_루트N {
	static int[] a = new int[100000];
	static int[] group = new int[317];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int r = 1;
		for (int i = 1; i * i <= n; i++) {
			r = i;
		}

		for (int i = 0; i < n; i++) {
			if (i % r == 0) {
				group[i / r] = a[i];
			} else {
				group[i / r] = Math.min(group[i / r], a[i]);
			}
		}

		while (m-- > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			start -= 1;
			end -= 1;
			int ans = a[start];
			int g1 = start / r;
			int g2 = end / r;
			if (g1 == g2) {
				for (int i = start; i <= end; i++) {
					ans = Math.min(ans, a[i]);
				}
			} else {
				while (true) {
					ans = Math.min(ans, a[start]);
					start += 1;
					if (start % r == 0) {
						break;
					}
				}

				while (true) {
					ans = Math.min(ans, a[end]);
					end -= 1;
					if (end % r == r - 1) {
						break;
					}
				}
				for (int i = start / r; i <= end / r; i++) {
					ans = Math.min(ans, group[i]);
				}
			}
			System.out.println(ans);
		}
	}
}

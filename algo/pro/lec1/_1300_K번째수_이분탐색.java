package com.algo.pro.lec1;

import java.util.Scanner;

public class _1300_K번째수_이분탐색 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long left = 1;
		long right = n * n;
		long ans = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			for (long i = 1; i <= n; i++) {
				cnt += Math.min(n, mid / i);
				//System.out.println("left=" + left +", right=" + right +", mid=" + mid +", i="+i + ", cnt=" + cnt);
			}
			if (cnt >= k) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
}

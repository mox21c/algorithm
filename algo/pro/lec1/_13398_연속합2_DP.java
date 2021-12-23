package com.algo.pro.lec1;

import java.util.Scanner;

public class _13398_연속합2_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n];
		int[] dr = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = a[i];
			if (i > 0 && d[i] < d[i - 1] + a[i]) {
				d[i] = d[i - 1] + a[i];
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			dr[i] = a[i];
			if (i < n - 1 && dr[i] < dr[i + 1] + a[i]) {
				dr[i] = dr[i + 1] + a[i];
			}

		}
		// ㅅㅜㄹㅡㄹ ㅈㅔㄱㅓㅎㅏㅈㅣ ㅇㅏㄴㅎㅇㅏㅆㅇㅡㄹ ㄸㅐ
		int ans = d[0];
		for (int i = 1; i < n; i++) {
			if (ans < d[i]) {
				ans = d[i];
			}
		}
		// 0 1 2 .... n-2 n-1
		for (int i = 1; i < n - 1; i++) {
			if (ans < d[i - 1] + dr[i + 1]) {
				ans = d[i - 1] + dr[i + 1];
			}
		}
		System.out.println(ans);
	}
}

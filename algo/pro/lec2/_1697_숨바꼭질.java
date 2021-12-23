package com.algo.pro.lec2;

import java.util.Scanner;

public class _1697_숨바꼭질 {
	static int d[] = new int[100001];
	static int q[] = new int[100001];
	static int head, tail;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		q[tail++] = N;
		d[N] = 1;
		while (head != tail) {
			int cur = q[head++];
			int next[] = { cur - 1, cur + 1, cur * 2 };
			for (int i = 0; i < 3; i++) {
				if (0 <= next[i] && next[i] <= 100000) {
					if (d[next[i]] == 0) {
						d[next[i]] = d[cur] + 1;
						q[tail++] = next[i];
					}
				}
			}
		}
		System.out.println(d[K] - 1);
	}
}

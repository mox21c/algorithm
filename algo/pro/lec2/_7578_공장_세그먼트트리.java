package com.algo.pro.lec2;

import java.util.Scanner;

public class _7578_공장_세그먼트트리 {
	static int tree[];
	static int NN;

	static int a[] = new int[500000];
	static int b[] = new int[500000];
	static int bn[] = new int[1000001];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++)
			a[i] = sc.nextInt();
		for (int i = 0; i < N; i++) {
			b[i] = sc.nextInt();
			bn[b[i]] = i;
		}

		NN = 1;
		while (NN < N)
			NN *= 2;
		tree = new int[NN * 2];

		long ans = 0;
		for (int i = 0; i < N; i++) {
			ans += get_sum(bn[a[i]] + 1, NN - 1, 1, 0, NN - 1);
			change_value(bn[a[i]], 1);
		}

		System.out.println(ans);
	}

	public static void change_value(int idx, int value) {
		int cur = NN + idx;
		tree[cur] = value;
		cur /= 2;
		while (0 < cur) {
			tree[cur] = tree[cur * 2] + tree[cur * 2 + 1];
			cur /= 2;
		}
	}

	public static int get_sum(int ql, int qr, int idx, int l, int r) {
		if (qr < l || r < ql)
			return 0; // ql qr l r, l r ql qr
		if (ql <= l && r <= qr)
			return tree[idx]; // ql l r qr
		return get_sum(ql, qr, idx * 2, l, (l + r) / 2)
				+ get_sum(ql, qr, idx * 2 + 1, (l + r) / 2 + 1, r);
	}
}

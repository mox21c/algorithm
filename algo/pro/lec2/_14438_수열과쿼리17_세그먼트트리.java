package com.algo.pro.lec2;

import java.util.Scanner;

public class _14438_수열과쿼리17_세그먼트트리 {
	static int a[] = new int[100001];
	static int tree[];
	static int NN;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (NN = 1; NN < N; NN *= 2)
			;
		tree = new int[NN * 2];

		for (int i = 1; i <= N; i++)
			tree[NN + i - 1] = sc.nextInt();
		for (int i = N + 1; i <= NN; i++)
			tree[NN + i - 1] = 1000000001;
		for (int i = NN - 1; i > 0; i--)
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);

		int M = sc.nextInt();
		while (M-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 1)
				changeValue(b, c);
			else
				System.out.println(rangeMin(b, c, 1, 1, NN));
		}
	}

	public static void changeValue(int idx, int value) {
		idx = NN + idx - 1;
		tree[idx] = value;
		for (idx /= 2; idx > 0; idx /= 2)
			tree[idx] = Math.min(tree[idx * 2], tree[idx * 2 + 1]);
	}

	// [ql, qr]: want range
	// idx: # of current node
	// [l, r]: range of current node
	// return minimum number of [l, r] in [ql, qr]
	public static int rangeMin(int ql, int qr, int idx, int l, int r) {
		// l r < ql qr, ql qr < l r
		if (r < ql || qr < l)
			return 1000000001;
		// ql <= l r <= qr
		if (ql <= l && r <= qr)
			return tree[idx];

		int left = rangeMin(ql, qr, idx * 2, l, (l + r) / 2);
		int right = rangeMin(ql, qr, idx * 2 + 1, (l + r) / 2 + 1, r);
		return Math.min(left, right);
	}
}

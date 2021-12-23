package com.algo.pro.excise;

import java.util.Arrays;
import java.util.Scanner;

public class _14438_수열과쿼리17 {
	static int[] a;
	static int N, M;
	static int NN;
	static int[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		M = sc.nextInt();

		// tree 배열 크기 
		for (NN = 1; NN < N; NN *= 2)
			;
		tree = new int[NN * 2];
		Arrays.fill(tree, 100000001);
		
		// 원본값 트리에 채워줌.
		for (int i = 1; i <= N; i++) {
			tree[NN + i - 1] = a[i - 1];
		}

		// 트리에 두개씩 비교해서 채워줌.(뒤에서 부터)
		for (int i = NN - 1; i > 0; i--) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}
		
		while (M-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 1) {
				updateVal(b, c);
			} else {
				System.out.println(query(b, c, 1, 1, NN));
			}
		}
	}

	static int query(int ql, int qr, int idx, int l, int r) {
		if (ql > r || qr < l) {
			return 100000001;
		}
		if (ql <= l && qr >= r) {
			return tree[idx];
		}
		int left = query(ql, qr, idx * 2, l, (l + r) / 2);
		int right = query(ql, qr, idx * 2 + 1, (l + r) / 2 + 1, r);
		return Math.min(left, right);
	}

	static void updateVal(int idx, int val) {
		idx = NN + idx - 1;
		tree[idx] = val;

		for (idx /= 2; idx > 0; idx /= 2) {
			tree[idx] = Math.min(tree[idx * 2], tree[idx * 2 + 1]);
		}
	}

}

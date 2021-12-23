package com.algo.pro.lec1;

import java.util.Arrays;
import java.util.Scanner;

public class _14537_수열과쿼리1_세그먼트 {
	static Query q[];
	static Elem a[];
	static int ans[] = new int[100000];
	static int tree[];
	static int NN;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		a = new Elem[N];
		for (int i = 0; i < N; i++) {
			a[i] = new Elem();
			a[i].x = sc.nextInt();
			a[i].idx = i;
		}

		int Q = sc.nextInt();
		q = new Query[Q];
		for (int i = 0; i < Q; i++) {
			q[i] = new Query();
			q[i].l = sc.nextInt();
			q[i].r = sc.nextInt();
			q[i].k = sc.nextInt();
			q[i].idx = i;
		}

		Arrays.sort(a);
		Arrays.sort(q);

		for (NN = 1; NN < N; NN *= 2)
			;
		tree = new int[NN * 2];

		for (int ai = 0, qi = 0; qi < Q; qi++) {
			if (ai < N) {
				while (q[qi].k < a[ai].x) {
					setValue(a[ai].idx, 1);
					if (++ai == N)
						break;
				}
			}
			ans[q[qi].idx] = getSum(q[qi].l - 1, q[qi].r - 1, 1, 0, NN - 1);
		}

		for (int i = 0; i < Q; i++)
			System.out.println(ans[i]);
	}

	static int getSum(int ql, int qr, int idx, int l, int r) {
		if (ql <= l && r <= qr)
			return tree[idx];
		int half = (l + r) / 2, sum = 0;
		if (ql <= half)
			sum += getSum(ql, qr, idx * 2, l, half);
		if (half < qr)
			sum += getSum(ql, qr, idx * 2 + 1, half + 1, r);
		return sum;
	}

	static void setValue(int idx, int value) {
		idx += NN;
		tree[idx] = value;
		for (idx /= 2; 0 < idx; idx /= 2)
			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
	}
}

class Query implements Comparable {
	int l, r, k, idx;

	@Override
	public int compareTo(Object o) {
		return ((Query) o).k - this.k;
	}
}

class Elem implements Comparable {
	int x, idx;

	@Override
	public int compareTo(Object o) {
		return ((Elem) o).x - this.x;
	}
}
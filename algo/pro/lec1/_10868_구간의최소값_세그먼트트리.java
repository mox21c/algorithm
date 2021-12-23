package com.algo.pro.lec1;

import java.util.Scanner;

public class _10868_구간의최소값_세그먼트트리 {
	static void init(int[] a, int[] tree, int node, int start, int end) {
		if (start == end) {
			tree[node] = a[start];
		} else {
			init(a, tree, node * 2, start, (start + end) / 2);
			init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		}
	}

	static int query(int[] tree, int node, int start, int end, int i, int j) {
		if (i > end || j < start)
			return -1;
		if (i <= start && end <= j)
			return tree[node];
		int m1 = query(tree, node * 2, start, (start + end) / 2, i, j);
		int m2 = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, i, j);
		if (m1 == -1)
			return m2;
		else if (m2 == -1)
			return m1;
		else
			return Math.min(m1, m2);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int tree_size = (1 << (h + 1));
		int[] tree = new int[tree_size];
		init(a, tree, 1, 0, n - 1);
		while (m-- > 0) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			System.out.println(query(tree, 1, 0, n - 1, left - 1, right - 1));
		}
	}
}

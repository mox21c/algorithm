package com.algo.pro.lec1;

import java.util.Scanner;

public class _1849_순열_세그먼트 {
	public static void init(int[] tree, int node, int start, int end) {
		if (start == end) {
			tree[node] = 1;
			return;
		}
		init(tree, node * 2, start, (start + end) / 2);
		init(tree, node * 2 + 1, (start + end) / 2 + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void update(int[] tree, int node, int start, int end, int i,
			int diff) {
		if (i > end || i < start) {
			return;
		}
		if (start == end) {
			tree[node] += diff;
			return;
		}
		update(tree, node * 2, start, (start + end) / 2, i, diff);
		update(tree, node * 2 + 1, (start + end) / 2 + 1, end, i, diff);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	//k번째 찾는것 
	public static int kth(int[] tree, int node, int start, int end, int k) {
		if (start == end) {
			return start;
		}
		if (k <= tree[node * 2]) {
			return kth(tree, node * 2, start, (start + end) / 2, k);
		} else {
			return kth(tree, node * 2 + 1, (start + end) / 2 + 1, end, k - tree[node * 2]);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int tree_size = (1 << (h + 1));
		int[] a = new int[n + 1];
		int[] ans = new int[n + 1];
		int[] tree = new int[tree_size];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		init(tree, 1, 1, n);
		for (int i = 1; i <= n; i++) {
			int k = a[i] + 1;
			int w = kth(tree, 1, 1, n, k);
			ans[w] = i;
			update(tree, 1, 1, n, w, -1);
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(ans[i]);
		}

	}
}

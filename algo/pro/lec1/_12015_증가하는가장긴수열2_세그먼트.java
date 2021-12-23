package com.algo.pro.lec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 세그먼트 트리 
 */
public class _12015_증가하는가장긴수열2_세그먼트 {
	public static int maximum(int[] tree, int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		return Math.max(
				maximum(tree, node * 2, start, (start + end) / 2, left, right),
				maximum(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}

	public static void update(int[] tree, int node, int start, int end, int i, int value) {
		if (i > end || i < start) {
			return;
		}
		tree[node] = Math.max(tree[node], value);
		if (start != end) {
			update(tree, node * 2, start, (start + end) / 2, i, value);
			update(tree, node * 2 + 1, (start + end) / 2 + 1, end, i, value);
		}
	}

	public static final int MAX = 1000000;

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		int h = (int) Math.ceil(Math.log(MAX) / Math.log(2));
		int tree_size = (1 << (h + 1));
		int[] tree = new int[tree_size];
		String line = bf.readLine();
		String[] nums = line.split(" ");
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.valueOf(nums[i]);
			int cur = maximum(tree, 1, 1, MAX, 1, num - 1);
			if (ans < cur + 1) {
				ans = cur + 1;
			}
			update(tree, 1, 1, MAX, num, cur + 1);
		}
		System.out.println(ans);
	}
}

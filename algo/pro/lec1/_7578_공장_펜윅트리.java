package com.algo.pro.lec1;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 세그먼트 트리 풀이는 나중에 오려 주기로 함. 참조만..
 */
public class _7578_공장_펜윅트리 {
	static int l = 0;

	static void update(int[] tree, int i, int diff) {
		while (i <= l) {
			tree[i] += diff;
			i += (i & -i);
		}
	}

	static int sum(int[] tree, int i) {
		int ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}

	static int sum(int[] tree, int l, int r) {
		if (l > r)
			return 0;
		return sum(tree, r) - sum(tree, l - 1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		HashMap<Integer, Integer> position = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			position.put(num, i + 1);
		}
		long ans = 0;
		int[] tree = new int[n + 1];
		l = n;
		for (int i = 0; i < n; i++) {
			ans += (long) sum(tree, position.get(a[i]) + 1, n);
			update(tree, position.get(a[i]), 1);
		}
		System.out.println(ans);
	}
}

package com.algo.pro.lec2;

import java.util.Scanner;

public class _9345_디지털비디오디스크_세그먼트트리 {
	static Node tree[];
	static int NN;

	static class Node {
		int min, max;

		public Node() {
			this.min = 987654321;
			this.max = -1;
		}

		public Node(int min, int max) {
			this.min = min;
			this.max = max;
		}

		public static Node mergeNode(Node left, Node right) {
			return new Node(Math.min(left.min, right.min), Math.max(left.max,
					right.max));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			runTestcase(sc);
		}
	}

	public static void runTestcase(Scanner sc) {
		int N = sc.nextInt();
		int K = sc.nextInt();

		for (NN = 1; NN < N; NN *= 2)
			;
		tree = new Node[NN * 2];

		for (int i = 0; i < N; i++)
			tree[NN + i] = new Node(i, i);
		for (int i = N; i < NN; i++)
			tree[NN + i] = new Node();
		for (int i = NN - 1; i > 0; i--)
			tree[i] = Node.mergeNode(tree[i * 2], tree[i * 2 + 1]);

		while (K-- > 0) {
			int q = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (q == 0) {
				int numa = tree[NN + a].min;
				int numb = tree[NN + b].min;
				changeValue(a, numb);
				changeValue(b, numa);
			} else {
				Node res = rangeInfo(a, b, 1, 0, NN - 1);
				if (res.min == a && res.max == b)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	public static void changeValue(int idx, int value) {
		idx = NN + idx;
		tree[idx].min = tree[idx].max = value;
		for (idx /= 2; idx > 0; idx /= 2)
			tree[idx] = Node.mergeNode(tree[idx * 2], tree[idx * 2 + 1]);
	}

	public static Node rangeInfo(int ql, int qr, int idx, int l, int r) {
		if (r < ql || qr < l)
			return new Node();
		if (ql <= l && r <= qr)
			return tree[idx];

		Node left = rangeInfo(ql, qr, idx * 2, l, (l + r) / 2);
		Node right = rangeInfo(ql, qr, idx * 2 + 1, (l + r) / 2 + 1, r);
		return Node.mergeNode(left, right);
	}
}

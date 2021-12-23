package com.algo.pro.lec1;

import java.util.ArrayList;
import java.util.Scanner;

class Trie2 {
	class Node {
		int[] children;
		boolean valid;

		Node() {
			children = new int[2];
			for (int i = 0; i < 2; i++) {
				children[i] = -1;
			}
			valid = false;
		}
	};

	ArrayList<Node> Trie2 = new ArrayList<>();
	int root;

	int init() {
		Node x = new Node();
		Trie2.add(x);
		return (int) Trie2.size() - 1;
	}

	Trie2() {
		root = init();
	}

	void add(int node, int num, int bit) {
		if (bit == -1) {
			Trie2.get(node).valid = true;
			return;
		}
		int c = (num >> bit) & 1;
		if (Trie2.get(node).children[c] == -1) {
			int next = init();
			Trie2.get(node).children[c] = next;
		}
		add(Trie2.get(node).children[c], num, bit - 1);
	}

	void add(int num) {
		add(root, num, 31);
	}

	int query(int node, int num, int bit) {
		if (bit == -1)
			return 0;
		int c = (num >> bit) & 1;
		c = 1 - c;
		if (Trie2.get(node).children[c] == -1) {
			c = 1 - c;
		}
		if (Trie2.get(node).children[c] == -1) {
			return 0;
		}
		int next = 0;
		if (c == 1)
			next = 1 << bit;
		return next | query(Trie2.get(node).children[c], num, bit - 1);
	}

	int query(int num) {
		return query(root, num, 31);
	}
}

public class _13504_XOR합_ {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int ans = 0;
			Trie2 Trie2 = new Trie2();
			int prefix = 0;
			Trie2.add(0);
			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				prefix ^= num;
				Trie2.add(prefix);
				int temp = (Trie2.query(prefix) ^ prefix);
				if (ans < temp)
					ans = temp;
			}
			System.out.println(ans);
		}
	}
}

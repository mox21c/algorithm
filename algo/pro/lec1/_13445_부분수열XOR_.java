package com.algo.pro.lec1;

import java.util.ArrayList;
import java.util.Scanner;

class Trie3 {
	class Node {
		int[] children;
		int[] cnt;
		boolean valid;

		Node() {
			children = new int[2];
			cnt = new int[2];
			for (int i = 0; i < 2; i++) {
				children[i] = -1;
				cnt[0] = 0;
			}
			valid = false;
		}
	};

	ArrayList<Node> Trie3 = new ArrayList<>();
	int root;

	int init() {
		Node x = new Node();
		Trie3.add(x);
		return (int) Trie3.size() - 1;
	}

	Trie3() {
		root = init();
	}

	void add(int node, int num, int bit) {
		if (bit == -1) {
			Trie3.get(node).valid = true;
			return;
		}
		int c = (num >> bit) & 1;
		if (Trie3.get(node).children[c] == -1) {
			int next = init();
			Trie3.get(node).children[c] = next;
		}
		Trie3.get(node).cnt[c] += 1;
		add(Trie3.get(node).children[c], num, bit - 1);
	}

	void add(int num) {
		add(root, num, 20);
	}

	int query(int node, int num, int k, int bit) {
		if (bit == -1)
			return 0;
		int c1 = (k >> bit) & 1;
		int c2 = (num >> bit) & 1;
		int ans = 0;
		if (c1 == 1) {
			ans += Trie3.get(node).cnt[c2];
			c2 = 1 - c2;
		}
		if (Trie3.get(node).children[c2] == -1)
			return ans;
		ans += query(Trie3.get(node).children[c2], num, k, bit - 1);
		return ans;
	}

	int query(int num, int k) {
		return query(root, num, k, 20);
	}
}

public class _13445_부분수열XOR_ {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long ans = 0;
		Trie3 Trie3 = new Trie3();
		int prefix = 0;
		Trie3.add(0);
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			prefix ^= num;
			ans += Trie3.query(prefix, k);
			Trie3.add(prefix);
		}
		System.out.println(ans);
	}
}
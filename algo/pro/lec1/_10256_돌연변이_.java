package com.algo.pro.lec1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

class Node4 {
	int[] children;
	int pi;
	int cnt;

	Node4() {
		children = new int[4];
		for (int i = 0; i < 4; i++) {
			children[i] = -1;
		}
		pi = -1;
		cnt = 0;
	}
}

public class _10256_돌연변이_ {
	static ArrayList<Node4> trie;

	static int to_Node4(char x) {
		if (x == 'A')
			return 0;
		else if (x == 'T')
			return 1;
		else if (x == 'G')
			return 2;
		else if (x == 'C')
			return 3;
		else
			return 4;
	}

	static int init() {
		Node4 x = new Node4();
		trie.add(x);
		return (int) trie.size() - 1;
	}

	static void add(int Node4, String s, int index) {
		if (index == s.length()) {
			trie.get(Node4).cnt = 1;
			return;
		}
		int c = to_Node4(s.charAt(index));
		if (trie.get(Node4).children[c] == -1) {
			int next = init();
			trie.get(Node4).children[c] = next;
		}
		add(trie.get(Node4).children[c], s, index + 1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			trie = new ArrayList<Node4>();
			int n = sc.nextInt();
			int m = sc.nextInt();
			String s = sc.next();
			String p = sc.next();
			int root = init();
			TreeSet<String> a = new TreeSet<>();
			for (int i = 0; i < m; i++) {
				for (int j = i; j < m; j++) {
					String p2 = new StringBuilder(p.substring(i, j + 1))
							.reverse().toString();
					a.add(p.substring(0, i) + p2 + p.substring(j + 1));
				}
			}
			for (String x : a) {
				add(root, x, 0);
			}
			Queue<Integer> q = new LinkedList<>();
			trie.get(root).pi = root;
			q.add(root);
			while (!q.isEmpty()) {
				int cur = q.remove();
				for (int i = 0; i < 4; i++) {
					int next = trie.get(cur).children[i];
					if (next == -1)
						continue;
					if (cur == root) {
						trie.get(next).pi = root;
					} else {
						int x = trie.get(cur).pi;
						while (x != root && trie.get(x).children[i] == -1) {
							x = trie.get(x).pi;
						}
						if (trie.get(x).children[i] != -1) {
							x = trie.get(x).children[i];
						}
						trie.get(next).pi = x;
					}
					int pi = trie.get(next).pi;
					trie.get(next).cnt += trie.get(pi).cnt;
					q.add(next);
				}
			}
			int ans = 0;
			int Node4 = root;
			for (int i = 0; i < n; i++) {
				int c = to_Node4(s.charAt(i));
				while (Node4 != root && trie.get(Node4).children[c] == -1) {
					Node4 = trie.get(Node4).pi;
				}
				if (trie.get(Node4).children[c] != -1) {
					Node4 = trie.get(Node4).children[c];
				}
				ans += trie.get(Node4).cnt;
			}
			System.out.println(ans);
		}
	}
}
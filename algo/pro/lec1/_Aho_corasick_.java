package com.algo.pro.lec1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node2 {
	int valid;
	int[] children;
	int pi;
	ArrayList<Integer> indexes;

	Node2() {
		valid = -1;
		children = new int[26];
		for (int i = 0; i < 26; i++) {
			children[i] = -1;
		}
		pi = -1;
		indexes = new ArrayList<Integer>();
	}
}

public class _Aho_corasick_ {
	static ArrayList<Node2> trie = new ArrayList<>();

	static int init() {
		Node2 x = new Node2();
		trie.add(x);
		return (int) trie.size() - 1;
	}

	static void add(int Node2, String s, int index, int string_index) {
		if (index == s.length()) {
			trie.get(Node2).valid = string_index;
			return;
		}
		int c = s.charAt(index) - 'A';
		if (trie.get(Node2).children[c] == -1) {
			int next = init();
			trie.get(Node2).children[c] = next;
		}
		add(trie.get(Node2).children[c], s, index + 1, string_index);
	}

	public static void main(String args[]) {
		int root = init();
		int n = 5;
		String[] a = { "ABAB", "AD", "ABC", "BCD", "ABABC" };
		for (int i = 0; i < n; i++) {
			add(root, a[i], 0, i);
		}
		Queue<Integer> q = new LinkedList<>();
		trie.get(root).pi = root;
		q.add(root);
		while (!q.isEmpty()) {
			int cur = q.remove();
			for (int i = 0; i < 26; i++) {
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
				trie.get(next).indexes = new ArrayList<>(trie.get(pi).indexes);
				if (trie.get(next).valid != -1) {
					trie.get(next).indexes.add(trie.get(next).valid);
				}
				q.add(next);
			}
		}
		for (int i = 0; i < trie.size(); i++) {
			System.out.print(i + " " + trie.get(i).pi);
			for (int x : trie.get(i).indexes) {
				System.out.print(" " + x);
			}
			System.out.println();
		}
		String s = "ABCDEABABABABCD";
		int Node2 = root;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'A';
			while (Node2 != root && trie.get(Node2).children[c] == -1) {
				Node2 = trie.get(Node2).pi;
			}
			if (trie.get(Node2).children[c] != -1) {
				Node2 = trie.get(Node2).children[c];
			}
			for (int x : trie.get(Node2).indexes) {
				System.out.println(Node2 + " " + x);
			}
		}
	}
}

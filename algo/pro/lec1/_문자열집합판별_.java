package com.algo.pro.lec1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node3 {
    int valid;
    int[] children;
    int pi;
    ArrayList<Integer> indexes;
    Node3() {
        valid = -1;
        children = new int[26];
        for (int i=0; i<26; i++) {
            children[i] = -1;
        }
        pi = -1;
        indexes = new ArrayList<Integer>();
    }
}
public class _문자열집합판별_ {
    static ArrayList<Node3> trie = new ArrayList<>();
    static int init() {
        Node3 x = new Node3();
        trie.add(x);
        return (int)trie.size()-1;
    }
    static void add(int Node3, String s, int index, int string_index) {
        if (index == s.length()) {
            trie.get(Node3).valid = string_index;
            return;
        }
        int c = s.charAt(index) - 'a';
        if (trie.get(Node3).children[c] == -1) {
            int next = init();
            trie.get(Node3).children[c] = next;
        }
        add(trie.get(Node3).children[c], s, index+1, string_index);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int root = init();
        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
            add(root, a[i], 0, i);
        }
        Queue<Integer> q = new LinkedList<>();
        trie.get(root).pi = root;
        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int i=0; i<26; i++) {
                int next = trie.get(cur).children[i];
                if (next == -1) continue;
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
        int m = sc.nextInt();
        while (m-- > 0) {
            String s = sc.next();
            int Node3 = root;
            boolean ok = false;
            for (int i=0; i<s.length(); i++) {
                int c = s.charAt(i) - 'a';
                while (Node3 != root && trie.get(Node3).children[c] == -1) {
                    Node3 = trie.get(Node3).pi;
                }
                if (trie.get(Node3).children[c] != -1) {
                    Node3 = trie.get(Node3).children[c];
                }
				if (trie.get(Node3).indexes.size() > 0) {
                    ok = true;
                }
            }
            System.out.println(ok ? "YES" : "NO");
        }
    }
}

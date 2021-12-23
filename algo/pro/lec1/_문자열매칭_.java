package com.algo.pro.lec1;

import java.util.Scanner;

public class _문자열매칭_ {
	static int match(String s, String p) {
		int n = s.length();
		int m = p.length();
		for (int i = 0; i <= n - m; i++) {
			boolean ok = true;
			for (int j = 0; j < m; j++) {
				if (s.charAt(i + j) != p.charAt(j)) {
					ok = false;
				}
			}
			if (ok)
				return i;
		}
		return -1;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = "ABCABDABCABEABC";
		String p = "ABCABE";
		// s = sc.next(); p = sc.next();
		System.out.println(match(s, p));
	}
}

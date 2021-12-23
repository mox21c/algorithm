package com.algo.pro.lec1;

import java.util.Scanner;

public class _KMP알고리즘_ {
	static int[] preprocessing(String p) {
		int m = p.length();
		int[] pi = new int[m];
		pi[0] = 0;
		int j = 0;
		for (int i = 1; i < m; i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if (p.charAt(i) == p.charAt(j)) {
				pi[i] = j + 1;
				j += 1;
			} else {
				pi[i] = 0;
			}
		}
		return pi;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	}
}

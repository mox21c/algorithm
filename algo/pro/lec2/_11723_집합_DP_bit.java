package com.algo.pro.lec2;

import java.util.Scanner;

public class _11723_집합_DP_bit {
	static boolean set[] = new boolean[21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		while (M-- > 0) {
			String cmd = sc.next();
			char first = cmd.charAt(0);
			if (first == 'a') {
				if (cmd.charAt(1) == 'd') {
					int x = sc.nextInt();
					set[x] = true;
				} else {
					for (int i = 1; i <= 20; i++)
						set[i] = true;
				}
			} else if (first == 'r') {
				int x = sc.nextInt();
				set[x] = false;
			} else if (first == 'c') {
				int x = sc.nextInt();
				System.out.println(set[x] ? 1 : 0);
			} else if (first == 't') {
				int x = sc.nextInt();
				set[x] = !set[x];
			} else if (first == 'e') {
				for (int i = 1; i <= 20; i++)
					set[i] = false;
			}
		}
	}
}

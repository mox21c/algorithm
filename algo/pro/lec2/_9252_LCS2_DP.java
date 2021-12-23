package com.algo.pro.lec2;

import java.util.Scanner;

public class _9252_LCS2_DP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		int la = a.length();
		int lb = b.length();

		int lcs[][] = new int[la + 1][lb + 1];
		for (int i = 1; i <= la; i++) {
			for (int j = 1; j <= lb; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					if (lcs[i - 1][j] < lcs[i][j - 1]) {
						lcs[i][j] = lcs[i][j - 1];
					} else {
						lcs[i][j] = lcs[i - 1][j];
					}
				}
			}
		}

		char ans[] = new char[lcs[la][lb]];
		int idx = lcs[la][lb] - 1, i1 = la, i2 = lb;
		while (0 <= idx) {
			if (a.charAt(i1 - 1) == b.charAt(i2 - 1)) {
				ans[idx--] = a.charAt(i1 - 1);
				i1--;
				i2--;
			} 
			else if (lcs[i1][i2 - 1] <= lcs[i1 - 1][i2]){
				i1--;
			}
			else{
				i2--;
			}
		}

		System.out.println(lcs[la][lb]);
		for (int i = 0; i < lcs[la][lb]; i++)
			System.out.print(ans[i]);
		System.out.println();

	}
}

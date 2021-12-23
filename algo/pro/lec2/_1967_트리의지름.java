package com.algo.pro.lec2;

import java.util.ArrayList;
import java.util.Scanner;

public class _1967_트리의지름 {

	static ArrayList<Edge> child[] = new ArrayList[10001];
	static int ans;
	static class Edge {
		int to, weight;

		Edge() {
		}

		Edge(int t, int w) {
			to = t;
			weight = w;
		}
	}

	// max(p <- leaf)
	static int getHalfDiameter(int p) {
		if (child[p].size() == 0)
			return 0;

		int max1 = 0, max2 = 0;
		for (int i = 0; i < child[p].size(); i++) {
			int len = getHalfDiameter(child[p].get(i).to)
					+ child[p].get(i).weight;
			if (len > max1) {
				max2 = max1;
				max1 = len;
			} else if (len > max2) {
				max2 = len;
			}
		}

		if (max1 + max2 > ans)
			ans = max1 + max2;
		return max1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++)
			child[i] = new ArrayList<Edge>();

		for (int i = 1; i < N; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			child[p].add(new Edge(c, w));
		}

		getHalfDiameter(1);
		System.out.println(ans);
	}
}



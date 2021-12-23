package com.algo.pro.lec2;

import java.util.Scanner;

public class _1260_DFSBFS {
	static boolean adj[][] = new boolean[1001][1001];
	static boolean visited[] = new boolean[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = adj[b][a] = true;
		}

		visitDfs(V, N);
		System.out.println();

		visited = new boolean[1001];
		visitBfs(V, N);
		System.out.println();
	}

	public static void visitDfs(int cur, int N) {
		visited[cur] = true;
		System.out.print(cur + " ");
		for (int i = 1; i <= N; i++)
			if (adj[cur][i] && !visited[i]) {
				visitDfs(i, N);
			}
	}

	public static void visitBfs(int start, int N) {
		int q[] = new int[1001];
		int head = 0, tail = 0;

		q[tail++] = start;
		visited[start] = true;
		while (head != tail) {
			int cur = q[head++];
			System.out.print(cur + " ");
			for (int i = 1; i <= N; i++)
				if (adj[cur][i] && !visited[i]) {
					q[tail++] = i;
					visited[i] = true;
				}
		}
	}
}

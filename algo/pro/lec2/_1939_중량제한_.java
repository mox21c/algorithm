package com.algo.pro.lec2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class _1939_중량제한_ {
	static Vector<Edge> adj[] = new Vector[100001];
	static int N, M, S, E;

	static boolean checkPossible(int weight) {
		boolean chk[] = new boolean[N + 1];
		chk[S] = true;

		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		while (!q.isEmpty()) {
			int cur = q.peek();
			q.poll();
			for (int i = 0; i < adj[cur].size(); i++) {
				int next = adj[cur].get(i).to;
				if (chk[next] || adj[cur].get(i).cost < weight)
					continue;
				if (next == E)
					return true;
				q.add(next);
				chk[next] = true;
			}
		}
		return chk[E];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 1; i <= N; i++)
			adj[i] = new Vector<Edge>();

		for (int i = 0, u, v, c; i < M; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			c = sc.nextInt();
			adj[u].add(new Edge(v, c));
			adj[v].add(new Edge(u, c));
		}

		S = sc.nextInt();
		E = sc.nextInt();

		int ans = 0, l = 0, r = 1000000000, m;
		while (l <= r) {
			m = (l + r) / 2;
			if (checkPossible(m)) {
				ans = m;
				l = m + 1;
			} else
				r = m - 1;
		}

		System.out.println(ans);
	}
}

class Edge {
	int to, cost;

	Edge() {
	}

	Edge(int t, int c) {
		to = t;
		cost = c;
	}
}
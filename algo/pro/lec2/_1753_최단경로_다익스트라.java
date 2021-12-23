package com.algo.pro.lec2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class _1753_최단경로_다익스트라 {
	static Vector<Edge> adj[] = new Vector[20001];
	static int minDistance[] = new int[20001];
	static boolean chk[] = new boolean[20001];

	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();
		for (int i = 1; i <= V; i++)
			adj[i] = new Vector<>();

		int K = sc.nextInt();
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj[u].add(new Edge(v, w));
		}

		Dijkstra(K, V);

		for (int i = 1; i <= V; i++) {
			if (minDistance[i] == 987654321)
				System.out.println("INF");
			else
				System.out.println(minDistance[i]);
		}
	}

	public static void Dijkstra(int start, int vertexs) {
		Arrays.fill(minDistance, 987654321);

		minDistance[start] = 0;
		while (true) {
			// 1. pick shortest V (chk[V] == false)
			int v = -1, mind = 987654321;
			for (int j = 1; j <= vertexs; j++) {
				if (chk[j])
					continue;
				if (minDistance[j] < mind) {
					v = j;
					mind = minDistance[j];
				}
			}
			if (v < 0)
				break;

			// 2. set mindistance of v
			chk[v] = true;

			// 3. renewal distance of adj[v]
			for (Edge edge : adj[v]) {
				int next = edge.to;
				int newDistance = mind + edge.cost;
				minDistance[next] = Math.min(minDistance[next], newDistance);
			}
		}
	}
}

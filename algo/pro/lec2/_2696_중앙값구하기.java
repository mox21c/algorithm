package com.algo.pro.lec2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class _2696_중앙값구하기 {
	static Vector<Edge> adj[] = new Vector[10001];
	static int dist[][] = new int[10001][21];
	static boolean chk[][] = new boolean[10001][21];

	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static class Node implements Comparable {
		int cur, cost, usecnt;

		public Node(int cur, int cost, int usecnt) {
			this.cur = cur;
			this.cost = cost;
			this.usecnt = usecnt;
		}

		@Override
		public int compareTo(Object o) {
			return this.cost - ((Node) o).cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 1; i <= N; i++)
			adj[i] = new Vector<>();

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj[u].add(new Edge(v, w));
			adj[v].add(new Edge(u, w));
		}

		System.out.println(Dijkstra(N, K, 1, N));
	}

	public static int Dijkstra(int vertexs, int maxk, int start, int target) {
		for (int i = 1; i <= vertexs; i++)
			Arrays.fill(dist[i], 987654321);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0, 0));
		dist[start][0] = 0;

		while (!pq.isEmpty()) {
			int v = pq.peek().cur;
			int mind = pq.peek().cost;
			int usecnt = pq.peek().usecnt;
			pq.poll();
			if (v == target)
				return mind;
			if (chk[v][usecnt])
				continue;

			chk[v][usecnt] = true;
			for (Edge edge : adj[v]) {
				int next = edge.to;
				int newd = mind + edge.cost;
				if (dist[next][usecnt] > newd) {
					pq.offer(new Node(next, newd, usecnt));
					dist[next][usecnt] = newd;
				}
				if (usecnt < maxk) {
					if (dist[next][usecnt + 1] > mind) {
						pq.offer(new Node(next, mind, usecnt + 1));
						dist[next][usecnt + 1] = mind;
					}
				}
			}
		}
		return -1;
	}
}

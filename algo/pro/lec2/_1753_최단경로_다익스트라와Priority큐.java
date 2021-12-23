package com.algo.pro.lec2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class _1753_최단경로_다익스트라와Priority큐 {
	static Vector<Node> adj[] = new Vector[20001];
	static int minDistance[] = new int[20001];
	static boolean chk[] = new boolean[20001];

	static class Node implements Comparable<Node> {
		int vertex, cost;

		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - ((Node) o).cost;
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
			adj[u].add(new Node(v, w));
		}

		Dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (minDistance[i] == 987654321)
				System.out.println("INF");
			else
				System.out.println(minDistance[i]);
		}
	}

	public static void Dijkstra(int start) {
		Arrays.fill(minDistance, 987654321);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		// vertex, cost
		pq.offer(new Node(start, 0)); // add method
		minDistance[start] = 0;
		while (!pq.isEmpty()) {
			// 1. pick shortest V (chk[V] == false)
			int v = pq.peek().vertex; // get top elem
			int mind = pq.peek().cost;
			pq.poll(); // remove top elem
			if (chk[v])
				continue;

			// 2. set mindistance of v
			chk[v] = true;

			// 3. renewal distance of adj[v]
			for (Node edge : adj[v]) {
				int next = edge.vertex;
				int newDistance = mind + edge.cost;
				if (minDistance[next] > newDistance) {
					pq.offer(new Node(next, newDistance));
					minDistance[next] = newDistance;
				}
			}
		}
	}
}

package com.algo.pro.excise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 개미굴 {
	static ArrayList<Edge> ar[];
	static int N;
	static int check;
	static int result;
	static boolean visited[], back_visited[], result_visited[];
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int TC = Integer.parseInt(st.nextToken());

		for (int T = 1; T <= TC; T++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			ar = new ArrayList[N + 1];
			visited = new boolean[N + 1];
			back_visited = new boolean[N + 1];
			result_visited = new boolean[N + 1];

			q = new LinkedList<>();

			for (int i = 0; i <= N; i++) {
				ar[i] = new ArrayList<>();
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				ar[a].add(new Edge(b, c));
				ar[b].add(new Edge(a, c));
			}
			check = 0;
			dfs(1);
			int cnt = 1;
			int max = 0;

			if (check != N) {
				System.out.println("0");
			} else {
				while (!q.isEmpty()) {

					int val = q.poll();

					for (int i = 0; i < ar[val].size(); i++) {
						if (back_visited[ar[val].get(i).v]
								&& !result_visited[ar[val].get(i).v]) {
							result_visited[ar[val].get(i).v] = true;
							if (max < ar[val].get(i).w) {
								max = ar[val].get(i).w;
								cnt = 1;
							} else if (max == ar[val].get(i).w) {

								cnt++;
							}
						}
					}

				}
			}

			System.out.println("#" + T + " " + cnt);
		}
	}

	public static void dfs(int here) {
		visited[here] = true;
		check++;

		for (int i = 0; i < ar[here].size(); i++) {
			if (visited[ar[here].get(i).v]) {
				if (!back_visited[ar[here].get(i).v]) {
					back_visited[ar[here].get(i).v] = true;
					q.add(ar[here].get(i).v);
				}

			} else {
				dfs(ar[here].get(i).v);
			}
		}
	}

	static class Edge {
		int v;
		int w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

}

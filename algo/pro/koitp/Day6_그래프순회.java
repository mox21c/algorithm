package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day6_그래프순회 {

	static int V, E, S;
	static ArrayList<Integer>[] a;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		S = Integer.valueOf(st.nextToken());


		a = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			a[s].add(e);
			a[e].add(s);
		}
		br.close();
		
		for (int i = 1; i <= V; i++) {
			Collections.sort(a[i]);
		}
		boolean[] chk = new boolean[V + 1];
		dfs(S, new boolean[V + 1]);
		sb.append("\n");
		
		chk = new boolean[V + 1];
		bfs(S, chk);
		System.out.println(sb.toString());
	}

	public static void dfs(int start, boolean[] chk) {
		chk[start] = true;
		sb.append(start);
		sb.append(" ");
		for (int i = 0; i < a[start].size(); i++) {
			if (!chk[a[start].get(i)]) {
				chk[a[start].get(i)] = true;
				dfs(a[start].get(i), chk);
			}
		}
		
	}

	public static void bfs(int start, boolean[] chk) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		chk[start] = true;
		while (!q.isEmpty()) {
			int t = q.remove();
			sb.append(t);
			sb.append(" ");
			for (int i = 0; i < a[t].size(); i++) {
				if (!chk[a[t].get(i)]) {
					q.add(a[t].get(i));
					chk[a[t].get(i)] = true;
				}
			}
		}
	}

}

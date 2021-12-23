package com.algo.info;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 단절점 {
	static int V, E;
	static ArrayList<Integer>[] lst;
	static StringTokenizer st;
	static int[] disc, cut;
	static int ans, d;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine().trim());
		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		lst = new ArrayList[V + 1];
		disc = new int[V + 1];
		cut = new int[V + 1];
		ans = 0;
		d = 0;

		for (int i = 1; i <= V; i++) {
			lst[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			lst[a].add(b);
			lst[b].add(a);
		}
		br.close();

		for (int i = 1; i <= V; i++) {
			if (disc[i] == 0) {
				dfs(i, true);
			}
		}
		for (int i = 1; i <= V; i++) {
			if (cut[i] == 1) {
				ans++;
			}
		}
		sb.append(ans);
		sb.append("\n");
		for (int i = 1; i <= V; i++) {
			if (cut[i] == 1) {
				sb.append(i);
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}

	public static int dfs(int here, boolean r) {
		disc[here] = ++d;
		int ret = disc[here];
		int child = 0;
		for (int there : lst[here]) {
			if (disc[there] == 0) {
				child++;
				int df = dfs(there, false);
				if (!r && df >= disc[here]) {
					cut[here] = 1;
				}
				ret = Math.min(ret, df);
			} else
				ret = Math.min(ret, disc[there]);
		}
		if (r && child > 1)
			cut[here] = 1;
		return ret;

	}
}

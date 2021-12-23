package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day5_동맹의동맹은동맹_find_unoin {
	static int N, Q;
	static StringTokenizer st;
	static int[] parent;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.valueOf(br.readLine().trim());
		Q = Integer.valueOf(br.readLine().trim());

		parent = new int[N + 1];

		// parent 배열 초기화 (자기 자신으로)
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine().trim());
			int t = Integer.valueOf(st.nextToken());
			int d1 = Integer.valueOf(st.nextToken());
			int d2 = Integer.valueOf(st.nextToken());

			// t가 0일 경우 서로 동맹을 맺어줌.
			if (t == 0) {
				union(d1, d2);
			}
			// 두수의 최상의 부모 값을 찾아 비교하여 같으면 동맹, 아니면 동맹이 아님.
			else {
				int x = find(d1);
				int y = find(d2);
				System.out.println(x == y ? 1 : 0);
			}
		}
		System.out.println(sb.toString());
	}
	
	// 최상위 부모를 찾아줌.
	public static int find(int u) {
		if (parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}

	// 서로 동맹을 맺어줌 (union 해줌)
	public static void union(int d1, int d2) {
		int x = find(d1);
		int y = find(d2);

		if (x == y) {
			return;
		}
		parent[x] = y;
	}
}

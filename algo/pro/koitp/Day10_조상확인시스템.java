package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Day10_조상확인시스템 {
	static int N, R, Q;
	static int counter;
	static ArrayList<Integer>[] al;
	static int[] IN, OUT;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken());
		Q = Integer.valueOf(st.nextToken());

		al = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			al[i] = new ArrayList<Integer>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int a = Integer.valueOf(st.nextToken());
			if (i != R){
				al[a].add(i);
			}
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(al[i]);
		}

		IN = new int[N + 1];
		OUT = new int[N + 1];
		counter = 0;

		dfs(R);

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.valueOf(st.nextToken());
			int child = Integer.valueOf(st.nextToken());
			if (IN[parent] <= IN[child] && OUT[parent] >= OUT[child]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		br.close();
	}

	public static void dfs(int here) {
		IN[here] = ++counter;
		for (int i = 0; i < al[here].size(); i++) {
			int there = al[here].get(i);
			dfs(there);
		}
		OUT[here] = ++counter;
	}
}

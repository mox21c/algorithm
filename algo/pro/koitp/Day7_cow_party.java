package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day7_cow_party {
	static int N, M, X;
	static StringTokenizer st;

	static class node {
		int p, cost;
		public node(int p, int cost) {
			this.p = p;
			this.cost = cost;
		}
	}

	static ArrayList<node>[] VT, reverseVT;
	static int[] dp, rdp, totaldp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		X = Integer.valueOf(st.nextToken());

		VT = new ArrayList[N + 1];
		reverseVT = new ArrayList[N + 1];

		dp = new int[N + 1];
		rdp = new int[N + 1];
		totaldp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			VT[i] = new ArrayList<node>();
			reverseVT[i] = new ArrayList<node>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());

			VT[x].add(new node(y, c));
			reverseVT[y].add(new node(x, c));
		}
		
		dijkstra(VT, dp, X);
		dijkstra(reverseVT, rdp, X);
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(rdp));
		int ans = 0;
		for(int i=1;i<=N; i++){
			if(ans < dp[i] + rdp[i]){
				ans = dp[i] + rdp[i];
			}
		}
		System.out.println(ans);
		br.close();
	}

	public static void dijkstra(ArrayList<node>[] v, int[] d, int start) {
		// 우선순위큐 선언.
		PriorityQueue<node> pq = new PriorityQueue<node>(N+1, new Comparator<node>() {
			public int compare(node o1, node o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});
		
		// 초기화.
		Arrays.fill(d, Integer.MAX_VALUE);
		
		// 시작점 넣어줌.
		d[start] = 0;
		pq.add(new node(start, 0));
		
		while(!pq.isEmpty()){
			node now = pq.remove();
			if(d[now.p] != now.cost){
				continue;
			}
			for(node next : v[now.p]){
				if(d[next.p] > d[now.p] + next.cost){
					d[next.p] = d[now.p] + next.cost;
					pq.add(new node(next.p, d[next.p]));
				}
			}
		}
	}
}

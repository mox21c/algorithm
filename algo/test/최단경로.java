package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {
	static int N,M;
	static class pair{
		int p;
		long cost;
		pair(int p, long cost){
			this.p = p;
			this.cost = cost;
		}
	}
	static long dist[];
	static ArrayList<pair>[] al;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		al = new ArrayList[N+1];
		for(int i=1; i<=N; i++){
			al[i] = new ArrayList<pair>();
		}
		
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			long c = Long.valueOf(st.nextToken());
			al[s].add(new pair(e, c));
			al[e].add(new pair(s, c));
		}
		System.out.println(dta(1));
		br.close();
	}
	
	public static long dta(int s){
		PriorityQueue<pair> pq = new PriorityQueue<pair>(N+1, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return Long.compare(o1.cost, o2.cost);
			}
		});
		dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[s] = 0;
		pq.add(new pair(s, 0));
		
		while(!pq.isEmpty()){
			pair r = pq.remove();
			int here = r.p;
			long cost = r.cost;
			if(dist[here] < cost){
				continue;
			}
			for(int i=0;i<al[here].size(); i++){
				int there = al[here].get(i).p;
				long thereCost = cost + al[here].get(i).cost;
				if(dist[there] > thereCost){
					dist[there] = thereCost;
					pq.add(new pair(there, thereCost));
				}
			}
		}
		return dist[N] == Long.MAX_VALUE ? -1 : dist[N];
	}
}

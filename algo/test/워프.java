package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 워프 {
	static StringTokenizer st;
	static int V, E;
	static int[] indegree;
	static ArrayList<pair>[] al;
	static long[] dist;
	static class pair{
		int p; 
		long cost;
		public pair(int p, long cost){
			this.p = p;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		al = new ArrayList[V+1];
		dist = new long[V+1];
		for(int i=1; i<=V; i++){
			al[i] = new ArrayList<pair>();
		}
		
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			long c = Long.valueOf(st.nextToken());
			al[s].add(new pair(e, c));
		}
		dta(1);
		
		System.out.println(dist[V] == Long.MAX_VALUE ? -1 : dist[V]);
		
		br.close();
	}
	
	public static void dta(int s){
		PriorityQueue<pair> pq = new PriorityQueue<pair>(V+1, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return Long.compare(o1.cost, o2.cost);
			}
		});
		Arrays.fill(dist, Long.MAX_VALUE);
		
		dist[s] = 0;
		
		pq.add(new pair(s, 0));
		
		while(!pq.isEmpty()){
			pair r = pq.remove();
			int pos = r.p;
			long cost = r.cost;
			
			if(dist[pos] < cost){
				continue;
			}
			
			for(int i=0;i<al[pos].size(); i++){
				int there = al[pos].get(i).p;
				long thereCost = cost + al[pos].get(i).cost;
				if(dist[there] > thereCost){
					dist[there] = thereCost;
					pq.add(new pair(there, thereCost));
				}
			}
		}
		
	}
}

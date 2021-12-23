package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cowparty {
	static StringTokenizer st;
	static class pair{
		int p, cost;
		pair(int p, int cost){
			this.p = p;
			this.cost = cost;
		}
		
	}
	static int N,M,X;
	static ArrayList<pair>[] reverseAl, al;
	static int[] dist, reverseDist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		X = Integer.valueOf(st.nextToken());
		
		al = new ArrayList[N+1];
		reverseAl = new ArrayList[N+1];
		
		dist =  new int[N+1];
		reverseDist =  new int[N+1];
		
		for(int i=1;i<=N; i++){
			al[i] = new ArrayList<pair>();
			reverseAl[i] = new ArrayList<pair>();
		}
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			reverseAl[e].add(new pair(s,c));
			al[s].add(new pair(e,c));
		}
		br.close();
		dta(X, reverseDist, reverseAl);
		dta(X, dist, al);
		int ans = 0;
		for(int i=1;i<=N; i++){
			ans = Math.max(ans, reverseDist[i] + dist[i]);
		}
		System.out.println(ans);
	}
	
	public static void dta(int s, int[] ds, ArrayList<pair>[] a){
		PriorityQueue<pair> pq = new PriorityQueue<pair>(N+1,new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return o1.cost - o2.cost;
			}
		});
		Arrays.fill(ds, Integer.MAX_VALUE);
		ds[s] = 0;
		pq.add(new pair(s, 0));
		
		while(!pq.isEmpty()){
			pair r = pq.remove();
			int here = r.p;
			int cost = r.cost;
			if(ds[here] < cost){
				continue;
			}
			for(int i=0;i<a[here].size(); i++){
				int there = a[here].get(i).p;
				int nextCost = cost + a[here].get(i).cost;
				if(ds[there] > nextCost){
					ds[there] = nextCost;
					pq.add(new pair(there, nextCost));
				}
			}
		}
	}
}

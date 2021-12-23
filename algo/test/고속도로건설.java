package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 고속도로건설 {
	static int N,M;
	static StringTokenizer st;
	static int[] parent;
	static class pair{
		int s,e,c;
		pair(int s, int e, int c){
			this.s=s;
			this.e=e;
			this.c=c;
		}
	}
	static ArrayList<pair> al;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());
		M = Integer.valueOf(br.readLine());
		
		parent = new int[N+1];
		for(int i=1;i<=N; i++){
			parent[i] = i;
		}
		
		PriorityQueue<pair> pq = new PriorityQueue<pair>(N+1, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return o1.c - o2.c;
			}
		});
		
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.valueOf(st.nextToken());
			int p2 = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			pq.add(new pair(p1,p2,c));
		}
		int ans = 0;
		while(!pq.isEmpty()){
			pair r = pq.remove();
			int x = find(r.s);
			int y = find(r.e);
			if(x == y){
				continue;
			}
			ans = ans + r.c;
			parent[x] = y;
			
			
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static int find(int u){
		if(parent[u] == u){
			return u;
		}
		return parent[u] = find(parent[u]);
	}
}

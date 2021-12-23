package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Day8_고속도로건설_mst_크루스칼 {
	static int N,M;
	static StringTokenizer st;
	static class pair{
		int s, e, cost;
		pair(int s, int e, int cost){
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	};
	static int[] parent;
	static ArrayList<pair> al;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());
		M = Integer.valueOf(br.readLine().trim());
		
		parent = new int[N+1];
		
		// 현재 자기 숫자로 초기화 
		for(int i=0;i<=N;i++){
			parent[i] = i;
		}
		
		al = new ArrayList<pair>();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			al.add(new pair(s, e, c));
		}
		
		// 간선 오름 차순 정렬 
		Collections.sort(al, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return o1.cost - o2.cost;
			}
		});
		
		ans = 0;
		for(int i=0;i<M;i++){
			if(merge(al.get(i).s, al.get(i).e)){
				ans += al.get(i).cost;
			}
		}
		System.out.println(ans);
		
		br.close();
	}
	
	public static int find(int n){
		if(n == parent[n]){
			return n;
		}
		return parent[n] = find(parent[n]);
	}
	
	public static boolean merge(int u, int v){
		u = find(u);
		v = find(v);
		// 사이클 존재 여부 확인 
		if(u == v){
			return false;
		}
		parent[u] = v;
		return true;
	}
}

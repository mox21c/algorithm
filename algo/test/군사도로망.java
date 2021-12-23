package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 군사도로망 {
	static int N,M,K,Q;
	static class pair{
		int s, e;
		long cost;
		pair(int s, int e, long cost){
			this.s=s;
			this.e=e;
			this.cost=cost;
		}
	}
	static long ans;
	static int[] parent, can_connect, connect;;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		Q = M+K;
		ans = 0;
		parent = new int[N+1];
		connect = new int[Q];
		can_connect = new int[Q];
		ArrayList<pair> al = new ArrayList<pair>();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a= Integer.valueOf(st.nextToken());
			int b= Integer.valueOf(st.nextToken());
			int c= Integer.valueOf(st.nextToken());
			al.add(new pair(a,b,-c));
			ans += c;
		}
		for(int i=0;i<K;i++){
			st = new StringTokenizer(br.readLine());
			int a= Integer.valueOf(st.nextToken());
			int b= Integer.valueOf(st.nextToken());
			int c= Integer.valueOf(st.nextToken());
			al.add(new pair(a,b,c));
		}
		
		for(int i=1;i<=N;i++){
			parent[i] = i;
		}
		
		Collections.sort(al, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return Long.compare(o1.cost ,o2.cost) ;
			}
		});
		
		for(int i=0;i<Q;i++){
			pair r = al.get(i);
			if(i==0 || al.get(i-1).cost != al.get(i).cost){
				for(int j=i;j<Q;j++){
					if(al.get(i).cost != al.get(j).cost){
						break;
					}
					if(find(al.get(j).s) != find(al.get(j).e)){
						can_connect[j] = 1;
					}
				}
			}
			
			
			int x = find(r.s);
			int y = find(r.e);
			if(x==y){
				continue;
			}
			ans += r.cost;
			parent[x] = parent[y];
			connect[i] = 1;
		}
//		System.out.println(Arrays.toString(can_connect));
//		System.out.println(Arrays.toString(connect));
		boolean isUnique = true;
		for(int i=0;i<N;i++){
			if(can_connect[i] == 1 && connect[i] ==0){
				isUnique = false;
				break;
			}
		}
		
		System.out.println(ans + " " + (isUnique?"unique":"not unique"));
		br.close();
	}
	public static int find(int u){
		if(parent[u] == u){
			return u;
		}
		return parent[u] = find(parent[u]);
	}
}

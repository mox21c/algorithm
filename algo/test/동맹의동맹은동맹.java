package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동맹의동맹은동맹 {
	static StringTokenizer st;
	static int N, Q;
	static int[] d,parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		Q = Integer.valueOf(br.readLine());
		d = new int[N+1];
		parent = new int[N+1];
		for(int i=1;i<=N;i++){
			parent[i] = i;
		}
		while(Q-- > 0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int p1 = Integer.valueOf(st.nextToken());
			int p2 = Integer.valueOf(st.nextToken());
			if(a == 0){
				int x = find(p1);
				int y = find(p2);
				if(x!=y){
					parent[x] = y;
				}
			}else{
				int x = find(p1);
				int y = find(p2);
				if(x==y){
					System.out.println(1);
				}else{
					System.out.println(0);
					//parent[x] = y;
				}
			}
		}
		br.close();
	}
	public static int find(int u){
		if(parent[u] == u){
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
}

package com.algo.pro.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// dfs의 넘버링.
public class 단절점 {
	static int V, E;
	// dfs를 돌면서 해당 순서를 저장.
	static int[] discovered;
	static boolean[] cutJum;
	static ArrayList<Integer>[] al;
	static int counter;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		al = new ArrayList[V+1];
		discovered = new int[V+1];
		cutJum = new boolean[V+1];
		
		for(int i=1;i<=V;i++){
			al[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=E;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			al[a].add(b);
			al[b].add(a);
		}
		
		for(int i=1;i<=V; i++){
			if(discovered[i] == 0){
				dfsCutJum(i, true);
			}
		}
		
		int resultCnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++){
			if(cutJum[i]){
				resultCnt++;
				sb.append(i);
				sb.append(" ");
			}
		}
		
		System.out.println(resultCnt);
		System.out.println(sb.toString());
		
		
		br.close();
	}
	
	public static int dfsCutJum(int here, boolean isRoot){
		discovered[here] = ++counter;
		int ret = discovered[here];
		int child = 0;
		for(int i=0;i < al[here].size(); i++){
			int there = al[here].get(i);
			if(discovered[there] == 0){
				child++;
				int low = dfsCutJum(there, false);
				if(!isRoot && low >= discovered[here]){
					cutJum[here] = true;
				}
				ret = Math.min(ret, low);
			}else{
				ret = Math.min(ret, discovered[there]);
			}
		}
		if(isRoot && child > 1){
			cutJum[here] = true;
		}
		return ret;
	}
}

/*
7 7
1 4
4 5
5 1
1 6
6 7
2 7
7 3

3
1 6 7
*/
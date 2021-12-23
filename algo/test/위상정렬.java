package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 위상정렬 {
	static StringTokenizer st;
	static int V, E;
	static int[] indegree;
	static ArrayList<Integer>[] al;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		al = new ArrayList[V+1];
		indegree = new int[V+1];
		for(int i=0;i<=V;i++){
			al[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			al[s].add(e);
			indegree[e]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=V;i++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()){
			int r = q.remove();
			sb.append(r);
			sb.append(" ");
			for(int i=0;i<al[r].size(); i++){
				if(--indegree[al[r].get(i)] == 0){
					q.add(al[r].get(i));
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}

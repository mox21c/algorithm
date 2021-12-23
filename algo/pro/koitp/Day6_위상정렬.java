package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day6_위상정렬 {
	static int V, E;
	static ArrayList<Integer>[] a;
	static int[] indegree;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		
		a = new ArrayList[V + 1];
		indegree = new int[V+1];
		for (int i = 1; i <= V; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			a[s].add(e);
			indegree[e]++;
		}
		br.close();
		
		for (int i = 1; i <= V; i++) {
			Collections.sort(a[i]);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= V; i++) {
			if(indegree[i] == 0){
				q.add(i);
			}
		}
		
		while(!q.isEmpty()){
			int t = q.remove();
			sb.append(t);
			sb.append(" ");
			for(int i=0;i<a[t].size();i++){
				if(--indegree[a[t].get(i)] == 0){
					q.add(a[t].get(i));
				}
			}
		}
		System.out.println(sb.toString());
	}
}

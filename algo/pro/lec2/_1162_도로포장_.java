package com.algo.pro.lec2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _1162_도로포장_ {
	static int N,M,K;
	static ArrayList<Edge>[] adj;
	static boolean[] visit;
	static int[] minDistance;
	static class edge implements Comparable<edge>{
		int p,cost;
		edge(int p, int cost){
			this.p = p;
			this.cost = cost;
		}
		public int compareTo(edge o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		adj = (ArrayList<Edge>[]) new ArrayList[N+1];
		visit = new boolean[N+1];
		minDistance = new int[N+1];
		
		for(int i=0;i<=N;i++){
			adj[i] = new ArrayList<Edge>();
		}
		
		for(int i=0;i<M;i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();
			adj[s].add(new Edge(e, c));
			adj[e].add(new Edge(s, c));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(1, 0));
		while(!pq.isEmpty()){
			
		}
		
	}
}

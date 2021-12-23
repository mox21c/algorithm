package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day7_최단경로 {
	static long[] dist;
    static int N, M;
    static ArrayList<pair>[] a;
    static StringTokenizer st;
    static StringBuilder sb;
    static class pair{
        int e; 
        long cost;
        pair(int e, long cost){
            this.e = e;
            this.cost = cost;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
 
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        
        a = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
        	a[i] = new ArrayList<pair>();
        }
         
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            a[e].add(new pair(s,cost));
            a[s].add(new pair(e,cost));
        }
        
        dist = new long[N+1];
        
        dijkstra(1);
        
        System.out.println(dist[N] < Long.MAX_VALUE ? dist[N] : -1);
        br.close();
    }
    
    public static void dijkstra(int src){
    	// 우선순위큐 정의, 가중치로 오름 차순 정렬.
    	PriorityQueue<pair> pq = new PriorityQueue<pair>(N+1, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return Long.compare(o1.cost, o2.cost);
			}
		});
    	// dist 배열 초기화 (무한대로)
    	Arrays.fill(dist, Long.MAX_VALUE);
    	
    	// 시작점 0으로 초기화.
    	dist[src] = 0;
    	
    	// 시작점 큐에 담아줌. 가중치는 0으로.
    	pq.add(new pair(src, 0));
    	
    	while(!pq.isEmpty()){
    		pair p = pq.remove();
    		int here = p.e;
    		long cost = p.cost;
    		// 가중치 누적값보다 원래 값이 작으면 그냥 넘어감.
    		if(dist[here] < cost){
    			continue;
    		}
    		// 연결 정점들을 돌면서 최소 비용 값으로 업데이트.
    		for(int i=0;i<a[here].size();i++){
    			int there = a[here].get(i).e;
    			long nextDist = cost + a[here].get(i).cost;
    			
    			if(dist[there] > nextDist){
    				dist[there] = nextDist;
    				pq.add(new pair(there, nextDist));
    			}
    		}
    	}
    }
}

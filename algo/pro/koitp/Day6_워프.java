package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day6_워프 {
	static long dist[];
    static int N, M;
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
        
        // 인접리스트 배열 초기화 
        ArrayList<pair>[] a = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            a[i] = new ArrayList<pair>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            long cost = Long.valueOf(st.nextToken());
            a[s].add(new pair(e, cost));
        }
        br.close();
        
        // distance배열 선언 및 초기화 (무한대값으로)
        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
         
        // 초기값은 0으로 세팅.
        dist[1] = 0;
        
        // 1~N-1까지 돌면서 해당 좌표에서 시작하는 점들에 대한 체크.
        for(int i=1;i<N;i++){
        	if(dist[i] < Long.MAX_VALUE){
        		for(int j=0;j<a[i].size();j++){
        			int nextPos = a[i].get(j).e;
        			long nextCost = dist[i] + a[i].get(j).cost;
        			// next pos의 가중치 비교후 작은 값으로 업데이트.
        			dist[nextPos] = Math.min(dist[nextPos], nextCost);
            	}
        	}
        }
        System.out.println(dist[N] < Long.MAX_VALUE ? dist[N] : -1 );
    }
}



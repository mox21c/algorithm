package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day5_최장증가부분수열LIS2 {
	static int NN;
	static int N;
	static int[] tree;
	static StringTokenizer st;
	static StringBuilder sb;
	static class pair{
		int idx, val;
		pair(int idx, int val){
			this.idx = idx;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.valueOf(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim()); 
        
        for(NN=1; NN<N; NN*=2);
        tree = new int[2 * NN];
        
        PriorityQueue<pair> pq = new PriorityQueue<pair>(N+1, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return o1.val - o2.val;
			}
		}); 
        for(int i=1; i<=N ;i++){
        	pq.add(new pair(i, Integer.valueOf(st.nextToken())));
        }
        
        int ans = 0;
        for(int i=1; i<=N ;i++){
        	pair p = pq.remove();
        	int maxmum = query(1, p.idx-1, 1, 1, NN);
        	
        	update(p.idx, maxmum+1);
        	ans = Math.max(ans, maxmum+1);
        	
		}
        
        System.out.println(ans);
        br.close();
	}
	
	public static int query(int ql, int qr, int idx, int l , int r){
		if(ql > r || qr < l){
			return 0;
		}
		if(l <= ql && qr <= r){
			return tree[idx];
		}
		int left = query(ql, qr, idx*2, l, (l+r)/2);
		int right = query(ql, qr, idx*2+1, (l+r)/2+1, r);
		return Math.max(left, right);
	}
	
	public static void update(int idx, int val){
		idx = NN+idx-1;
		tree[idx] = val;
		for(idx/=2; idx>0; idx/=2){
			tree[idx] = Math.max(tree[idx*2], tree[idx*2+1]);
		}
	}
}

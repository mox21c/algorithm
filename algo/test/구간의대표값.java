package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간의대표값 {
	static int NN;
	static int N, M;
	static StringTokenizer st;
	static long[] minTree, maxTree, sumTree, a;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.valueOf(br.readLine().trim());
        
        for(NN=1; NN<N; NN*=2){}
        System.out.println(NN);
        
        minTree = new long[NN*2];
        maxTree = new long[NN*2];
        sumTree = new long[NN*2];
        Arrays.fill(minTree, Long.MAX_VALUE);
        
        st = new StringTokenizer(br.readLine());
    	for(int i=1;i<=N; i++){
        	long val = Long.valueOf(st.nextToken());
        	minTree[NN+i-1] = val;
        	maxTree[NN+i-1] = val;
        	sumTree[NN+i-1] = val;
        }
    	
    	for(int i=NN-1; i>0 ;i--){
    		minTree[i] = Math.min(minTree[i*2], minTree[i*2+1]);
    		maxTree[i] = Math.max(minTree[i*2], minTree[i*2+1]);
    		sumTree[i] = minTree[i*2] + minTree[i*2+1];
    		
    	}
    	System.out.println(Arrays.toString(minTree));
    	
    	M = Integer.valueOf(br.readLine().trim());
    	
    	while(M-- > 0){
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.valueOf(st.nextToken());
    		int b = Integer.valueOf(st.nextToken());
        	
        	System.out.println(minQuery(a, b, 1, 1, NN));
    	}
        br.close();
	}
	public static long minQuery(int ql, int qr, int idx, int l, int r){
		if(ql > r || qr < l){
			return Long.MAX_VALUE;
		}
		if(ql <= l && r <= qr){
			return minTree[idx];
		}
		long left = minQuery(ql, qr, idx*2, l, (l+r)/2);
		long right = minQuery(ql, qr, idx*2+1, (l+r)/2+1, r);
		return Math.min(left, right);
		
		
		
	}
}

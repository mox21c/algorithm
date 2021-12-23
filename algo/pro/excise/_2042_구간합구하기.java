package com.algo.pro.excise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2042_구간합구하기 {
	static int NN, N, M, K, Q;
	static long[] tree;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] a = br.readLine().split(" ");
		N = Integer.valueOf(a[0]);
		M = Integer.valueOf(a[1]);
		K = Integer.valueOf(a[2]);
		Q = M + K;
		
		for(NN=1;NN<=N;NN*=2);
		
		tree = new long[2*NN];
		
		for(int i=1;i<=N;i++){
			tree[NN+i-1] = Long.valueOf(br.readLine());
		}
		
		for(int i=NN-1;i>0;i--){
			tree[i] = tree[i*2] + tree[i*2+1];
		}
		
		while(Q-- > 0){
			String[] ar = br.readLine().split(" ");
			int v1 = Integer.valueOf(ar[0]);
			int v2 = Integer.valueOf(ar[1]);
			int v3 = Integer.valueOf(ar[2]);
			
			if(v1 == 1){
				change(v2, v3);
			}
			else{
				System.out.println(query(v2, v3, 1, 1, NN));
			}
			
		}
		br.close();
	}
	public static void change(int idx, long val){
		idx = idx + NN - 1;
		tree[idx] = val;
		for(idx/=2; idx > 0; idx/=2){
			tree[idx] = tree[idx*2] + tree[idx*2+1];
		}
		
	}
	
	public static long query(int ql, int qr, int idx, int l, int r){
		if(ql > r || qr < l){
			return 0;
		}
		
		if(ql <= l && qr >= r){
			return tree[idx];
		}
		
		long left = query(ql, qr, idx*2 , l, (l+r)/2);
		long right = query(ql, qr, idx*2+1, (l+r)/2+1, r);
		
		return left+right;
	}
}

package com.algo.pro.excise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class __14438 {
	static int N;
	static int NN;
	static int[] tree;
	static StringTokenizer st;
	static int Q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine().trim());
		
		for(NN=1;NN<N;NN*=2);
		
		tree = new int[NN * 2];
		Arrays.fill(tree, 987654321);
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N ; i++){
			tree[NN + i - 1] = Integer.valueOf(st.nextToken());
		}
		
		for(int i=NN-1;i>0;i--){
			tree[i] = Math.min(tree[i*2], tree[i*2+1]);
		}
		
		Q = Integer.valueOf(br.readLine().trim());
		
		while(Q-- > 0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			if(a == 1){
				update(b, c);
			}else{
				System.out.println(select(b, c, 1, 1, NN));
			}
		}
		
		br.close();
	}
	
	static void update(int idx, int val){
		idx = NN + idx -1;
		tree[idx] = val;
		
		for(idx/=2; idx>0; idx/=2){
			tree[idx] = Math.min(tree[idx*2], tree[idx*2+1]);
		}
	}
	
	static int select(int ql, int qr, int idx, int l, int r){
		if(ql>r || l > qr){
			return 987654321;
		}
		if(l>=ql && qr >= r){
			return tree[idx];
		}
		int left = select(ql, qr, idx*2, l, (l+r)/2);
		int right = select(ql, qr, idx*2+1, (l+r)/2+1, r);
		return Math.min(left, right);
	}
}

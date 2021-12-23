package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day5_구간의대표값 {
	static int NN;
	static int N, M;
	static StringTokenizer st;
	static long[] minTree, maxTree, sumTree, a;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.valueOf(br.readLine().trim());
        
        for(NN=1; NN < N ; NN*=2);
        
        minTree = new long[NN * 2];
        maxTree = new long[NN * 2];
        sumTree = new long[NN * 2];
        
        // 최소값을 구하기 위해서는 큰수로 초기화..
        Arrays.fill(minTree, 987654321);
        
        st = new StringTokenizer(br.readLine().trim());
        
        for(int i=1;i<=N;i++){
        	int t = Integer.valueOf(st.nextToken());
        	minTree[NN + i - 1] = t;
        	maxTree[NN + i - 1] = t;
        	sumTree[NN + i - 1] = t;
        }
        
        for(int i=NN-1;i>0;i--){
        	minTree[i] = Math.min(minTree[i*2], minTree[i*2+1]);
        	maxTree[i] = Math.max(maxTree[i*2], maxTree[i*2+1]);
        	sumTree[i] = sumTree[i*2]+ sumTree[i*2+1];
        }
        M = Integer.valueOf(br.readLine().trim());
        
        while(M-- > 0){
        	st = new StringTokenizer(br.readLine().trim());
        	int x = Integer.valueOf(st.nextToken());
        	int y = Integer.valueOf(st.nextToken());
        	sb.append(queryMin(x, y, 1, 1, NN));
        	sb.append(" ");
        	sb.append(queryMax(x, y, 1, 1, NN));
        	sb.append(" ");
        	sb.append(querySum(x, y, 1, 1, NN));
        	sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
	}
	
	public static long queryMin(int ql, int qr, int idx, int l, int r){
		if(ql > r || qr < l){
			return 987654321;
		}
		if(ql <= l && r <= qr){
			return minTree[idx];
		}
		long left = queryMin(ql, qr, idx*2, l, (l+r)/2);
		long right = queryMin(ql, qr, idx*2+1, (l+r)/2+1, r);
		return Math.min(left, right);
	}
	
	public static long queryMax(int ql, int qr, int idx, int l, int r){
		if(ql > r || qr < l){
			return 0;
		}
		if(ql <= l && r <= qr){
			return maxTree[idx];
		}
		long left = queryMax(ql, qr, idx*2, l, (l+r)/2);
		long right = queryMax(ql, qr, idx*2+1, (l+r)/2+1, r);
		return Math.max(left, right);
	}
	
	public static long querySum(int ql, int qr, int idx, int l, int r){
		if(ql > r || qr < l){
			return 0;
		}
		if(ql <= l && r <= qr){
			return sumTree[idx];
		}
		long left = querySum(ql, qr, idx*2, l, (l+r)/2);
		long right = querySum(ql, qr, idx*2+1, (l+r)/2+1, r);
		return left + right;
	}
}

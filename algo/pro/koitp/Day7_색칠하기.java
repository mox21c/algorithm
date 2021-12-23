package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day7_색칠하기 {
	static int N;
	static int K;
	static StringTokenizer st;
	static final long MOD = 1000000003l;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		long d[] = new long[1000001];
		
		d[1] = K;
		d[2] = (long) K * (K-1)  % MOD;
		d[3] = (long) K * (K-1)* (K-2)  % MOD;
		for(int i=4; i<=N; i++){
			d[i] = (long)(d[i-1]*(K-2))%MOD + (long)(d[i-2]*(K-1))%MOD;
		}
		
		System.out.println((long) d[N] % MOD);
		br.close();
	}
}
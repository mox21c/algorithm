package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_MatrixChainMultiplication {
	static int N;
	static StringTokenizer st;
	static int[] a;
	static int[][] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());
		a = new int[505];
		d = new int[505][505];
		
		st = new StringTokenizer(br.readLine().trim());
		for(int i=1;i<=N+1;i++){
			a[i] = Integer.valueOf(st.nextToken());
		}
		
		for(int k=1;k<N;k++){
			for(int i=1;i+k <= N; i++){
				d[i][i+k] = 987654321;
				for(int j=i; j<i+k; j++){
					d[i][i+k] = Math.min(d[i][i+k], d[i][j] + d[j+1][i+k] + a[i]*a[j+1]*a[i+k+1]);
				}
			}
		}
		System.out.println(d[1][N]);
	}
}

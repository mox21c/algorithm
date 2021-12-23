package com.algo.pro.lec2;

import java.util.Scanner;

public class _11660_구간의합구하기5_DP {
	static int N,M;
	static int[][] o,d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		o = new int[N+1][N+1];
		d = new int[N+1][N+1];
		
		for(int i=1;i<=N; i++){
			for(int j=1;j<=N; j++){
				o[i][j] = sc.nextInt();
				d[i][j] = d[i-1][j] + d[i][j-1] + o[i][j] - d[i-1][j-1];
			}
		}
		
		for(int i=0;i<M; i++){
			int s1 = sc.nextInt();
			int e1 = sc.nextInt();
			int s2 = sc.nextInt();
			int e2 = sc.nextInt();
			
			System.out.println(d[s2][e2] - d[s2][e1-1] - d[s1-1][e2] + d[s1-1][e1-1]);
		}
	}
}

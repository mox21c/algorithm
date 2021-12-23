package com.algo.pro.lec2;

import java.util.Scanner;

public class _11659_구간의합구하기4_DP {
	static int N,M;
	static int[] o,d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		o = new int[N+1];
		d = new int[N+1];
		
		for(int i=1;i<=N; i++){
			o[i] = sc.nextInt();
			d[i] = o[i] + d[i-1];
		}
		
		for(int i=0;i<M; i++){
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			System.out.println(d[e] - d[s-1]);
		}
	}
}

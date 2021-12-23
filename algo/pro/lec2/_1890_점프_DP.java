package com.algo.pro.lec2;

import java.util.Scanner;

public class _1890_점프_DP {
	static long d[][] = new long[101][101];
	static int a[][] = new int[101][101];

	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				a[i][j] = sc.nextInt();
				
		d[0][0] = 1;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++){
				if(a[i][j] == 0) continue;
				if(i + a[i][j] < N) d[i + a[i][j]][j] += d[i][j];
				if(j + a[i][j] < N) d[i][j + a[i][j]] += d[i][j];
			}
						
		System.out.println(d[N - 1][N - 1]);
	}
}

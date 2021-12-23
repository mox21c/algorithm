package com.algo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 폐지줍기 {
	static StringTokenizer st;
	static int N;
	static int[][] dp, org;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		org = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int i=1; i<=N ;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N ;j++){
				org[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		for(int i=1; i<=N ;i++){
			for(int j=1;j<=N ;j++){
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + org[i][j];
			}
		}
		System.out.println(dp[N][N]);
		br.close();
	}
}
package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_AssemblyLineScheduling {
	static int N, e1, e2, x1, x2;
	static int[][] line;
	static int[][] move;
	static int[][] d;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.valueOf(st.nextToken());
		e1 = Integer.valueOf(st.nextToken());
		e2 = Integer.valueOf(st.nextToken());
		x1 = Integer.valueOf(st.nextToken());
		x2 = Integer.valueOf(st.nextToken());
		
		line = new int[3][N+1];
		
		st = new StringTokenizer(br.readLine().trim());
		for(int i=1;i<=N;i++){
			line[1][i] = Integer.valueOf(st.nextToken());;
		}
		st = new StringTokenizer(br.readLine().trim());
		for(int i=1;i<=N;i++){
			line[2][i] = Integer.valueOf(st.nextToken());;
		}
		
		move = new int[3][N+1];
		
		st = new StringTokenizer(br.readLine().trim());
		for(int i=2;i<=N;i++){
			move[1][i] = Integer.valueOf(st.nextToken());;
		}
		st = new StringTokenizer(br.readLine().trim());
		for(int i=2;i<=N;i++){
			move[2][i] = Integer.valueOf(st.nextToken());;
		}
		
		d = new int[3][N+1];
		
		d[1][1] = e1 + line[1][1];
		d[2][1] = e2 + line[2][1];
		for(int c=2;c<=N;c++){
			for(int r=1; r<3;r++){
				int case1 = 0;
				int case2 = 0;
				if(r==1){
					 case1 = d[1][c-1] + line[1][c];
					 case2 = d[2][c-1] + move[2][c] + line[1][c];
				}else{
					 case1 = d[2][c-1] + line[2][c];
					 case2 = d[1][c-1] + move[1][c] + line[2][c];
				}
				d[r][c] = Math.min(case1, case2);
			}
		}
		System.out.println(Math.min(d[1][N]+x1, d[2][N]+x2));
		
		br.close();
	}
}

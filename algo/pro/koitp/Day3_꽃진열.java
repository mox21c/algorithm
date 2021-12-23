package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * d(i,j) = 1~i까지의 꽃, 1~j까지의 꽃병.
 * 1. i꽃이 j꽃병에 꽂히는 경우 = d(i-1,j-1) + a(i,j) 
 * 2. i꽃이 j꽃병에 꽂히지 않는 경우 = d(i,j-1)
 * 1,2경우의 최대값을 넣어줌.
 * ==> 정답 = d(F,V)
 */
public class Day3_꽃진열 {
	static int F, V; // F:꽃수, V:화분수 
	static StringTokenizer st;
	static int[][] a, d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		F = Integer.valueOf(st.nextToken());
		V = Integer.valueOf(st.nextToken());
		a = new int[F+1][V+1];
		d = new int[F+1][V+1];
		for(int i=1;i<=F;i++){
			st = new StringTokenizer(br.readLine().trim());
			for(int j=1;j<=V;j++){
				a[i][j] =  Integer.valueOf(st.nextToken());
			}
		}
		d[0][0] = 0;
		for(int f=1;f<=F;f++){
			// 초기화... 
			d[f][f] = d[f-1][f-1] + a[f][f];
			for(int v=f+1;v<=V;v++){
				d[f][v] = Math.max(d[f-1][v-1] + a[f][v], d[f][v-1]);
			}
		}
		System.out.println(d[F][V]);
	}
}

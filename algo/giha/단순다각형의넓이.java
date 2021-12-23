package com.algo.giha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단순다각형의넓이 {
	static StringTokenizer st;
	static int N;
	static int[] X,Y;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		X = new int[N+1];
		Y = new int[N+1];
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.valueOf(st.nextToken());
			Y[i] = Integer.valueOf(st.nextToken());
		}
		X[N] = X[0];
		Y[N] = Y[0];
		
		long sum = 0l;
		for(int i=0;i<N; i++){
			sum += (long) X[i]*Y[i+1] - (long) Y[i]*X[i+1];
		}
		
		sb.append(Math.abs(sum/2));
		sb.append(sum%2==0 ? ".0" : ".5");
		
		System.out.println(sb.toString());
		
		br.close();
	}
}

package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 머지소트, 삽입정렬, ..
public class Day8_세금 {
	static int N,K;
	static int M, X, Y;
	static int[] A;
	static long[] S, B, ANS, D, E;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		A = new int[N+1];
		S = new long[N+1];
		B = new long[99];
		ANS = new long[99];
		D = new long[99];
		E = new long[99];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			A[i] = Integer.valueOf(st.nextToken());
			S[i] = S[i-1] + A[i];
		}
		
		// B : S[0] ~ S[i-1] 중 하위 k개, M : B 배열의 크기
		M=1;
		B[M] = 0;
		
		for(int i=1; i<=N; i++){
			// D : A[i]로 끝나는 부분수열합 중 상위 k개
			for(int j=1;j<=M;j++){
				D[j] = S[i] - B[j];
			}
			// E : ANS배열의 값을 담아놓는 임시 배열
			for(int j=1;j<=X;j++){
				E[j] = ANS[j];
			}
			Y = X;
			X = 0;
			// D 배열과 M 배열을 Merge하여 ANS배열에 넣는 과정.
			for(int j=1,k=1; (j<=M||k<=Y) && X<K ;){
				if(k>Y || j<=M && D[j] >= E[k]){
					ANS[++X] = D[j++];
				}else{
					ANS[++X] = E[k++];
				}
			}
			B[M+1] = Integer.MAX_VALUE;
			// S[i]를 B배열에 넣는 과정
			for(int j=1;j<M+1;j++){
				// S[i]가 들어갈 위치를 찾음
				if(B[j] >= S[i]){
					// S[i]가 들어갈 위치까지를 뒤에서부터 한칸씩 민다.
					for(int k=M;k>=j;k--){
						B[k+1] = B[k];
					}
					B[j] = S[i];
					break;
				}
			}
			if (M < K) {
				M++;
			}
		}
		System.out.println(ANS[K]);
		
		br.close();
	}
}

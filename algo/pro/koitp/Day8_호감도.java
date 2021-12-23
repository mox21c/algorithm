package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day8_호감도 {
	static int T, N;
	static int[] X,Y;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.valueOf(br.readLine());
		while(T-- > 0){
			N = Integer.valueOf(br.readLine());
			X = new int[N+1];
			Y = new int[N+1];
			for(int i=1;i<=N;i++){
				st = new StringTokenizer(br.readLine());
				X[i] = Integer.valueOf(st.nextToken())+1;
				Y[i] = Integer.valueOf(st.nextToken())+1;
			}
			
			int expectCnt = Math.round(N/5)+1;
			
			boolean isCheck = false;
			
			for(int i=1;i<N;i++){
				for(int j=i+1;j<=N;j++){
					int sameCnt = 2;
					isCheck = false;
					double posGiulgi = giulgi(i,j);
					for(int k=1;k<=N;k++){
						if(k==i || k==j){
							continue;
						}
						if(posGiulgi == giulgi(i, k)){
							sameCnt++;
						}
					}
					System.out.println(sameCnt +" "+ expectCnt);
					if(sameCnt >= expectCnt){
						isCheck = true;
						break;
					}
				}
				if(isCheck){
					break;
				}
			}
			
			System.out.println(isCheck ? "YES" : "NO");
		}
		br.close();
		
	}
	public static double giulgi(int pos1, int pos2){
		if((X[pos2] - X[pos1]) == 0){
			return Double.MAX_VALUE;
		}
		return  (Y[pos2] - Y[pos1]) / (X[pos2] - X[pos1]);
	}
	
}

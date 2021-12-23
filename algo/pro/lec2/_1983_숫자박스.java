package com.algo.pro.lec2;

import java.util.Arrays;
import java.util.Scanner;

public class _1983_숫자박스 {
	static int N;
	static int[] a,b;
	static int aNumberCnt, bNumberCnt;
	static int[][][] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		a = new int[N+1];
		b = new int[N+1];
		d = new int[N+1][N+1][N+1];
		
		for(int c=0;c<2;c++){
			for(int i=1;i<=N;i++){
				int n = sc.nextInt();
				if(c==0){
					if(n != 0) a[++aNumberCnt] = n;
				}
				else{
					if(n != 0) b[++bNumberCnt] = n;
				}
			}
		}
		for(int i = 0; i <= N; i++){
			for(int j = 0; j <= aNumberCnt; j++){
				Arrays.fill(d[i][j], -987654321);
			}
		}
		
		d[0][0][0] = 0;
		for(int i = 1; i <= N; i++){
			for(int ai = 0; ai <= aNumberCnt; ai++){
				for(int bi = 0; bi <= aNumberCnt; bi++){
					d[i][ai][bi] = d[i - 1][ai][bi];
					if(ai > 0){
						d[i][ai][bi] = Math.max(d[i][ai][bi], d[i - 1][ai - 1][bi]);
					}
					if(bi > 0){
						d[i][ai][bi] = Math.max(d[i][ai][bi], d[i - 1][ai][bi - 1]);
					}
					if(ai > 0 && bi > 0){
						d[i][ai][bi] = Math.max(d[i][ai][bi], d[i - 1][ai - 1][bi - 1] + a[ai] * b[bi]);
					}
				}
			}
		}

		System.out.println(d[N][aNumberCnt][bNumberCnt]);
		
	}
}

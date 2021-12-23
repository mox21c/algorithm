package com.algo.pro.excise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 종이컵 {
	static int T, N, M;
	static int[][] a,d;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.valueOf(br.readLine());
		
		for(int t=1;t<=T;t++){
			
			st = new StringTokenizer(br.readLine().trim());
			
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			
			a = new int[N+1][N+1];
			d = new int[N+1][N+1];
			
			for(int i=0;i<M;i++){
				st = new StringTokenizer(br.readLine().trim());
				int v1 = Integer.valueOf(st.nextToken());
				int v2 = Integer.valueOf(st.nextToken());
				a[v1][v2] = 1;
				a[v2][v1] = 1; 
			}
			int tmpI, tmpJ;
			for(int i=1;i<=N;i++){
				for(int j=2;j<=N;j++){
					tmpI = j - 1;
					tmpJ = i + j -1;
					if(tmpJ > N){
						break;
					}
					if(a[tmpI][tmpJ] == 1){
						d[tmpI][tmpJ] = d[tmpI+1][tmpJ-1] + 1;
					}
					for(int k=tmpI; k<tmpJ ; k++){
						d[tmpI][tmpJ] = Math.max(d[tmpI][tmpJ] , d[tmpI][k] + d[k+1][tmpJ]);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(String.valueOf(t));
            sb.append(" ");
            sb.append(String.valueOf(d[1][N]));
            System.out.println(sb.toString());
		}
		
		br.close();
	}
}

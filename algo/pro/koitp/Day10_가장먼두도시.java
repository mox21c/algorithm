package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드 워샬 알고리즘 
// 모든 쌍들에 대해서 최단 거리를 구해줌. 시간복잡도 ( |V|^3 )
public class Day10_가장먼두도시 {
	static int N;
	static int ans;
	static int[][] dist;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());
		dist = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++){
				dist[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		br.close();
		
		// 한 점을 경유하여.
		for(int k=1;k<=N;k++){
			// x에서.
			for(int i=1;i<=N;i++){
				// y로 갈때.
				for(int j=1;j<=N;j++){
					// 최단거리면 업데이트 해줌.
					if(dist[i][j] > dist[i][k] + dist[k][j]){
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		// 결국 dist배열에 각 정점사이의 최단 거리가 들어감.
		// x축 : to, y축 : from
		ans = 0;
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				ans = Math.max(ans,dist[i][j]);
			}
		}

		System.out.println(ans);
	}
}

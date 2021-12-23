package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP의 두가지 채우는 방법
// 1. 앞에 완성된 수를 가져와 채우는 방식.
// 2. 뒤에 영향 있는 애들을 채워주는 방식.

// 바이토닉 투어는 두명의 애를 보내서 최소거리를 구한다고 생각하면된다.
// - 1번 아이가 i점으로 출발.
// - 2번 아이가 j점으로 출발.
public class Day8_BitonicTour {
	static int N;
	static double[][] d;
	static int[] X,Y;
	static double ans;
	static StringTokenizer st;

	static class pair {
		int x, y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 좌표 점의 갯수.
		N = Integer.valueOf(br.readLine());
		d = new double[N + 1][N + 1];
		X = new int[N+1];
		Y = new int[N+1];
		ans = Double.MAX_VALUE;
		
		// 좌표값 넣어줌.
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.valueOf(st.nextToken());
			Y[i] = Integer.valueOf(st.nextToken());
		}
		br.close();
		
		// DP 구현을 위해 d배열 초기화.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				d[i][j] = Double.MAX_VALUE;
			}
		}

		// DP 구현을 위해 1번 좌표와 2번 좌표의 거리를 초기 값을 세팅 해줌.
		d[1][2] = dist(1, 2);
		
		// 모든 점들을 돌면서 두 점사이의 거리를 해서, 뒤에 영향있는 부분들을 채워줌.
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				// i,j 두점 다음의 점을 k로 해줌.
				int k = j + 1;
				// i에서 출발해서 k점을 밟을수도 있고, j점에서 출발해서 k점을 밟을 수도 있다.
				// 두 아이가 같이 k점을 밟았을때를 가정하고 최소값을 채워줌.
				d[i][k] = Math.min(d[i][k], d[i][j] + dist(j, k));
				d[j][k] = Math.min(d[j][k], d[i][j] + dist(i, k));
			}
		}
		for (int i = 1; i < N; i++) {
			ans = Math.min(ans, d[i][N] + dist(i, N));
		}
		System.out.printf("%.2f",(double) Math.round(ans * 100)/100);
	}

	// 두점 사이의 거리를 구해줌.
	public static double dist(int pos1, int pos2) {
		int xGap = X[pos1] - X[pos2];
		int yGap = Y[pos1] - Y[pos2];
		return Math.hypot(xGap, yGap);
	}
}

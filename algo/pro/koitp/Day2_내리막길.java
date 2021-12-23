package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_내리막길 {
	static int N, M;
	static int[][] visit;
	static int[][] a, d;
	static StringTokenizer st;
	static int[] rt = new int[] { 1, 0, -1, 0 };
	static int[] ct = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		a = new int[N + 2][M + 2];
		d = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= M; j++) {
				a[i][j] = Integer.valueOf(st.nextToken());
				d[i][j] = -1;
			}
		}
		d[1][1] = 1;
		System.out.println(find(N, M));
		br.close();
	}

	static int find(int x, int y) {
		if (d[x][y] != -1) {
			return d[x][y];
		}

		// visit을 하던가, 초기화를 꼭 해줘야 한다. -1로 초기화되어 있으므로..
		d[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			int X = x + rt[i];
			int Y = y + ct[i];
			if (a[X][Y] <= a[x][y]) {
				continue;
			}
			d[x][y] += find(X, Y);
		}
		d[x][y] %= 1234567;
		return d[x][y];

	}
}

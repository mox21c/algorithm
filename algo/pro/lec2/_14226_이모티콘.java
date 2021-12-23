package com.algo.pro.lec2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _14226_이모티콘 {

	static int mind[][] = new int[1001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int S = sc.nextInt();
		Queue<Info> q = new LinkedList<Info>();
		q.add(new Info(1, 0));
		mind[1][0] = 1;
		int ans = -1;
		while (!q.isEmpty()) {
			int w = q.peek().window, c = q.peek().clip;
			q.poll();
			if (w == S) {
				ans = mind[w][c] - 1;
				break;
			}

			Info next[] = { new Info(w, w), new Info(w + c, c),
					new Info(w - 1, c) };
			for (int i = 0; i < 3; i++) {
				if (next[i].window > 1000 || next[i].window < 0)
					continue;
				if (mind[next[i].window][next[i].clip] == 0) {
					mind[next[i].window][next[i].clip] = mind[w][c] + 1;
					q.add(next[i]);
				}
			}
		}

		System.out.println(ans);
	}
}

class Info {
	int window, clip;

	public Info(int w, int c) {
		window = w;
		clip = c;
	}
}

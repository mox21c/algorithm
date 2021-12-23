package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// sliding window 
public class Day4_철로_SlidingWindow {
	static int N, L;
	static ArrayList<trail> a;
	static int[] chk;
	static StringTokenizer st;
	static int answer, count;

	static class trail {
		int pos, trailIdx;

		public trail(int pos, int trailIdx) {
			this.pos = pos;
			this.trailIdx = trailIdx;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());
		a = new ArrayList<trail>();
		chk = new int[N+1];
		answer = 0;
		count = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int j1 = Integer.valueOf(st.nextToken());
			int j2 = Integer.valueOf(st.nextToken());
			a.add(new trail(j1, i));
			a.add(new trail(j2, i));
		}
		L = Integer.valueOf(br.readLine().trim());

		// pos 로 오름차순 정렬.
		Collections.sort(a, new Comparator<trail>() {
			public int compare(trail o1, trail o2) {
				return o1.pos - o2.pos;
			}
		});

		for(int i=0, j=0; i<2*N; i++){
			if(i==0 || a.get(i-1).pos != a.get(i).pos){
				for(;j<2*N && a.get(j).pos - a.get(i).pos <= L ; j++){
					if(++chk[a.get(j).trailIdx] == 2){
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
			if(--chk[a.get(i).trailIdx] == 1){
				count--;
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}

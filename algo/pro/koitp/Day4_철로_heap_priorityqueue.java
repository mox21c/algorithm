package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// heap, prioryqueue 사용.
public class Day4_철로_heap_priorityqueue {
	static int N,L;
	static ArrayList<trail> a;
	static StringTokenizer st;
	static PriorityQueue<Integer> pq;
	static int answer, count;
	static class trail{
		int start, end;
		public trail(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());
		a = new ArrayList<trail>();
		answer = 0;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine().trim());
			int j1 = Integer.valueOf(st.nextToken());
			int j2 = Integer.valueOf(st.nextToken());
			a.add(new trail(Math.min(j1,j2), Math.max(j1,j2)));
		}
		L = Integer.valueOf(br.readLine().trim());
		
		// end 로 오름차순 정렬.
		Collections.sort(a, new Comparator<trail>() {
			public int compare(trail o1, trail o2) {
				return o1.end - o2.end;
			}
		});
		
		// 오름차순 정렬 우선순위큐 이용.
		pq = new PriorityQueue<Integer>(N*2, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		for(int i=0;i<N; i++){
			pq.add(a.get(i).start);
			while(!pq.isEmpty() && pq.peek() < a.get(i).end - L){
				pq.remove();
			}
			answer = Math.max(answer, pq.size());
		}
		System.out.println(answer);
		br.close();
	}
}

/*
입력 예제 1

8
5 40
35 25
10 20
10 25
30 50
50 60
30 25
80 100
30
출력 예제 1

4
입력 예제 2

4
20 80
70 30
35 65
40 60
10
출력 예제 2

0
입력 예제 3

5
-5 5
30 40
-5 5
50 40
5 -5
10
출력 예제 3

3
*/
package com.algo.pro.lec2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _2751_수정렬하기2_priorityqueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++){
			int x = sc.nextInt();
			pq.offer(x);
		}
		
		for(int i=0; i<N;i++){
			System.out.println(pq.peek());
			pq.poll();
		}
	}
}

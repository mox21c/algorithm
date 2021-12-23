package com.algo.pro.lec2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _11286_절대값힙_heap {
	static class Node implements Comparable<Node>{
		int x,absx;
		Node(int x){
			this.x = x;
			this.absx = x<0 ? -x : x;
		}
		
		@Override
		public int compareTo(Node o) {
			if(absx == ((Node)o).absx)
	            return this.x - ((Node)o).x;
	        return this.absx - ((Node)o).absx;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		while(N-- > 0){
			
			int x = sc.nextInt();
			if(x == 0){
				if(pq.isEmpty()){
					System.out.println(0);
				}else{
					System.out.println(pq.peek().x);
					pq.poll();
				}
			}
			else{
				pq.offer(new Node(x));
			}
		}
	}
}

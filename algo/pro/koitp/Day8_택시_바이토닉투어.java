package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day8_택시_바이토닉투어 {
	static int N, W;
	static StringTokenizer st;
	static class pair {
		int x, y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<pair> v;
	static int[][] visit, D;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		W = Integer.valueOf(br.readLine());
		
		v = new ArrayList<pair>();
		visit = new int[N+1][N+1];
		D = new int[N+1][N+1];
		
		
		v.add(new pair(1, 1));
		v.add(new pair(N, N));
		
		for(int i=2; i<=W; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			v.add(new pair(x, y));
		}
		int a=0, b=1;
		
		System.out.println(dy(a,b));
		
		for(int i=2;i<=W;i++){
			if(dis(v.get(a), v.get(i)) + dy(i,b) == dy(a,b)){
				System.out.println("1");
				a = i;
			}else{
				System.out.println("2");
				b = i;
			}
		}
		br.close();
	}
	
	public static int dis(pair a, pair b){
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}
	
	public static int dy(int a, int b){
		int n = Math.max(a, b) + 1;
		if(n>W || a==b){
			return 0;
		}
		if(visit[a][b] > 0){
			return D[a][b];
		}
		visit[a][b] = 1;
		return D[a][b] = Math.min(dis(v.get(a), v.get(n))+dy(n,b) , dis(v.get(b), v.get(n)) + dy(a, n));
	}
}

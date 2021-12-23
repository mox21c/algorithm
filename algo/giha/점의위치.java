package com.algo.giha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 점의위치 {
	static StringTokenizer st;
	static int N;
	static ArrayList<point> al;

	static class point {
		long x, y;

		public point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		al = new ArrayList<point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Integer.valueOf(st.nextToken());
			long y = Integer.valueOf(st.nextToken());
			al.add(new point(x, y));
		}
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Integer.valueOf(st.nextToken());
			long y = Integer.valueOf(st.nextToken());
			
			if(getCrossCnt(new point(x, y))%2==0){
				System.out.println("out");
			}else{
				System.out.println("in");
			}
		}

		br.close();
	}
	
	public static int getCrossCnt(point p){
		long nx = Integer.MAX_VALUE+1;
		long ny = p.y-1;
		
		int chkCnt = 0;
		for(int i=0; i<al.size(); i++){
			if(crossCheck(al.get(i), al.get((i+1)%N), p, new point(nx, ny))){
				chkCnt++;
			}
		}
		return chkCnt;
		
	}
	
	public static int ccw(point a, point b, point c){
		long tmp = a.x*b.y + b.x*c.y + c.x*a.y - b.x*a.y - c.x*b.y - a.x*c.y;
		if(tmp > 0){
			return 1;
		}
		if(tmp < 0){
			return -1;
		}
		return 0;
	}
	
	public static boolean crossCheck(point a, point b, point c, point d){
		return ccw(a, b, c) * ccw(a, b, d) < 0 && ccw(c, d, a) * ccw(c, d, b) < 0;
	}

}

/*
4
1 1
1 3
3 3
3 1
0 0
2 2

out
in
 */

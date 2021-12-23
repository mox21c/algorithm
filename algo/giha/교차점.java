package com.algo.giha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 교차점 {
	static StringTokenizer st;

	static class point {
		long x, y;

		point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		public long s(){
			return this.x + this.y;
		}
	}

	static int N;
	static ArrayList<point> al;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());

		for (int i = 0; i < N; i++) {
			al = new ArrayList<point>();

			st = new StringTokenizer(br.readLine());
			long x1 = Long.valueOf(st.nextToken());
			long y1 = Long.valueOf(st.nextToken());
			long x2 = Long.valueOf(st.nextToken());
			long y2 = Long.valueOf(st.nextToken());
			al.add(new point(x1, y1));
			al.add(new point(x1, y2));
			al.add(new point(x2, y2));
			al.add(new point(x2, y1));

			st = new StringTokenizer(br.readLine());
			x1 = Long.valueOf(st.nextToken());
			y1 = Long.valueOf(st.nextToken());
			x2 = Long.valueOf(st.nextToken());
			y2 = Long.valueOf(st.nextToken());
			point p1 = new point(x1, y1);
			point p2 = new point(x2, y2);

			int crossCnt = 0;
			int j = 0;
			for (j = 0; j < 4; j++) {
				int val = crossChk(p1, p2, al.get(j), al.get((j + 1) % 3));
				if (val == -1) {
					break;
				}
				crossCnt += val;
				val = crossChk(p1, p2, al.get(j), al.get(j));
				if(val<0){
					crossCnt--;
				}
			}
			System.out.println(j < 4 ? 4 : crossCnt);
		}
	}

	public static int ccw(point a, point b, point c) {
		long tmp = a.x * b.y + b.x * c.y + c.x * a.y - b.x * a.y - c.x * b.y - a.x * c.y;
		if (tmp > 0) {
			return 1;
		}
		if (tmp < 0) {
			return -1;
		}
		return 0;
	}

	public static int crossChk(point pa, point pb, point qa, point qb) {
		int tmp1 = ccw(pa, pb, qa);
		int tmp2 = ccw(pa, pb, qb);
		int tmp3 = ccw(qa, qb, pa);
		int tmp4 = ccw(qa, qb, pb);
		
		if(tmp1 <0 && tmp2<0){
			if(pb.s() < qa.s() || qb.s() < pa.s()){
				return 0;
			}
			if(pb.s() == qa.s() || pa.s() == qb.s()){
				return 1;
			}
			return -1;
		}
		if(tmp1 == tmp2 || tmp3 == tmp4){
			return 0;
		}
		return 1;
	}
}

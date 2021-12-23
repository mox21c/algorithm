package com.algo.giha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// 아직 미완성.
public class 동물사냥 {
	static int N;
	static StringTokenizer st;

	static class point {
		int x, y, idx;
		double angle;
		long dist;

		point(int idx, int x, int y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
		}

		point(int idx, int x, int y, double angle, long dist) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.angle = angle;
			this.dist = dist;
		}
	}

	static ArrayList<point> orglist;
	static point defaultPos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		orglist = new ArrayList<point>();

		defaultPos = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.valueOf(st.nextToken()) * 100d;
			double y = Double.valueOf(st.nextToken()) * 100d;
			orglist.add(new point(i+1,(int)x, (int)y));
			if (defaultPos == null) {
				defaultPos = orglist.get(i);
			} else {
				if (defaultPos.y > y || (defaultPos.y == y && defaultPos.x > x)) {
					defaultPos = orglist.get(i);
				}
			}
		}

		ArrayList<point> ch = convexhull(orglist);
		Collections.sort(ch, new Comparator<point>() {
			public int compare(point o1, point o2) {
				return Integer.compare(o1.x, o2.x);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(ch.get(0).idx + "\n");
		for(int i=1; i<ch.size()-1; i++){
			if(Math.max(ch.get(0).y, ch.get(ch.size()-1).y) > ch.get(i).y){
				continue;
			}
			sb.append(ch.get(i).idx + "\n");
		}
		sb.append(ch.get(ch.size()-1).idx + "\n");
		System.out.println(sb.toString());

		br.close();
	}

	public static ArrayList<point> convexhull(ArrayList<point> al) {

		ArrayList<point> ch = new ArrayList<point>();
		for (point p : al) {
			int dx = p.x - defaultPos.x;
			int dy = p.y - defaultPos.y;
			p.angle = Math.toDegrees(Math.atan2(dy, dx));
			p.dist = dist(defaultPos, p);
		}

		Collections.sort(al, new Comparator<point>() {
			public int compare(point o1, point o2) {
				if (Double.compare(o1.angle, o2.angle) == 0) {
					return Long.compare(o1.dist, o2.dist);
				}
				return Double.compare(o1.angle, o2.angle);
			}
		});
		al.add(defaultPos);

		int stackIdx = 0;
		int[] stack = new int[N + 1];
		stack[++stackIdx] = 0;
		stack[++stackIdx] = 1;

		for (int i = 2; i <= N; i++) {
			while (stackIdx >= 2) {
				point p1 = al.get(stack[stackIdx - 1]);
				point p2 = al.get(stack[stackIdx]);
				point pc = al.get(i);
				int k = ccw(p1, p2, pc);
				//long d1 = dist(p1, p2);
				//long d2 = dist(p1, pc);

				if (k < 0) {
					stackIdx--;
				} else {
					break;
				}
			}
			if (stackIdx == 1 || ccw(al.get(stack[stackIdx - 1]), al.get(stack[stackIdx]), al.get(i)) > 0) {
				stack[++stackIdx] = i;
			}
		}

		for (int i = 1; i < stackIdx; i++) {
			ch.add(al.get(stack[i]));
		}
		return ch;
	}

	public static int ccw(point X, point Y, point Z) {
		long ret = (long) X.x * Y.y + (long) Y.x * Z.y + (long) Z.x * X.y - (long) Y.x * X.y - (long) Z.x * Y.y - (long) X.x * Z.y;
		if (ret < 0) {
			return -1;
		}
		if (ret > 0) {
			return 1;
		}
		return 0;
	}

	public static long dist(point X, point Y) {
		return (long) (X.x - Y.x) * (X.x - Y.x) + (long) (X.y - Y.y)* (X.y - Y.y);
	}
}

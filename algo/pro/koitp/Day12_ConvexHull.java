package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Day12_ConvexHull {
	static StringTokenizer stz;
	static int N;
	static int stackIdx;
	static int[] stack;
	static ArrayList<coo> al;

	static coo defalutPoint; // 기본 극단점

	static class coo {
		int x, y;
		double angle;
		long dist;

		// x좌표, y좌표, x-y좌표 각도, x-y좌표 거리
		public coo(int x, int y, double angle, long dist) {
			this.x = x;
			this.y = y;
			this.angle = angle;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());
		al = new ArrayList<coo>();

		stack = new int[100005];
		stackIdx = 0;

		// 처음 기준 극단점은 null 로 초기화
		defalutPoint = null;

		// 입력 좌표값 arraylist에 넣기
		for (int i = 0; i < N; i++) {
			stz = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(stz.nextToken());
			int y = Integer.valueOf(stz.nextToken());
			al.add(new coo(x, y, 0d, 0l));

			// 기준 극단점 구하기
			// 처음에 극단점을 구할 때, 같은 y좌표를 갖는 점이 여러개인 경우 해당 점 중, 가장 x좌표가 작은 점 극단점
			// 왜냐하면 중간에 있는 점들은 극단점에 해당하지 않기 때문이다.
			if (defalutPoint == null) {
				defalutPoint = al.get(i);
			} else {
				if (y < defalutPoint.y) {
					defalutPoint = al.get(i);
				} else if (y == defalutPoint.y) {
					if (x < defalutPoint.x) {
						defalutPoint = al.get(i);
					}
				}
			}
		}

		// 기준 극단점으로 부터 각도와 거리를 구해서 넣어줌.
		for (int i = 0; i < al.size(); i++) {
			coo p = al.get(i);
			double dx = p.x - defalutPoint.x;
			double dy = p.y - defalutPoint.y;
			al.get(i).angle = Math.toDegrees(Math.atan2(dy, dx));
			al.get(i).dist = dist(defalutPoint, p);
		}

		// 극단점으로 부터 각도로 오름차순 정렬
		// 만약에 각도가 같으면, 거리가 가까운 거 우선으로 정렬
		Collections.sort(al, new Comparator<coo>() {
			public int compare(coo o1, coo o2) {
				if (Double.compare(o1.angle, o2.angle) == 0) {
					return Long.compare(o1.dist, o2.dist);
				}
				return Double.compare(o1.angle, o2.angle);
			}
		});

		// 기준 극단점을 arraylist 맨 끝에 넣어줌.
		al.add(defalutPoint);

		// stack 에서 두점을 먼저 세팅
		stack[++stackIdx] = 0;
		stack[++stackIdx] = 1;

		// stack 에 다음 점부터 하나씩 넣어보면서 계산..
		for (int i = 2; i <= N; i++) {
			while (stackIdx >= 2) {

				coo comparePos1 = al.get(stack[stackIdx - 1]);
				coo comparePos2 = al.get(stack[stackIdx]);
				coo curruntPos = al.get(i);

				int k = ccw(comparePos1, comparePos2, curruntPos);
				long d1 = dist(comparePos1, comparePos2);
				long d2 = dist(comparePos1, curruntPos);

				// 아래 조건일 경우 stack 에서 pop을 해줌.
				// 1. comparePos1 와 comparePos2를 이은 선분 기준으로 curruntPos가 오른쪽에 있을
				// 경우.
				// 2. 세점이 같은 직선 상에 있을 경우는 거리가 작은 경우.
				if (k < 0 || (k == 0 && d1 < d2)) {
					stackIdx--;
				} else {
					break;
				}
			}

			if (stackIdx == 1
					|| ccw(al.get(stack[stackIdx - 1]),
							al.get(stack[stackIdx]), al.get(i)) > 0) {
				stack[++stackIdx] = i;
			}
		}

		System.out.println(stackIdx - 1);

		br.close();
	}

	public static int ccw(coo X, coo Y, coo Z) {
		long k = (long) X.x * Y.y + (long) Y.x * Z.y + (long) Z.x * X.y - (long) X.x * Z.y - (long) Y.x * X.y - (long) Z.x * Y.y;

		if (k > 0) {
			return 1;
		}
		if (k < 0) {
			return -1;
		}
		return 0;
	}

	public static long dist(coo X, coo Y) {
		return (long) (X.x - Y.x) * (X.x - Y.x) + (long) (X.y - Y.y) * (X.y - Y.y);
	}
}

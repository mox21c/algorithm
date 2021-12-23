package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파라메트릭 서치.
public class Day11_리본 {
	static int N,K;
	static long[] a;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		a = new long[N];
		long l = 1;
		long r = 0;
		long mid = 0;
		for(int i=0;i<N;i++){
			a[i] = Long.valueOf(br.readLine().trim());
			if(a[i] > r){
				r = a[i];
			}
		}
		
		while(l<r){
			// +1을 해준 이유는 경계선에서 무한루프가 돔.
			mid = (r+l+1)/2;
			if(check(mid)){
				// 정답을 포함하고 이동해야 하기 때문에.
				l = mid;
			}else{
				r = mid - 1;
			}
		}
		
		System.out.println(l);
		br.close();
	}
	public static boolean check(long divide){
		int cnt = 0;
		for(int i=0;i<a.length; i++){
			cnt += a[i]/divide;
		}
		return cnt >= K;
	}
}

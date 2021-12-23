package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분할정복.
// a^m = a * a^m/2 * 1 (짝수 일때)
// a^m = a * a^m/2 * a (홀수 일때)
public class Day10_거듭제곱구하기 {
	static StringTokenizer st;
	static final long MOD = 1000000007;
	static long a;
	static long m;
	static long answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		a = Long.valueOf(st.nextToken());
		m = Long.valueOf(st.nextToken());
		answer = 1l;
		while(m>0){
			if(m % 2 == 1){
				answer = answer * a % MOD;
			}
			a = a * a % MOD;
			m /=2 ;
		}
		System.out.println(answer);
		br.close();
	}
}

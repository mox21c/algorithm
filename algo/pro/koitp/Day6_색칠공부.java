package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 색칠하기 문제 같은 방식으로 구한 경우의 수 + K-1의 곁가지들의 갯수승.
public class Day6_색칠공부 {
	static int N, K;
	static int[] f;
	static long[] d;
	static int[] indegree;
	static StringTokenizer st;
	static long ans;
	static final int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		f = new int[N+1];
		d = new long[N+1];
		indegree = new int[N+1];
		ans = 1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
			f[i] = Integer.valueOf(st.nextToken());
			indegree[f[i]]++;
		}
		br.close();
		
		// 위상정렬을 하면서 곁가지들을 계산.
		// K-1^곁가지들의 갯수.
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}
		while(!q.isEmpty()){
			int x = q.remove();
			ans = (long) ans * (K-1) % MOD;
			if(--indegree[f[x]] == 0){
				q.add(f[x]);
			}
		}
		// K=2 가지 색일 경우의 수 => K*(K-1) 개. (색칠하기 문제 참고)
		d[2] = (long) K * (K-1) % MOD;
		for(int i=3; i<=N; i++){
			d[i] = (d[i-2] * (K-1) + d[i-1] * (K-2)) % MOD;
		}
		
		// K=1 가지 색일 경우의 수 => K 개 초기화 .
		d[1] = K;
		for(int i=1; i<=N; i++){
			if(indegree[i]>0){
				int M = 1;
				indegree[f[i]]--;
				for(int j=f[i];j!=i;j=f[j]){
					M++;
					indegree[f[j]]--;
				}
				ans = ans * d[M] % MOD;
			}
		}
		System.out.println(ans);
	}
}

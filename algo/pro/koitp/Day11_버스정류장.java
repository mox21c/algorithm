package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Day11_버스정류장 {
	static int N;
	static int[] town, person;
	static int[] sum;
	static StringTokenizer st;
	static class pair{
		int town, cnt;
		public pair(int town, int cnt){
			this.town = town;
			this.cnt = cnt;
		}
	}
	static ArrayList<pair> al;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		al = new ArrayList<pair>();
		
		//town = new int[100001];
		//person = new int[100001];
		sum = new int[100001];
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			al.add(new pair(Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken())));
			//town[i] = Integer.valueOf(st.nextToken());
			//person[i] = Integer.valueOf(st.nextToken());
			//sum[i] = sum[i-1] + person[i];
		}
		Collections.sort(al, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return o1.town - o2.town;
			}
		});
		
		for(int i=0;i<N ;i ++){
			sum[i+1] = sum[i] + al.get(i).cnt;	
		}
		
		for(int i=0;i<N ;i ++){
			int a = al.get(i).cnt;
			int s1 = sum[i+1];
			int s2 = sum[N]-sum[i];
			if(a > s1-s2 && a >= s2-s1){
				System.out.println(i+1);
			}
		}
		
		br.close();
	}
}

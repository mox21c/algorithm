package com.algo.pro.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 단절선 {
	static int V, E;
	static int[] discovered;
	static ArrayList<pair> cutLine;
	static class pair{
		int s,e;
		public pair(int s, int e){
			this.s=s;
			this.e=e;
		}
		public String toString() {
			return  s + " " + e;
		}
		
	}
	static ArrayList<Integer>[] al;
	static int counter;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		al = new ArrayList[V + 1];
		discovered = new int[V + 1];
		cutLine = new ArrayList<pair>();

		for (int i = 1; i <= V; i++) {
			al[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			al[a].add(b);
			al[b].add(a);
		}

		for (int i = 1; i <= V; i++) {
			if (discovered[i] == 0) {
				dfsCutLine(i, 0);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(cutLine.size());
		sb.append("\n");
		for (int i = 0; i < cutLine.size(); i++) {
			sb.append(cutLine.get(i).toString());
			sb.append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
	
	public static int dfsCutLine(int here, int parent){
		discovered[here] = ++counter;
		int ret = discovered[here];
		for(int i=0;i<al[here].size();i++){
			int there = al[here].get(i);
			if(there == parent){
				continue;
			}
			if(discovered[there] == 0){
				int low = dfsCutLine(there, here);
				if(low > discovered[here]){
					if(here > there){
						cutLine.add(new pair(there, here));
					}else{
						cutLine.add(new pair(here, there));
					}
				}
				ret = Math.min(ret, low);
			}else{
				ret = Math.min(ret, discovered[there]);
			}
		}
		return ret;
	}
}

/*
7 7
1 4
4 5
5 1
1 6
6 7
2 7
7 3

4
2 7
3 7
6 7
1 6
*/

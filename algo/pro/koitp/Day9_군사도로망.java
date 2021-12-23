package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// 1. 완성된 도로를 없애 버림. 
// 1-1. 이 도로들은 음수의 가중치로 치환. 
// 1-2. ans에 도로를 없애는 비용의 sum값을 저장해둠.
// 2. 음수의 가중치를 가지고 크루스칼 알고리즘을 적용.
public class Day9_군사도로망 {
	static int N,M,K;
	static StringTokenizer st;
	static class pair{
		int s, e, cost;
		pair(int s, int e, int cost){
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	};
	static int[] parent;
	static ArrayList<pair> al;
	static long ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		ans = 0l;
		
		// 이미 건설된 도로 일 경우 없애는 비용을 ans에 넣어주고, 비용을 음수로 바꾸어준다.
		// 결국 전체 도로는 아직 건설되지 않은 그래프로 바꾸어 준다.
		// 음수로 바꾸었을때, 나중에 크루스칼 알고리즘을 적용할 경우 우선순위가 먼저 적용된다.
		// 이말은 결국, 이미 건설되었던 도로는 음수의 가중치로 크루스칼 시 우선적으로 고려되는 효과를 가지게 된다.
		al = new ArrayList<pair>();
		for(int i=0;i<M+K;i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.valueOf(st.nextToken());
			int e = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			if(i<M){
				al.add(new pair(s,e,-c));
				ans += c;
			}else{
				al.add(new pair(s,e,c));
			}
		}
		
		// 크루스칼 사용하기 위해 cost 별로 오름차순 정렬 
		Collections.sort(al, new Comparator<pair>() {
			public int compare(pair o1, pair o2) {
				return o1.cost - o2.cost;
			}
		});
		
		// find & unio을 사용하기 위한 parent 배열 초기화 
		parent = new int[N+1];
		for(int i=0;i<=N;i++){
			parent[i] = i;
		}
		
		// 연결된 간선을 담아둘 배열
		boolean[] connect = new boolean[M+K];
		
		// 연결될수 있는 간선을 담아둘 배열 
		boolean[] can_connect = new boolean[M+K];
		
		for(int i=0;i<al.size();i++){
			// 연결 될수 있는 간선인지 찾기 위한 로직.
			if(i==0 || al.get(i-1).cost != al.get(i).cost){
				// 가중치가 같으면서, 같은 그룹에 포함되지 않다면 연결할수 있는 간선으로 표시.
				for(int j=i; j<al.size(); j++){
					if(al.get(i).cost != al.get(j).cost){
						break;
					}
					if(find(al.get(j).s) != find(al.get(j).e)){
						can_connect[j] = true;
					}
				}
			}
			
			int x = find(al.get(i).s);
			int y = find(al.get(i).e);
			if(x == y){
				continue;
			}
			ans += al.get(i).cost;
			parent[x] = parent[y];
			
			// 연결된 간선에 대한 표시.
			connect[i] = true;
		}
		
		boolean isUnique = true;
	    for(int i=0;i<al.size();i++){
	    	// 연결가능 한데 연결되지 않은 간선이 있다면 unique하지 않다.
	    	if(can_connect[i] && !connect[i]){
	    		isUnique = false;
	    		break;
	    	}
	    }
		
		System.out.println(ans + " " + (isUnique ? "unique" : "not unique"));
	}
	
	public static int find(int u){
		if(parent[u] == u){
			return u;
		}
		return parent[u] = find(parent[u]);
	}
}

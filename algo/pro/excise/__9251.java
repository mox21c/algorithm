package com.algo.pro.excise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class __9251 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().trim().toCharArray();
		char[] b = br.readLine().trim().toCharArray();
		br.close();
		
		int al = a.length;
		int bl = b.length;
		int[][] d = new int[bl+1][al+1];
		
		for(int r=1;r<=bl;r++){
			for(int c=1;c<=al;c++){
				if(a[c-1] == b[r-1]){
					d[r][c] = d[r-1][c-1] + 1;
				}
				else{
					d[r][c] = Math.max(d[r-1][c], d[r][c-1]);
				}
			}
		}
		
		Stack<Character> st = new Stack<Character>();
		
		while(true){
			if(bl==0 || al==0 || d[bl][al] == 0){
				break;
			}
			if(d[bl][al] == d[bl-1][al]){
				bl--;
			}else if(d[bl][al] == d[bl][al-1]){
				al--;
			}else if(d[bl][al] == d[bl-1][al-1]+1){
				st.add(a[al-1]);
				bl--;
				al--;
			}
		}
			
		StringBuilder sb = new StringBuilder();
		sb.append(d[b.length][a.length]);
		sb.append("\n");
		while(!st.isEmpty()){
			sb.append(st.pop());
		}
		
		System.out.println(sb.toString());
		
		
		
	}
}

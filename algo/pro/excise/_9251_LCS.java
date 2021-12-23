package com.algo.pro.excise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9251_LCS {
	static String str1, str2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine();
		str2 = br.readLine();
		
		int str1Len = str1.length();
		int str2Len = str2.length();
		
		int[][] pan = new int[str1Len+1][str2Len+1];
		
		for(int r=1;r<=str1Len; r++){
			for(int c=1;c<=str2Len; c++){
				if(str1.charAt(r-1) == str2.charAt(c-1)){
					pan[r][c] = pan[r-1][c-1] + 1;
				}
				else{
					pan[r][c] = Math.max(pan[r-1][c], pan[r][c-1]);
				}
			}
		}
		
		int ans = pan[str1Len][str2Len];
		System.out.println(ans);
		
		char[] ansArr = new char[ans+1];
		int str1Pos = str1Len;
		int str2Pos = str2Len;
		while(true){
			if(str1Pos == 0 || str2Pos == 0){
				break;
			}
			if(pan[str1Pos-1][str2Pos] == pan[str1Pos][str2Pos]){
				str1Pos--;
			}
			else if(pan[str1Pos][str2Pos-1] == pan[str1Pos][str2Pos]){
				str2Pos--;
			}
			else{
				ansArr[ans--] = str1.charAt(str1Pos-1);
				str1Pos--;
				str2Pos--;
			}
		}
		
		for(int i=1;i<ansArr.length;i++){
			System.out.print(ansArr[i]);
		}
		
		
		br.close();
	}
}

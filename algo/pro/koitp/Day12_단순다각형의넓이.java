package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day12_단순다각형의넓이 {
	static int N;
    static long[] X, Y;
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        X = new long[N+1];
        Y = new long[N+1];
        
        for(int i=1;i<=N;i++){
        	st = new StringTokenizer(br.readLine());
        	X[i] = Long.valueOf(st.nextToken());
        	Y[i] = Long.valueOf(st.nextToken());
        }
        
        long sum1 = 0l;
        long sum2 = 0l;
        for(int i=1;i<=N;i++){
        	if(i==N){
        		sum1 += X[i]*Y[1];
            	sum2 += X[1]*Y[i];
        	}else{
        		sum1 += X[i]*Y[i+1];
            	sum2 += X[i+1]*Y[i];
        	}
        }
        long sum = Math.abs(sum1-sum2);
        // double <- long은 같은 64비트더라도 정확도가 떨어짐.
        // 따라서 정수부와 소수부를 따로 출력함.
        if(N > 2){
        	if(sum%2==0){
        		System.out.println(sum/2 + ".0");
        	}else{
        		System.out.println(sum/2 + ".5");
        	}
        	
        }else{
        	System.out.println("0.0");
        }
        
        br.close();
    }
}

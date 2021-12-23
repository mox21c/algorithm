package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day4_탑 {
	static int A[];
    static StringTokenizer st;
    static Stack<Integer> s;
    static StringBuilder sb;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine().trim());
        A = new int[N + 1];
        s = new Stack<Integer>();
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
         
        for (int i = 1; i <= N; i++) {
            int temp = Integer.valueOf(st.nextToken());
            A[i] = temp;
 
            while (!s.isEmpty() && A[s.peek()] < A[i]) {
                s.pop();
            }
 
            if (s.empty()) {
                sb.append("0");
            } else {
                sb.append(s.peek());
            }
            sb.append(" ");
 
            s.add(i);
        }
        System.out.println(sb.toString());
    }
}

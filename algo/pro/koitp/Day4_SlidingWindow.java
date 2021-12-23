package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day4_SlidingWindow {
	static int N, K;
    static int[] a;
    static StringTokenizer st;
    static Deque<Integer> mn, mx;
    static StringBuilder sb ;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine().trim());
        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());
 
        a = new int[N + 1];
 
        mn = new LinkedList<Integer>();
        mx = new LinkedList<Integer>();
        long sum = 0l;
         
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.valueOf(st.nextToken());
        }
        br.close();
         
        for (int i = 1; i <= N; i++) {
            sum += a[i];
            if (i > K) {
                sum -= a[i - K];
            }
            while (!mn.isEmpty() && a[mn.peekLast()] >= a[i]){
                mn.pollLast();
            }
            mn.addLast(i);
 
            while (!mx.isEmpty() && a[mx.peekLast()] <= a[i]){
                mx.pollLast();
            }
            mx.addLast(i);
 
            while (mn.peekFirst() <= i - K){
                mn.pollFirst();
            }
            while (mx.peekFirst() <= i - K){
                mx.pollFirst();
            }
            if (i >= K) {
                sb.append(a[mn.peekFirst()]);
                sb.append(" ");
                sb.append(a[mx.peekFirst()]);
                sb.append(" ");
                sb.append(sum);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

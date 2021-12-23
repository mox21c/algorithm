package com.algo.pro.koitp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Day4_중앙값 {
	static int N;
    static PriorityQueue<Integer> q1, q2;
    static StringBuilder sb;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int N = Integer.valueOf(br.readLine().trim());
        q1 = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        q2 = new PriorityQueue<Integer>();
        
        int mid = 0;
        int val = 0;
        for (int i = 0; i < N; i++) {
            val = Integer.valueOf(br.readLine().trim());
            if (i == 0) {
                mid = val;
            } else {
                if (val < mid) {
                    q1.add(val);
                } else {
                    q2.add(val);
                }
            }
//          (i & 1) = 1,3,5,7,9
//          (i & 2) = 2,3,6,7
            if (i % 2 == 0) {
                while (q1.size() > q2.size()) {
                    q2.add(mid);
                    mid = q1.peek();
                    q1.remove();
                }
                while (q1.size() < q2.size()) {
                    q1.add(mid);
                    mid = q2.peek();
                    q2.remove();
                }
                System.out.println(mid);
            }
        }
    }
}

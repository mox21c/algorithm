package com.algo.pro.lec2;

import java.util.Scanner;

public class _2042_구간합구하기_세그먼트트리 {
	static int a[] = new int[1000001];
    static long tree[];
    static int NN;

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        for(NN = 1; NN < N; NN *= 2);
        tree = new long[NN * 2];

        for(int i = 1; i <= N; i++)
            tree[NN + i - 1] = sc.nextInt();
        for(int i = NN - 1; i > 0; i--)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];

        int Q = M + K;
        while(Q-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == 1) changeValue(b, c);
            else System.out.println(rangeSum(b, c, 1, 1, NN));
        }
    }

    public static void changeValue(int idx, int value){
        idx = NN + idx - 1;
        tree[idx] = value;
        for(idx /= 2; idx > 0; idx /= 2)
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }

    // [ql, qr]: want range
    // idx: # of current node
    // [l, r]: range of current node
    // return sum of [l, r] in [ql, qr] 
    public static long rangeSum(int ql, int qr, int idx, int l, int r){
        // l r < ql qr, ql qr < l r
        if(r < ql || qr < l) return 0;
        // ql <= l r <= qr
        if(ql <= l && r <= qr) return tree[idx];

        long left = rangeSum(ql, qr, idx * 2, l, (l + r) / 2);
        long right = rangeSum(ql, qr, idx * 2 + 1, (l + r) / 2 + 1, r);
        return left + right;
    }
}

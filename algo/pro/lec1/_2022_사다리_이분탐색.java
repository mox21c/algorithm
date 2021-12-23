package com.algo.pro.lec1;

import java.util.Scanner;

public class _2022_사다리_이분탐색 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double c = sc.nextDouble();
            double left = 0;
            double right = Math.min(x, y);
            //for, whil문 둘중에 하나를 사용.
            for (int k=0; k<10000; k++) { // 좀 큰 경우의 수를 다 돌려 봄.
            //while (Math.abs(right-left) > 1e-6) {  // 오차를 10-6까지 허용.
                double mid = (left + right) / 2.0;
                double d = mid;
                double h1 = Math.sqrt(x*x-d*d);
                double h2 = Math.sqrt(y*y-d*d);
                double h = (h1*h2)/(h1+h2);
                if (h > c) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            System.out.printf("%.3f\n",left);
        }
    }
}

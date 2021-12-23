package com.algo.pro.lec2;

import java.util.Scanner;

public class _1517_버블소트_ {
	static int arr[] = new int[1000000];
	static int ordered[] = new int[1000000];
	static long ans;

	static void mergeSort(int l, int r) {
		if (r - l < 2) {
			if (arr[r] < arr[l]) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				ans++;
			}
			return;
		}

		int half = (l + r) / 2;
		mergeSort(l, half);
		mergeSort(half + 1, r);

		int idx = l, li = l, ri = half + 1;
		while (li <= half && ri <= r) {
			if (arr[li] <= arr[ri])
				ordered[idx++] = arr[li++];
			else {
				ordered[idx++] = arr[ri++];
				ans += half - li + 1;
			}
		}

		while (li <= half)
			ordered[idx++] = arr[li++];
		while (ri <= r)
			ordered[idx++] = arr[ri++];

		for (int i = l; i <= r; i++)
			arr[i] = ordered[i];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		mergeSort(0, N - 1);
		System.out.println(ans);
	}
}

package com.algo.pro.lec2;

import java.util.Scanner;

public class _2751_수정렬하기2_mergesort {
	static int arr[] = new int[1000000];
	static int ordered[] = new int[1000000];

	static void mergeSort(int l, int r) {
		if (r - l < 2) {
			if (arr[r] < arr[l]) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
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
			else
				ordered[idx++] = arr[ri++];
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

		for (int i = 0; i < N; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

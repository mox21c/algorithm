package com.algo.pro.lec2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11723_집합_DP_array {
	static StringTokenizer line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int bit[] = new int[21];
		bit[1] = 1;
		for (int i = 2; i <= 20; i++)
			bit[i] = bit[i - 1] * 2;

		line = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(line.nextToken());
		int status = 0;

		while (M-- > 0) {
			line = new StringTokenizer(br.readLine());
			String cmd = line.nextToken();
			if (cmd.charAt(0) == 'a') {
				if (cmd.charAt(1) == 'd') {
					int x = Integer.parseInt(line.nextToken());
					status |= bit[x];
				} else
					status = (1 << 20) - 1;
			} else if (cmd.charAt(0) == 'r') {
				int x = Integer.parseInt(line.nextToken());
				status &= ~bit[x];
			} else if (cmd.charAt(0) == 'c') {
				int x = Integer.parseInt(line.nextToken());
				bw.write((status & bit[x]) == 0 ? "0\n" : "1\n");
				bw.flush();
			} else if (cmd.charAt(0) == 't') {
				int x = Integer.parseInt(line.nextToken());
				status ^= bit[x];
			} else
				status = 0;
		}
	}
}

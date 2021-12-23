package com.algo.pro.excise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
   
public class 직사각형  {
    static int t, n, m;
    static StringTokenizer st;
    static int[][] mat, top, left;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for(int seq = 1; seq <= t; seq++) {
        	ans = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            mat = new int[n+1][m+1];
            mat = new int[n+1][m+1];
            top = new int[n+1][m+1];
            left = new int[n+1][m+1];
            for(int i = 1; i <= n; i++) {
            	char[] cc = br.readLine().toCharArray();
            	for(int j = 1; j <= m; j++) {
            		if(cc[j-1] == '1') {
            			top[i][j] = top[i-1][j] + 1;	//높이
            			left[i][j] = left[i][j-1] + 1;	//좌측길이
            		}
            	}
            }
            for(int i = 1; i <= n; i++) {
            	for(int j = 1; j <= m; j++) {
            		if(left[i][j] > 0 && (j == m || left[i][j+1] == 0)) {
            			Stack<int[]> stack = new Stack<>();	//스택안의 int 배열 - 0번은 top 1번은 left
            			int pre = 0;
            			for(int k = j - left[i][j] + 1; k <= j; k++) {
            				if(pre <= top[i][k]) {	//이전 높이보다 현재 높이가 크면 이전 값을 가져와 중첩시킴..
            					mat[i][k] = mat[i][k-1] + top[i][k];
            				} else {
            					while(!stack.isEmpty()) {
            						int[] pair = stack.peek();
            						if(pair[0] > top[i][k] ) {	//스택에서 현재높이보다 작은 값이 나올때까지 pop
                						stack.pop();
            						} else {
            							mat[i][k] = mat[i][k-(left[i][k] - pair[1])];	//스택에서 현재높이보다 작은 값을 찾음.. -> 현재 값보다 작으므로 가져와서 중첩시킴..
            							break;
            						}
            					}
            					if(stack.isEmpty()) {	//스택이 비어있다면 현재 위치의 높이보다 작은 값이 없음.. 사격형의 개수 = k 번째 높이를 포함하는 최대 너비의 사각형 = top * left
                					mat[i][k] += top[i][k] * left[i][k];
            					} else {
                					mat[i][k] += top[i][k] * (left[i][k] - stack.peek()[1]);	//스택에 남아 있는 값은 현재 top 보다 작은 값.. [현재 left - 중첩시 참조한 위치의 left] 가 너비가 된다.. 
            					}
            				}
							stack.push(new int[]{top[i][k], left[i][k]});
        					pre = top[i][k];
        					ans += mat[i][k];
            			}
            		}
            	}
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(String.valueOf(seq));
            sb.append(" ");
            sb.append(String.valueOf(ans));
            System.out.println(sb.toString());
        }
        br.close();
    }
}
 


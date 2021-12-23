package com.algo.giha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//## 원점을 지나는 평면의 방정식
//a = y1*z2 - z1*y2
//b = z1*x2 - x1*z2
//c = x1*y2 - y1*x2
//a*x3 + b*y3 + c*z3 = 0

public class 공간속의점 {
  static int t, ans;
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      st = new StringTokenizer(br.readLine());
      t = Integer.parseInt(st.nextToken());
      for(int seq = 1; seq <= t; seq++) {
          st = new StringTokenizer(br.readLine());
          Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
          Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
          Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

          if( isZero(p1.x, p1.y, p1.z, p2.x, p2.y, p2.z, p3.x, p3.y, p3.z) ) {    //동일점
              ans = 0;
          } else {
              int a = p1.y*p2.z - p1.z*p2.y;
              int b = p1.z*p2.x - p1.x*p2.z;
              int c = p1.x*p2.y - p1.y*p2.x;
              int d = a*p3.x + b*p3.y + c*p3.z;
              if( d == 0 ) {  //동일평면
                  int a2 = p1.y*p3.z - p1.z*p3.y;
                  int b2 = p1.z*p3.x - p1.x*p3.z;
                  int c2 = p1.x*p3.y - p1.y*p3.x;
                  if(isZero(a, b, c, a2, b2, c2)) {   //동일직선
                      ans = 1;
                  } else {
                      ans = 2;
                  }
              } else {
                  ans = 3;
              }
          }
          StringBuilder sb = new StringBuilder();
          sb.append("#");
          sb.append(String.valueOf(seq));
          sb.append(" ");
          sb.append(String.valueOf(ans));
          System.out.println(sb.toString());
      }
  }
   
  static class Point {
      int x, y, z;
      Point(int x, int y, int z) {
          this.x = x;
          this.y = y;
          this.z = z;
      }
  }
   
  static boolean isZero(int... k) {
      boolean ret = true;
      for(int i : k) {
          ret = ret && (i == 0);
      }
      return ret;
  }
}

/*
 * 7 0 0 0 0 0 0 0 0 0 3 9 -6 -1 -3 2 8 24 -16 3 3 3 1 3 5 5 7 9 1 1 1 -2 -2 -2
 * 1 1 1 1 2 3 4 5 6 7 8 9 1 2 3 -4 -5 -6 0 0 0 1 2 1 1 2 1 2 1 2
 * 
 * (출력) #1 0 #2 1 #3 2 #4 1 #5 2 #6 2 #7 2
 */

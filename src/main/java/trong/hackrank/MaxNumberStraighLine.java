package trong.hackrank;

import java.util.HashMap;

/**
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line
 */
public class MaxNumberStraighLine {

  public int maxPoints(Point[] points) {
    if (points.length == 0) {
      return 0;
    }
    if (points.length == 1) {
      return 1;
    }

    // the max number
    int result = 0;
    for (int i = 0; i < points.length; i++) {
      int vcnt = 0, dup = 0, curmax =1; //垂直一条线的点，重合点，当前共线的最大点


      HashMap<Double, Integer> map = new HashMap<>();
      for (int j = i+1; j < points.length; j++) {
        double delta_x = 0, delta_y=0, k=0.0;
        if (j != i) {
          delta_x = points[i].x - points[j].x;
          delta_y = points[i].y - points[j].y;
          if (delta_x == 0 && delta_y == 0) {
            dup++;
          }
          else if (delta_x == 0) {
            if (vcnt == 0) {
              vcnt = 2;
            }
            else {
              vcnt++;
            }
            curmax = Math.max(vcnt, curmax);
          }
          else {
            k = delta_y/delta_x;
            if (map.get(k) == null) {
              map.put(k, 2);
            }
            else {
              Integer or = map.get(k);
              or++;
              map.put(k, or);
            }
            curmax = Math.max(map.get(k), curmax);
          }
        }
      }
      result = Math.max(result, curmax+dup);
    }

    return result;
  }

  public static void main(String[] args) {
    Point[] test = new Point[3];
    Point a = new Point(0,0);
    Point b = new Point(94911151,94911150);
    Point c = new Point(94911152,94911151);
    test[0] = a;
    test[1] = b;
    test[2] = c;
    MaxNumberStraighLine ss = new MaxNumberStraighLine();
    System.out.println(ss.maxPoints(test));
  }
}

class Point {
  int x;
  int y;

  Point() {
    x = 0;
    y = 0;
  }

  Point(int a, int b) {
    x = a;
    y = b;
  }
}

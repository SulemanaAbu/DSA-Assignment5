package algorithms;

import java.util.ArrayList;
import java.util.List;

public class QuickHull {

    public static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> quickHull(Point[] points) {
        if (points.length < 3) return null;

        List<Point> hull = new ArrayList<>();

        int minPoint = -1, maxPoint = -1;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i].x < minX) {
                minX = points[i].x;
                minPoint = i;
            }
            if (points[i].x > maxX) {
                maxX = points[i].x;
                maxPoint = i;
            }
        }

        Point A = points[minPoint];
        Point B = points[maxPoint];
        hull.add(A);
        hull.add(B);

        List<Point> leftSet = new ArrayList<>();
        List<Point> rightSet = new ArrayList<>();

        for (Point point : points) {
            if (point != A && point != B) {
                if (pointLocation(A, B, point) == -1) {
                    leftSet.add(point);
                } else if (pointLocation(A, B, point) == 1) {
                    rightSet.add(point);
                }
            }
        }

        hullSet(A, B, rightSet, hull);
        hullSet(B, A, leftSet, hull);

        return hull;
    }

    private static int pointLocation(Point A, Point B, Point P) {
        int cp1 = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);
        return Integer.compare(cp1, 0);
    }

    private static void hullSet(Point A, Point B, List<Point> set, List<Point> hull) {
        if (set.isEmpty()) return;

        int insertPosition = hull.indexOf(B);
        if (set.size() == 1) {
            Point p = set.getFirst();
            set.remove(p);
            hull.add(insertPosition, p);
            return;
        }

        int dist = Integer.MIN_VALUE;
        int furthestPoint = -1;

        for (int i = 0; i < set.size(); i++) {
            Point p = set.get(i);
            int distance = distance(A, B, p);
            if (distance > dist) {
                dist = distance;
                furthestPoint = i;
            }
        }

        Point P = set.get(furthestPoint);
        set.remove(furthestPoint);
        hull.add(insertPosition, P);

        List<Point> leftSetAP = new ArrayList<>();
        for (Point M : set) {
            if (pointLocation(A, P, M) == 1) {
                leftSetAP.add(M);
            }
        }

        List<Point> leftSetPB = new ArrayList<>();
        for (Point M : set) {
            if (pointLocation(P, B, M) == 1) {
                leftSetPB.add(M);
            }
        }

        hullSet(A, P, leftSetAP, hull);
        hullSet(P, B, leftSetPB, hull);
    }

    private static int distance(Point A, Point B, Point C) {
        int ABx = B.x - A.x;
        int ABy = B.y - A.y;
        int num = ABx * (A.y - C.y) - ABy * (A.x - C.x);
        if (num < 0) num = -num;
        return num;
    }
}

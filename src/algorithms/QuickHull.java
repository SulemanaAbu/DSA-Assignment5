package algorithms;

import java.util.ArrayList;
import java.util.List;

public class QuickHull {
    public static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> quickHull(Point[] points) {
        List<Point> hull = new ArrayList<>();
        if (points.length < 3) {
            return hull;
        }

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
        points[minPoint] = points[0];
        points[maxPoint] = points[points.length - 1];

        List<Point> leftSet = new ArrayList<>();
        List<Point> rightSet = new ArrayList<>();

        for (int i = 1; i < points.length - 1; i++) {
            Point p = points[i];
            if (pointLocation(A, B, p) == -1) {
                leftSet.add(p);
            } else if (pointLocation(A, B, p) == 1) {
                rightSet.add(p);
            }
        }

        hullSet(A, B, rightSet, hull);
        hullSet(B, A, leftSet, hull);

        return hull;
    }

    private static int distance(Point A, Point B, Point C) {
        int ABx = B.x - A.x;
        int ABy = B.y - A.y;
        int num = ABx * (A.y - C.y) - ABy * (A.x - C.x);
        if (num < 0) {
            num = -num;
        }
        return num;
    }

    private static void hullSet(Point A, Point B, List<Point> set, List<Point> hull) {
        int insertPosition = hull.indexOf(B);
        if (set.isEmpty()) {
            return;
        }
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
        for (Point m : set) {
            if (pointLocation(A, P, m) == 1) {
                leftSetAP.add(m);
            }
        }

        List<Point> leftSetPB = new ArrayList<>();
        for (Point m : set) {
            if (pointLocation(P, B, m) == 1) {
                leftSetPB.add(m);
            }
        }

        hullSet(A, P, leftSetAP, hull);
        hullSet(P, B, leftSetPB, hull);
    }

    private static int pointLocation(Point A, Point B, Point P) {
        int cp1 = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);
        return Integer.compare(cp1, 0);
    }
}


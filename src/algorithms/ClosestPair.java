package algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    public static double closestPair(java.awt.Point[] points) {
        return 0;
    }

    public static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double findClosestPair(Point[] points) {
        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, Comparator.comparingDouble(p -> p.x));
        return findClosestPairRecursive(sortedByX);
    }

    private static double findClosestPairRecursive(Point[] points) {
        int n = points.length;
        if (n <= 3) {
            return bruteForce(points);
        }

        int mid = n / 2;
        Point midPoint = points[mid];

        Point[] left = Arrays.copyOfRange(points, 0, mid);
        Point[] right = Arrays.copyOfRange(points, mid, n);

        double leftDist = findClosestPairRecursive(left);
        double rightDist = findClosestPairRecursive(right);

        double minDist = Math.min(leftDist, rightDist);

        Point[] strip = Arrays.stream(points)
                .filter(p -> Math.abs(p.x - midPoint.x) < minDist)
                .toArray(Point[]::new);

        Arrays.sort(strip, Comparator.comparingDouble(p -> p.y));

        return Math.min(minDist, stripClosest(strip, minDist));
    }

    private static double stripClosest(Point[] strip, double minDist) {
        double min = minDist;
        int n = strip.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n && (strip[j].y - strip[i].y) < min; ++j) {
                double dist = distance(strip[i], strip[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }

        return min;
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    private static double bruteForce(Point[] points) {
        double min = Double.MAX_VALUE;
        int n = points.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double dist = distance(points[i], points[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }

        return min;
    }
}

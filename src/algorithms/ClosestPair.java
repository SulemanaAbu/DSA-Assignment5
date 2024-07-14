package algorithms;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static double closestPair(Point[] points) {
        if (points.length < 2) return Double.POSITIVE_INFINITY;
        Point[] pointsSortedByX = points.clone();
        Arrays.sort(pointsSortedByX, Comparator.comparingInt(point -> point.x));
        Point[] pointsSortedByY = points.clone();
        Arrays.sort(pointsSortedByY, Comparator.comparingInt(point -> point.y));
        return closestPairRec(pointsSortedByX, pointsSortedByY);
    }

    private static double closestPairRec(Point[] pointsSortedByX, Point[] pointsSortedByY) {
        int n = pointsSortedByX.length;
        if (n <= 3) return bruteForce(pointsSortedByX);

        int mid = n / 2;
        Point midPoint = pointsSortedByX[mid];

        Point[] pointsSortedByYLeft = Arrays.copyOfRange(pointsSortedByY, 0, mid);
        Point[] pointsSortedByYRight = Arrays.copyOfRange(pointsSortedByY, mid, n);

        double dl = closestPairRec(Arrays.copyOfRange(pointsSortedByX, 0, mid), pointsSortedByYLeft);
        double dr = closestPairRec(Arrays.copyOfRange(pointsSortedByX, mid, n), pointsSortedByYRight);

        double d = Math.min(dl, dr);

        Point[] strip = Arrays.stream(pointsSortedByY).filter(point -> Math.abs(point.x - midPoint.x) < d).toArray(Point[]::new);

        return Math.min(d, stripClosest(strip, d));
    }

    private static double bruteForce(Point[] points) {
        double minDist = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }
        return minDist;
    }

    private static double stripClosest(Point[] strip, double d) {
        double min = d;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < min; j++) {
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
}

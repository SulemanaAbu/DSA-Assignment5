
import algorithms.*;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Divide and Conquer Algorithms");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));

        JButton quickSortButton = new JButton("QuickSort");
        JButton mergeSortButton = new JButton("MergeSort");
        JButton closestPairButton = new JButton("Closest Pair");
        JButton strassenButton = new JButton("Strassen's Matrix Multiplication");
        JButton quickHullButton = new JButton("QuickHull");

        quickSortButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter array of integers (comma-separated):");
            int[] array = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
            QuickSort.quickSort(array, 0, array.length - 1);
            JOptionPane.showMessageDialog(frame, "Sorted array: " + Arrays.toString(array));
        });

        mergeSortButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter array of integers (comma-separated):");
            int[] array = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
            MergeSort.mergeSort(array);
            JOptionPane.showMessageDialog(frame, "Sorted array: " + Arrays.toString(array));
        });

        closestPairButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter points (format: x1,y1 x2,y2 ...):");
            String[] pointsStr = input.split(" ");
            ClosestPair.Point[] points = new ClosestPair.Point[pointsStr.length];
            for (int i = 0; i < pointsStr.length; i++) {
                String[] xy = pointsStr[i].split(",");
                points[i] = new ClosestPair.Point(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]));
            }
            double closestDistance = ClosestPair.findClosestPair(points);
            JOptionPane.showMessageDialog(frame, "Closest pair distance: " + closestDistance);
        });

        strassenButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter size of matrix (n):");
            int n = Integer.parseInt(input);

            int[][] A = new int[n][n];
            int[][] B = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter element A[" + i + "][" + j + "]:"));
                    B[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter element B[" + i + "][" + j + "]:"));
                }
            }

            int[][] C = StrassenMatrixMultiplication.strassenMatrixMultiplication(A, B);
            StringBuilder result = new StringBuilder("Resultant Matrix:\n");
            for (int[] row : C) {
                result.append(Arrays.toString(row)).append("\n");
            }
            JOptionPane.showMessageDialog(frame, result.toString());
        });

        quickHullButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter points (format: x1,y1 x2,y2 ...):");
            String[] pointsStr = input.split(" ");
            QuickHull.Point[] points = new QuickHull.Point[pointsStr.length];
            for (int i = 0; i < pointsStr.length; i++) {
                String[] xy = pointsStr[i].split(",");
                points[i] = new QuickHull.Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
            }
            java.util.List<QuickHull.Point> hull = QuickHull.quickHull(points);
            StringBuilder result = new StringBuilder("Convex Hull Points:\n");
            for (QuickHull.Point point : hull) {
                result.append("(").append(point.x).append(", ").append(point.y).append(")\n");
            }
            JOptionPane.showMessageDialog(frame, result.toString());
        });

        frame.add(quickSortButton);
        frame.add(mergeSortButton);
        frame.add(closestPairButton);
        frame.add(strassenButton);
        frame.add(quickHullButton);

        frame.setVisible(true);
    }
}

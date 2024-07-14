package main;

import algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Algorithms");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(12, 1));

        // Divide and Conquer Buttons
        JButton quickSortButton = new JButton("QuickSort");
        JButton mergeSortButton = new JButton("MergeSort");
        JButton closestPairButton = new JButton("Closest Pair of Points");
        JButton strassenButton = new JButton("Strassen's Matrix Multiplication");
        JButton quickHullButton = new JButton("QuickHull");

        quickSortButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter array elements separated by commas:");
            if (input != null) {
                String[] inputArray = input.split(",");
                int[] array = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();
                QuickSort.quickSort(array, 0, array.length - 1);
                JOptionPane.showMessageDialog(frame, "Sorted Array: " + Arrays.toString(array));
            }
        });

        mergeSortButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter array elements separated by commas:");
            String[] inputArray = input.split(",");
            int[] array = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();
            MergeSort.mergeSort(array, 0, array.length - 1);
            JOptionPane.showMessageDialog(frame, "Sorted Array: " + Arrays.toString(array));
        });

        closestPairButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter points as x1,y1 x2,y2 ...:");
            if (input != null) {
                String[] pointsStr = input.split(" ");
                Point[] points = new Point[pointsStr.length];
                for (int i = 0; i < pointsStr.length; i++) {
                    String[] coords = pointsStr[i].split(",");
                    points[i] = new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                }
                double result = ClosestPair.closestPair(points);
                JOptionPane.showMessageDialog(frame, "Closest distance: " + result);
            }
        });

        strassenButton.addActionListener(e -> {
            int[][] A = {{1, 2}, {3, 4}};
            int[][] B = {{5, 6}, {7, 8}};
            int[][] result = StrassenMatrixMultiplication.multiply(A, B);
            JOptionPane.showMessageDialog(frame, "Result matrix: " + Arrays.deepToString(result));
        });

        quickHullButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter points as x1,y1 x2,y2 ...:");
            if (input != null) {
                String[] pointsStr = input.split(" ");
                QuickHull.Point[] points = new QuickHull.Point[pointsStr.length];
                for (int i = 0; i < pointsStr.length; i++) {
                    String[] coords = pointsStr[i].split(",");
                    points[i] = new QuickHull.Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                }
                List<QuickHull.Point> hull = QuickHull.quickHull(points);
                StringBuilder result = new StringBuilder("Convex Hull Points:\n");
                for (QuickHull.Point point : hull) {
                    result.append("(").append(point.x).append(", ").append(point.y).append(")\n");
                }
                JOptionPane.showMessageDialog(frame, result.toString());
            }
        });

        // Greedy Buttons
        JButton dijkstraButton = new JButton("Dijkstra's Shortest Path");
        JButton huffmanButton = new JButton("Huffman Codes");
        JButton kruskalButton = new JButton("Kruskal's MST");
        JButton primButton = new JButton("Prim's MST");
        JButton tspButton = new JButton("Traveling Salesman Problem");

        dijkstraButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter the number of nodes:");
            if (input != null) {
                int nodes = Integer.parseInt(input);
                int[][] graph = new int[nodes][nodes];
                for (int i = 0; i < nodes; i++) {
                    for (int j = 0; j < nodes; j++) {
                        graph[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter weight for edge " + i + " to " + j + " (0 if no edge):"));
                    }
                }
                int src = Integer.parseInt(JOptionPane.showInputDialog("Enter the source node:"));
                int[] distances = Dijkstra.dijkstra(graph, src);
                StringBuilder result = new StringBuilder("Shortest distances from node " + src + ":\n");
                for (int i = 0; i < distances.length; i++) {
                    result.append("To node ").append(i).append(": ").append(distances[i]).append("\n");
                }
                JOptionPane.showMessageDialog(frame, result.toString());
            }
        });

        huffmanButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter characters and their frequencies (format: char1,frequency1 char2,frequency2 ...):");
            if (input != null) {
                String[] charFreqStr = input.split(" ");
                Map<Character, Integer> charFreq = new HashMap<>();
                for (String cf : charFreqStr) {
                    String[] cfArr = cf.split(",");
                    charFreq.put(cfArr[0].charAt(0), Integer.parseInt(cfArr[1]));
                }
                Map<Character, String> huffmanCodes = HuffmanCodes.generateHuffmanCodes(charFreq);
                StringBuilder result = new StringBuilder("Huffman Codes:\n");
                for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                    result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, result.toString());
            }
        });

        kruskalButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter the number of nodes:");
            int nodes = Integer.parseInt(input);
            input = JOptionPane.showInputDialog("Enter the number of edges:");
            int edges = Integer.parseInt(input);

            Kruskal kruskal = new Kruskal(nodes, edges);

            for (int i = 0; i < edges; i++) {
                int src = Integer.parseInt(JOptionPane.showInputDialog("Enter source of edge " + (i + 1) + ":"));
                int dest = Integer.parseInt(JOptionPane.showInputDialog("Enter destination of edge " + (i + 1) + ":"));
                int weight = Integer.parseInt(JOptionPane.showInputDialog("Enter weight of edge " + (i + 1) + ":"));
                kruskal.addEdge(i, src, dest, weight);
            }

            Kruskal.Edge[] result = kruskal.kruskalMST();
            StringBuilder output = new StringBuilder("Edges in MST:\n");
            for (int i = 0; i < nodes - 1; i++) {
                output.append(result[i].src).append(" - ").append(result[i].dest).append(": ").append(result[i].weight).append("\n");
            }
            JOptionPane.showMessageDialog(frame, output.toString());
        });

        primButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter the number of nodes:");
            if (input != null) {
                int nodes = Integer.parseInt(input);
                int[][] graph = new int[nodes][nodes];
                for (int i = 0; i < nodes; i++) {
                    for (int j = 0; j < nodes; j++) {
                        graph[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter weight for edge " + i + " to " + j + " (0 if no edge):"));
                    }
                }
                int totalWeight = Prim.primMST(graph);
                JOptionPane.showMessageDialog(frame, "Total weight of MST: " + totalWeight);
            }
        });

        tspButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter the number of nodes:");
            int nodes = Integer.parseInt(input);
            int[][] graph = new int[nodes][nodes];
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    graph[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter weight for edge " + i + " to " + j + " (0 if no edge):"));
                }
            }
            int result = TSP.findTSP(graph);
            JOptionPane.showMessageDialog(frame, "Minimum cost of TSP: " + result);
        });

        frame.add(quickSortButton);
        frame.add(mergeSortButton);
        frame.add(closestPairButton);
        frame.add(strassenButton);
        frame.add(quickHullButton);
        frame.add(dijkstraButton);
        frame.add(huffmanButton);
        frame.add(kruskalButton);
        frame.add(primButton);
        frame.add(tspButton);

        frame.setVisible(true);
    }
}

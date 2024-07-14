# DSA-Assignment5
# Divide_Greedy_Assignment

## Description
This Java GUI application showcases various algorithms implemented using object-oriented programming concepts. It includes implementations of sorting algorithms (QuickSort, MergeSort), computational geometry algorithms (Closest Pair of Points, QuickHull), matrix algorithms (Strassen's Matrix Multiplication), and graph algorithms (Dijkstra's Shortest Path, Huffman Codes, Kruskal's MST, Prim's MST, Traveling Salesman Problem).

![Screenshot (45)](https://github.com/user-attachments/assets/641b39ec-ef4d-442d-a330-8884fc09464c)

## Dependencies
This application requires Java Development Kit (JDK) version 8 or higher to be installed on your system.

## Compilation and Execution
1. **Compiling the Application:**
   - Open a command prompt or terminal window.
   - Navigate to the directory containing the source code (`Main.java` and algorithm implementations).
   - Compile the source code using the following command:
     ```
     javac Main.java
     ```

2. **Running the Application:**
   - After compiling, run the application with the following command:
     ```
     java Main
     ```
   - This will launch the GUI application where you can interact with different algorithms.

## Algorithm Examples

### QuickSort
- **Description:** QuickSort is a divide-and-conquer sorting algorithm that sorts elements based on a pivot element.
- **Example:**
  - **Input:** 10, 5, 8, 3, 1 ![QSInput](https://github.com/user-attachments/assets/c329e3dc-61ee-49b8-9212-7874aa0a7676)
  - **Output:** Sorted Array: [1, 3, 5, 8, 10]   ![QSOutput](https://github.com/user-attachments/assets/0b92cd38-2932-4503-b753-be2f08f435ba)


### MergeSort
- **Description:** MergeSort is another divide-and-conquer sorting algorithm that divides the array into halves, sorts each half, and then merges them.
- **Example:**
  - **Input:** 7, 2, 4, 1, 5
  - **Output:** Sorted Array: [1, 2, 4, 5, 7]

### Closest Pair of Points
- **Description:** Find the pair of points with the smallest Euclidean distance between them.
- **Example:**
  - **Input:** Points: (0,0), (1,1), (3,4), (5,2)
  - **Output:** Closest distance: 1.41 (distance between points (1,1) and (0,0))

### Strassen's Matrix Multiplication
- **Description:** A matrix multiplication algorithm that performs matrix multiplication in less time compared to the standard method.
- **Example:**
  - **Input:** Two 2x2 matrices A and B
    - A = [[1, 2], [3, 4]]
    - B = [[5, 6], [7, 8]]
  - **Output:** Result matrix: [[19, 22], [43, 50]]

### QuickHull
- **Description:** Finds the convex hull for a set of points in a 2D plane.
- **Example:**
  - **Input:** Points: (1,1), (2,5), (3,3), (5,3), (6,2)
  - **Output:** Convex Hull Points: (1,1), (5,3), (6,2)

### Dijkstra's Shortest Path
- **Description:** Finds the shortest paths from a source node to all other nodes in a weighted graph.
- **Example:**
  - **Input:**
    - Number of nodes: 4
    - Weighted graph (matrix form):
      ```
      0  10  5  999
      999  0  2  1
      999 999  0  4
      7 999 999  0
      ```
    - Source node: 0
  - **Output:** Shortest distances from node 0: To node 1: 8, To node 2: 5, To node 3: 9

### Huffman Codes
- **Description:** Generates Huffman codes based on character frequencies to minimize the average encoding length.
- **Example:**
  - **Input:** Frequencies: (A,3) (B,6) (C,1) (D,2)
  - **Output:** Huffman Codes: A: 10, B: 0, C: 110, D: 111

### Kruskal's MST
- **Description:** Finds the Minimum Spanning Tree (MST) of a graph using Kruskal's algorithm.
- **Example:**
  - **Input:**
    - Number of nodes: 4
    - Number of edges: 5
    - Edges: (0,1,10), (0,2,6), (0,3,5), (1,3,15), (2,3,4)
  - **Output:** Edges in MST: 2 - 3: 4, 0 - 3: 5, 0 - 1: 10

### Prim's MST
- **Description:** Finds the Minimum Spanning Tree (MST) of a graph using Prim's algorithm.
- **Example:**
  - **Input:**
    - Number of nodes: 4
    - Weighted graph (matrix form):
      ```
      0  5  8  0
      5  0  10  15
      8  10  0  20
      0  15  20  0
      ```
  - **Output:** Total weight of MST: 30

### Traveling Salesman Problem (TSP)
- **Description:** Finds the minimum cost Hamiltonian cycle in a complete weighted graph.
- **Example:**
  - **Input:**
    - Number of nodes: 4
    - Weighted graph (matrix form):
      ```
      0  10  15  20
      10  0  35  25
      15  35  0  30
      20  25  30  0
      ```
  - **Output:** Minimum cost of TSP: 80


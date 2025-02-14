﻿# DSA-Assignment5
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
  - **Input:** 10, 5, 8, 3, 1  ![QSI](https://github.com/user-attachments/assets/77132f9f-e529-42ab-8b34-f15a3ea09e42)

  - **Output:** Sorted Array: [1, 3, 5, 8, 10]   ![QSOutput](https://github.com/user-attachments/assets/0b92cd38-2932-4503-b753-be2f08f435ba)


### MergeSort
- **Description:** MergeSort is another divide-and-conquer sorting algorithm that divides the array into halves, sorts each half, and then merges them.
- **Example:**
  - **Input:** 7, 2, 4, 1, 5  ![MSInput](https://github.com/user-attachments/assets/54423632-4f27-4bb9-a2d4-cd43b3143376)

  - **Output:** Sorted Array: [1, 2, 4, 5, 7]  ![MSOutput](https://github.com/user-attachments/assets/0b57e12a-c2ac-47d0-8e76-e896d785396e)


### Closest Pair of Points
- **Description:** Finds the pair of points with the smallest Euclidean distance between them.
- **Example:**
  - **Input:** Points: (0,0), (1,1), (3,4), (5,2)  ![CPInput](https://github.com/user-attachments/assets/2cb0e2aa-8804-4c4b-b3fc-ef9d430d47c0)

  - **Output:** Closest distance: 1.41 (distance between points (1,1) and (0,0))  ![CPOutput](https://github.com/user-attachments/assets/733d09c7-c781-46e3-a404-5c093dd97220)

### Strassen's Matrix Multiplication
- **Description:** A matrix multiplication algorithm that performs matrix multiplication in less time compared to the standard method.
- **Example:**
  - **Input:** Two 2x2 matrices A and B
    - A = [[1, 2], [3, 4]]
    - B = [[5, 6], [7, 8]]
  - **Output:** Result matrix: [[19, 22], [43, 50]]  ![SMM](https://github.com/user-attachments/assets/c3ed2ef2-7085-42ab-b4d4-65803505be08)

### QuickHull
- **Description:** Finds the convex hull for a set of points in a 2D plane.
- **Example:**
  - **Input:** Points: (1,1), (2,5), (3,3), (5,3), (6,2)  ![QHInput](https://github.com/user-attachments/assets/4107b4b4-3651-4e9d-a8b6-f7c62ddc59d8)

  - **Output:** Convex Hull Points: (1,1), (2,5), (5,3), (6,2)  ![QHOutput](https://github.com/user-attachments/assets/b7bdfca0-c18b-40f1-aadb-b604963e3789)


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
  - **Output:** Shortest distances from node 0: To node 1: 10, To node 2: 5, To node 3: 9
      ![dj](https://github.com/user-attachments/assets/e45c6f99-bacf-4550-9cd2-115f20d80c9d)

### Huffman Codes
- **Description:** Generates Huffman codes based on character frequencies to minimize the average encoding length.
- **Example:**
      ![HuffI](https://github.com/user-attachments/assets/ab6a0bda-20da-435b-8626-77d8bd2887e7)
  - **Input:** Frequencies: (A,3) (B,6) (C,1) (D,2)
      ![HuffO](https://github.com/user-attachments/assets/c3e11b99-34b9-4fb5-95e9-f64a32808fce)
  - **Output:** Huffman Codes: A: 10, B: 0, C: 110, D: 111
      
### Kruskal's MST
- **Description:** Finds a graph's Minimum Spanning Tree (MST) using Kruskal's algorithm.
- **Example:**
  - **Input:**
    - Number of nodes: 4
    - Number of edges: 5
    - Edges: (0,1,10), (0,2,6), (0,3,5), (1,3,15), (2,3,4)
  - **Output:** Edges in MST: 2 - 3: 4, 0 - 3: 5, 0 - 1: 10
      ![Krus](https://github.com/user-attachments/assets/dc23e32c-6ca8-4fba-82a2-a4ed482298dd)


### Prim's MST
- **Description:** Finds a graph's Minimum Spanning Tree (MST) using Prim's algorithm.
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
  - **Output:** Total weight of MST: 28
      ![prim](https://github.com/user-attachments/assets/4293ab17-0a61-4bac-ab16-868d46e7988f)

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
      ![TSP](https://github.com/user-attachments/assets/97b4559b-f25a-4f4c-98d5-fdca04154658)


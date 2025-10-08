# Learn Data Structures 

This repository contains a collection of fundamental data structures and algorithms implemented in C++ and Java. It serves as a practical reference and educational resource for understanding core computer science concepts.

## Project Structure

The repository is organized into two main directories, one for each programming language:

-   `cpp/`: Contains C++ implementations.
-   `java/`: Contains various Java projects, primarily structured for Apache NetBeans.

## C++ Implementations

The `cpp/` directory showcases basic and recursive implementations of common data structures.

### Data Structures
-   **`LinkedList.cpp`**: A standard singly linked list with operations for insertion, deletion, searching, and traversal.
-   **`DoubleList.cpp`**: A doubly linked list. The example application manages a priority queue for patient vaccinations based on profession (medico) and age.
-   **`CircularList.cpp`**: A circular linked list implementation demonstrated with a list of `Jugador` (player) objects.

### Recursive Implementations
The `cpp/recursive/` subdirectory contains examples of solving problems using recursion.
-   **`LinkedList.cpp`**: A recursive implementation of a linked list, including methods for printing in reverse order.
-   **`Matrix.cpp`**: Functions for recursively filling and displaying 2D arrays (matrices), including printing the main diagonal.
-   **`Vector.cpp`**: A set of recursive functions for vector (array) operations like sum, count, search, and reverse printing.

## Java Implementations

The `java/` directory consists of several Apache NetBeans projects, each focusing on a specific data structure or algorithm.

### Vector and Sorting/Searching
-   **`vector/`**: A simple project demonstrating various sorting and searching algorithms on an integer array.
    -   **Sorting**: Bubble Sort, Selection Sort, Quicksort, Heapsort.
    -   **Searching**: Linear Search, Binary Search.

### Lists and Collections
-   **`cars/`**: A console application managing a list of `Car` objects. It provides implementations of `bubbleSort` (by model) and `selectSort` (by price).
-   **`employees/`**: Manages a `LinkedList` of `Employee` objects. It showcases sorting using `Comparable` (by code) and `Comparator` (by name), alongside binary and linear search implementations.
-   **`products/`**: A Swing-based GUI application (using `JOptionPane`) for managing a product inventory. This project demonstrates:
    -   **Sorting**: Quicksort (by reference), Heapsort (by name), and `Comparator`-based sort (by price).
    -   **Searching**: Linear search (by reference) and binary search (by name).

### Binary Trees
-   **`bintree/arbin/`**: Defines a generic interface `Arbin<E>` and a basic node class `ArbinNode<E>` for binary trees.
-   **`bintree/intarbin/`**: An implementation of an unbalanced binary tree for integers, with methods for calculating weight, height, and retrieving leaves.
-   **`bintree/sortedintarbin/`**: Implements a Binary Search Tree (BST) for integers, including methods for adding, searching, and removing elements while maintaining order.
-   **`bintree/songs/`**: A practical application using a Binary Search Tree to manage a collection of `Song` objects. It supports adding, searching, removing, and finding the song with the maximum length. Data is persisted to a file (`songs.obj`).

### Graphs
-   **`graphs/`**: A comprehensive project covering graph data structures and related algorithms.
    -   **Representation**: An interface `Graph<E>` and a `MatrixGraph<E>` adjacency matrix implementation.
    -   **Search Algorithms**: Implementations of Breadth-First Search (`BreadthFirstSearch`) and Depth-First Search (`DepthFirstSearch`).
    -   **Shortest Path Algorithms**:
        -   **`Dijkstra.java`**: Finds the shortest path from a single source vertex to all other vertices.
        -   **`Floyd.java`**: Implements the Floyd-Warshall algorithm to find all-pairs shortest paths.
    -   **Applications**:
        -   `neighbs/`: A a console application that models relationships between neighborhoods.
        -   `strings/`: A simple driver class to demonstrate graph algorithms using string vertices.

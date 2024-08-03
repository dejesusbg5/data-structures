/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class MatrixGraph<E> implements Graph<E> {

    private ArrayList<E> vertices = new ArrayList<>();
    private final int maxLength = 1000;
    private double edges[][] = new double[maxLength][maxLength];

    public MatrixGraph() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if (i != j) {
                    edges[i][j] = INFINITE;
                }
            }
        }
    }

    @Override
    public void addNewVertex(E x) {
        if (length() <= maxLength) {
            vertices.add(x);
        }
    }

    @Override
    public E getVertex(int pos) {
        return vertices.get(pos);
    }

    @Override
    public void addNewEdge(int from, int to, double value) {
        if (0 <= from && from < length()
                && 0 <= to && to < length()
                && from != to) {
            edges[from][to] = value;
        } else {
            throw new UnsupportedOperationException("Error: indices " + from + " or " + to + " out of bounds.");
        }
    }

    @Override
    public double getEdge(int from, int to) {
        if (0 <= from && from < length()
                && 0 <= to && to < length()
                && from != to) {
            return edges[from][to];
        } else {
            throw new UnsupportedOperationException("Error: indices " + from + " or " + to + " out of bounds.");
        }
    }

    @Override
    public int length() {
        return vertices.size();
    }

    @Override
    public ArrayList<E> successors(int index) {
        ArrayList<E> successors = new ArrayList<>();

        if (0 <= index && index < vertices.size()) {
            for (int i = 0; i < edges.length; i++) {
                if (i != index && edges[index][i] != INFINITE) {
                    successors.add(getVertex(i));
                }
            }
        } else {
            throw new UnsupportedOperationException("Error: index " + index + " out of bounds.");
        }

        return successors;
    }

    @Override
    public void removeEdge(int from, int to) {
        if (0 <= from && from < length()
                && 0 <= to && to < length()
                && from != to) {
            edges[from][to] = INFINITE;
        } else {
            throw new UnsupportedOperationException("Error: indices " + from + " or " + to + " out of bounds.");
        }
    }

    @Override
    public String toString() {
        String graph = "";
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                graph += edges[i][j] + ", ";
            }
            graph += " \n";
        }

        return "Vertices = " + vertices.toString() + "\n\n" + graph;
    }

}

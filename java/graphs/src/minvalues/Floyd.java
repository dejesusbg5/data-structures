/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minvalues;

import data.Graph;

/**
 *
 * @author ESTUDIANTE
 */
public class Floyd<E> {

    private int f[][];
    private int r[][];
    private Graph<E> graph;

    public Floyd(Graph<E> graph) {
        this.graph = graph;

        int n = graph.length();
        f = new int[n][n];
        r = new int[n][n];

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                if (i != j) {
                    f[i][j] = (int) graph.getEdge(i, j);
                    r[i][j] = -1;
                }
            }
        }

        minValue();
    }

    private void minValue() {
        for (int k = 0; k < f.length; k++) {
            for (int i = 0; i < f.length; i++) {
                for (int j = 0; j < f.length; j++) {
                    if (f[i][k] + f[k][j] < f[i][j]) {
                        f[i][j] = f[i][k] + f[k][j];
                        r[i][j] = k;
                    }
                }
            }
        }
    }

    public String path(int i, int j) {
        return "Floyd minvalues = [" + path(i, j, r[i][j]) + "]";
    }

    private String path(int i, int j, int k) {
        k = r[i][j];
        return (k != -1)
                ? path(i, k, r[i][j]) + k + " -> " + path(k, j, r[i][j])
                : "";
    }

    @Override
    public String toString() {
        String matrixGraph = "";
        for (int[] row : f) {
            for (int j = 0; j < f.length; j++) {
                matrixGraph += row[j] + ", ";
            }
            matrixGraph += " \n";
        }

        return matrixGraph;
    }
}

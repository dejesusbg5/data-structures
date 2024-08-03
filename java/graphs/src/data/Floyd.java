/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ESTUDIANTE
 */
public class Floyd {

    private int f[][];
    private int r[][];
    private Graph<String> graph;

    public Floyd(Graph<String> graph) {
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
                        f[i][j] = k;
                    }
                }
            }
        }
    }

    public void showPath(int i, int j) {
        int k = r[i][j];
        if (k != -1) {
            showPath(i, k);
            System.out.println(" " + k);
            showPath(k, j);
        }
    }

    @Override
    public String toString() {
        String lis = "";
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                lis += " " + f[i][j];
            }
            lis += "\n";
        }
        return lis;
    }
}

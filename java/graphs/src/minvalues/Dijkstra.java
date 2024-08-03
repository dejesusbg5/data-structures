/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minvalues;

import data.Graph;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author ESTUDIANTE
 */
public class Dijkstra<E> {

    private int d[];
    private HashSet<Integer> s = new HashSet<>();
    private Graph<E> graph;

    public Dijkstra(Graph<E> graph, int from) {
        this.graph = graph;

        d = new int[graph.length()];
        for (int i = 0; i < d.length; i++) {
            if (i != from) {
                d[i] = (int) graph.getEdge(from, i);
            }
        }

        minPath(from);
    }

    public int[] getD() {
        return d;
    }

    private void minPath(int from) {
        s.add(from);

        for (int i = 0; i < d.length; i++) {
            int v = minValue();
            s.add(v);

            for (int w = 0; w < d.length; w++) {
                if (!s.contains(w)) {
                    d[w] = Integer.min(d[w], (int) (d[v] + graph.getEdge(v, w)));
                }
            }
        }
    }

    private int minValue() {
        int minIndex = 0,
                minValue = (int) Graph.INFINITE;

        for (int i = 0; i < d.length; i++) {
            if (!s.contains(i)) {
                if (d[i] < minValue) {
                    minValue = d[i];
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

}

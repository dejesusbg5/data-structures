/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import data.Graph;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Estudiante
 */
public class DepthFirstSearch<E> {

    private HashSet<E> visited = new HashSet<>();

    public String path(Graph<E> g, int pos) {
        visited.clear();
        ArrayList<E> successors = new ArrayList<>();
        return "DFS Path = [" + path(g, pos, successors) + "]";
    }

    private String path(Graph<E> g, int pos, ArrayList<E> successors) {
        visited.add(g.getVertex(pos));
        successors = g.successors(pos);
        
        for (E s : successors) {
            if (!visited.contains(s)) {
                return g.getVertex(pos) + " -> " + path(g, getIndex(g, s), successors);
            }
        }

        return g.getVertex(pos).toString();
    }

    private int getIndex(Graph<E> g, E successors) {
        for (int i = 0; i < g.length(); i++) {
            if (g.getVertex(i).equals(successors)) {
                return i;
            }
        }

        return -1;
    }

}

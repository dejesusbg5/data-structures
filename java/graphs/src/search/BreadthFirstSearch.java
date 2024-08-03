/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import data.Graph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author Estudiante
 */
public class BreadthFirstSearch<E> {

    private HashSet<E> visited = new HashSet<>();
    private LinkedList<E> queue = new LinkedList();

    public String path(Graph<E> g, int pos) {
        queue.clear();
        visited.clear();

        ArrayList<E> successors = new ArrayList<>();
        return "BFS Path = [" + path(g, pos, successors) + "]";
    }

    private String path(Graph<E> g, int pos, ArrayList<E> successors) {
        queue.addLast(g.getVertex(pos));
        visited.add(g.getVertex(pos));

        String path = "";

        while (!queue.isEmpty()) {
            E v = queue.poll();
            successors = g.successors(getIndex(g, v));

            for (E s : successors) {
                if (!visited.contains(s)) {
                    visited.add(s);
                    queue.addLast(s);
                }
            }

            path += v.toString() + " -> ";
        }

        return path;
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

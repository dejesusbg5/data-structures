/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neighbs;

import data.Graph;
import data.MatrixGraph;
import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTE
 */
public class NeighbGraph {

    public Graph<Neighb> create(int n) {
        Graph<Neighb> g = new MatrixGraph<>();

        for (int i = 0; i < n; i++) {
            g.addNewVertex(new Neighb(
                    (int) (Math.random() * n),
                    "Neighb #" + i,
                    (int) (Math.random() * 10000))
            );
        }

        int maxEdges = n * (n - 1);
        for (int i = 0; i < maxEdges; i++) {
            int from = (int) (Math.random() * n),
                    to = (int) (Math.random() * n);

            if (from != to) {
                g.addNewEdge(from, to, (int) (Math.random() * 1000));
            }
        }

        return g;
    }

    public int moreOutputs(Graph<Neighb> g) {
        int max = g.successors(0).size();

        for (int i = 1; i < g.length(); i++) {
            if (g.successors(i).size() > max) {
                max = g.successors(i).size();
            }
        }

        return max;
    }

    public ArrayList<Neighb> neighbMoreOutputs(Graph<Neighb> g) {
        int max = moreOutputs(g);
        ArrayList<Neighb> neighbs = new ArrayList<>();

        for (int i = 0; i < g.length(); i++) {
            if (g.successors(i).size() == max) {
                neighbs.add(g.getVertex(i));
            }
        }

        return neighbs;
    }

    public int getPos(Graph<Neighb> g, String name) {
        for (int i = 0; i < g.length(); i++) {
            if (name.equals(g.getVertex(i).getName())) {
                return i;
            }
        }

        return -1;
    }

    public boolean completeGraph(Graph<Neighb> g) {
        for (int i = 0; i < g.length(); i++) {
            for (int j = 0; j < g.length(); j++) {
                if (i != j && g.getEdge(i, j) == g.INFINITE) {
                    return false;
                }
            }
        }

        return true;
    }

    public void invert(Graph<Neighb> g) {
        for (int i = 0; i < g.length(); i++) {
            for (int j = i + 1; j < g.length(); j++) {
                double temp = g.getEdge(i, j);
                g.removeEdge(i, j);
                g.addNewEdge(i, j, g.getEdge(j, i));
                g.removeEdge(j, i);
                g.addNewEdge(j, i, temp);
            }
        }
    }

    public static void main(String[] args) {
        NeighbGraph ng = new NeighbGraph();
        Graph<Neighb> g = ng.create(7);
        System.out.println(g.toString());
        System.out.println(ng.moreOutputs(g));
        System.out.println(ng.neighbMoreOutputs(g).toString());
        System.out.println(ng.getPos(g, "Neighb #2"));
        System.out.println(ng.completeGraph(g));

        ng.invert(g);
        System.out.println(g.toString());

    }
}

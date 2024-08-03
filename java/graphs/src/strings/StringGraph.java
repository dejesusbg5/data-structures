/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

import minvalues.Dijkstra;
import minvalues.Floyd;
import data.Graph;
import data.MatrixGraph;
import java.util.Arrays;
import search.BreadthFirstSearch;
import search.DepthFirstSearch;

/**
 *
 * @author Estudiante
 */
public class StringGraph {

    public Graph<String> create() {
        Graph<String> g = new MatrixGraph<>();

        g.addNewVertex("A");
        g.addNewVertex("B");
        g.addNewVertex("C");
        g.addNewVertex("D");
        g.addNewVertex("E");

        g.addNewEdge(0, 1, 12);
        g.addNewEdge(0, 3, 87);
        g.addNewEdge(1, 4, 11);
        g.addNewEdge(2, 0, 19);
        g.addNewEdge(3, 1, 23);
        g.addNewEdge(3, 2, 10);
        g.addNewEdge(4, 3, 43);

        return g;
    }

    public static void main(String[] args) {
        StringGraph graph = new StringGraph();
        Graph<String> g = graph.create();
        System.out.println(g.toString());

        Dijkstra<String> d = new Dijkstra<>(g, 0);
        System.out.println("Dijkstra minvalues = " + Arrays.toString(d.getD()) + "");

        Floyd<String> f = new Floyd<>(g);
        System.out.println(f.path(0, 3));
        System.out.println(f.toString());

        DepthFirstSearch<String> dfs = new DepthFirstSearch<>();
        System.out.println(dfs.path(g, 0));
        
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        System.out.println(bfs.path(g, 0));
    }
}

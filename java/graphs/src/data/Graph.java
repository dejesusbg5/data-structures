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
public interface Graph<E> {

//    double INFINITE = Double.POSITIVE_INFINITY;
    double INFINITE = 99999.0;

    void addNewVertex(E x);

    E getVertex(int pos);

    void addNewEdge(int from, int to, double value);

    double getEdge(int from, int to);

    int length();

    ArrayList<E> successors(int index);

    void removeEdge(int from, int to);

    @Override
    String toString();
}

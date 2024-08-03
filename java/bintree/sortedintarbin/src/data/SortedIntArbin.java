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
public class SortedIntArbin {

    private Arbin<Integer> root;

    public int weight() {
        return weight(root);
    }

    private int weight(Arbin<Integer> r) {
        return (r != null) ? (weight(r.getLeft()) + weight(r.getRight()) + 1) : 0;
    }

    public int height() {
        return height(root);
    }

    private int height(Arbin<Integer> r) {
        return (r != null) ? (Math.max(height(r.getLeft()), height(r.getRight())) + 1) : 0;
    }

    public ArrayList<Integer> getLeaves() {
        ArrayList<Integer> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        return leaves;
    }

    private void getLeaves(Arbin<Integer> r, ArrayList<Integer> leaves) {
        if (r != null) {
            if (r.getLeft() == null && r.getRight() == null) {
                leaves.add(r.get());
            }

            getLeaves(r.getLeft(), leaves);
            getLeaves(r.getRight(), leaves);
        }
    }

    public String toString() {
        return "{" + toString(root).substring(0, toString(root).length() - 2) + "}";
    }

    private String toString(Arbin<Integer> r) {
        return (r == null) ? "" : toString(r.getLeft()) + r.get() + ", " + toString(r.getRight());
    }

    public void add(int x) {
        if (root == null) {
            root = new ArbinNode<>(x);
        } else {
            add(root, x);
        }
    }

    private void add(Arbin<Integer> r, int data) {
        if (r.get() < data) {
            if (r.getRight() == null) {
                r.linkRight(new ArbinNode<>(data));
            } else {
                add(r.getRight(), data);
            }
        } else {
            if (r.getLeft() == null) {
                r.linkLeft(new ArbinNode<>(data));
            } else {
                add(r.getLeft(), data);
            }
        }
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(Arbin<Integer> r, int data) {
        return (r == null) ? false
                : (r.get() == data) ? true
                : (r.get() < data) ? contains(r.getRight(), data) : contains(r.getLeft(), data);
    }

    public void remove(int data) {
        if (contains(data)) {
            root = remove(root, data);
        }
    }

    public Arbin<Integer> remove(Arbin<Integer> r, int data) {
        if (r == null) {
            return r;
        } else if (r.get() < data) {
            r.linkRight(remove(r.getRight(), data));
        } else if (r.get() < data) {
            r.linkLeft(remove(r.getLeft(), data));
        } else {
            if (r.getLeft() == null) {
                return r.getRight();
            } else if (r.getRight() == null) {
                return r.getLeft();
            }

            r.set(min(r.getRight()));
            r.linkRight(remove(r.getRight(), r.get()));
        }

        return r;
    }

    private Integer min(Arbin<Integer> r) {
        int min = r.get();

        while (r.getLeft() != null) {
            min = r.getLeft().get();
            r.set(r.getLeft().get());
        }

        return min;
    }

    public static void main(String[] args) {
        SortedIntArbin arbin = new SortedIntArbin();

        arbin.add(6);
        arbin.add(4);
        arbin.add(5);
        arbin.add(2);
        arbin.add(9);
        arbin.add(7);
        arbin.add(11);

        System.out.println("arbol: " + arbin.toString());
        System.out.println("peso: " + arbin.weight());
        System.out.println("altura: " + arbin.height());
        System.out.println("hojas: " + arbin.getLeaves().toString());
    }
}

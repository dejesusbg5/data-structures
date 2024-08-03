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
public class IntArbin {

    public Arbin<Integer> create(int data) {
        Arbin<Integer> root = new ArbinNode<>(data);
        return root;
    }

    public void showPreorder(Arbin<Integer> r) {
        if (r != null) {
            System.out.println(" " + r.get());
            showPreorder(r.getLeft());
            showPreorder(r.getRight());
        }
    }

    public void showPostorder(Arbin<Integer> r) {
        if (r != null) {
            showPreorder(r.getLeft());
            showPreorder(r.getRight());
            System.out.println(" " + r.get());
        }
    }

    public void showInorder(Arbin<Integer> r) {
        if (r != null) {
            showPreorder(r.getLeft());
            System.out.println(" " + r.get());
            showPreorder(r.getRight());
        }
    }

    public int weight(Arbin<Integer> r) {
        return (r != null) ? (weight(r.getLeft()) + weight(r.getRight()) + 1) : 0;
    }

    public int height(Arbin<Integer> r) {
        return (r != null) ? (Math.max(height(r.getLeft()), height(r.getRight())) + 1) : 0;
    }

    public void getLeaves(Arbin<Integer> r, ArrayList<Integer> leaves) {
        if (r != null) {
            if (r.getLeft() == null && r.getRight() == null) {
                leaves.add(r.get());
            }
            
            getLeaves(r.getLeft(), leaves);
            getLeaves(r.getRight(), leaves);
        }
    }

    public static void main(String[] args) {
        IntArbin arbin = new IntArbin();
        Arbin<Integer> root = arbin.create(2);

        root.linkLeft(new ArbinNode<>(7));
        root.getLeft().linkLeft(new ArbinNode<>(2));
        root.getLeft().linkRight(new ArbinNode<>(6));
        root.getLeft().getRight().linkLeft(new ArbinNode<>(5));
        root.getLeft().getRight().linkRight(new ArbinNode<>(11));

        root.linkRight(new ArbinNode<>(5));
        root.getRight().linkRight(new ArbinNode<>(9));
        root.getRight().getRight().linkLeft(new ArbinNode<>(4));

        arbin.showPreorder(root);
        System.out.println("peso: " + arbin.weight(root));
        System.out.println("altura: " + arbin.height(root));

        ArrayList<Integer> leaves = new ArrayList<>();
        arbin.getLeaves(root, leaves);
        System.out.println("hojas: " + leaves.toString());
    }
}

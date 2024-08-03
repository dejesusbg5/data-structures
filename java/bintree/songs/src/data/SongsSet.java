/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTE
 */
public class SongsSet implements Serializable {

    private Arbin<Song> root;

    public int weight() {
        return weight(root);
    }

    private int weight(Arbin<Song> r) {
        return (r != null) ? (weight(r.getLeft()) + weight(r.getRight()) + 1) : 0;
    }

    public int height() {
        return height(root);
    }

    private int height(Arbin<Song> r) {
        return (r != null) ? (Math.max(height(r.getLeft()), height(r.getRight())) + 1) : 0;
    }

    public ArrayList<Song> getLeaves() {
        ArrayList<Song> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        return leaves;
    }

    private void getLeaves(Arbin<Song> r, ArrayList<Song> leaves) {
        if (r != null) {
            if (r.getLeft() == null && r.getRight() == null) {
                leaves.add(r.get());
            }

            getLeaves(r.getLeft(), leaves);
            getLeaves(r.getRight(), leaves);
        }
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Arbin<Song> r) {
        return (r == null) ? "" : toString(r.getLeft()) + r.get() + "\n" + toString(r.getRight());
    }

    public boolean add(Song s) {
        if (root == null) {
            root = new ArbinNode<>(s);
            return true;
        } else if (!contains(s.getName())) {
            add(root, s);
            return true;
        }

        return false;
    }

    private void add(Arbin<Song> r, Song s) {
        if (r.get().getName().compareTo(s.getName()) < 0) {
            if (r.getRight() == null) {
                r.linkRight(new ArbinNode<>(s));
            } else {
                add(r.getRight(), s);
            }
        } else {
            if (r.getLeft() == null) {
                r.linkLeft(new ArbinNode<>(s));
            } else {
                add(r.getLeft(), s);
            }
        }
    }

    public boolean contains(String n) {
        return contains(root, n);
    }

    private boolean contains(Arbin<Song> r, String n) {
        return (r == null) ? false
                : (r.get().getName().equals(n)) ? true
                : (r.get().getName().compareTo(n) < 0) ? contains(r.getRight(), n) : contains(r.getLeft(), n);
    }

    public void remove(String n) {
        if (contains(n)) {
            root = remove(root, n);
        }
    }

    public Arbin<Song> remove(Arbin<Song> r, String n) {
        if (r == null) {
            return r;
        } else if (r.get().getName().compareTo(n) < 0) {
            r.linkRight(remove(r.getRight(), n));
        } else if (r.get().getName().compareTo(n) > 0) {
            r.linkLeft(remove(r.getLeft(), n));
        } else {
            if (r.getLeft() == null) {
                return r.getRight();
            } else if (r.getRight() == null) {
                return r.getLeft();
            }

            r.set(minRightChild(r.getRight()));
            r.linkRight(remove(r.getRight(), r.get().getName()));
        }

        return r;
    }

    private Song minRightChild(Arbin<Song> r) {
        Song min = r.get();

        while (r.getLeft() != null) {
            min = r.getLeft().get();
            r.set(r.getLeft().get());
        }

        return min;
    }

    public Song maxLength() {
        Song max = root.get();
        maxLength(root, max);
        return max;
    }

    private void maxLength(Arbin<Song> r, Song max) {
        if (r != null) {
            if (r.get().getLength() > max.getLength()) {
                max.setName(r.get().getName());
                max.setGenre(r.get().getGenre());
                max.setComposer(r.get().getComposer());
                max.setScore((int) r.get().getScore());
                max.setLength(r.get().getLength());
            }

            maxLength(r.getLeft(), max);
            maxLength(r.getRight(), max);
        }
    }
}

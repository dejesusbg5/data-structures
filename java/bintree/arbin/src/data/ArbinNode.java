/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Estudiante
 */
public class ArbinNode<E> implements Arbin<E> {
    private E data;
    private Arbin<E> l;
    private Arbin<E> r;

    public ArbinNode(E data) {
        this.data = data;
        this.l = null;
        this.r = null;
    }
    
    @Override
    public E get() {
        return data;
    }

    @Override
    public Arbin<E> getLeft() {
        return l;
    }

    @Override
    public Arbin<E> getRight() {
        return r;
    }

    @Override
    public void linkLeft(Arbin<E> r) {
        this.l = r;
    }

    @Override
    public void linkRight(Arbin<E> r) {
        this.r = r;
    }

    @Override
    public void set(E data) {
        this.data = data;
    }
    
}

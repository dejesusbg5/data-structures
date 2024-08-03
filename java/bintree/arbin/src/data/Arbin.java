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
public interface Arbin<E> {
    E get();
    Arbin<E> getLeft();
    Arbin<E> getRight();
    void linkLeft(Arbin <E> r);
    void linkRight(Arbin <E> r);
    void set(E x);
}

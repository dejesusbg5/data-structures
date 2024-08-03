/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Car;
import data.CarList;

/**
 *
 * @author ESTUDIANTE
 */
public class App {

    public static void main(String[] args) {
        CarList list = new CarList();

        list.add(new Car("abc", 2022, 20000));
        list.add(new Car("cde", 2017, 15000));
        list.add(new Car("efg", 2011, 17000));
        list.add(new Car("ghi", 2020, 35000));

        list.bubbleSort();
        System.out.println("Sorted by model (bubbleSort):");
        System.out.println(list.toString());

        list.selectSort();
        System.out.println("Sorted by price (bubbleSort):");
        System.out.println(list.toString());
    }
}

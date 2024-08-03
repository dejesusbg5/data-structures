/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Employee;
import data.EmployeeSet;
import java.util.Scanner;

/**
 *
 * @author ESTUDIANTE
 */
public class Test {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        EmployeeSet s = new EmployeeSet();
        Employee e;

        s.add(new Employee(132, "ASD", 2000, "GER"));
        s.add(new Employee(632, "DSD", 2000, "PRO"));
        s.add(new Employee(432, "CSD", 2000, "SEC"));
        s.add(new Employee(112, "AAD", 2000, "PRO"));
        s.add(new Employee(112, "ABD", 2000, "PRO"));

        s.sortByName();
        System.out.println(s.toString());

////        searches an employee by their code
//        int data;
//        System.out.println("\nIngrese el código a buscar: ");
//        data = kb.nextInt();
//
////        e = s.searchByCode(data);
//        e = s.binarySearchByCode(data);
//        if (e != null) {
//            System.out.println("Código encontrado: " + e.toString());
//        } else {
//            System.out.println("Código no encontrado");
//        }

//        searches an employee by their name
        String name;
        System.out.println("\nIngrese el nombre a buscar: ");
        name = kb.next();

//        e = s.searchByName(name);
//        e = s.nativeBinarySearchByName(name);
        e = s.binarySearchByName(name);
        if (e != null) {
            System.out.println("Nombre encontrado: " + e.toString());
        } else {
            System.out.println("Nombre no encontrado");
        }

////        searches all employees by position.
//        String position;
//        System.out.println("\nIngrese el cargo a buscar: ");
//        position = kb.next();
//
//        EmployeeSet byPosition = s.searchByPosition(position);
//        System.out.println(byPosition.toString());
//        
//        returns a list of all positions.
//        System.out.println(s.getPositions().toString());
    }
}

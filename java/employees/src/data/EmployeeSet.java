/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author ESTUDIANTE
 */
public class EmployeeSet {

    LinkedList<Employee> s;

    public EmployeeSet() {
        s = new LinkedList<>();
    }

    public void add(Employee e) {
        s.add(e);
    }

    public void sort() {
        Collections.sort(s);
    }

    public void sortByName() {
        Collections.sort(s, new SortEmployeeByName());
    }

    @Override
    public String toString() {
        return s.toString();
    }

    public Employee searchByCode(int code) {
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).getCode() == code) {
                return s.get(i);
            }
        }

        return null;
    }

    public Employee searchByName(String name) {
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).getName().equals(name)) {
                return s.get(i);
            }
        }

        return null;
    }

    public EmployeeSet searchByPosition(String pos) {
        EmployeeSet byPosition = new EmployeeSet();

        for (Employee employee : s) {
            if (employee.getPosition().equals(pos)) {
                byPosition.add(employee);
            }
        }

        return byPosition;
    }

    public HashSet<String> getPositions() {
        HashSet<String> positions = new HashSet<>();

        for (Employee employee : s) {
            positions.add(employee.getPosition());
        }

        return positions;
    }

    public Employee binarySearchByCode(int code) {
        int mid, low = 0, high = s.size() - 1;

        while (high >= low) {
            mid = (high + low) / 2;

            if (s.get(mid).getCode() == code) {
                return s.get(mid);
            }

            if (s.get(mid).getCode() > code) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    public Employee nativeBinarySearchByName(String name) {
        int index = Collections.binarySearch(s, new Employee(name), new SortEmployeeByName());
        return (index >= 0) ? s.get(index) : null;
    }

    public Employee binarySearchByName(String name) {
        int mid, low = 0, high = s.size() - 1;

        while (high >= low) {
            mid = (high + low) / 2;

            if (s.get(mid).getName().compareTo(name) == 0) {
                return s.get(mid);
            }

            if (s.get(mid).getName().compareTo(name) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return null;
    }
}

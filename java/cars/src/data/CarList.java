/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTE
 */
public class CarList {

    ArrayList<Car> cars;

    public CarList() {
        cars = new ArrayList<Car>();
    }

    @Override
    public String toString() {
        String carList = "";

        for (Car car : cars) {
            carList += " " + car.toString() + "\n";
        }

        return carList;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void bubbleSort() {
        Car temp;

        for (int i = 0; i < cars.size(); i++) {
            for (int j = 0; j < cars.size() - 1; j++) {
                if (cars.get(j).getModel() > cars.get(j + 1).getModel()) {
                    temp = cars.get(j);
                    cars.set(j, cars.get(j + 1));
                    cars.set(j + 1, temp);
                }
            }
        }
    }

    public void selectSort() {
        Car temp;
        int minIndex;

        for (int i = 0; i < cars.size(); i++) {
            minIndex = i;

            for (int j = i + 1; j < cars.size(); j++) {
                if (cars.get(j).getPrice() < cars.get(minIndex).getPrice()) {
                    minIndex = j;
                }
            }

            temp = cars.get(i);
            cars.set(i, cars.get(minIndex));
            cars.set(minIndex, temp);
        }
    }

    private void __quickSort__(ArrayList<Car> cars, int left, int right) {
        Car pivot = cars.get((left + right) / 2);
        int i = left, j = right;
    }

    public void quickSort() {
        __quickSort__(cars, 0, cars.size());
    }

    public void removebyPlate(String plate) {
        Car carToRemove = null;

        for (Car car : cars) {
            if (car.getPlate().equals(plate)) {
                carToRemove = car;
                break;
            }
        }

        cars.remove(carToRemove);
    }

}

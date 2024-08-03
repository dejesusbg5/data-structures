/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ESTUDIANTE
 */
public class Car {

    String plate;
    int model;
    float price;

    public Car(String plate, int model, float price) {
        this.plate = plate;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", plate=" + plate + ", price=" + price + "]";
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Car;
import data.CarList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class Menu {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        String menuString = "Autos\n"
                + "1. Add\n"
                + "2. Show\n"
                + "3. Sort by model (bubble)\n"
                + "4. Sort by price (select)\n"
                + "5. Sort by plate (quick)\n"
                + "6. Remove by plate\n"
                + "7. Exit\n"
                + "Choose an option:\n";

        CarList list = new CarList();
        int opt;

        exit:
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(menuString));

            switch (opt) {
                case 1:
                    list.add(new Car(
                            JOptionPane.showInputDialog("Input plate:"),
                            Integer.parseInt(JOptionPane.showInputDialog("Input model:")),
                            Float.parseFloat(JOptionPane.showInputDialog("Input price:"))
                    ));

                    JOptionPane.showMessageDialog(null, "Car added sucessfully");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, list.toString());
                    break;

                case 3:
                    list.bubbleSort();
                    JOptionPane.showMessageDialog(null, "Car sorted by model sucessfully");
                    break;

                case 4:
                    list.selectSort();
                    JOptionPane.showMessageDialog(null, "Car sorted by price sucessfully");
                    break;

                case 5:
                    list.quickSort();
                    JOptionPane.showMessageDialog(null, "Car sorted by price sucessfully");
                    break;

                case 6:
                    list.removebyPlate(JOptionPane.showInputDialog("Input plate to remove:"));
                    JOptionPane.showMessageDialog(null, "Car removed sucessfully");
                    break;

                case 7:
                    break exit;
            }
        } while (true);
    }

}

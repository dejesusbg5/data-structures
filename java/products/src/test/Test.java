package test;

import data.Product;
import data.ProductsList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Test {
    public static void main(String[] args) {
        ProductsList l = new ProductsList();
        String message, query;
        int intQuery;
        Product p;

        String menu = "Options:\n"
                + "1. Add a new product\n"
                + "2. Show the list of products\n"
                + "3. Sort by reference\n" // ordenar por referencia (quicksort)
                + "4. Search by name (option 1)\n" // buscar por nombre (binario - algoritmo)
                + "5. Search by name (option 2)\n" // buscar por nombre (binario - java)
                + "6. Sort by name\n" // ordenar por nombre (heapsort)
                + "7. Search by reference\n" // buscar por referencia (lineal)
                + "8. Find all family basket products\n" // hallar los productos de la canasta familiar
                + "9. Find the most expensive product\n" // hallar el producto más caro
                + "10. Sort by price\n" // ordenar por costo (comparator)
                + "11. Exit";

        int option;
        end: do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (option) {
                case 1:
                    JTextField refField = new JTextField(),
                            nameField = new JTextField(),
                            priceField = new JTextField(),
                            familyBasketField = new JTextField();

                    Object[] form = {
                            "Reference:", refField,
                            "Name:", nameField,
                            "Price:", priceField,
                            "Family Basket (true/false)", familyBasketField
                    };

                    JOptionPane.showConfirmDialog(null, form, "Add new product", JOptionPane.OK_CANCEL_OPTION);

                    l.add(new Product(
                            Integer.parseInt(refField.getText()),
                            nameField.getText(),
                            Float.parseFloat(priceField.getText()),
                            Boolean.parseBoolean(familyBasketField.getText())));

                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, new JScrollPane(l.toTable()));
                    break;

                case 3:
                    l.quickSortByRef();
                    JOptionPane.showMessageDialog(null, "Products sorted successfully");
                    break;

                case 4:
                    l.heapSortByName();
                    query = JOptionPane.showInputDialog(null, "Enter name:");
                    p = l.binarySearchByName(query);

                    message = (p != null) ? p.toString() : (query + " not found");
                    JOptionPane.showMessageDialog(null, message);
                    break;

                case 5:
                    l.heapSortByName();
                    query = JOptionPane.showInputDialog(null, "Enter name:");
                    p = l.nativeBinarySearchByName(query);

                    String result = (p != null) ? p.toString() : (query + " not found");
                    JOptionPane.showMessageDialog(null, result);
                    break;

                case 6:
                    l.heapSortByName();
                    JOptionPane.showMessageDialog(null, "Products sorted successfully");
                    break;

                case 7:
                    intQuery = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter reference:"));
                    p = l.linearSearchByRef(intQuery);

                    message = (p != null) ? p.toString() : (intQuery + " not found");
                    JOptionPane.showMessageDialog(null, message);
                    break;

                case 8:
                    JOptionPane.showMessageDialog(null, new JScrollPane(l.getFamilyBasket().toTable()));
                    break;

                case 9:
                    p = l.getMostExpensive();
                    JOptionPane.showMessageDialog(null, p.toString());
                    break;

                case 10:
                    l.comparatorSortByPrice();
                    JOptionPane.showMessageDialog(null, "Products sorted successfully");
                    break;

                case 11:
                    break end;
            }
        } while (true);
    }
}

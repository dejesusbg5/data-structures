package data;

import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JTable;

public class ProductsList {
    private LinkedList<Product> l;

    private void __swap__(LinkedList<Product> list, int i, int j) {
        Product temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private void __quickSortByRef__(LinkedList<Product> list, int left, int right) {
        int pivot = list.get((left + right) / 2).getRef(),
                i = left, j = right;

        while (i < j) {
            while (list.get(i).getRef() < pivot) {
                i++;
            }

            while (list.get(j).getRef() > pivot) {
                j--;
            }

            if (i <= j) {
                __swap__(list, i++, j--);
            }
        }

        if (left < j) {
            __quickSortByRef__(list, left, j);
        }

        if (i < right) {
            __quickSortByRef__(list, i, right);
        }
    }

    private void __heapifyByName__(LinkedList<Product> list, int n, int i) {
        int largest, left = 2 * i + 1, right = left + 1;

        if (left > n) {
            return;
        }

        largest = (right > n || list.get(left).getName().compareTo(list.get(right).getName()) > 0)
                ? left
                : right;

        if (list.get(i).getName().compareTo(list.get(largest).getName()) < 0) {
            __swap__(list, i, largest);
            __heapifyByName__(list, n, largest);
        }
    }

    public ProductsList() {
        l = new LinkedList<>();
    }

    public void add(Product p) {
        l.add(p);
    }

    public void quickSortByRef() {
        __quickSortByRef__(l, 0, l.size() - 1);
    }

    public Product binarySearchByName(String query) {
        int mid, low = 0, high = l.size() - 1;

        while (low < high) {
            mid = (low + high) / 2;

            if (l.get(mid).getName().compareTo(query) == 0) {
                return l.get(mid);
            } else if (l.get(mid).getName().compareTo(query) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    public Product nativeBinarySearchByName(String query) {
        int i = Collections.binarySearch(l, new Product(query), new SortProductsByName());
        return (i >= 0) ? l.get(i) : null;
    }

    public void heapSortByName() {
        for (int i = l.size() / 2; i >= 0; i--) {
            __heapifyByName__(l, l.size() - 1, i);
        }

        for (int i = l.size() - 1; i >= 0; i--) {
            __swap__(l, 0, i);
            __heapifyByName__(l, i - 1, 0);
        }
    }

    public Product linearSearchByRef(int query) {
        for (Product p : l) {
            if (p.getRef() == query) {
                return p;
            }
        }

        return null;
    }

    public ProductsList getFamilyBasket() {
        ProductsList familyBasket = new ProductsList();

        for (Product p : l) {
            if (p.isFamilyBasket()) {
                familyBasket.add(p);
            }
        }

        return familyBasket;
    }

    public Product getMostExpensive() {
        Product mostExpensive = l.get(0);

        for (Product p : l) {
            if (p.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = p;
            }
        }

        return mostExpensive;
    }

    public void comparatorSortByPrice() {
        Collections.sort(l, new SortProductsByPrice());
    }

    public JTable toTable() {
        String[] cols = { "#", "Name", "Price", "Family Basket" };
        String[][] data = new String[l.size()][4];

        for (int i = 0; i < data.length; i++) {
            Product p = l.get(i);

            data[i][0] = String.valueOf(p.getRef());
            data[i][1] = p.getName();
            data[i][2] = "$" + String.valueOf(p.getPrice());
            data[i][3] = String.valueOf(p.isFamilyBasket());
        }

        return new JTable(data, cols);
    }

    @Override
    public String toString() {
        return l.toString();
    }
}

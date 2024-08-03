package data;

import java.util.Comparator;

public class SortProductsByName implements Comparator<Product>{
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

package data;

public class Product implements Comparable<Product> {
    private int ref;
    private String name;
    private float price;
    private boolean familyBasket;

    public Product(int ref, String name, float price, boolean familyBasket) {
        this.ref = ref;
        this.name = name;
        this.price = price;
        this.familyBasket = familyBasket;
    }

    public Product(String query) {
        this.name = query;
    }

    @Override
    public String toString() {
        return "Product [ref=" + ref + ", name=" + name + ", price=" + price + ", isFamilyBasket="
                + familyBasket + "]";
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isFamilyBasket() {
        return familyBasket;
    }

    public void setFamilyBasket(boolean familyBasket) {
        this.familyBasket = familyBasket;
    }

    @Override
    public int compareTo(Product p) {
        return (int) (this.price - p.getPrice());
    }
}

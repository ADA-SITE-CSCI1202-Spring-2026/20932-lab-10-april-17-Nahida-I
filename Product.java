import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Product{
    String name;
    double price;
    boolean inStock;

    public Product(String name, double price, boolean inStock){
        this.name = name;
        this.price = price;
        this.inStock = inStock; 
    }
    public String toString() {
        return name + " - $" + price + " - " + (inStock ? "In Stock" : "Out of Stock");
    }

    public static void main(String[] args){
        
        List<Product> products = new ArrayList<>();
        products.add(new Product("Mouse", 25, true));
        products.add(new Product("Keyboard", 45, false));
        products.add(new Product("Headphones", 40, true));
        products.add(new Product("Monitor", 200, true));

        Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

        products.removeIf(p -> !isAffordable.test(p));
        for (Product p : products) {
            System.out.println(p);
        }
    }

}
package JAVA_LANG.vending_machine;

import java.util.ArrayList;
import java.util.List;

public abstract class VendingMachine {

    protected List<Product> products;

    public VendingMachine() {
        this.products = new ArrayList<>();
    }

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public abstract void addProducts (List<Product> products);

    public Product getProduct(String name) {

//        products.stream().filter(product -> product.getName().equals(name)).findFirst().orElse(null);

        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                return product;
            }
        }

        System.out.println("No such product: " + name);
        return null;
    }



//    public Product getProduct(String name) {
//
//        for (Product product : products) {
//            if (product.getName().equals(name)) {
//                products.remove(product);
//                return product;
//            }
//        }
//
//        throw new RuntimeException("No such product: " + name);
//    }

    public List<Product> getProducts() {
        return products;
    }
}

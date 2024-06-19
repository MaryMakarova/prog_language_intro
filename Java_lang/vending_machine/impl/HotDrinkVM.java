package JAVA_LANG.vending_machine.impl;

import JAVA_LANG.vending_machine.Product;
import JAVA_LANG.vending_machine.VendingMachine;

import java.util.List;

public class HotDrinkVM extends VendingMachine {

    public HotDrinkVM() {
        super();
    }

    public HotDrinkVM(List<Product> products) {
        super(products);
    }

    @Override
    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public Product getProduct(String name, int volume, int temperature) {
        for (Product product : products) {
            if (product instanceof HotDrink) {
                if (product.getName().equals(name) && ((HotDrink) product).getTemperature() == temperature) {
                    products.remove(product);
                    return product;
                }
            }
        }

        System.out.println("No such hot drink: " + name);
        return null;
    }
}

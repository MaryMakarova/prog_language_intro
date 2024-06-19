package JAVA_LANG.vending_machine;

import JAVA_LANG.vending_machine.impl.BottleOfWater;
import JAVA_LANG.vending_machine.impl.HotDrink;
import JAVA_LANG.vending_machine.impl.EPackage;
import JAVA_LANG.vending_machine.impl.HotDrinkVM;
import JAVA_LANG.vending_machine.impl.WaterVendingMachine;
import JAVA_LANG.vending_machine.impl.HotDrink;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductMain {

    public static void main(String[] args) {
        Product bottle1 = new BottleOfWater("Родники", 55, LocalDate.of(2024, 5, 1));

        Product bottle2 = new BottleOfWater("Родники Газированная", 55, LocalDate.of(2024, 5, 1),
                true, EPackage.GLASS.getMaterial(), 0.5F);

        VendingMachine vm = new WaterVendingMachine();

        VendingMachine vm1 = new HotDrinkVM();

        System.out.println(vm.getProducts());

        //vm.addProducts(List.of(bottle1, bottle1, bottle1, bottle2, bottle2, bottle2));

        //vm1.addProducts(new ArrayList<>());

        //System.out.println(vm.getProducts());

        //vm.getProduct("Родники");

        //System.out.println(vm.getProducts());

        // Создание нескольких горячих напитков
        HotDrink coffee = new HotDrink("Coffee", 2.5, LocalDate.now(), 80);
        HotDrink tea = new HotDrink("Tea", 2.0, LocalDate.now(), 85);

        // Создание вендинговых машин
        HotDrinkVM hotDrinkVM1 = new HotDrinkVM();
        HotDrinkVM hotDrinkVM2 = new HotDrinkVM(Arrays.asList(coffee));

        // Добавление продуктов в вендинговые машины
        hotDrinkVM1.addProducts(Arrays.asList(coffee, tea));

        System.out.println(hotDrinkVM1.getProducts());
        System.out.println(hotDrinkVM2.getProducts());

        // Получение продукта
        Product product1 = hotDrinkVM1.getProduct("Coffee", 250, 80);
        System.out.println("Got product: " + product1);

        Product product2 = hotDrinkVM2.getProduct("Tea", 250, 85);
        System.out.println("Got product: " + product2);
    }
}

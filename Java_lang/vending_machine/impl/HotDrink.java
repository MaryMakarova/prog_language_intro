package JAVA_LANG.vending_machine.impl;

import JAVA_LANG.vending_machine.Product;

import java.time.LocalDate;

public class HotDrink extends Product {

    private int temperature;

    public HotDrink(String name, double price, LocalDate releaseDate, int temperature) {
        super(name, price, releaseDate);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", temperature=" + temperature +
                '}';
    }
}
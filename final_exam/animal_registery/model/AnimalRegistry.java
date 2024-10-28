package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalRegistry {
    List<Animal> animals = new ArrayList<>();

    public void registerAnimals() {
        animals.add(new Dog(1, "Мухтар", LocalDate.of(2019, 2, 10), new ArrayList<>(Arrays.asList("Fetch", "Guard", "Hunt"))));
        animals.add(new Dog(2, "Балка", LocalDate.of(2018, 6, 15), new ArrayList<>(Arrays.asList("Play", "Bark", "Meow"))));
        animals.add(new Dog(3, "Барбос", LocalDate.of(2020, 1, 5), new ArrayList<>(Arrays.asList("Run on wheel", "Burrow", "Climb"))));
        animals.add(new Cat(4, "Матроскин", LocalDate.of(2017, 4, 25), new ArrayList<>(Arrays.asList("Gallop", "Carry load", "Pull cart"))));
        animals.add(new Cat(5, "Барсик", LocalDate.of(2016, 7, 10), new ArrayList<>(Arrays.asList("Fetch", "Guard", "Hunt"))));
        animals.add(new Cat(6, "Мурзик", LocalDate.of(2020, 3, 17), new ArrayList<>(Arrays.asList("Play", "Bark", "Meow"))));
        animals.add(new Hamster(7, "Пушистик", LocalDate.of(2021, 1, 3), new ArrayList<>(Arrays.asList("Run on wheel", "Burrow", "Climb"))));
        animals.add(new Hamster(8, "Шарик", LocalDate.of(2022, 2, 14), new ArrayList<>(Arrays.asList("Gallop", "Carry load", "Pull cart"))));
        animals.add(new Hamster(9, "Крошка", LocalDate.of(2020, 11, 20), new ArrayList<>(Arrays.asList("Fetch", "Guard", "Hunt"))));
        animals.add(new Horse(10, "Буцефал", LocalDate.of(2015, 8, 20), new ArrayList<>(Arrays.asList("Play", "Bark", "Meow"))));
        animals.add(new Horse(11, "Пегас", LocalDate.of(2016, 6, 10), new ArrayList<>(Arrays.asList("Run on wheel", "Burrow", "Climb"))));
        animals.add(new Horse(12, "Цезарь", LocalDate.of(2017, 3, 15), new ArrayList<>(Arrays.asList("Gallop", "Carry load", "Pull cart"))));
        animals.add(new Donkey(13, "Иа-Иа", LocalDate.of(2019, 8, 12), new ArrayList<>(Arrays.asList("Fetch", "Guard", "Hunt"))));
        animals.add(new Donkey(14, "Пиноккио", LocalDate.of(2020, 5, 5), new ArrayList<>(Arrays.asList("Play", "Bark", "Meow"))));
        animals.add(new Donkey(15, "Сивка-Бурка", LocalDate.of(2021, 2, 20), new ArrayList<>(Arrays.asList("Run on wheel", "Burrow", "Climb"))));
        animals.add(new Camel(16, "Буратино", LocalDate.of(2019, 8, 12), new ArrayList<>(Arrays.asList("Gallop", "Carry load", "Pull cart"))));
        animals.add(new Camel(17, "Али-Баба", LocalDate.of(2020, 5, 5), new ArrayList<>(Arrays.asList("Fetch", "Guard", "Hunt"))));
        animals.add(new Camel(18, "Каспер", LocalDate.of(2021, 2, 20), new ArrayList<>(Arrays.asList("Play", "Bark", "Meow"))));
    }

    public Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

}
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.*;
import controller.*;
   

class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AnimalRegistry registry = new AnimalRegistry();

    public static void main(String[] args) {
        registry.registerAnimals();

        while (true) {
            System.out.println("\n1. Просмотреть команды животного");
            System.out.println("2. Обучить животное новой команде");
            System.out.println("3. Добавить новое животное");
            System.out.println("4. Выход");

            System.out.print("\nВыберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    displayAnimalCommands();
                    break;
                case 2:
                    teachAnimalNewCommand();
                    break;
                case 3:
                    addAnimal();
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
            }
        }
    }

    private static void displayAnimalCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = registry.getAnimalByName(name);
        if (animal != null) {
            AnimalController controller = new AnimalController(animal);
            controller.displayCommands();
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private static void teachAnimalNewCommand() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = registry.getAnimalByName(name);
        if (animal != null) {
            System.out.print("Введите новую команду: ");
            String command = scanner.nextLine();
            AnimalController controller = new AnimalController(animal);
            controller.teachNewCommand(command);
        } else {
            System.out.println("Животное не найдено.");
        }
    }

private static void addAnimal() {
    try (Counter counter = new Counter()) {
        System.out.print("Введите вид животного: ");
        String type = scanner.nextLine();
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения животного (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Введите команды, разделенные запятой: ");
        String commands = scanner.nextLine();
        List<String> commandList = new ArrayList<>(Arrays.asList(commands.split(",")));

        Animal animal;
        switch (type.toLowerCase()) {
            case "dog":
                animal = new Dog(registry.getAnimals().size() + 1, name, LocalDate.parse(birthDate), commandList);
                break;
            case "cat":
                animal = new Cat(registry.getAnimals().size() + 1, name, LocalDate.parse(birthDate), commandList);
                break;
            case "camel":
                animal = new Camel(registry.getAnimals().size() + 1, name, LocalDate.parse(birthDate), commandList);
                break;
            case "donkey":
                animal = new Donkey(registry.getAnimals().size() + 1, name, LocalDate.parse(birthDate), commandList);
                break;
            case "hamster":
                animal = new Hamster(registry.getAnimals().size() + 1, name, LocalDate.parse(birthDate), commandList);
                break;  
            case "horse":
                animal = new Horse(registry.getAnimals().size() + 1, name, LocalDate.parse(birthDate), commandList);
                break;          
            default:
                System.out.println("Введен некорректный вид животного. Пожалуйста, попробуйте снова.");
                return;
        }
        registry.addAnimal(animal);
        counter.add(); // Увеличиваем счетчик
        System.out.println("Животное успешно добавлено! Количество добавленных животных: " + counter.getCount());
    } // Здесь counter автоматически закрывается
}
}
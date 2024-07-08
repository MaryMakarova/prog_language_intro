package design_patterns;

import java.util.Scanner;

import design_patterns.controller.CalculatorController;
import design_patterns.view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorView view = new CalculatorView(scanner);
        CalculatorController controller = new CalculatorController(view);
        controller.calculateFromUserInput();
        scanner.close();
    }    

}

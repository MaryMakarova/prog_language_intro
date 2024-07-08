package design_patterns.view;

import java.util.Scanner;
import design_patterns.model.ComplexNumber;

public class CalculatorView {
    private Scanner scanner;

    public CalculatorView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printCalculation(String operation, ComplexNumber result) {
        System.out.println(operation + " result: " + result.getReal() + " + " + result.getImaginary() + "i");
    }

    public Object[] start() {
        System.out.print("Enter real part of the first complex number: ");
        double real1 = scanner.nextDouble();

        System.out.print("Enter imaginary part of the first complex number: ");
        double imaginary1 = scanner.nextDouble();

        System.out.print("Enter real part of the second complex number: ");
        double real2 = scanner.nextDouble();

        System.out.print("Enter imaginary part of the second complex number: ");
        double imaginary2 = scanner.nextDouble();

        System.out.print("Enter operation (+, *, /): ");
        String operation = scanner.next();

        return new Object[]{new ComplexNumber(real1, imaginary1), new ComplexNumber(real2, imaginary2), operation};
    }
}

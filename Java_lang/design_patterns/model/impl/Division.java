package design_patterns.model.impl;

import design_patterns.model.ComplexNumber;
import design_patterns.model.Operationable;

public class Division implements Operationable {

    @Override
    public ComplexNumber perform(ComplexNumber number1, ComplexNumber number2) {
        double real = (number1.getReal() * number2.getReal() + number1.getImaginary() * number2.getImaginary()) /
                (Math.pow(number2.getReal(), 2) + Math.pow(number2.getImaginary(), 2));
        double imaginary = (number2.getReal() * number1.getImaginary() - number1.getReal() * number2.getImaginary()) /
                (Math.pow(number2.getReal(), 2) + Math.pow(number2.getImaginary(), 2));
        return new ComplexNumber(real, imaginary);
    }
}

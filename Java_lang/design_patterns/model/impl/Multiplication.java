package design_patterns.model.impl;

import design_patterns.model.ComplexNumber;
import design_patterns.model.Operationable;

public class Multiplication implements Operationable {

    @Override
    public ComplexNumber perform(ComplexNumber number1, ComplexNumber number2) {
        double real = number1.getReal() * number2.getReal() - number1.getImaginary() * number2.getImaginary();
        double imaginary = number1.getReal() * number2.getImaginary() + number1.getImaginary() * number2.getReal();
        return new ComplexNumber(real, imaginary);
    }

}

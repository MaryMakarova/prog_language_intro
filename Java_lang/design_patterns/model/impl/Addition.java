package design_patterns.model.impl;

import design_patterns.model.ComplexNumber;
import design_patterns.model.Operationable;

public class Addition implements Operationable {

    @Override
    public ComplexNumber perform(ComplexNumber number1, ComplexNumber number2) {
        double real = number1.getReal() + number2.getReal();
        double imaginary = number1.getImaginary() + number2.getImaginary();
        return new ComplexNumber(real, imaginary);
    }
}

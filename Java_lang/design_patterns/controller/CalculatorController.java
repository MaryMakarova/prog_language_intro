package design_patterns.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import design_patterns.model.ComplexNumber;
import design_patterns.model.Operationable;
import design_patterns.model.impl.Addition;
import design_patterns.model.impl.Division;
import design_patterns.model.impl.Multiplication;
import design_patterns.view.CalculatorView;

public class CalculatorController {
    private static final Logger logger = Logger.getLogger(CalculatorController.class.getName());

    private CalculatorView view;
    private Map<String, Operationable> operations;

    public CalculatorController(CalculatorView view) {
        this.view = view;
        this.operations = new HashMap<>();
        operations.put("+", new Addition());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public void calculateFromUserInput() {
        Object[] inputs = view.start();
        ComplexNumber number1 = (ComplexNumber)inputs[0];
        ComplexNumber number2 = (ComplexNumber)inputs[1];
        String operationSymbol = (String)inputs[2];
        
        Operationable operation = operations.get(operationSymbol);
        
        if (operation != null) {
            calculate(operation, number1, number2, operationSymbol);
        } else {
            System.out.println("Unknown operation: " + operationSymbol);
        }
    }

    private void calculate(Operationable operation, ComplexNumber number1, ComplexNumber number2, String operationName) {
        ComplexNumber result = operation.perform(number1, number2);
        logger.info(operationName + " performed. Result: " + result.getReal() + " + " + result.getImaginary() + "i");
        view.printCalculation(operationName, result);
    }
}

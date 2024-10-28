package controller;

import model.Animal;


public class AnimalController {
    private Animal model;

    public AnimalController(Animal model) {
        this.model = model;
    }

    public void displayCommands(){
        model.displayCommands();
    }

    public void teachNewCommand(String command){
        model.teachNewCommand(command);
    }
}
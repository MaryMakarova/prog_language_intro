package model;

import java.time.LocalDate;
import java.util.List;

 public class Horse extends DraughtAnimal {
    public Horse(int id, String name, LocalDate birth_date, List<String> skills) {
        super(id, name, birth_date, skills);
    }

    @Override
    public void displayCommands() {
        System.out.println("Commands for " + this.name + ": " + this.getSkills());
    }

    @Override
    public void teachNewCommand(String command) {
        this.skills.add(command);
        System.out.println(this.name + " has learned a new command: " + command);
    }
}
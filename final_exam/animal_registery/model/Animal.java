package model;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public abstract class Animal {
    int id;
    String name;
    LocalDate birth_date;
    List<String> skills;

    Animal(int id, String name, LocalDate birth_date, List<String> skills) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getSkills() {
        return String.join(", ", skills);
    }

    public void setSkills(String updatedSkills) {
        this.skills = Arrays.asList(updatedSkills.split(", "));
    }

    public abstract void displayCommands();

    public abstract void teachNewCommand(String command);
}

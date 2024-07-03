package mvc_students_and_teachers.model.impl;

import java.util.ArrayList;
import java.util.List;

import mvc_students_and_teachers.model.User;

public class Teacher extends User {

    private final List<Integer> groups = new ArrayList<>();
    private final String specialty;
    
    public Teacher(int id, String name, String lastName, String specialty) {
        super(id, name, lastName);
        this.specialty = specialty;
    }

    public List<Integer> getGroups() {
        return groups;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + ": id = %s, name = %s, lastName = %s, groups = %s, specialty = %s", id, name, lastName, groups, specialty);
    }

}

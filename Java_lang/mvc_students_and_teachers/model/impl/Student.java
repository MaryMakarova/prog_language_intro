package mvc_students_and_teachers.model.impl;

import mvc_students_and_teachers.model.User;

public class Student extends User {

    int groupId;

    public Student(int id, String name, String lastName, int groupId) {
        super(id, name, lastName);
        this.groupId = groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}

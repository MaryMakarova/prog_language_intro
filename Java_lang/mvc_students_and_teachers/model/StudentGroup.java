package mvc_students_and_teachers.model;

import java.util.List;

import mvc_students_and_teachers.model.impl.Student;
import mvc_students_and_teachers.model.impl.Teacher;

public class StudentGroup {
    private int id;
    private Teacher teacher;
    private List<Student> students;

    public StudentGroup(int id, Teacher teacher, List<Student> students) {
        this.id = id;
        this.teacher = teacher;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}

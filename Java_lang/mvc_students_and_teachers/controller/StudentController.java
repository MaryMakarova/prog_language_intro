package mvc_students_and_teachers.controller;

import java.util.List;

import mvc_students_and_teachers.model.impl.Student;
import mvc_students_and_teachers.service.StudentService;

public class StudentController {
    private StudentService service = new StudentService();

    public Student createStudent(String name, String lastName, int idgroup) {
        return service.createStudent(name, lastName, idgroup);

    }

    public Student getById(int id) {

        Student student = null;
        try {
            student = service.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
}

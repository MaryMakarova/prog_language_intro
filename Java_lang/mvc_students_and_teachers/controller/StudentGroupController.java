package mvc_students_and_teachers.controller;

import java.util.List;

import mvc_students_and_teachers.model.StudentGroup;
import mvc_students_and_teachers.model.impl.Student;
import mvc_students_and_teachers.model.impl.Teacher;
import mvc_students_and_teachers.service.StudentGroupService;

public class StudentGroupController {
    private StudentGroupService studentGroupService = new StudentGroupService();

    public StudentGroup createStudentGroup(Teacher teacher, List<Student> students) {
        return studentGroupService.createStudentGroup(teacher, students);
    }

    public StudentGroup getById(int id) {

        StudentGroup studentGroup = null;
        try {
            studentGroup = studentGroupService.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return studentGroup;
    }

}

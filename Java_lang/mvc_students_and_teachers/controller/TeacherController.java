package mvc_students_and_teachers.controller;

import java.util.List;

import mvc_students_and_teachers.model.impl.Teacher;
import mvc_students_and_teachers.service.TeacherService;


public class TeacherController {
    private TeacherService service = new TeacherService();

    public Teacher createTeacher(String name, String lastName, String speciality){
        return service.createTeacher(name, lastName, speciality);
    }

     public Teacher getById(int id) {

        Teacher teacher = null;
        try {
            teacher = service.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }
    
    public void addGroupToTeacher(Teacher teacher, int groupId) {
        service.addGroupId(teacher, groupId);
    }
}

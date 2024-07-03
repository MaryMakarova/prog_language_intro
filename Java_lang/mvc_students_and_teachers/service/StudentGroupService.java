package mvc_students_and_teachers.service;

import java.util.List;

import mvc_students_and_teachers.controller.TeacherController;
import mvc_students_and_teachers.model.StudentGroup;
import mvc_students_and_teachers.model.DataBase.DataBase;
import mvc_students_and_teachers.model.impl.Student;
import mvc_students_and_teachers.model.impl.Teacher;

public class StudentGroupService {
    public StudentGroup createStudentGroup(Teacher teacher, List<Student> students) {
        final TeacherController teacherController = new TeacherController();
        int id = DataBase.groupCounter++;
        
        StudentGroup studentGroup = new StudentGroup(id, teacher, students);

        teacherController.addGroupToTeacher(teacher, id);
        for (Student student : students) {
            student.setGroupId(id);
        }
        DataBase.studentGroupsDB.add(studentGroup);
        return studentGroup;
        
    }

    public StudentGroup getById(int id) throws Exception {
        StudentGroup studentGroup = DataBase.studentGroupsDB
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        if (studentGroup == null) {
            throw new Exception("Группа не найдена");
        }
        return studentGroup;
    }

}

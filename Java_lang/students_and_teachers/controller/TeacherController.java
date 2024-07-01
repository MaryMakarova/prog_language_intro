package students_and_teachers.controller;

import students_and_teachers.model.Teacher;
import students_and_teachers.service.TeacherService;
import students_and_teachers.view.TeacherView;

import java.time.LocalDate;
import java.util.List;

public class TeacherController implements UserController<Teacher> {

    private final TeacherService teacherService = new TeacherService();
    private final TeacherView teacherView = new TeacherView();

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        teacherService.create(firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(teacherService.getAll());
    }

    public void edit(Teacher teacher, String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        teacher.setFirstName(firstName);
        teacher.setSecondName(secondName);
        teacher.setPatronymic(patronymic);
        teacher.setDateOfBirth(dateOfBirth);
        teacherView.sendOnConsole(teacherService.getAll());
    }

    public void getAllTeachers() {
        teacherView.sendOnConsole(teacherService.getAll());
    }

    public List<Teacher> getAll() {
        return teacherService.getAll();
    }
}

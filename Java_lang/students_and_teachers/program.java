package students_and_teachers;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import students_and_teachers.controller.TeacherController;
import students_and_teachers.model.Student;
import students_and_teachers.model.Teacher;
import students_and_teachers.view.StudentView;
import students_and_teachers.view.TeacherView;

public class program {
    public static void main(String[] args) {
        // final List<Student> students = new ArrayList<>();
        // students.add(new Student("Евгений", "Онегин", "Александрович", LocalDate.of(1795, Month.MAY, 9), 1L));
        // students.add(new Student("Татьяна", "Ларина", "Дмитриевна", LocalDate.of(1803, Month.MARCH, 1), 2L));

        // StudentView studentView = new StudentView();
        // studentView.sendOnConsole(students);

        TeacherController teacherController = new TeacherController();

        teacherController.create("Евгений", "Онегин", "Александрович", LocalDate.of(1799, Month.MAY, 9));
        //teacherController.create("Татьяна", "Ларина", "Дмитриевна", LocalDate.of(1803, Month.MARCH, 1));
 
        Teacher oneign = teacherController.getAll().get(0);
        teacherController.edit(oneign, oneign.getFirstName(), oneign.getSecondName(), oneign.getPatronymic(), LocalDate.of(1785, Month.MAY, 9));
        
    }

}

package mvc_students_and_teachers.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mvc_students_and_teachers.controller.StudentController;
import mvc_students_and_teachers.controller.StudentGroupController;
import mvc_students_and_teachers.controller.TeacherController;
import mvc_students_and_teachers.model.StudentGroup;
import mvc_students_and_teachers.model.DataBase.DataBase;
import mvc_students_and_teachers.model.impl.Student;
import mvc_students_and_teachers.model.impl.Teacher;

public class StudentGroupView {
   private StudentGroupController studentGroupController = new StudentGroupController();
    private TeacherController teacherController = new TeacherController();
    private StudentController studentController = new StudentController();
    

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать группу студентов");
            System.out.println("2 - найти группу по id");
            System.out.println("3 - выход");

            switch (scanner.nextInt()) {
                case 1 -> createStudentGroup();
                case 2 -> getStudentGroupById();
                case 3 -> System.exit(0);
                default -> System.out.println("Операция не поддерживается");
            }
        }
    }

    private void createStudentGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id преподавателя:");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        System.out.println("Введите id студентов через запятую:");
        String[] studentIds = scanner.nextLine().split(", ");
        Teacher teacher = teacherController.getById(teacherId);
        List<Student> students = new ArrayList<>();
        for (String id : studentIds) {
            Student student = studentController.getById(Integer.parseInt(id.trim()));
            if (student != null) {
                students.add(student);
            }
        }
        StudentGroup studentGroup = studentGroupController.createStudentGroup(teacher, students);
        System.out.println("Создана группа студентов: " + studentGroup);
    }

    private StudentGroup getStudentGroupById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id группы: ");
        int id = scanner.nextInt();
        StudentGroup studentGroup = studentGroupController.getById(id);
        System.out.println(studentGroup);
        return studentGroup;
    };

}

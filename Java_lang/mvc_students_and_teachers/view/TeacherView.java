package mvc_students_and_teachers.view;

import java.util.List;
import java.util.Scanner;

import mvc_students_and_teachers.controller.TeacherController;
import mvc_students_and_teachers.model.DataBase.DataBase;
import mvc_students_and_teachers.model.impl.Teacher;

public class TeacherView {
    private TeacherController controller = new TeacherController();

    public void start() {
        DataBase.fillDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать преподавателя");
            System.out.println("2 - найти преподавателя по id");
            System.out.println("3 - распечатать информацию о всех преподавателях");
            System.out.println("4 - добавить преподавателю группу");
            System.out.println("5 - выход");

            switch (scanner.nextInt()) {
                case 1 -> createTeacher();
                case 2 -> getById();
                case 3 -> getAllTeachers();
                case 4 -> addGroupToTeacher();
                case 5 -> System.exit(0);// выход из приложения

                default -> System.out.println("Операция не поддерживается");
            }
        }

    }

    private Teacher createTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();
        System.out.println("Введите специальность:");
        String speciality = scanner.nextLine();
        Teacher teacher = controller.createTeacher(name, lastName, speciality);
        System.out.println(teacher);
        return teacher;

    };

    private Teacher getById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id преподавателя: ");
        int id = scanner.nextInt();
        Teacher teacher = controller.getById(id);
        System.out.println(teacher);
        return teacher;
    };

    private List<Teacher> getAllTeachers() {
        List<Teacher> teachers = controller.getAllTeachers();
        System.out.println(teachers);
        return teachers;
    };

    private void addGroupToTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id преподавателя:");
        int teacherId = scanner.nextInt();
        System.out.println("Введите номер группы:");
        int groupId = scanner.nextInt();
        Teacher teacher = controller.getById(teacherId);
        if (teacher != null) {
            controller.addGroupToTeacher(teacher, groupId);
            System.out.println(teacher);
        } else {
            System.out.println("Преподаватель с таким id не найден");
        }

    }
}

package mvc_students_and_teachers.model.DataBase;

import java.util.ArrayList;
import java.util.List;

import mvc_students_and_teachers.model.StudentGroup;
import mvc_students_and_teachers.model.impl.Student;
import mvc_students_and_teachers.model.impl.Teacher;
import mvc_students_and_teachers.service.TeacherService;


//симулирует базу данных
public class DataBase {
    public static final List<Student> studentsDB = new ArrayList<>();
    public static final List<Teacher> teachersDB = new ArrayList<>();
    public static final List<StudentGroup> studentGroupsDB = new ArrayList<>();
    private static final TeacherService teacherService = new TeacherService();
    public static int groupCounter = 1;

    public static void fillDB() {
        Teacher pushkin = new Teacher(1, "Александр", "Пушкин", "Филология");
        //teacherService.addGroupId(pushkin, 1);
        //teacherService.addGroupId(pushkin, 2);
        teachersDB.add(pushkin);
        Teacher chaadaev = new Teacher(2, "Петр", "Чаадаев", "Политология");
        //teacherService.addGroupId(chaadaev, 3);
        teachersDB.add(chaadaev);
        Student onegin = new Student(1, "Евгений", "Онегин", 0);
        Student lensky = new Student(2, "Владимир", "Ленский", 0);
        Student larinat = new Student (3, "Татьяна", "Ларина", 0);
        Student larinao = new Student (4, "Ольга", "Ларина", 0);
        studentsDB.add(onegin);
        studentsDB.add(lensky);
        studentsDB.add(larinat);
        studentsDB.add(larinao);
    }
}

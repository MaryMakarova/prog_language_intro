package mvc_students_and_teachers.service;

import java.util.List;

import mvc_students_and_teachers.model.DataBase.DataBase;
import mvc_students_and_teachers.model.impl.Teacher;

public class TeacherService {
    public Teacher createTeacher(String name, String lastName, String speciality){
        int id;
        int size = DataBase.teachersDB.size();
        // id = size + 1;
        if(size == 0){
            id = 1;
        } else {
            id = size + 1;
        }
        Teacher teacher = new Teacher(id, name, lastName, speciality);
        DataBase.teachersDB.add(teacher);
        return teacher;
    }

    public void addGroupId(Teacher teacher, int id) {
        teacher.getGroups().add(id);
    }

    public Teacher getById(int id) throws Exception {
        Teacher teacher = DataBase.teachersDB
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        if (teacher == null) {
            throw new Exception("Преподаватель не найден");//выбрасываем проверяемое исключение, которое компилятор требует отработать
        }
        return teacher;
    }

    public List<Teacher> getAllTeachers(){
        return DataBase.teachersDB;
    }

}

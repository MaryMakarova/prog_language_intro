package students;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

import students.group.StudentGroup;
import students.intake.Intake;
import students.intake.IntakeService;
import students.students.Student;

public class Main {
    public static void main(String[] args) {

        Student onegin = new Student("Евгений Александрович Онегин", 4);
        Student larinat = new Student("Татьяна Дмитриевна Ларина", 1);
        Student lensky = new Student("Владимир Вячеславович Ленский", 2);
        Student chaadaev = new Student("Петр Яковлевич Чаадаев", 3);
        Student larinao = new Student ("Ольга Дмитриевна Ларина", 5);
        Student larinap = new Student ("Прасковья Ларина", 6);
        Student larind = new Student ("Дмитрий Ларин", 7);


        StudentGroup studentGroup1 = new StudentGroup();
        StudentGroup studentGroup2 = new StudentGroup();
        StudentGroup studentGroup3 = new StudentGroup();
        //StudentGroup studentGroup4 = new StudentGroup();

        studentGroup1.addStudent(onegin);
        studentGroup1.addStudent(chaadaev);
        studentGroup1.addStudent(lensky);
        studentGroup2.addStudent(larinat);
        studentGroup2.addStudent(larinao);
        studentGroup3.addStudent(larinap);
        studentGroup3.addStudent(larind);

        Intake intake1 = new Intake();
        Intake intake2 = new Intake();

        intake1.addGroup(studentGroup1);
        intake1.addGroup(studentGroup2);
        intake2.addGroup(studentGroup3);

        // System.out.println("студенты " + studentGroup.students);
        // Iterator<Student> iterator = new StudentGroupIterator(studentGroup);

        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }

        for(Student student: studentGroup1) {
            System.out.println("В группу 1 поступил студент " + student);
        }

        for(Student student: studentGroup2) {
            System.out.println("В группу 2 поступил студент " + student);
        }

        for(Student student: studentGroup3) {
            System.out.println("В группу 3 поступил студент " + student);
        }

        List<Intake> intakes = new ArrayList<>();
        intakes.add(intake1);
        intakes.add(intake2);

        IntakeService intakeService = new IntakeService(intakes);
        intakeService.sortIntakes();

        System.out.println("После сортировки:");
        int intakeNum = 1;
        for (Intake intake: intakes) {
            System.out.println("В потоке " + intake.getGroupsCount() + " групп(a).");
            int groupNum = 1;
            for(StudentGroup group: intake) {
                System.out.println("  В группе " + groupNum + " учатся:");
                for(Student student: group) {
                    System.out.println("    " + student);
                }
                groupNum++;
            }
            intakeNum++;
        }        

        //ArrayList<Student> arrayList = new ArrayList<>(List.of(onegin, larinat, lensky, chaadaev, larinao, larinap, larind));

        //System.out.println(arrayList);

        // public int compare(Student o1, Student o2) {
        //     return o1.id - o2.id;
        // }
        //Collections.sort(arrayList, (s1, s2) -> s1.id - s2.id); // лямда выражение

        // Collections.sort(arrayList, new StudentComparator()); // сортировка, второй аргумент обратная сортировка
        //System.out.println(arrayList);
    }

}


package students.group;
import students.students.Student;
import java.util.Iterator;

public class StudentGroupIterator implements Iterator<Student> {

    private StudentGroup studentGroup;
    private int index = 0;

    public StudentGroupIterator(StudentGroup group) {
        this.studentGroup = group;
    }

    private Student[] getStudents() {
        String[] names = studentGroup.students.toString().split(";");
        Student[] students = new Student[names.length];

        int count = 0;
        for(String name: names) {
            students[count] = new Student(name, count);
            count++;
        }
        // System.out.println(Arrays.toString(names));
        return students;
    }

    @Override
    public boolean hasNext() {
        return index < getStudents().length;
    }

    @Override
    public Student next() {
        Student[] students = getStudents();
        return students[index++];
    }
}


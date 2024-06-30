package students.group;
import java.util.Iterator;
import students.students.Student;

public class StudentGroup implements Iterable<Student> {

        public StringBuilder students = new StringBuilder();

    public void addStudent(Student student) {
        students.append(student).append(";");
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(this);
    }

}

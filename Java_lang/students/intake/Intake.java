package students.intake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import students.group.StudentGroup;

public class Intake implements Iterable<StudentGroup> {
    private List<StudentGroup> studentGroups = new ArrayList<>();

    public void addGroup(StudentGroup studentGroup) {
        studentGroups.add(studentGroup);
    }

    public int getGroupsCount() {
        return studentGroups.size();
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return studentGroups.iterator();
    }
}

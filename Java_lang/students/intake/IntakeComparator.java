package students.intake;

import java.util.Comparator;

public class IntakeComparator implements Comparator<Intake> {
    @Override
    public int compare(Intake o1, Intake o2) {
        return o1.getGroupsCount() - o2.getGroupsCount();
    }
}

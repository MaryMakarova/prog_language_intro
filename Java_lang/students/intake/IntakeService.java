package students.intake;

import java.util.Collections;
import java.util.List;

public class IntakeService {
    private List<Intake> intakes;

    public IntakeService(List<Intake> intakes) {
        this.intakes = intakes;
    }

    public void sortIntakes() {
        Collections.sort(intakes, new IntakeComparator());
    }
}

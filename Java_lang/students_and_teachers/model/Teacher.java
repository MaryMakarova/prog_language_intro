package students_and_teachers.model;
import java.time.LocalDate;

public class Teacher extends User {

    private Long teacherId;

    public Teacher(String firstName, String secondName, String patronymic, LocalDate dateOfBirth, Long teacherId) {
        super(firstName, secondName, patronymic, dateOfBirth);
        this.teacherId = teacherId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public void setPatronymic(String patronymic) {
        super.setPatronymic(patronymic);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        super.setDateOfBirth(dateOfBirth);
    }

    @Override
    public String toString() {
        return "Teacher{" +
               "teacherId='" + teacherId +'\'' +
               ", firstName='" + super.getFirstName() + '\'' +
               ", secondName='" + super.getSecondName() + '\'' +
               ", patronymic='" + super.getPatronymic() + '\'' +
               ", dateOfBirth=" + super.getDateOfBirth() +
               '}';
    }
}

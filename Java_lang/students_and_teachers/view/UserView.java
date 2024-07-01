package students_and_teachers.view;

import students_and_teachers.model.User;

import java.util.List;

public interface UserView<T extends User>{
    void sendOnConsole(List<T> list);
}

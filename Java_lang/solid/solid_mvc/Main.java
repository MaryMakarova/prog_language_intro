package solid.solid_mvc;

import solid.solid_mvc.controller.UserController;
import solid.solid_mvc.model.User;
import solid.solid_mvc.model.DataPersister;
import solid.solid_mvc.model.Persister;
import solid.solid_mvc.view.UserView;

public class Main {
    public static void main(String[] args) {
        User model  = retrieveUserFromDatabase();
        UserView view = new UserView();
        DataPersister persister = new Persister();
        UserController controller = new UserController(model, view, persister);
        
        controller.updateView();
        controller.saveUser();
        controller.userReport();
    }

    private static User retrieveUserFromDatabase() {
        return new User("John Doe");
    }

}

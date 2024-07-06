package solid.solid_mvc.controller;

import solid.solid_mvc.model.DataPersister;
import solid.solid_mvc.model.User;
import solid.solid_mvc.view.UserView;


public class UserController {
    private User model;
    private UserView view;
    private DataPersister persister;

    public UserController(User model, UserView view, DataPersister persister) {
        this.model = model;
        this.view = view;
        this.persister = persister;
    }

    public void updateView() {
        view.printUserDetails(model.getName());
    }

    public void saveUser() {
        persister.save(model);
    }
    
    public void userReport() {
        view.report(model.getName());
    }
}

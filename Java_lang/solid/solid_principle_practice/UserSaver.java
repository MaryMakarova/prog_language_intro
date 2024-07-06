package solid.solid_principle_practice;

public class UserSaver {
    private final DataPersister persister;

    public UserSaver(DataPersister persister){
        this.persister = persister;
    }

    public void save(User user) {
        persister.save(user);
    }
}

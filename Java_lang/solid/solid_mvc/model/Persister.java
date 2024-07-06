package solid.solid_mvc.model;

public class Persister implements DataPersister{
    public void save(User user) {
        System.out.println("Save user: " + user.getName());
    }

}

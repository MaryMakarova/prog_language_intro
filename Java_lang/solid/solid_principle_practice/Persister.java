package solid.solid_principle_practice;

public class Persister implements DataPersister{

    public void save(User user) {
        System.out.println("Save user: " + user.getName());
    }
}

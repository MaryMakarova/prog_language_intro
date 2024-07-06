package solid.solid_principle_practice;

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe");
        DataPersister persister = new Persister();
        UserSaver userSaver = new UserSaver(persister);
        userSaver.save(user);
        user.report();
    }
}

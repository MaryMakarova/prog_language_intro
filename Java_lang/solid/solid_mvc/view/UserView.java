package solid.solid_mvc.view;

public class UserView {
    public void printUserDetails(String userName) {
        System.out.println("User: ");
        System.out.println("Name: " + userName);
    }

    public void report(String userName) {
        System.out.println("Report for user: " + userName);
    }

}

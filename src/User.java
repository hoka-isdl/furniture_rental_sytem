import java.util.ArrayList;
import java.util.List;

public class User implements CommonEntity {
    private static int userCount = 0;
    public int id;
    private String name;
    private String address;
    private static List<User> users = new ArrayList<>();

    public User(String name, String address) {
        this.id = ++userCount;
        this.name = name;
        this.address = address;
    }

    @Override
    public void register() {
        users.add(this);
        System.out.println("User registered: " + this);
    }

    @Override
    public void delete() {
        users.remove(this);
        System.out.println("User deleted: " + this);
    }

    public int getId() {
        return id;
    }

    public static User findById(int id) {
        for (User user : users) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }

    public static User findByName(String name) {
        for (User user : users) {
            if (user.name.equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public static void displayAllUsers() {
        System.out.println("User List:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', address='" + address + "'}";
    }
}

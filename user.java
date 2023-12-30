import java.util.ArrayList;

public class user {
    private String users;
    private String password;
    static ArrayList<user> us= new ArrayList<>();

    public user() {
    }

    public user(String users, String password) {
        this.users = users;
        this.password = password;
    }

    /**
     * 获取
     * @return users
     */
    public String getUsers() {
        return users;
    }

    /**
     * 设置
     * @param users
     */
    public void setUsers(String users) {
        this.users = users;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "user{users = " + users + ", password = " + password + "}";
    }
}

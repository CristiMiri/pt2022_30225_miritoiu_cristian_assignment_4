package MODEL;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Person implements Serializable {
    private final int id;
    private String username;
    private String password;
    private Job role;
    private static int i=0;

    public Person(String username, String password, Job role) {
        this.username = username;
        this.password = password;
        this.role = role;
        i++;
        this.id = i;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Job getRole() {
        return role;
    }

    public void setRole(Job role) {
        this.role = role;
    }


}

package Model;

public class User {
    String name;
    String id;
    String role;
    public User(){
        name = null;
        id = null;
        role = null;
        password = null;
        Username = null;
    }

    public User(String name, String id, String role, String password, String username) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.password = password;
        Username = username;
    }

    String password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    String Username;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

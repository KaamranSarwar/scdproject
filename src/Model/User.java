package Model;
/**
 * Represents a user with basic information.
 */
public class User {
    String name;
    String id;
    String role;

    /**
     * default constructot initialzing the values
     */
    public User(){
        name = null;
        id = null;
        role = null;
        password = null;
        Username = null;
    }
    /**
     * Constructor to create a User object with specific details.
     *
     * @param name     The name of the user
     * @param id       The unique identifier for the user
     * @param role     The role of the user
     * @param password The password associated with the user
     * @param username The username of the user
     */
    public User(String name, String id, String role, String password, String username) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.password = password;
        Username = username;
    }

    String password;

    /**
     *
     * @return this returns the username of the user
     */

    public String getUsername() {
        return Username;
    }

    /**
     * this set the username of the user
     * @param username
     */

    public void setUsername(String username) {
        Username = username;
    }

    String Username;

    /**
     * this return the name of the user
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * this sets the name of the user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * this returns id of the user
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * this set the id of the user
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * this return role
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * the set role of the user
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * this return the password of the user
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * this sets the password of the user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
